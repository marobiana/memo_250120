package com.memo.post;

import com.memo.post.service.PostBO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class PostRestController {
    private final PostBO postBO;

    @PostMapping("/create")
    public Map<String, Object> create(
            @RequestParam("subject") String subject,
            @RequestParam("content") String content,
            HttpSession session
    ) {
        // userId 꺼내기
        int userId = (int)session.getAttribute("userId");

        // db insert
        int rowCount = postBO.addPost(userId, subject, content, null);

        // 응답값
        Map<String, Object> result = new HashMap<>();
        if (rowCount > 0) {
            result.put("code", 200);
            result.put("result", "성공");
        } else {
            result.put("code", 500);
            result.put("error_message", "메모를 저장하지 못했습니다.");
        }
        return result;
    }
}
