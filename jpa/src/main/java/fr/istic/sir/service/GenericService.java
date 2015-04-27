package fr.istic.sir.Service;

import java.util.List;

public interface GenericService<T> {
	public T find(int id);
	public List<T> findAll();
	public T add(T t);
	public T update(T t);
	public void delete(T t);
}
