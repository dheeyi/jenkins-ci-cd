package com.jenkins_ci_cd.jenkins_ci_cd;

import com.jenkins_ci_cd.jenkins_ci_cd.Controller.CourseController;
import com.jenkins_ci_cd.jenkins_ci_cd.Services.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(CourseController.class)
public class JenkinsCiCdApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testNameApp() throws Exception {
		String defaultCourse = "Curso: CI/CD con Jenkins y CircleCI";
		when(courseService.getNameCourse(defaultCourse)).thenReturn(defaultCourse);

		mockMvc.perform(get("/api/v1/nameCourse"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.course", is(defaultCourse)))
				.andExpect(jsonPath("$.status", is("success")));
	}
}