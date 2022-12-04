package com.nepnep.security;

import java.io.UnsupportedEncodingException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtTokenProviderTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		log.info("@BeforeAll setUpBeforeClass");
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		log.info("@AfterAll tearDownAfterClass");
	}

	@BeforeEach
	public void setUp() throws Exception {
		log.info("@BeforeEach setUp");
	}

	@AfterEach
	public void tearDown() throws Exception {
		log.info("@AfterEach tearDown");
	}

	@Test
	public void testCreateToken() throws UnsupportedEncodingException {

	}

	@Test
	public void testVerifyJWT() throws UnsupportedEncodingException {
//		String jwtToken = "eiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjY5OTQ4NDcxLCJ1c2VyIjoi6rmA7ISg66qpIiwiZW1haWwiOiJ0anNhaHJAIn0.Y2LDlbb0o31Y4LnwpbmXy7w1kd8TiMRzFdizPj3x6HI";
//	    JwtTokenProvider.verifyJWT(jwtToken);
//		fail("Not yet implemented");
	}

}
