package com.jjh.students;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class App {
	public static void main(String[] args) {
		System.out.println("Starting");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPA");
		EntityManager em = emf.createEntityManager();
		
		System.out.println("Find a student by ID");
		Student student = em.find(Student.class, 1);
		System.out.println(student);

		// Create a new Student
		Student s1 = new Student(7,
				"Bill",
				"John",
				"Games",
				"bj@my.com");
		em.getTransaction().begin();
        em.persist(s1);
        em.getTransaction().commit();
		System.out.println("Stored student: " + s1);

		System.out.println("--------");

        // Retrieve all students

		System.out.println("Final All students");
		String jql = "SELECT e FROM Student e";
		TypedQuery<Student> query = em.createQuery(jql, Student.class);
		List<Student> results = query.getResultList();
		for (Student s : results) {
			System.out.println(s);	
		}

		System.out.println("--------");

		// Retrieve all students doing games
		System.out.println("Final All students where subject is games");
		String jql2 = "SELECT e FROM Student e WHERE e.subject = 'Games'";
		TypedQuery<Student> query2 = em.createQuery(jql2, Student.class);
		List<Student> results2 = query2.getResultList();
		for (Student s : results2) {
			System.out.println(s);
		}

		// Update the object we created from the database

		System.out.println("Update students name");
		Student s2 = em.find(Student.class, 7);
		s2.setName("William");
		em.getTransaction().begin();
		em.persist(s2);
		em.getTransaction().commit();

		Student student2 = em.find(Student.class, 7);
		System.out.println(student2);

        // Delete the object we created from the database

		Student s3 = em.find(Student.class, 7);
		em.getTransaction().begin();
		em.remove(s3);
		em.getTransaction().commit();

		System.out.println("Done");

	}
}
