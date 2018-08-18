package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.Groups;
import java.util.List;


public interface GroupRepository extends CrudRepository<Groups, Long>{

	public boolean existsByName(String name);

        public List<Groups> findByUsers_Username(String username);

        public List<Groups> findAllBygroupId(Long groupId);
}
