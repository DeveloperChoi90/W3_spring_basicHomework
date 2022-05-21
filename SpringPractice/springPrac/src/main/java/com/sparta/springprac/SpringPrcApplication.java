package com.sparta.springprac;

import com.sparta.springprac.domain.Course;
import com.sparta.springprac.domain.CourseRepository;
import com.sparta.springprac.domain.CourseRequestDto;
import com.sparta.springprac.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class SpringPrcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrcApplication.class, args);
	}
	// Week02Application.java 의 main 함수 아래에 붙여주세요.

	@Bean
	public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
		return (args) -> {
			courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

			System.out.println("데이터 인쇄");
			List<Course> courseList = courseRepository.findAll();
			showList(courseList);

//			Course new_course = new Course("웹개발의 봄, Spring", "임민영");
			CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
			courseService.update(1L, requestDto);
			courseList = courseRepository.findAll();
			showList(courseList);

//			courseRepository.deleteAll();
		};
	}

	private void showList(List<Course> courseList) {
		for (Course course : courseList) {
			System.out.println(course.getId());
			System.out.println(course.getTitle());
			System.out.println(course.getTutor());
		}
	}
}
