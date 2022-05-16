package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.UserPwdDto;
import model.Student;

@Service
public class StudentServiceImp implements StudentService {

	RestTemplate template;
	String urlBase = "http://localhost:8000/crud";
	@Value("${user}")
	String user;
	@Value("${pwd}")
	String pwd;

	String token;

	public StudentServiceImp(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}

	private void getToken() {
		var dto = new UserPwdDto(user, pwd);
		token = template.postForObject(urlBase + "/login", dto, String.class);
	}
	
	private HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer " + token);
		return headers;
	}

	@Override
	public void altaStudent(Student student) {
		if (token == null || token.equals(""))
			getToken();

		
		template.exchange(urlBase + "/Alumno", HttpMethod.POST, new HttpEntity<>(student, getHeaders()), Void.class);
	}

	@Override
	public List<Student> studentPorPuntuacionMinima(double puntuacion) {

		if (token == null || token.equals(""))
			getToken();


		// el rest template solo retorna arrays de objetos
		Student[] estudiantes = template.exchange(urlBase + "/Alumnos", 
														HttpMethod.GET, 
														new HttpEntity<>(getHeaders()), 
														Student[].class).getBody();
		// utilizamos streams para filtrar y transformar en lista
		return Arrays.stream(estudiantes).filter(s -> s.getPuntuacion() >= puntuacion).collect(Collectors.toList()); // List
																													// de
																													// students
																													// con
																													// filtrado
																													// por
																													// nota
	}

}
