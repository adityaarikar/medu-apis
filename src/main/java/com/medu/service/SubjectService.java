package com.medu.service;

import org.springframework.stereotype.Component;

import com.medu.entities.Subject;

import java.util.List;

@Component
public interface SubjectService {

    public List<Subject> getAllSubject();

    public Subject saveSubject(Subject subject);

    public Subject getSubjectById(int id);

    public Subject updateSubjectById(Subject subject, int subjectId);

    public String deleteSubjectById(int subjectId);
}
