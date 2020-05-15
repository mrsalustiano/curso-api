package com.qintess.curso.api.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HashUtilTests {

	@Test
	public void getSecureHashTest() {
		String hash = HashUtil.getSecureHash("asd123");
		System.out.println(hash);
		
		assertThat(hash.length()).isEqualTo(64);
	}
}
