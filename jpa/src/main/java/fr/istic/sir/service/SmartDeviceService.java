package fr.istic.sir.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import fr.istic.sir.resources.SmartDevice;

public class SmartDeviceService implements GenericService<SmartDevice> {
	private EntityManager manager;
	
	/**
	 * Init the entityManager
	 */
	public SmartDeviceService() {
		this.manager = Persistence.createEntityManagerFactory("mysql").createEntityManager();
	}

	/**
	 * Find a SmartDevice by an ID
	 * @param id
	 * @return SmartDevice
	 */
	public SmartDevice find(int id) {
		return manager.find(SmartDevice.class, id);
	}

	/**
	 * Delete a SmartDevice by this ID
	 * @param int id
	 */
	public void delete(SmartDevice s) {
		manager.getTransaction().begin();
		manager.remove(s);
		manager.getTransaction().commit();
	}
	
	/**
	 * Add a SmartDevice
	 * @param SmartDevice s
	 */
	public SmartDevice add(SmartDevice s) {
		manager.getTransaction().begin();
		manager.persist(s);
		manager.getTransaction().commit();
		return s;
	}

	public SmartDevice update(SmartDevice s) {
		manager.getTransaction().begin();
		manager.merge(s);
		manager.getTransaction().commit();
		return s;
	}

	public List<SmartDevice> findAll() {
		return manager.createQuery("SELECT s FROM SmartDevice s", SmartDevice.class).getResultList();
	}

}
