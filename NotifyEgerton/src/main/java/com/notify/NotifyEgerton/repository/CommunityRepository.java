package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.Community;


public interface CommunityRepository extends CrudRepository<Community, Long> {

	public boolean existsByName(String name);


}
