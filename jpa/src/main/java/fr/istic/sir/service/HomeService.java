package fr.istic.sir.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.istic.sir.resources.Home;

public class HomeService implements GenericService<Home>{
	
	private EntityManager manager;
	
	/**
	 * Init the entityManager
	 */
	public HomeService() {
		this.manager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
	}
	
	/**
	 * Get a home by an ID
	 * @param id
	 * @return Home
	 */
	public Home find(int id) {
		Home home = manager.find(Home.class, id);
		return home;
	}
	
	public List<Home> findAll() {
		return manager.createQuery("SELECT h FROM Home h", Home.class).getResultList();
	}

	/**
	 * Add a Home
	 * @param Home home
	 */
	public Home add(Home home) {
		manager.getTransaction().begin();
		manager.persist(home);
		manager.getTransaction().commit();
		return home;
	}

	public Home update(Home home) {
		manager.getTransaction().begin();
		manager.merge(home);
		manager.getTransaction().commit();
		return home;
	}

	/**
	 * Delete a Home by this ID
	 * @param int id
	 */
	public void delete(Home home) {
		manager.getTransaction().begin();
		manager.merge(home);
		manager.getTransaction().commit();
	}
}
