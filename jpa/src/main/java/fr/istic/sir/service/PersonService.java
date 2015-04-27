package fr.istic.sir.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.istic.sir.resources.Person;

public class PersonService implements GenericService<Person>{

	private EntityManager manager;
	
	/**
	 * Init the entityManager
	 */
	public PersonService() {
		this.manager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
	}

	/**
	 * Find a Person by an ID
	 * @param id
	 * @return SmartDevice
	 */
	public Person find(int id) {
		Person person = manager.find(Person.class, id);
		return person;
	}
	

	public List<Person> findAll() {
		return manager.createQuery("Select p FROM Person p",Person.class).getResultList();
	}

	/**
	 * Add one person in the db
	 * @param Person person
	 */
	public Person add(Person person) {
		manager.getTransaction().begin();
		manager.persist(person);
		manager.getTransaction().commit();
		return person;
	}

	public Person update(Person person) {
		manager.getTransaction().begin();
		manager.merge(person);
		manager.getTransaction().commit();
		return person;
	}

	public void delete(Person person) {
		manager.getTransaction().begin();
		manager.remove(person);
		manager.getTransaction().commit();
	}
}
