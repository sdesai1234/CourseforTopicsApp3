package com.example.mySecondApp.demo3.topics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
class TopicService
{
	@Autowired
	public TopicRepository TopicRepo;
	
	public List<Topic> getAllTopicsfromRepo(Pageable pg)
	{
		
		//Long topicid
		List<Topic> Topics= TopicRepo.findAllTopics(pg);	
		//Topic Topic1=new Topic(new Long(1),"Snehal");
		//List<Topic> Topics=new ArrayList<Topic>();
		//Topics.add(Topic1);
	  return Topics;
	}
	
	
	public Optional<Topic> getTopicfromRepo(long id)
	{
		//TopicRepo.findById(id)
		return TopicRepo.findById(id);
	}
	
	public void createNewTopicinRepo(Topic NewTopic)
	{
		TopicRepo.save(NewTopic);
		
	
	}
	
	public void updateTopicinRepo(Long id,Topic NewTopic )
	{
		
		TopicRepo.save(NewTopic);
	}
	
	public void deleteTopicinRepo(Long id)
	{
		
		TopicRepo.deleteById(id);
	}
	
}
