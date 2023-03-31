package br.com.fiap.DesafioRestFull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.DesafioRestFull.model.Criterio;

import br.com.fiap.DesafioRestFull.model.ProcessoSeletivo;

import br.com.fiap.DesafioRestFull.repository.CriterioRepository;

@RestController
@RequestMapping("criterioresource")
public class CriterioResource {
	
	@Autowired
    private CriterioRepository criterioRepository;
	
	 @GetMapping
	    public List<Criterio> listar(){
	        return criterioRepository.findAll();
	    }

	    @GetMapping("{id}")
	    public Criterio buscar(@PathVariable Integer id){
	        return criterioRepository.findById(id).get();
	    }
	    
	    @GetMapping("{id}/{processoSeletivo}")
	    public Criterio buscarporchave(@PathVariable Integer id, @PathVariable ProcessoSeletivo processo){
	        return criterioRepository.findByIdAndProcesso(id, processo);
	    }
	    
	    @ResponseStatus(code = HttpStatus.CREATED)
	    @PostMapping
	    public Criterio cadastrar(@RequestBody Criterio criterio){
	        return criterioRepository.save(criterio);
	    }

	    @PutMapping("{id}/{processoSeletivo}")
	    public Criterio atuliza(@RequestBody Criterio criterio, @PathVariable Integer id, @PathVariable ProcessoSeletivo processo){
	        criterio.setId(id);
	        criterio.setProcessoSeletivo(processo);
	        return criterioRepository.save(criterio);
	    }

	    @DeleteMapping("{id}/{processoSeletivo}")
	    public void excluir(@PathVariable Integer id, @PathVariable ProcessoSeletivo processo){
	    	Criterio criterio = buscarporchave(id, processo);
	        criterioRepository.delete(criterio);
	    }
	    
	    
}
