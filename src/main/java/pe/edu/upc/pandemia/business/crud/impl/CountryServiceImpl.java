package pe.edu.upc.pandemia.business.crud.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.CountryService;
import pe.edu.upc.pandemia.model.entity.Country;
import pe.edu.upc.pandemia.model.repository.CountryRepository;
import pe.edu.upc.pandemia.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class CountryServiceImpl implements CountryService {

	@Inject
	private CountryRepository countryRepository;
	
	@Override
	public JpaRepository<Country, String> getJpaRepository() {
		return countryRepository;
	}

}
