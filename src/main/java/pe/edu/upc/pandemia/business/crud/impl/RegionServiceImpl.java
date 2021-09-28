package pe.edu.upc.pandemia.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.RegionService;
import pe.edu.upc.pandemia.model.entity.Region;
import pe.edu.upc.pandemia.model.repository.JpaRepository;
import pe.edu.upc.pandemia.model.repository.RegionRepository;

@Named
@ApplicationScoped
public class RegionServiceImpl implements RegionService {

	@Inject
	private RegionRepository regionRepository;
	
	@Override
	public JpaRepository<Region, Integer> getJpaRepository() {
		return regionRepository;
	}

	@Override
	public List<Region> findByName(String name) throws Exception {
		return regionRepository.findByName(name);
	}
	

}
