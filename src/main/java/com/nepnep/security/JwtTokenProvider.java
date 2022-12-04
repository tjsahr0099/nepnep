package com.nepnep.security;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtTokenProvider {
//	
//	
//	//토큰 복호화
//    public static Map<String, Object> verifyJWT(String jwt) {
//        Map<String, Object> claimMap = null;
//        try {
//            Claims claims = Jwts.parser()
//                    .setSigningKey(key.getBytes("UTF-8")) // Set Key
//                    .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
//                    .getBody();
//
//            claimMap = claims;
//
//            //Date expiration = claims.get("exp", Date.class);
//            //String data = claims.get("data", String.class);
//            
//        } catch (MalformedJwtException e) {
//            log.error("Invalid JWT Token");
//            throw new ApiException(ErrorCode.TOKEN_INVALID);     
//        } catch (ExpiredJwtException e) {
//            log.error("Expired JWT Token");
//            throw new ApiException(ErrorCode.TOKEN_EXPIRED);     
//        } catch (UnsupportedJwtException e) {
//            log.error("Unsupported JWT Token", e);
//        } catch (IllegalArgumentException e) {
//            log.error("JWT claims string is empty.");
//            throw new ApiException(ErrorCode.TOKEN_EMPTY);     
//        } catch (SignatureException e) {
//		} catch (UnsupportedEncodingException e) {
//		} 
//        return claimMap;
//    }    
//    

	private final Key key;

	public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {

		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	// 유저 정보를 가지고 AccessToken, RefreshToken 을 생성하는 메서드
	public TokenInfo generateToken(Authentication authentication) {
		// 권한 가져오기
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		long now = (new Date()).getTime();
		// Access Token 생성
		Date accessTokenExpiresIn = new Date(now + 86400000);
		String accessToken = Jwts.builder().setSubject(authentication.getName()).claim("auth", authorities)
				.setExpiration(accessTokenExpiresIn).signWith(key, SignatureAlgorithm.HS256).compact();

		// Refresh Token 생성
		String refreshToken = Jwts.builder().setExpiration(new Date(now + 86400000))
				.signWith(key, SignatureAlgorithm.HS256).compact();

		return TokenInfo.builder().grantType("Bearer").accessToken(accessToken).refreshToken(refreshToken).build();
	}

	// JWT 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
	public Authentication getAuthentication(String accessToken) {
		// 토큰 복호화
		Claims claims = parseClaims(accessToken);

		if (claims.get("auth") == null) {
			throw new RuntimeException("권한 정보가 없는 토큰입니다.");
		}

		// 클레임에서 권한 정보 가져오기
		Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());

		// UserDetails 객체를 만들어서 Authentication 리턴
		UserDetails principal = new User(claims.getSubject(), "", authorities);
		return new UsernamePasswordAuthenticationToken(principal, "", authorities);
	}

	// 토큰 정보를 검증하는 메서드
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("Invalid JWT Token", e);
		} catch (ExpiredJwtException e) {
			log.info("Expired JWT Token", e);
		} catch (UnsupportedJwtException e) {
			log.info("Unsupported JWT Token", e);
		} catch (IllegalArgumentException e) {
			log.info("JWT claims string is empty.", e);
		}
		return false;
	}

	private Claims parseClaims(String accessToken) {
		try {
			return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();
		} catch (ExpiredJwtException e) {
			return e.getClaims();
		}
	}

}
