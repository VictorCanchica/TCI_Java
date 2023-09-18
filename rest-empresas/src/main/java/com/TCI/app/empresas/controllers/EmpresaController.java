package com.TCI.app.empresas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.TCI.app.empresas.models.entity.Empresa;
import com.TCI.app.empresas.models.services.IEmpresaServices;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
		
	@Autowired
	private  IEmpresaServices empresaService;
	
	@GetMapping("/listar")
	public List<Empresa> listAll(){
		return empresaService.listarEmpresas();
	}
	@GetMapping("/listar/{empresaId}")
	public Empresa idEmpresa(@PathVariable Long empresaId){
				return empresaService.findById(empresaId);
	}
	
	@GetMapping("/listar/ultimasTres")
	public List<Empresa> listarUltimosTres(){
		return empresaService.obtenerUltimosTresRegistros();
	}
	@GetMapping("/listar/ultimos/{cantidad}")
	public List<Empresa> obtenerUltimosRegistros(@PathVariable("cantidad") int cantidad) {
	    return empresaService.obtenerUltimosRegistros(cantidad);
	}
	
	@PostMapping("/registrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa registrarEmpresa(@RequestBody Empresa empresa) {
		return empresaService.registrarEmpresa(empresa);
	}
	@DeleteMapping("/delete/{empresaId}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("empresaId")Long empresaId){
		return empresaService.deleteById(empresaId);
	}
	@PutMapping("/editar/{id}")
	  public ResponseEntity<Empresa> updateEmpresa(@PathVariable("id") long id, @RequestBody Empresa empresa) {
	    Optional<Empresa> empresaData = Optional.ofNullable(empresaService.findById(id));

	    if (empresaData.isPresent()) {
	      Empresa _empresa = empresaData.get();
	      _empresa.setRuc(empresa.getRuc());
	      _empresa.setDirecion(empresa.getDirecion());
	      _empresa.setEstado(empresa.getEstado());
	      _empresa.setRazonSocial(empresa.getRazonSocial());
	      return new ResponseEntity<>(empresaService.registrarEmpresa(_empresa), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	;
	
	

}
