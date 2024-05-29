package com.example.bloggheaven.Repository;

import com.example.bloggheaven.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
