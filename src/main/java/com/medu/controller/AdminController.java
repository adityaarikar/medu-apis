package com.medu.controller;

import java.util.List;

import com.medu.dao.ChapterRepository;
import com.medu.entities.Chapter;
import com.medu.service.ChapterService;
import com.medu.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.medu.dao.SubjectRepository;
import com.medu.dao.TopicRepository;
import com.medu.entities.Subject;
import com.medu.entities.Topic;
import com.medu.service.SubjectService;

@Controller
@CrossOrigin
public class AdminController {

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private ChapterRepository chapterRepository;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private TopicRepository topicRepository;

//=====>Subject controller

	//Get all Subjects
	//http://localhost:8080/subject
	@GetMapping("/subject")
	public ResponseEntity<List<Subject>> getAllSubject(){
		List<Subject> listOfSubjects = subjectService.getAllSubject();
		return new ResponseEntity<List<Subject>>(listOfSubjects,HttpStatus.OK);
	}

	//Add new subjects
	//http://localhost:8080/subject
	@PostMapping("/subject")
	public ResponseEntity<?> addSubject(@RequestBody Subject subject){
		Subject newSubject = subjectService.saveSubject(subject);

		return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
	}

	//Update any subject
	@PutMapping("/subject")
	public ResponseEntity<Subject> updateSubjectById(@RequestBody Subject subject,@RequestParam(value = "subject_id") int subject_id){
		Subject newSubject = subjectService.updateSubjectById(subject, subject_id);

		return new ResponseEntity<>(newSubject,HttpStatus.OK);
	}

	//Delete any subject by id
	@DeleteMapping("/subject")
	public ResponseEntity<String> deleteSubjectById(@RequestParam(value = "subject_id") int subject_id){
		String ans = subjectService.deleteSubjectById(subject_id);
		if(ans == "Deleted") {
			return new ResponseEntity<>(ans,HttpStatus.OK);			
		}else {
			return new ResponseEntity<>("Unable to delete", HttpStatus.BAD_REQUEST);
		}
	}

//=====>Chapters controller

	//get all chapters
	@GetMapping("/chapters")
	public ResponseEntity<List<Chapter>> getAllChapters(){
		List<Chapter> listOfChapters = chapterService.getAllChapters();

		return new ResponseEntity<>(listOfChapters, HttpStatus.OK);
	}

	//Get all chapters of subject
	@GetMapping("/chapter")
	public ResponseEntity<List<?>> getAllChaptersOfSubject(@RequestParam(value = "subject_id") int subject_id){
		Subject getSubject = subjectService.getSubjectById(subject_id);
		List<Chapter> listOfChapters = getSubject.getChapters();

		return new ResponseEntity<>(listOfChapters,HttpStatus.OK);
	}

	//Add Chapter to any subject
	//http://localhost:8080/topic?subject_id=6
	@PostMapping("/chapter")
	public ResponseEntity<?> addChapter(@RequestBody Chapter chapter, @RequestParam(value = "subject_id") int subject_id){
		Subject getSubject = subjectService.getSubjectById(subject_id);
		List<Chapter> chapters = getSubject.getChapters();
		chapters.add(chapter);

		Chapter newChapter = chapterService.saveChapter(chapter);
		newChapter.setSubjectName(getSubject.getName());
		chapterRepository.save(newChapter);

		return new ResponseEntity<>(newChapter, HttpStatus.CREATED);
	}

	//Update any chapter from particular subject
	@PutMapping("/chapter")
	public ResponseEntity<Chapter> updateChapterById(@RequestBody Chapter chapter,@RequestParam(value = "chapter_id") int chapter_id){
		Chapter newChapter = chapterService.updateChapterById(chapter_id,chapter);

		return new ResponseEntity<>(newChapter,HttpStatus.OK);
	}

	//Delete any chapter from particular subject
	@DeleteMapping("/chapter")
	public ResponseEntity<String> deleteChapterById(@RequestParam(value = "chapter_id") int chapter_id){
		String res = chapterService.deleteChapterById(chapter_id);
		if (res == "Deleted"){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

//=====>Chapters controller

	//get all topics
	@GetMapping("/topics")
	public ResponseEntity<List<Topic>> getAllTopics(){
		List<Topic> listOfTopics = topicService.getAllTopic();

		return new ResponseEntity<>(listOfTopics, HttpStatus.OK);
	}

	//get topic from particular chapter
	@GetMapping("/topic")
	public ResponseEntity<List<Topic>> getAllTopicOfChapter(@RequestParam(value = "chapter_id") int chapter_id){
		Chapter chapter = chapterRepository.getById(chapter_id);
		List<Topic> topicLists = chapter.getTopics();

		return new ResponseEntity<>(topicLists, HttpStatus.OK);
	}

	//Add topic to a particular subject
	@PostMapping("/topic")
	public ResponseEntity<Topic> addTopicToChapter(@RequestParam(value = "chapter_id") int chapter_id, @RequestBody Topic topic){
		Chapter chapter = chapterService.getChapterById(chapter_id);
		List<Topic> topics = chapter.getTopics();
		topics.add(topic);

		Topic newTopic = topicService.saveTopic(topic);
		newTopic.setSubjectName(chapter.getSubjectName());
		newTopic.setChapterName(chapter.getChapterName());
		topicRepository.save(newTopic);

		return new ResponseEntity<>(newTopic, HttpStatus.OK);
	}

	//Update topic by topic_id
	@PutMapping("/topic")
	public ResponseEntity<Topic> updateTopicById(@RequestParam(value = "topic_id") int topic_id,@RequestBody Topic topic){
		Topic newTopic = topicService.updateTopicById(topic, topic_id);

		return new ResponseEntity<>(newTopic, HttpStatus.OK);
	}

	//Delete Topic by topic_id
	@DeleteMapping("/topic")
	public ResponseEntity<String> deleteTopicById(@RequestParam(value = "topic_id") int topic_id){
		String res = topicService.deleteTopicById(topic_id);
		if (res == "Deleted"){
			return new ResponseEntity<>(HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
