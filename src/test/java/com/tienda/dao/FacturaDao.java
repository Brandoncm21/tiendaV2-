package com.tienda.dao;

import com.tienda.domain.Facturar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository<Facturar, Long> {
 }
