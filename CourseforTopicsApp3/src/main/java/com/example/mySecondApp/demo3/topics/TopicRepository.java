package com.example.mySecondApp.demo3.topics;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic, Long>
{
	//public Course findBycourseId(Long CourseId);
	
	@Query(value= "select * from  TOPIC" , nativeQuery=true )
	public List<Topic> findAllTopics(Pageable pageable);
}