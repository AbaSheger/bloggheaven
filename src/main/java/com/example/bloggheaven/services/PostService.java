package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.PostRepository;
import com.example.bloggheaven.Repository.UserRepository;
import com.example.bloggheaven.entity.Post;
import com.example.bloggheaven.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Post save(Post post) {

        User author = post.getAuthor();
        if (author != null) {
            if (author.getId() != null && !userRepository.existsById(author.getId())) {
                throw new RuntimeException("Author with id " + author.getId() + " not found");
            } else if (author.getId() != null) {
                author = userRepository.findById(author.getId()).get();
            } else {
                author = userRepository.save(author);
            }
            post.setAuthor(author);
        }

        return postRepository.save(post);


    }

    //update post
    public Post update(Post post) {
       Optional<Post> optionalPost = postRepository.findById(post.getId());

         if (optionalPost.isPresent()) {
              Post existingPost = optionalPost.get();
              existingPost.setId(post.getId());
              existingPost.setTitle(post.getTitle());
              existingPost.setContent(post.getContent());
              return postRepository.save(existingPost);
         } else {
              throw new RuntimeException("Post not found");
         }



    }

    //delete post
    public void delete(Long post) {
        postRepository.deleteById(post);
    }

}
