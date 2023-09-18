package com.TCI.app.empresas.models.services;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.TCI.app.empresas.models.entity.Empresa;
public interface IEmpresaServices {
	
	public Empresa findById(Long idEmpresa);
	public Empresa registrarEmpresa(Empresa empresa);
	public List<Empresa> listarEmpresas();
    public List<Empresa> obtenerUltimosTresRegistros();
    public List<Empresa> obtenerUltimosRegistros(int cantidad);
    public ResponseEntity<HttpStatus> deleteById(Long idEmpresa);
    public ResponseEntity<HttpStatus> editById(Long idEmpresa);
}
