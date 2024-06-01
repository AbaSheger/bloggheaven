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

    //client_USER

    @GetMapping ("/posts")
    @PreAuthorize("hasRole('client_USER')")
    public List <Post> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping ("/posts/{id}")
    @PreAuthorize("hasRole('client_USER')")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping ("/newpost")
    @PreAuthorize("hasRole('client_USER')")
    public String createPost(@RequestBody Post post) {
        postService.save(post);
        return "Post created successfully";
    }

    @PutMapping ("/updatepost/{id}")
    @PreAuthorize("hasRole('client_USER')")
    public String updatePost(@PathVariable Long id, @RequestBody Post post){
        post.setId(id);
        postService.update(post);
        return "Post updated successfully";
    }

    @DeleteMapping ("/deletepost/{id}")
    @PreAuthorize("hasRole('client_USER')")
    public String deletePost(@PathVariable Long id){
        postService.delete(id);
        return "Post deleted successfully";
    }


}
