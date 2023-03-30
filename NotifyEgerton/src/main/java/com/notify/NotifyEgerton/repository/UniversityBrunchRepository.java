package com.notify.NotifyEgerton.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.UniversityBrunch;

public interface UniversityBrunchRepository extends CrudRepository<UniversityBrunch, String> {

	public boolean existsByName(String name);
	
	public List<UniversityBrunch> findByUniversityId(String universityId);

}

