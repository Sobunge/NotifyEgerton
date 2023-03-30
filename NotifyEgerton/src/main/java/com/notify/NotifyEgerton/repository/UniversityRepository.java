package com.notify.NotifyEgerton.repository;

import org.springframework.data.repository.CrudRepository;

import com.notify.NotifyEgerton.model.University;

public interface UniversityRepository extends CrudRepository<University, String> {

	public boolean existsByName(String name);

}
