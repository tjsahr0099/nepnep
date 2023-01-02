# 알고리즘 문제 진행 방법

### 1. 주석 템플릿 적용
window - preferences - java - code style - code templates - comments - types 경로에

```
/**
 * @author ${author:git_config(user.name)}
 * ${date}
 */ 
```

입력

### 2. 브랜치 생성
로컬 또는 github에서 브랜치 생성. 예시와 패턴 동일하게 
(예시) master -> algo/ksm/문자열나누기


### 3. 클래스, 기본 함수 생성 ( 클래스명, 메인함수, 실행펑션(solution) 형식 맞추기 )

```
public class 문자열_나누기 {
	public static void main(String[] args) { 
		문자열_나누기 s = new 문자열_나누기();
		s.solution();
	}
	
	public String solution(String[] survey, int[] choices) {
		
	}
}
```

### 4. 알고리즘 완료 후 해당 브랜치 push

### 5. 스터디때 체크 후 선정된 1인의 소스 머지 진행



---------------------------------------


# 참고사항
### xss 
https://blog.naver.com/PostView.naver?blogId=sun_zero2&logNo=222619027250&parentCategoryNo=&categoryNo=11&viewDate=&isShowPopularPosts=true&from=search
https://homoefficio.github.io/2016/11/21/Spring%EC%97%90%EC%84%9C-JSON%EC%97%90-XSS-%EB%B0%A9%EC%A7%80-%EC%B2%98%EB%A6%AC-%ED%95%98%EA%B8%B0/

### jwt	
https://gksdudrb922.tistory.com/217#MemberRepository
	 
### jasypt
https://bibi6666667.tistory.com/317
