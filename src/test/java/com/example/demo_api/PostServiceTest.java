package com.example.demo_api;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class PostServiceTest {
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    public PostServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    void getAllPosts_全件取得できること() 
    {
        Post post1 = new Post();
        post1.setTitle("First");
        Post post2 = new Post();
        post2.setTitle("Second");

        when(postRepository.findAll()).thenReturn(Arrays.asList(post1, post2));

        // ACT
        List<Post> result = postService.getAllPosts();

        // ASSERT
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Post::getTitle).containsExactly("First", "Second");

        // Repository が本当に呼ばれたか確認
        verify(postRepository, times(1)).findAll();
    }
}
