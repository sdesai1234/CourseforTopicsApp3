package com.example.mySecondApp.demo3.topics;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TopicController
{
	 @Autowired
	 public TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics()
	{  //need to pass column name rather than entity for native SQL query
		List<Topic> Topics = topicService.getAllTopicsfromRepo(PageRequest.of(0, 5, Sort.by("TOPIC_ID").ascending().and(Sort.by("TOPIC_NAME").ascending())));
	   //.by("TOPIC_NAME").descending())
	   return Topics;
	}
	
	@GetMapping("/topics/{Id}")
	public Optional<Topic> getAllTopics(@PathVariable long Id)
	{
	    Optional<Topic> Topic = topicService.getTopicfromRepo(Id);
		System.out.println(topicService.getTopicfromRepo(10001));
	     return Topic ;
	}
	
	@PostMapping("/topics")
	public void createNewTopic(@RequestBody Topic requestedNewTopic)
	{
		topicService.createNewTopicinRepo(requestedNewTopic);
	  // return Topics;
	}
	
	@PutMapping("/topics/{Id}")
	public void createNewTopic(@PathVariable long Id,@RequestBody Topic requestedNewTopic)
	{
		topicService.updateTopicinRepo(Id,requestedNewTopic);
	  // return Topics;
	}
	
	@DeleteMapping("/topics/{Id}")
	public void deleteTopic(@PathVariable long Id)
	{
		
		topicService.deleteTopicinRepo(Id);
	}
	
	
	
	
}
