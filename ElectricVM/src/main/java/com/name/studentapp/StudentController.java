package com.name.studentapp;

import jakarta.ws.rs.*;

import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/students")

public class StudentController {

	private StudentDAO studentDAO = new StudentDAO();

	@GET

	@Produces(MediaType.APPLICATION_JSON)

	public List<Student> getAllStudents() {

		return studentDAO.readAll();

	}

	@POST

	@Consumes(MediaType.APPLICATION_JSON)

	@Produces(MediaType.APPLICATION_JSON)

	public Student createStudent(Student student) {

		return studentDAO.create(student);

	}

	@GET

	@Path("/{id}")

	@Produces(MediaType.APPLICATION_JSON)

	public Student getStudent(@PathParam("id") int id) {

		return studentDAO.read(id);

	}

	@PUT

	@Path("/{id}")

	@Consumes(MediaType.APPLICATION_JSON)

	@Produces(MediaType.APPLICATION_JSON)

	public Student updateStudent(@PathParam("id") int id, Student student) {

		return studentDAO.update(id, student);

	}

	@DELETE

	@Path("/{id}")

	@Produces(MediaType.APPLICATION_JSON)

	public void deleteStudent(@PathParam("id") int id) {

		studentDAO.delete(id);

	}

}