package com.medu.entities;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sId;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	private List<Chapter> chapters;
	
	@Column(unique = true, nullable = false)
	private String name;

	public Subject() {
		super();
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Chapter> getChapters() {
		return chapters;
	}

	public void setChapters(List<Chapter> chapters) {
		this.chapters = chapters;
	}
}
