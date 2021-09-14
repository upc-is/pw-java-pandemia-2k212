package pe.edu.upc.pandemia.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.pandemia.business.crud.RegionService;
import pe.edu.upc.pandemia.model.entity.Region;

@Named("regionView")
@ViewScoped
public class RegionView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Region> regions;
	
	@Inject
	private RegionService regionService;
	
	@PostConstruct
	public void init() {
		try {
			regions = regionService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Region> getRegions() {
		return regions;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

}
