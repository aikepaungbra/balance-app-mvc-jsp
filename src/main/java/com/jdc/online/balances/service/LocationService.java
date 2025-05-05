package com.jdc.online.balances.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.online.balances.model.entity.District;
import com.jdc.online.balances.model.entity.Region;
import com.jdc.online.balances.model.entity.Township;
import com.jdc.online.balances.model.repo.DistrictRepo;
import com.jdc.online.balances.model.repo.RegionRepo;
import com.jdc.online.balances.model.repo.TownshipRepo;
import com.jdc.online.balances.utils.EntityOperations;

import lombok.RequiredArgsConstructor;
import lombok.var;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationService {
	
	private final RegionRepo regionRepo;
	private final DistrictRepo districtRepo;
	private final TownshipRepo townshipRepo;

	
	public List<Region> getAllLocations() {
		return regionRepo.findAll();
	}


	public List<District> findDistrictByRegion(int regionId) {
		return districtRepo.findByRegionId(regionId);
	}


	public List<Township> findTownshipByDistrict(int districtId) {
		return townshipRepo.findByDistrictId(districtId);
	}


	public List<District> getDistrictsForSelectedTownship(Integer townshipId) {
		
		if(null != townshipId) {
			
			var township = EntityOperations.safeCall(
					townshipRepo.findById(townshipId),
					"township", "id", townshipId);
			
			var regionId = township.getDistrict().getRegion().getId();
			return districtRepo.findByRegionId(regionId);
		}
		
		return null;
	}


	public List<Township> getTownshipsForSelectedTownship(Integer townshipId) {
		
		if(null != townshipId) {
					
			var township = EntityOperations.safeCall(
					townshipRepo.findById(townshipId),
					"township", "id", townshipId);
			
			var districtId = township.getDistrict().getId();
			return townshipRepo.findByDistrictId(districtId);
		}
		
		return null;
	}

}
