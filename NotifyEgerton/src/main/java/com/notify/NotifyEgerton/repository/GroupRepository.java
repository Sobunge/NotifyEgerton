package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.Groups;


public interface GroupRepository extends CrudRepository<Groups, Long>{

	public boolean existsByName(String name);
}
