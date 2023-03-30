package com.notify.NotifyEgerton.service;

import com.notify.NotifyEgerton.model.Post;
import com.notify.NotifyEgerton.repository.PostRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
    public List<Post> getAllPost(){
    
        List<Post> post = new ArrayList<>();
        
        postRepository.findAll().forEach(post :: add);
        
        return post;
    }
    
    public List<Post> getAllPost(long communityId){
    
         List<Post> post = new ArrayList<>();
        
        postRepository.findByCommunityCommunityId(communityId).forEach(post :: add);
        
        return post;
    }
    
    public List<Post> getAllGroupPost(long groupId){
    
    
        List<Post> post = new ArrayList<>();
        
        postRepository.findByGroupGroupId(groupId).forEach(post :: add);
        
        return post;
    }
    
    public void addPost(Post post){
        
        postRepository.save(post);
    }
    
    public Optional<Post> getPost(Long id){
        
        return postRepository.findById(id);
    }
    
    public void deletePost(Post post){
        postRepository.delete(post);
    }
    
}
