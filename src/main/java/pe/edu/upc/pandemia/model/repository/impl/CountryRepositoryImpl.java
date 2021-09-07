package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Country;
import pe.edu.upc.pandemia.model.repository.CountryRepository;

public class CountryRepositoryImpl implements CountryRepository {

	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Country> findById(String id) throws Exception {
		return findById(id, Country.class);
	}

	@Override
	public List<Country> findAll() throws Exception {
		String jpql = "SELECT country FROM Country country";	
		return findAll(Country.class, jpql);
	}

}
