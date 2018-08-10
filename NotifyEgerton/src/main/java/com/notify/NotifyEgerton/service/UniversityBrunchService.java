package com.notify.NotifyEgerton.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notify.NotifyEgerton.model.UniversityBrunch;
import com.notify.NotifyEgerton.repository.UniversityBrunchRepository;

@Service
public class UniversityBrunchService {

	@Autowired
	private UniversityBrunchRepository universityBrunchRepository;
	
	
	public List<UniversityBrunch> getAllUniversityBrunches(String universityId){
		
		List<UniversityBrunch> universityBrunch = new ArrayList<>();
		universityBrunchRepository.findByUniversityId(universityId)
		.forEach(universityBrunch :: add);
		
		return universityBrunch;
	}
	
	public Optional<UniversityBrunch> getUniversityBrunch(String id) {
		
		return universityBrunchRepository.findById(id);
	} 
	
	public void addUniversityBrunch(UniversityBrunch universityBrunch) {
		universityBrunchRepository.save(universityBrunch);
	}
	
	public void updateUniversityBrunch(UniversityBrunch universityBrunch) {
		universityBrunchRepository.save(universityBrunch);
	}
	

	public boolean isUniversityBrunchPresent(String name) {
	
		return universityBrunchRepository.existsByName(name);
	}
	
	public void deleteUniversityBrunch(UniversityBrunch universityBrunch) {
		
		universityBrunchRepository.delete(universityBrunch);
	}
}
