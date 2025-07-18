package com.memo;

import com.memo.user.service.UserBO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RequiredArgsConstructor
@SpringBootTest
@Slf4j
class MemoApplicationTests {
	@Autowired
	UserBO userBO;

	@Test
	void ObjectUtils_테스트() {
		String str1 = "";
		String str2 = null;
		assertEquals(true, ObjectUtils.isEmpty(str1));
		assertEquals(true, ObjectUtils.isEmpty(str2));

		List<Integer> list1 = new ArrayList<>(); // []
		List<Integer> list2 = null;
		assertEquals(true, ObjectUtils.isEmpty(list1));
		assertEquals(true, ObjectUtils.isEmpty(list2));

//		if (ObjectUtils.isEmpty(str1)) {
//
//		}
	}


	@Transactional  // insert -> delete 롤백
	@Test
	void 회원가입_테스트() {
		userBO.addUser("test111111", "testpassword111",
				"테스트111", "test111@test.com");
	}

	@Test
	void 테스트1() {
		log.info("Hello world");
	}

	@Test
	void 테스트2() {
		int a = 10;
		int b = 20;
		assertEquals(30, a + b);
	}

}
