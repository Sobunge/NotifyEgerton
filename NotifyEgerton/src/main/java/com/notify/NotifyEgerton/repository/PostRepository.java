package com.notify.NotifyEgerton.repository;

import com.notify.NotifyEgerton.model.Post;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long>{
    
    public List<Post> findByCommunityCommunityId(Long communityId);

    public List<Post> findByGroupGroupId(Long groupId);
}
