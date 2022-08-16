package com.medu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.medu.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
