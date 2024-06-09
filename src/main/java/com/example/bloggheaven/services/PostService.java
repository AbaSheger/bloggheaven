package com.example.bloggheaven.services;

import com.example.bloggheaven.Repository.PostRepository;
import com.example.bloggheaven.Repository.UserRepository;
import com.example.bloggheaven.Repository.AddressRepository;
import com.example.bloggheaven.entity.Address;
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
public final AddressRepository addressRepository;
    @Autowired
    public PostService(PostRepository postRepository , UserRepository userRepository, AddressRepository addressRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    //get all posts
    public List<Post> findAll() {

        return postRepository.findAll();
    }

    //get post by id
    public Post findById(Long id) {

        return postRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post with ID: " + id + " not found"));
    }


    // Create post with potential new user
    public Post save(Post post) {
        User author = post.getAuthor();
        if (author != null) {
            if (author.getId() != null) {
                // Existing user, fetch from repository
                Optional<User> optionalUser = userRepository.findById(author.getId());
                if (optionalUser.isPresent()) {
                    author = optionalUser.get();
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
                }
            } else {
                // New user, handle address by ID if provided
                Address address = author.getAddress();
                if (address != null && address.getId() != null) {
                    Optional<Address> optionalAddress = addressRepository.findById(address.getId());
                    if (optionalAddress.isPresent()) {
                        address = optionalAddress.get();
                    } else {
                        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found");
                    }
                } else if (address != null) {
                    // New address
                    address = addressRepository.save(address);
                }
                author.setAddress(address);
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
              throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
         }



    }

    //delete post
    public void delete(Long post) {

        if (!postRepository.existsById(post)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found");
        }
        postRepository.deleteById(post);
    }

}
