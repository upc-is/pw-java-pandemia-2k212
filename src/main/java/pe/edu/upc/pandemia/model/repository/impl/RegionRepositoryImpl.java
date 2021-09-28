package pe.edu.upc.pandemia.model.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.model.repository.RegionRepository;

@Named
@ApplicationScoped
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
		return findByQuery(Region.class, jpql);
	}

	@Override
	public List<Region> findByName(String name) throws Exception {
		String jpql = "SELECT r FROM Region r WHERE r.name LIKE '%" + name + "%'" ;	
		System.out.println(jpql);
		return findByQuery(Region.class, jpql);
	}

	
}
