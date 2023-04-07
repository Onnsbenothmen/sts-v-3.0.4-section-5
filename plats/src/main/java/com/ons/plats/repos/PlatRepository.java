package com.ons.plats.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ons.plats.entities.Plat;


public interface PlatRepository extends JpaRepository<Plat, Long>   {

}