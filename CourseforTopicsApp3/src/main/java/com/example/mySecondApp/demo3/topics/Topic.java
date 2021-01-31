package com.example.mySecondApp.demo3.topics;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TOPIC")
public class Topic
{
	@Id
	@Column(name="TOPIC_ID")
	private Long id;
	
	@Column(name="TOPIC_NAME")
	private String topicName  ;
	
	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	
	
	public Topic(Long id, String topicName) {
		super();
		this.id = id;
		this.topicName = topicName;
	}

	public Topic() {
		super();
		
	}
	
	
	
	
	
	
}