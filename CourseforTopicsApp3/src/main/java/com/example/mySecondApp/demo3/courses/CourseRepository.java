package com.example.mySecondApp.demo3.courses;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>
{   
	
    //below is JPQL Query 
	/*@Query(value="SELECT C FROM Course C INNER JOIN C.topic WHERE C.topic.id=?1 ") */
	
	
	/* FOR PRIMARY KEY NAME id(QUERY AS PER PREVIOUS APPLICATION ENTITY) : @Query(value="SELECT C.* FROM COURSE C , TOPIC T WHERE C.ID = T.ID AND T.ID=?1 ", nativeQuery=true) */
	/* To reduce ambiguity between primary key names , we can have column name as topic id and write SQL query like below */ 
	@Query(value="SELECT C.* FROM COURSE C , TOPIC T WHERE C.TOPIC_ID = T.TOPIC_ID AND T.TOPIC_ID=?1 ", nativeQuery=true)
	public List<Course> getAllByTopicId(Long id);
	
	
	
	//JPQL need entity names rather than table names , case sensitive
   /*@Query(value="SELECT C FROM Course C WHERE C.CourseId=?1 AND C.name=?2")*/
	
	//NATIVE SQL  need to specify column name of primary key and use it in query ,not case sensitive
	@Query(value="SELECT * FROM COURSE WHERE course_id=?1 AND name=?2", nativeQuery=true)
	public List<Course> getAllByName(Long CourseId, String name);
	
	@Query(value="SELECT * FROM COURSE", nativeQuery=true)
	public List<Course> findAllCourses(Pageable pageable);


	@Query(value="SELECT C FROM Course C")
	public List<Course> getAll(Sort sort);
	
	
	
	

}