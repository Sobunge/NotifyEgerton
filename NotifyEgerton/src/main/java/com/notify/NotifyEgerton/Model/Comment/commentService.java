
package com.notify.NotifyEgerton.Model.Comment;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentService {
    
     @Autowired 
    private commentRepository CommentRepository;
    
    public List<Comment> getAllComments(){
    
         List<Comment> comment = new ArrayList<>();
        CommentRepository.findAll().forEach(comment :: add);
        
        return comment;
    }
    
    public Comment getComment(String id){
        
        Comment comment  = new Comment();
        
                comment = CommentRepository.findById(id).get();
            
            return comment;
    }
    
     
    public void addComment(Comment comment){
        CommentRepository.save(comment);
    }
    
    public void updateComment(String id, Comment comment)
    {
        CommentRepository.save(comment);
    }
    
    public void deleteComment(String id)
    {
        CommentRepository.deleteById(id);
    }
    
}
