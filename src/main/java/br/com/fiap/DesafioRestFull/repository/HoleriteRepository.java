package br.com.fiap.DesafioRestFull.repository;

import br.com.fiap.DesafioRestFull.model.Holerite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface HoleriteRepository extends JpaRepository<Holerite, Integer> {

    List<Holerite> findByIdFuncionaro(Integer idFuncionario);
    List<Holerite> findByData(Calendar Data);
    List<Holerite> findByDataGreaterThanEqualAndDataLessThanEqual(Calendar Start, Calendar End);
    List<Holerite> findByDataGreaterThanEqualAndDataLessThanEqualAndIdFuncionaro(Calendar Start,
                                                                                 Calendar End,
                                                                                 Integer IdFuncionaro);
}
