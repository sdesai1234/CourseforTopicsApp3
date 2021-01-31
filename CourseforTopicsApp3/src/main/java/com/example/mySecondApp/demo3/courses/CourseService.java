package com.example.mySecondApp.demo3.courses;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mySecondApp.demo3.Exceptions.CourseAlreadyExistsException;
import com.example.mySecondApp.demo3.Exceptions.CourseNotPresentException;

@Service
class CourseService
{
	@Autowired
	public CourseRepository courseRepo;
	
	
	
	public List<Course> getAllCoursesfromRepo()
	{
		//List<Course> Courses= (List<Course>)courseRepo.findAll();
		
		//Course Course1=new Course(new Long(1),"Snehal");
		//List<Course> Courses=new ArrayList<Course>();
		//Courses.add(Course1);
		List<Course> Courses=courseRepo.getAll(Sort.by("CourseId"));
		
	  return Courses;
	}
	
	
	public Optional<Course> getCoursefromRepo(long id)
	{
		//courseRepo.findById(id)
		if(!courseRepo.existsById(id))
			throw new CourseNotPresentException("Course not present in the system"); 
		return courseRepo.findById(id);
		
		
	}
	
	
	/*
	public Optional<Course> getCoursefromRepo(long id)
	{
		//courseRepo.findById(id)
		return courseRepo.findById(id);
	}
	*/
	public void createNewCourseinRepo(Course NewCourse)
	{
		Long newCourseId=NewCourse.getCourseId();
		if(courseRepo.existsById(newCourseId))
			throw new CourseAlreadyExistsException("Course alreay present in the system");
		courseRepo.save(NewCourse);
		
	
	}
	
	public void updateCourseinRepo(Long id,Course NewCourse )
	{
		if(courseRepo.existsById(id))
              courseRepo.save(NewCourse);
		else throw new CourseNotPresentException("Course not present in the system"); 
	}
	
	public void deleteCourseinRepo(Long id)
	{
		if(courseRepo.existsById(id))
		{
			//System.out.println("Inside delete course request");
		courseRepo.deleteById(id);
		}
		else throw new CourseNotPresentException("Course not present in the system"); 
	}
	
	public List<Course> getAllTopicCoursesfromRepo(Long i)
	{
		System.out.println("Inside getAllTopicCoursesfromRepo method "+ courseRepo.getAllByTopicId(i));
		List<Course> Courses= courseRepo.getAllByTopicId(i)	;
		//Course Course1=new Course(new Long(1),"Snehal");
		//List<Course> Courses=new ArrayList<Course>();
		//Courses.add(Course1);
	  return Courses;
	}
	
	
	public List<Course> getAllTopicCoursesfromByName(Long id,String topicName)
	{
		System.out.println("Inside getAllTopicCoursesfromRepo method "+ courseRepo.getAllByName(id,topicName));
		List<Course> Courses= courseRepo.getAllByName(id,topicName)	;
	    return Courses;
	}
	
	
	public List<Course> getAllCourses(Pageable  pageable)
	{
		
		return courseRepo.findAllCourses(pageable);
	}
	
}
