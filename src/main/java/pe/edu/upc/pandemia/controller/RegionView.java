package pe.edu.upc.pandemia.controller;

import java.io.Serializable;
import java.util.ArrayList;
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
	private Region regionSelected;
	private List<Region> regionsSelected;	
	
	@Inject
	private RegionService regionService;
	
	@PostConstruct
	public void init() {
		regionsSelected = new ArrayList<>();
		try {
			regions = regionService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasRegionsSelected() {
		if (regionsSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public List<Region> getRegions() {
		return regions;
	}

	public void setRegionService(RegionService regionService) {
		this.regionService = regionService;
	}

	public Region getRegionSelected() {
		return regionSelected;
	}

	public void setRegionSelected(Region regionSelected) {
		this.regionSelected = regionSelected;
	}

	public List<Region> getRegionsSelected() {
		return regionsSelected;
	}

	public void setRegionsSelected(List<Region> regionsSelected) {
		this.regionsSelected = regionsSelected;
	}
	
}
