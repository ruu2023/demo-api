package com.example.demo_api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)  // このコントローラーだけをテスト
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;  // HTTP リクエストを模擬するツール

    @TestConfiguration
    static class TestConfig {
        @Bean
        PostService postService() {
            return Mockito.mock(PostService.class);
        }
    } // 依存関係をモック化

    @Test
    void hello_正常に動作すること() throws Exception {
        // GET /api/hello にリクエストを送る
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())  // ステータス 200 OK
                .andExpect(content().string("Hello, Spring Boot!"));  // レスポンス内容
    }

    @Test
    void helloWithName_名前を渡すと挨拶が返ること() throws Exception {
        mockMvc.perform(get("/api/hello/太郎"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, 太郎!"));
    }

    @Test
    void getStatus_APIレスポンス形式で返ること() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("success"))  // JSON の status フィールド
                .andExpect(jsonPath("$.message").value("API is running!"));  // JSON の message フィールド
    }
}