package br.com.fiap.DesafioRestFull.repository;

import br.com.fiap.DesafioRestFull.model.Holerite;
import br.com.fiap.DesafioRestFull.model.Reajuste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReajusteRepository extends JpaRepository<Reajuste, Integer> {

    Reajuste findByIdAndHolerite(Integer id, Holerite holerite);
    List<Reajuste> findByHolerite(Holerite holerite);
    List<Reajuste> findByNome(String nome);
    List<Reajuste> findByValorGreaterThan(Double valor);

}
