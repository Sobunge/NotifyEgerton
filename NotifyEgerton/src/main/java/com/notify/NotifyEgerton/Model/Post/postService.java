package com.notify.NotifyEgerton.Model.Post;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class postService {
    
     @Autowired 
    private postRepository PostRepository;
    
    public List<Post> getAllPosts(){
    
         List<Post> post = new ArrayList<>();
        PostRepository.findAll().forEach(post :: add);
        
        return post;
    }
    
    public Post getPost(String id){
        
        Post post  = new Post();
        
                post = PostRepository.findById(id).get();
            
            return post;
    }
    
     
    public void addPost(Post post){
        PostRepository.save(post);
    }
    
    public void updatePost(String id, Post post)
    {
        PostRepository.save(post);
    }
    
    public void deletePost(String id)
    {
        PostRepository.deleteById(id);
    }
    
    
}
