package fr.istic.sir.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import fr.istic.sir.resources.Person;

public class PersonService {

	private EntityManager manager;
	
	/**
	 * Init the entityManager
	 */
	public PersonService() {
		this.manager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
	}
	
	private String findById = "SELECT p FROM Person p WHERE id = :id";
	private String findAll = "SELECT p FROM Person p";
	
	/**
	 * Get a Person by an ID
	 * @param id
	 * @return SmartDevice
	 */
	public Person getById(int id) {
		try {
			Person person = manager.createQuery(findById, Person.class)
				.setParameter("id",id).getSingleResult();
			return person;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Get all Person
	 * @return List<Person>
	 */
	public List<Person> getAll() {
		try {
			List<Person> lp = manager.createQuery(findAll, Person.class).getResultList();
			return lp;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Delete one person with his id
	 * @param int id
	 */
	public void delete(int id) {
		manager.getTransaction().begin();
		manager.remove(manager.find(Person.class, id));
		manager.getTransaction().commit();
		manager.close();
	}
	
	/**
	 * Add one person in the db
	 * @param Person person
	 */
	public void add(Person person) {
		manager.getTransaction().begin();
		manager.persist(person);
		manager.flush();
		manager.getTransaction().commit();
		manager.close();
	}
}
