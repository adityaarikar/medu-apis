package com.medu.service.impl;

import java.util.List;

import com.medu.dao.TopicRepository;
import com.medu.entities.Topic;
import com.medu.exception.ResourceNotFoundException;
import com.medu.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicServceImpl implements TopicService{

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getAllTopic() {
		return topicRepository.findAll();
	}

	@Override
	public Topic saveTopic(Topic topic) {
		if(topic.getName().isBlank()) {
			throw new IllegalArgumentException("");
		}else if(topic.getPdfLink().isBlank()){
			throw new IllegalArgumentException("");
		}else if(topic.getVideoLink().isBlank()){
			throw new IllegalArgumentException("");
		}else {			
			return topicRepository.save(topic);
		}
	}

	@Override
	public Topic updateTopicById(Topic topic, int topicId) {
		if(topicRepository.findById(topicId).isEmpty()){
			throw new ResourceNotFoundException("Topic not found");
		}else{
			if(topic.getName().isBlank()) {
				throw new IllegalArgumentException("");
			}else if(topic.getVideoLink().isBlank()){
				throw new IllegalArgumentException("");
			}else {
				Topic existingTopic = topicRepository.getById(topicId);
				
				existingTopic.setName(topic.getName());
				existingTopic.setPdfLink(topic.getPdfLink());
				existingTopic.setVideoLink(topic.getVideoLink());
				existingTopic.setHindiVideoLink(topic.getHindiVideoLink());
				
				return topicRepository.save(existingTopic);
			}			
		}
	}

	@Override
	public String deleteTopicById(int topicId) {
		if(topicRepository.findById(topicId).isEmpty()){
			throw new ResourceNotFoundException("Topic not found");
		}else{
			topicRepository.deleteById(topicId);
			return "Deleted";
		}
	}
}
