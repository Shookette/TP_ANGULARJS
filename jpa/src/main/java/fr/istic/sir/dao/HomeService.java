package fr.istic.sir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import fr.istic.sir.resources.Home;
import fr.istic.sir.resources.SmartDevice;

public class HomeService {
	
	private EntityManager manager;
	
	/**
	 * Init the entityManager
	 */
	public HomeService() {
		this.manager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
	}
	
	private String findById = "SELECT h FROM Home h WHERE id = :id";
	private String findAll = "SELECT h FROM Home h";
	
	/**
	 * Get a home by an ID
	 * @param id
	 * @return Home
	 */
	public Home getById(int id) {
		try {
			Home home = manager.createQuery(findById, Home.class)
				.setParameter("id",id).getSingleResult();
			return home;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Return All the Home recorded in the DB
	 * @return List<Home>
	 */
	public List<Home> getAll() {
		try {
			List<Home> lh = manager.createQuery(findAll, Home.class).getResultList();
			return lh;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Delete a Home by this ID
	 * @param int id
	 */
	public void delete(int id) {
		manager.getTransaction().begin();
		manager.remove(manager.find(Home.class, id));
		manager.getTransaction().commit();
		manager.close();
	}

	/**
	 * Add a Home
	 * @param Home home
	 */

	public void add(Home home) {
		manager.getTransaction().begin();
		manager.persist(home);
		manager.flush();
		manager.getTransaction().commit();
		manager.close();
	}
	
	/**
	 * Add device for one home
	 * @param id
	 * @param SmarthDevice device
	 */
	public void addDevice(int id, SmartDevice device) {
		Home home = this.getById(id);
		manager.getTransaction().begin();
		home.addDevice(device);
		manager.getTransaction().commit();
		manager.close();
	}

}
