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

import br.com.fiap.DesafioRestFull.model.Pontos;
import br.com.fiap.DesafioRestFull.repository.PontosRepository;

@RestController
@RequestMapping("pontos")
public class PontosResource {
	
    @Autowired
    private PontosRepository pontosRepository;
    
    @GetMapping
    public List<Pontos> listar() {
    	return pontosRepository.findAll();
    }
    
    @GetMapping("{id}")
    public Pontos buscarporchave(@PathVariable Integer id){
        return pontosRepository.findById(id).get();
    }
    
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Pontos cadastrar(@RequestBody Pontos pontos){
        return pontosRepository.save(pontos);
    }
    
    @PutMapping("{id}")
    public Pontos atuliza(@RequestBody Pontos pontos, @PathVariable Integer id){
        pontos.setId(id);
        return pontosRepository.save(pontos);
    }
    
    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        Pontos pontos = buscarporchave(id);
        pontosRepository.delete(pontos);
    }

}
