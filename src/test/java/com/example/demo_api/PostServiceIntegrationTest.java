package com.example.demo_api;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
class PostServiceIntegrationTest {

    @Autowired
    private PostService postService;

    @Test
    void RDSから全Postを取得する() {
        List<Post> result = postService.getAllPosts();

        System.out.println("=== RDS Posts ===");
        result.forEach(post ->
                System.out.printf("id=%d, title=%s, desc=%s, date=%s%n",
                        post.getId(), post.getTitle(), post.getDescription(), post.getDate())
        );
    }
}