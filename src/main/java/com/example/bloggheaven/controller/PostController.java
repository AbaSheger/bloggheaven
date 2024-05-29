package com.example.bloggheaven.controller;


import com.example.bloggheaven.entity.Post;
import com.example.bloggheaven.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping ("/posts")
   // @PreAuthorize("hasRole('USER')")
    public List <Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping ("/posts/{id}")
    @PreAuthorize("hasRole('USER')")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping ("/newpost")
    @PreAuthorize("hasRole('USER')")
    public String createPost(@RequestBody Post post) {
        postService.save(post);
        return "Post created successfully";
    }

    @PutMapping ("/updatepost/{id}")
    @PreAuthorize("hasRole('USER')")
    public String updatePost(@PathVariable Long id, @RequestBody Post post){
        postService.update(post);
        return "Post updated successfully";
    }

    @DeleteMapping ("/deletepost/{id}")
    @PreAuthorize("hasRole('USER')")
    public String deletePost(@PathVariable Long id){
        postService.delete(id);
        return "Post deleted successfully";
    }


}
