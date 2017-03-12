package it.coderunner.dao;

import java.util.List;

import it.coderunner.model.Car;

public interface CarDAO {

	void save(Car c);
	
	List<Car> list();
	
}
