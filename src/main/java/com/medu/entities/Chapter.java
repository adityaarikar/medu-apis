package com.medu.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CHAPTER")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cId;

    @Column(unique = true, nullable = false)
    private String chapterName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "chapter_id")
    private List<Topic> topics;

    @Column()
    private String subjectName;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
