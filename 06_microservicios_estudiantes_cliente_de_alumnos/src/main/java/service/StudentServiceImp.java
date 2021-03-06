package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Student;

@Service
public class StudentServiceImp implements StudentService {

	RestTemplate template;
	String urlBase="http://localhost8000/crud";
	
	public StudentServiceImp(@Autowired RestTemplate template) {
		super();
		this.template = template;
	}
	
	@Override
	public void altaStudent(Student student) {
		template.postForLocation(urlBase+"/Alumno", student);

	}

	@Override
	public List<Student> studentPorPuntuacionMinima(double puntuacion) {
		//el rest template solo retorna arrays de objetos
		Student[] estudiantes =template.getForObject(urlBase+"/Alumnos", Student[].class);
		//utilizamos streams para filtrar y transformar en lista
		return Arrays.stream(estudiantes)
		.filter(s->s.getPuntuacion()>puntuacion)
		.collect(Collectors.toList()); //List de students con filtrado por nota
	}

}
