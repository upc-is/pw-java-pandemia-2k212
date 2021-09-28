package pe.edu.upc.pandemia.model.repository;

import java.util.List;

import pe.edu.upc.pandemia.model.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {
	List<Region> findByName(String name) throws Exception;
}
