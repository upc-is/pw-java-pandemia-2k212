package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Location;
import pe.edu.upc.pandemia.model.repository.LocationRepository;

public class LocationRepositoryImpl implements LocationRepository {

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Location> findById(Integer id) throws Exception {
		return findById(id, Location.class);
	}

	@Override
	public List<Location> findAll() throws Exception {
		String jpql = "SELECT lo FROM Location lo";	
		return findAll(Location.class, jpql);
	}

}
