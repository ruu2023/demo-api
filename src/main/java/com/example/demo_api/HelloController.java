package com.example.demo_api;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_api.learn_design.Book;
import com.example.demo_api.learn_design.BookShelf;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final PostService postService;

    HelloController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/status")
    public ApiResponse getStatus() {
        return new ApiResponse("success", "API is running!");
    }

    // ★ Post テーブルから title を全件取得して返す API
    @GetMapping("/posts/titles")
    public List<String> getAllPostTitles() {
        return postService.getAllPosts()
                          .stream()
                          .map(Post::getTitle)
                          .collect(Collectors.toList());
    }

    @GetMapping("/")
    public ApiResponse get() {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("first book"));
        bookShelf.appendBook(new Book("second book"));
        bookShelf.appendBook(new Book("third book"));
        bookShelf.appendBook(new Book("fourth book"));

        Iterator<Book> it = bookShelf.iterator();
        while(it.hasNext())
        {
            Book book = it.next();
            System.out.println(book.getName());
        }

        // 拡張for文を使う方法
        for(Book book: bookShelf)
        {
            System.out.println(book.getName());
        }

        return new ApiResponse("success", "API is running!");
    }
}

class ApiResponse {
    private String status;
    private String message;

    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters
    public String getStatus() { return status; }
    public String getMessage() { return message; }
}