package com.prueba.imatia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.imatia.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
