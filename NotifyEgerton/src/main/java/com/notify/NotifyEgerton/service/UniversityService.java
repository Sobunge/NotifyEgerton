package com.notify.NotifyEgerton.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notify.NotifyEgerton.model.University;
import com.notify.NotifyEgerton.repository.UniversityRepository;


@Service
public class UniversityService {

	@Autowired
	private UniversityRepository universityRepository;
	
	
	public List<University> getAllUniversities(){
		
		List<University> university = new ArrayList<>();
		universityRepository.findAll()
		.forEach(university :: add);
		
		return university;
	}
	
	public Optional<University> getUniversity(String id) {
		
		return universityRepository.findById(id);
	} 
	
	public void addUniversity(University university) {
		universityRepository.save(university);
	}
	
	public void updateUniversity(University university) {
		universityRepository.save(university);
	}
	

	public boolean isUniversityPresent(String name) {
	
		return universityRepository.existsByName(name);
	}
	
	public void deleteUniversity(University university) {
		
		universityRepository.delete(university);
	}
}
