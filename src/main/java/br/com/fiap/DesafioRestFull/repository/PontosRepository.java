package br.com.fiap.DesafioRestFull.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DesafioRestFull.model.Pontos;

public interface PontosRepository extends JpaRepository<Pontos,Integer> {
	
    List<Pontos> findByIdFuncionaro(Integer idFuncionario);
    List<Pontos> findByData(Calendar Data);
    List<Pontos> findByDataGreaterThanEqualAndDataLessThanEqual(Calendar Start, Calendar End);
    List<Pontos> findByDataGreaterThanEqualAndDataLessThanEqualAndIdFuncionaro(Calendar Start, Calendar End, Integer IdFuncionaro);

}
