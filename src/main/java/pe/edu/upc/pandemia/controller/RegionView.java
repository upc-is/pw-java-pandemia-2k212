package pe.edu.upc.pandemia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.pandemia.business.crud.RegionService;
import pe.edu.upc.pandemia.model.entity.Region;

@Named("regionView")
@ViewScoped
public class RegionView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Region> regions;
	private Region regionSelected;
	private List<Region> regionsSelected;
	private Region regionSearch;
	
	@Inject
	private RegionService regionService;
	
	@PostConstruct
	public void init() {
		regionsSelected = new ArrayList<>();
		regionSearch = new Region();
		getAllRegion();
	}
	
	public boolean hasRegionsSelected() {
		if (regionsSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasRegionSelected() {
		if (regionsSelected.size() == 1) {
			return true;
		}
		return false;
	}
	public void createNew() {
		regionSelected = new Region();		
	}
	public void editRegionSelected() {
		regionSelected = regionsSelected.get(0);
	}
	public void saveRegion() {
		try {
			if (regionSelected.getId() == null) {
				regionService.create(regionSelected);
				regions.add(regionSelected);
			} 
			else {
				regionService.update(regionSelected);
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('regionDialog').hide()");
        PrimeFaces.current().ajax().update("regionDataTable");
	}
	public void deleteRegion() {
		try {
			this.regions.remove(regionSelected);
			regionService.deleteById(this.regionSelected.getId());
			this.regionSelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		//PrimeFaces.current().ajax().update("form:messages", "regionDataTable");
	}
	public void searchRegion() {
		try {
			regions = regionService.findByName(regionSearch.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllRegion() {
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

	public Region getRegionSearch() {
		return regionSearch;
	}

	public void setRegionSearch(Region regionSearch) {
		this.regionSearch = regionSearch;
	}
	
}
