package com.medu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medu.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer>{
}
