package br.com.fiap.DesafioRestFull.controller;

import br.com.fiap.DesafioRestFull.model.Holerite;
import br.com.fiap.DesafioRestFull.model.Reajuste;
import br.com.fiap.DesafioRestFull.repository.HoleriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("holerite")
public class HoleriteResource {

    @Autowired
    private HoleriteRepository holeriteRepository;

    private ReajusteResource reajusteResource;

    @GetMapping
    public List<Holerite> listar(){
        return holeriteRepository.findAll();
    }

    @GetMapping("{id}")
    public Holerite buscar(@PathVariable Integer id){
        return holeriteRepository.findById(id).get();
    }

    @GetMapping("data")
    public List<Holerite> buscapordata(@RequestParam Calendar data){
        return holeriteRepository.findByData(data);
    }

    @GetMapping("periodo")
    public List<Holerite> buscaporperiodo(@RequestParam Calendar start, @RequestParam Calendar end){
        return holeriteRepository.findByDataGreaterThanEqualAndDataLessThanEqual(start,end);
    }

    @GetMapping("funcionario_periodo")
    public List<Holerite> buscaporfuncionaroperiodo(@RequestParam Integer id,
                                                    @RequestParam Calendar start,
                                                    @RequestParam Calendar end){
        return holeriteRepository.findByDataGreaterThanEqualAndDataLessThanEqualAndIdFuncionaro(start,end,id);
    }

    @GetMapping("funcionario")
    public List<Holerite> buscaporfuncionaro(@RequestParam Integer id){
       return holeriteRepository.findByIdFuncionaro(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Holerite cadastar(@RequestBody Holerite holerite){
        return holeriteRepository.save(holerite);
    }

    @PutMapping("{id}")
    public Holerite atualizar(@RequestBody Holerite holerite, @PathVariable Integer id){
        holerite.setId(id);
        return holeriteRepository.save(holerite);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        Holerite holerite = holeriteRepository.findById(id).get();
        List<Reajuste> reajustes = reajusteResource.buscarporholerite(holerite);
        for (Reajuste rejuste: reajustes
             ) {
            reajusteResource.excluir(rejuste.getId(),rejuste.getHolerite());
        }
        holeriteRepository.deleteById(id);
    }

}
