package com.ons.produits.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ons.produits.entities.Produit;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}