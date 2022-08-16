package com.medu.service.impl;

import com.medu.dao.ChapterRepository;
import com.medu.dao.SubjectRepository;
import com.medu.entities.Chapter;
import com.medu.exception.ResourceNotFoundException;
import com.medu.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    @Override
    public Chapter saveChapter(Chapter chapter) {
    	if(chapter.getChapterName().isBlank()) {
    		throw new IllegalArgumentException("");
    	}else {
    		return chapterRepository.save(chapter);
    	}
    }

    @Override
    public Chapter getChapterById(int id) {
    	
    	if(chapterRepository.findById(id).isEmpty()) {
    		throw new ResourceNotFoundException("Chapter does not exists");
    	}else {
    		return chapterRepository.getById(id);
    	}
    }

    @Override
    public Chapter updateChapterById(int chapter_id, Chapter chapter) {
        if(chapterRepository.findById(chapter_id).isEmpty()){
        	throw new ResourceNotFoundException("Chapter does not exists");
        }else{
        	if(chapter.getChapterName().isBlank()) {
        		throw new IllegalArgumentException("");
        	}else {
        		Chapter existingChapter = chapterRepository.getById(chapter_id);
        		
        		existingChapter.setChapterName(chapter.getChapterName());
        		return chapterRepository.save(existingChapter);
        	}
        }
    }

    @Override
    public String deleteChapterById(int id) {
        if(chapterRepository.findById(id).isEmpty()){
        	throw new ResourceNotFoundException("Chapter does not exists");
        }else{
        	chapterRepository.deleteById(id);
        	return "Deleted";
        }
    }
}
