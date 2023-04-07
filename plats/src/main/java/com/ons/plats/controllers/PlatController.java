package com.ons.plats.controllers;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ons.plats.entities.Plat;
import com.ons.plats.service.PlatService;

@Controller
public class PlatController {

	@Autowired
	PlatService platService;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createPlat";
	}
	@RequestMapping("/savePlat")
	public String savePlat(@ModelAttribute("plat") Plat plat, 
	 @RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date datePreparation = dateformat.parse(String.valueOf(date));
	 plat.setDatePreparation(datePreparation);
	 
	Plat savePlat = platService.savePlat(plat);
	String msg ="plat enregistré avec Id "+savePlat.getIdPlat();
	modelMap.addAttribute("msg", msg);
	return "createPlat";
	}
	

	
	@RequestMapping("/modifierPlat")
	public String editerPlat(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Plat p= platService.getPlat(id);
	modelMap.addAttribute("plat", p);
	return "editerPlat";
	}
	
	@RequestMapping("/updatePlat")
	public String updatePlat(@ModelAttribute("plat") Plat plat,
	@RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date datePreparation = dateformat.parse(String.valueOf(date));
	 plat.setDatePreparation(datePreparation);
	 
	 platService.updatePlat(plat);
	 List<Plat> pls = platService.getAllPlats();
	 modelMap.addAttribute("plats", pls);
	return "listePlats";
	}
	
	@RequestMapping("/ListePlats")
	public String listePlats(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	Page<Plat> pls = platService.getAllPlatsParPage(page, size);
	modelMap.addAttribute("plats", pls);
	 modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listePlats";
	}
	
	@RequestMapping("/supprimerPlat")
	public String supprimerPlat(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	platService.deletePlatById(id);
	Page<Plat> pls = platService.getAllPlatsParPage(page, 
	size);
	modelMap.addAttribute("plats", pls);
	modelMap.addAttribute("pages", new int[pls.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listePlats";
	}

	
	
	
}
