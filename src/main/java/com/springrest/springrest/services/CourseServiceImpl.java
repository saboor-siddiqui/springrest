package com.springrest.springrest.services;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entitites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements  CourseService {
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl() {
//        list = new ArrayList<>();
//        list.add(new Course(145,"Java Core Course","Basics of Java"));
//        list.add(new Course(146,"Java Spring Boot","Creating Rest API using spring boot"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseDao.getById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course entity = courseDao.getById(courseId);
        courseDao.delete(entity);
    }

    @Override
    public Course updateCourse(Course course) {
        courseDao.save(course);
        return course;
    }
}
