package fr.istic.sir.rest;

import java.util.List;

public interface GenericResource<T> {
	public List<T> getAll();
	public T get(int id);
	public void delete(int id);
	public void add(String jsonResult);	
}
