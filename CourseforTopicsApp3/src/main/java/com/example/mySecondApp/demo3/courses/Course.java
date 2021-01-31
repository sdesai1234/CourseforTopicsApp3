package com.example.mySecondApp.demo3.courses;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mySecondApp.demo3.topics.Topic;

@Entity
class Course
{
	@Id
	@Column(name ="COURSE_ID")
	private Long CourseId;
	
	@Column(name ="NAME")
	private String name  ;
	
	
	//@Column(name ="TOPIC_REL")
	@ManyToOne
	private Topic topic;
	
	
	public Topic getTopic() {
		return topic;
	}


	public void setTopic(Topic topic) {
		this.topic = topic;
	}


	public Course() {
		super();
		
	}
	
	
	public Course(Long courseId, String name, Long  topicId) {
		super();
		CourseId = courseId;
		this.name = name;
		this.topic = new Topic(topicId,"");
	}


	public Long getCourseId() {
		return CourseId;
	}
	public void setCourseId(Long courseId) {
		CourseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}