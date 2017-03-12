package it.coderunner.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import it.coderunner.dao.CarDAO;
import it.coderunner.model.Car;

@Repository
public class CarDAOImpl implements CarDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void save(Car c) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(c);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Car> list() {
		Session session = this.sessionFactory.openSession();
		List<Car> carList = session.createQuery("from Car").list();
		session.close();
		return carList;
	}

}