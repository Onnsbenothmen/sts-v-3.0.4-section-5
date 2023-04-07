package com.ons.plats;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ons.plats.entities.Plat;
import com.ons.plats.repos.PlatRepository;
import com.ons.plats.service.PlatService;

@SpringBootTest
class PlatsApplicationTests {

	@Autowired
	private PlatRepository platRepository;
	@Autowired

	private PlatService platService;
	@Test
	public void testCreatePlat() {
	Plat pl = new Plat("lazagne",34.900,new Date());
	platRepository.save(pl);
	System.out.println(pl);

	}
	
	@Test
	public void testFindPlat()
	{
	Plat p = platRepository.findById(1L).get(); 
	System.out.println(p);
	}
	
	@Test
	public void testUpdatePlat()
	{
	Plat p = platRepository.findById(1L).get();
	p.setPrixPlat(10.800);
	platRepository.save(p);
	System.out.println(p);

	}
	
	@Test
	public void testDeletePlat()
	{
	platRepository.deleteById(3L);;
	}
	 
	@Test
	public void testListerTousPlats()
	{
	List<Plat> pls = platRepository.findAll();
	for (Plat p : pls)
	{
	System.out.println(p);
	}
	}

	@Test
	public void testFindByNomPlatContains()
	{
	Page<Plat> pls = platService.getAllPlatsParPage(0,2);
	System.out.println(pls.getSize());
	System.out.println(pls.getTotalElements());
	System.out.println(pls.getTotalPages());
	pls.getContent().forEach(p -> {System.out.println(p.toString());
	 });
	/*ou bien
	for (Plat p : pls)
	{
	System.out.println(p);
	} */
	}
}
