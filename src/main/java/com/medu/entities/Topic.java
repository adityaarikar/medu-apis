package com.medu.entities;

import javax.persistence.*;

@Entity
@Table(name="TOPIC")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column(unique = true, nullable = false)
	private String englishVideoLink;

	@Column(unique = true, nullable = false)
	private String hindiVideoLink;

	public String getHindiVideoLink() {
		return hindiVideoLink;
	}

	public void setHindiVideoLink(String hindiVideoLink) {
		this.hindiVideoLink = hindiVideoLink;
	}

	@Column(unique = true, nullable = false)
	private String pdfLink;

	@Column()
	private String subjectName;

	@Column()
	private String chapterName;

	public Topic() {
		super();
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglishVideoLink() {
		return englishVideoLink;
	}

	public void setEnglishVideoLink(String englishVideoLink) {
		this.englishVideoLink = englishVideoLink;
	}

	public String getPdfLink() {
		return pdfLink;
	}

	public void setPdfLink(String pdfLink) {
		this.pdfLink = pdfLink;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
}
