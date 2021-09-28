package pe.edu.upc.pandemia.model.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.edu.upc.pandemia.model.entity.Location;
import pe.edu.upc.pandemia.model.repository.LocationRepository;

@Named
@ApplicationScoped
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
		return findByQuery(Location.class, jpql);
	}

	@Override
	public List<Location> findByCity(String city) throws Exception {		
		return findByField("city", city);
	}

	@Override
	public List<Location> findByStateProvince(String stateProvince) throws Exception {
		return findByField("state_province", stateProvince);
	}
	
	private List<Location> findByField(String field, String value) throws Exception {
		List<Location> locations = new ArrayList<>();
		String jpql = "SELECT lo FROM Location lo WHERE lo." + field + " = '" + value + "'";	
		TypedQuery<Location> typedQuery = getEntityManager().createQuery(jpql, Location.class);
		locations = typedQuery.getResultList();		
		return locations;
	}

}
