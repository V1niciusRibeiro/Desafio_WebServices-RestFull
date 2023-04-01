package br.com.fiap.DesafioRestFull.controller;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.fiap.DesafioRestFull.model.ProcessoSeletivo;

import br.com.fiap.DesafioRestFull.repository.ProcessoSeletivoRepository;



@RestController
@RequestMapping("processoSeletivo")
public class ProcessoSeletivoResource {
	
	@Autowired
    private ProcessoSeletivoRepository ProcessoSeletivoRepository;

  
    @GetMapping("periodo")
    public List<ProcessoSeletivo> buscaporperiodo(@RequestParam Calendar start, @RequestParam Calendar end){
        return ProcessoSeletivoRepository.findByDtIniGreaterThanEqualAndDtFimLessThanEqual(start,end);
    }
    
    @GetMapping
    public List<ProcessoSeletivo> listar(){
        return ProcessoSeletivoRepository.findAll();
    }

    @GetMapping("{id}")
    public ProcessoSeletivo buscar(@PathVariable Integer id){
        return ProcessoSeletivoRepository.findById(id).get();
    }
    
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public ProcessoSeletivo cadastar(@RequestBody ProcessoSeletivo processo){
        return ProcessoSeletivoRepository.save(processo);
    }

    @PutMapping("{id}")
    public ProcessoSeletivo atualizar(@RequestBody ProcessoSeletivo processo, @PathVariable Integer id){
    	processo.setIdProcessoSeletivo(id);
        return ProcessoSeletivoRepository.save(processo);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
    	ProcessoSeletivoRepository.deleteById(id);
    }
    
}
