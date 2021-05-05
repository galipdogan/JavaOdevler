package Utils;

import Entities.Order;

public interface BaseCrudManager<T> {
	void add(T entity);
	void update(T entity);
	void delete(T entity);
}
