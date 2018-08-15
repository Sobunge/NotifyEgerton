package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.Community;
import com.notify.NotifyEgerton.model.User;
import java.util.List;


public interface CommunityRepository extends CrudRepository<Community, Long> {

	public boolean existsByName(String name);
        
        public List<Community> findByUser_Username(String username);

        public List<Community> findAllBycommunityId(Long communityId);

}
