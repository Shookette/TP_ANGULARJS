package fr.istic.sir.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import fr.istic.sir.resources.SmartDevice;

public class SmartDeviceService {
	private EntityManager manager;
	
	/**
	 * Init the entityManager
	 */
	public SmartDeviceService() {
		this.manager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
	}
	
	private String findById = "SELECT s FROM SmartDevice s WHERE id = :id";
	private String findAll = "SELECT s FROM SmartDevice s";
	
	/**
	 * Get a SmartDevice by an ID
	 * @param id
	 * @return SmartDevice
	 */
	public SmartDevice getById(int id) {
		try {
			SmartDevice smartDevice = manager.createQuery(findById, SmartDevice.class)
				.setParameter("id",id).getSingleResult();
			return smartDevice;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	/**
	 * Return All the SmartDevice recorded in the DB
	 * @return List<SmartDevice>
	 */
	public List<SmartDevice> getAll() {
		try {
			List<SmartDevice> ls = manager.createQuery(findAll, SmartDevice.class).getResultList();
			return ls;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * Delete a SmartDevice by this ID
	 * @param int id
	 */
	public void delete(int id) {
		manager.getTransaction().begin();
		manager.remove(manager.find(SmartDevice.class, id));
		manager.getTransaction().commit();
		manager.close();
	}
	
	/**
	 * Add a SmartDevice
	 * @param SmartDevice s
	 */
	public void add(SmartDevice s) {
		manager.getTransaction().begin();
		manager.persist(s);
		manager.flush();
		manager.getTransaction().commit();
		manager.close();
	}
}
