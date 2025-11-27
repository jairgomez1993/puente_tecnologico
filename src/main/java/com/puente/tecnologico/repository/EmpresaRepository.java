package com.puente.tecnologico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.puente.tecnologico.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}