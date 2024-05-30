package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.PostRepository;
import com.example.bloggheaven.Repository.UserRepository;
import com.example.bloggheaven.entity.Post;
import com.example.bloggheaven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {
private final PostRepository postRepository;
public  final UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository , UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    //get all posts
    public List<Post> findAll() {

        return postRepository.findAll();
    }

    //get post by id
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    // create post
    public Post save(Post post,Long userId ) {
        //fetch user
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        post.setAuthor(user);

        return postRepository.save(post);
    }

    //update post
    public Post update(Post post) {
        return postRepository.save(post);
    }

    //delete post
    public void delete(Long post) {
        postRepository.deleteById(post);
    }

}
