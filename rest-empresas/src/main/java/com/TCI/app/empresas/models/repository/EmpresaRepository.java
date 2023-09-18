package com.TCI.app.empresas.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TCI.app.empresas.models.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	List<Empresa> findTop3ByOrderByIdEmpresaDesc();
	
	List<Empresa> findAllByOrderByIdEmpresaDesc();
	

}
