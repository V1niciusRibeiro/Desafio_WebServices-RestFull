package br.com.fiap.DesafioRestFull.controller;

import br.com.fiap.DesafioRestFull.model.Holerite;
import br.com.fiap.DesafioRestFull.model.Reajuste;
import br.com.fiap.DesafioRestFull.repository.ReajusteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reajuste")
public class ReajusteResource {

    @Autowired
    private ReajusteRepository reajusteRepository;

    @GetMapping
    public List<Reajuste> listar(){
        return reajusteRepository.findAll();
    }

    @GetMapping("{id}/{holerite}")
    public Reajuste buscarporchave(@PathVariable Integer id, @PathVariable Holerite holerite){
        return reajusteRepository.findByIdAndHolerite(id, holerite);
    }

    @GetMapping("holerite")
    public List<Reajuste> buscarporholerite(@RequestParam Holerite holerite){
        return reajusteRepository.findByHolerite(holerite);
    }

    @GetMapping("nome")
    public List<Reajuste> buscarpornome(@RequestParam String nome){
        return reajusteRepository.findByNome(nome);
    }

    @GetMapping("valor")
    public List<Reajuste> burcarporvalor(@RequestParam Double valor){
        return reajusteRepository.findByValorGreaterThan(valor);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Reajuste cadastrar(@RequestBody Reajuste reajuste){
        return reajusteRepository.save(reajuste);
    }

    @PutMapping("{id}/{holerite}")
    public Reajuste atuliza(@RequestBody Reajuste reajuste, @PathVariable Integer id, @PathVariable Holerite holerite){
        reajuste.setId(id);
        reajuste.setHolerite(holerite);
        return reajusteRepository.save(reajuste);
    }

    @DeleteMapping("{id}/{holerite}")
    public void excluir(@PathVariable Integer id, @PathVariable Holerite holerite){
        Reajuste reajuste = buscarporchave(id, holerite);
        reajusteRepository.delete(reajuste);
    }

}
