package com.TCI.app.empresas.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.TCI.app.empresas.models.entity.Empresa;
import com.TCI.app.empresas.models.repository.EmpresaRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpresaServiceImpl implements IEmpresaServices {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }
	
	@Override
	public Empresa findById(Long idEmpresa) {
	Optional<Empresa> empresaOptional=empresaRepository.findById(idEmpresa);
		return empresaOptional.orElse(null);
	}
	

	@Override
	@Transactional
	public Empresa registrarEmpresa(Empresa empresa) {
		return empresaRepository.save(empresa);
	}


	@Override
		public List<Empresa> obtenerUltimosTresRegistros() {
		return empresaRepository.findTop3ByOrderByIdEmpresaDesc();
		}

	@Override
	public List<Empresa> obtenerUltimosRegistros(int cantidad) {
		List<Empresa> todasLasEmpresas = empresaRepository.findAllByOrderByIdEmpresaDesc();
		if (cantidad >= todasLasEmpresas.size()) {
		       return todasLasEmpresas;
		  } else {
		        return todasLasEmpresas.subList(0, cantidad);
		  }
		}
	@Override
	@Transactional
		public ResponseEntity<HttpStatus> deleteById(Long idEmpresa) {
		try {
		empresaRepository.deleteById(idEmpresa);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	@Override
	public ResponseEntity<HttpStatus> editById(Long idEmpresa) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
