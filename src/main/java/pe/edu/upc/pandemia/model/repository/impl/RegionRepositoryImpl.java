package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.model.repository.RegionRepository;

public class RegionRepositoryImpl implements RegionRepository {
	
	@PersistenceContext(unitName = "pandemiaPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public Optional<Region> findById(Integer id) throws Exception {				
		return findById(id, Region.class);
	}

	@Override
	public List<Region> findAll() throws Exception {
		// create a Sentence
		String jpql = "SELECT region FROM Region region";		
		return findAll(Region.class, jpql);
	}

}
