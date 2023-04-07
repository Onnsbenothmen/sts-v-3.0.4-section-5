package com.ons.plats.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ons.plats.entities.Plat;

public interface PlatService {
	
	Plat savePlat(Plat pl);
	Plat updatePlat(Plat p);
	void deletePlat(Plat p);
	void deletePlatById(Long id);
	Plat getPlat(Long id);
	List<Plat> getAllPlats();
	Page<Plat> getAllPlatsParPage(int page, int size);

}
