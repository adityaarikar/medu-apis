package com.medu.service;

import com.medu.entities.Chapter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ChapterService {

    public List<Chapter> getAllChapters();

    public Chapter saveChapter(Chapter chapter);

    public Chapter getChapterById(int id);

    public Chapter updateChapterById(int id, Chapter chapter);

    public String deleteChapterById(int id);
}
