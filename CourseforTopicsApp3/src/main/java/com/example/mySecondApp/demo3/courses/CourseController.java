package com.example.mySecondApp.demo3.courses;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mySecondApp.demo3.Exceptions.CourseAlreadyExistsException;
import com.example.mySecondApp.demo3.Exceptions.CourseNotPresentException;
import com.example.mySecondApp.demo3.topics.Topic;

import  com.example.mySecondApp.demo3.Exceptions.CourseCentralizedExecptionHandler;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@RestController
class CourseController
{
	 @Autowired
	 public CourseService courseService;
	
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		
		//sort data by course_id 
		List<Course> Courses =courseService.getAllCoursesfromRepo();
		
		return  ResponseEntity.ok(Courses) ;
		
		
	  // return Courses;
	}
	
	
	
	@GetMapping("/courses/{Id}")
	public ResponseEntity<Optional<Course>> getAllCourses(@PathVariable(value="Id") long Id)
	{
		try {
	    Optional<Course> course = courseService.getCoursefromRepo(Id);
	    return ResponseEntity.ok(course) ;
	   // return course ;
		}
		catch(CourseNotPresentException e)
		{
			
			return  ResponseEntity.notFound().build();
		}
		
	    
		//System.out.println(courseService.getCoursefromRepo(10001));
	     } 
	  
	
	/*
	
	@GetMapping("/courses/{Id}")
	public Optional<Course> getAllCourses(@PathVariable(value="Id") long Id)
	{
	    Optional<Course> course = courseService.getCoursefromRepo(Id);
		//System.out.println(courseService.getCoursefromRepo(10001));
	     return course ;
	}
	*/
	
	@PostMapping("/courses")
	public void createNewCourse(@RequestBody Course requestedNewcourse)
	//public  ResponseEntity<Course> createNewCourse(@RequestBody Course requestedNewcourse)
	{
		//try {
		requestedNewcourse.setTopic(new Topic(new Long(2),""));
		
		courseService.createNewCourseinRepo(requestedNewcourse);
		//return ResponseEntity.created(null).build();
		//}
		//catch(CourseAlreadyExistsException e)
		//{
		//	return ResponseEntity.badRequest().build();	
			
		//}
	  // return Courses;
	}
	
	@PutMapping("/courses/{Id}")
	public ResponseEntity<String> updateCourse(@PathVariable long Id,@RequestBody Course requestedNewcourse)
	{
		
		try {
		courseService.updateCourseinRepo(Id,requestedNewcourse);
		return ResponseEntity.ok().build();
		}
		catch(CourseNotPresentException e){
			return ResponseEntity.badRequest().build();    //of(e.getMessage()).build();
					//.notFound().build();
		}
	  // return Courses;
	}
	
	@DeleteMapping("/courses/{Id}")
	public ResponseEntity<String> deleteCourse(@PathVariable long Id)
	{
		try {
		courseService.deleteCourseinRepo(Id);
		return ResponseEntity.ok().build();
		}
		catch(CourseNotPresentException e){
			return ResponseEntity.badRequest().build();    //of(e.getMessage()).build();
					//.notFound().build();
		}
	}
	
	
	//topic-course api's
	
		@GetMapping("/topics/{topicid}/courses/{courseId}")
		public ResponseEntity<Optional<Course>> getTopicCourse(@PathVariable long courseId)
		{
			// Optional<Course> course = courseService.getCoursefromRepo(courseId);
				
			  //   return course ;
			     
			     
			  try {
			 	    Optional<Course> course = courseService.getCoursefromRepo(courseId);
			 	    return ResponseEntity.ok(course) ;
			 	   // return course ;
			 		}
			 		catch(CourseNotPresentException e)
			 		{
			 			
			 			return  ResponseEntity.notFound().build();
			 		}
		}
		
		@GetMapping("/topics/{topicid}/courses")
		public List<Course> getTopicAllCourses(@PathVariable Long topicid)
		{
			List<Course> Courses =courseService.getAllTopicCoursesfromRepo(topicid);
		   return Courses;
		}
	
		
		@PostMapping("/topics/{topicid}/courses")
		public void createNewTopicCourse(@RequestBody Course requestedNewcourse,@PathVariable Long topicid )
		{
			requestedNewcourse.setTopic(new Topic(topicid,""));
			courseService.createNewCourseinRepo(requestedNewcourse);
		  // return Courses;
		}
		
		@PutMapping("topics/{topicid}/courses/{Id}")
		public void updateTopicCourse(@PathVariable long Id,@RequestBody Course requestedNewcourse)
		{
			//set proper Topic for updated Course
			
			courseService.updateCourseinRepo(Id,requestedNewcourse);
		  // return Courses;
		}
		
		@DeleteMapping("topics/{topicid}/courses/{Id}")
		public void deleteTopicCourse(@PathVariable long Id)
		{
			
			courseService.deleteCourseinRepo(Id);
		}
		
		@GetMapping("/courses/courseinfo")
		public List<Course> getCoursesByName(@RequestParam(value="id") Long id, @RequestParam(value="name") String name)
		{
			
			List<Course> l=courseService.getAllTopicCoursesfromByName(id,name);
			return l;		
		}
		@GetMapping("/courses/allcourseinfobyPages")
		public List<Course> getAllCoursesbyPagination()
		{
		return courseService.getAllCourses(PageRequest.of(0, 2, Direction.ASC, "COURSE_ID"));
		}
}
