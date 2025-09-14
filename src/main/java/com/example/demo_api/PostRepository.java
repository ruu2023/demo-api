package com.example.demo_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Post テーブルを操作するリポジトリ
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}