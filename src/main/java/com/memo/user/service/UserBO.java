package com.memo.user.service;

import com.memo.user.entity.UserEntity;
import com.memo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 생성자 주입 Dependency Injection => Spring bean 주입
@RequiredArgsConstructor
@Service
public class UserBO {
    private final UserRepository userRepository;

//    public UserBO(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    // input: loginId
    // output: boolean true:중복
    public boolean isDuplicateLoginId(String loginId) {
        // select * from user where loginId = ?
        UserEntity user = userRepository.findByLoginId(loginId).orElse(null);
        return user != null;
    }
}
