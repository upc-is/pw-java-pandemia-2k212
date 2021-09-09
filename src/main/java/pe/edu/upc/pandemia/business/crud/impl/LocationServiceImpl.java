package pe.edu.upc.pandemia.business.crud.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.LocationService;
import pe.edu.upc.pandemia.model.entity.Location;
import pe.edu.upc.pandemia.model.repository.JpaRepository;
import pe.edu.upc.pandemia.model.repository.LocationRepository;

@Named
@ApplicationScoped
public class LocationServiceImpl implements LocationService {

	@Inject
	private LocationRepository locationRepository; 
	
	@Override
	public JpaRepository<Location, Integer> getJpaRepository() {
		return locationRepository;
	}

	@Override
	public List<Location> findByCity(String city) throws Exception {
		return locationRepository.findByCity(city);
	}

	@Override
	public List<Location> findByStateProvince(String stateProvince) throws Exception {
		return locationRepository.findByStateProvince(stateProvince);
	}
}
