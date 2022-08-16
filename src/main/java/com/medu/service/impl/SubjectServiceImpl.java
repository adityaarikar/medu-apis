package com.medu.service.impl;

import com.medu.dao.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medu.entities.Subject;
import com.medu.exception.ResourceNotFoundException;
import com.medu.service.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public List<Subject> getAllSubject() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject saveSubject(Subject subject) {
		if(subject.getName().isBlank()) {
			throw new IllegalArgumentException("");
		}else {
			return subjectRepository.save(subject);
		}
	}

	@Override
	public Subject getSubjectById(int id) {
		if(subjectRepository.findById(id).isEmpty()) {
			throw new ResourceNotFoundException("Subject does not exist");
		}else {
			return subjectRepository.getById(id);	 
		}
	}

	@Override
	public Subject updateSubjectById(Subject subject, int subjectId) {		
		if(subjectRepository.findById(subjectId).isEmpty()) {
			throw new ResourceNotFoundException("Subject does not exixt");
		}else {
			if(subject.getName().isBlank()) {
				throw new IllegalArgumentException("");
			}else {				
				Subject existingSubject = subjectRepository.getById(subjectId);
				
				existingSubject.setName(subject.getName());
				
				return subjectRepository.save(existingSubject);
			}
		}
	}

	@Override
	public String deleteSubjectById(int subjectId) {
		if(subjectRepository.findById(subjectId).isEmpty()) {
			throw new ResourceNotFoundException("Subject does not exixt");
		}else {
			subjectRepository.deleteById(subjectId);
			
			return "Deleted";
		}		
	}
}
