package service;

import java.util.List;

import model.Alumno;

public interface AlumnoService {
	void altaAlumno(Alumno a);
	Alumno buscarAlumno(int idAlumno);
	boolean eliminarAlumno(int idAlumno);
	boolean actualizarAlumno(int idAlumno,String curso);
	List<Alumno> buscarAlumnos();
	List<String> buscarCursos();
}
