package com.medu.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.medu.entities.Topic;

@Component
public interface TopicService {
	public List<Topic> getAllTopic();

	public Topic saveTopic(Topic topic);

	public Topic updateTopicById(Topic topic, int topicId);

	public String deleteTopicById(int topicId);
}
