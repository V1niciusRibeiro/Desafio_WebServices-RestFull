package br.com.fiap.DesafioRestFull.repository;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.DesafioRestFull.model.Pontos;

public interface PontosRepository extends JpaRepository<Pontos,Integer> {
	/*
    List<Pontos> findByIdFuncionario(Integer idFuncionario);
    List<Pontos> findByDtHora(GregorianCalendar Data);
    List<Pontos> findByDtHoraGreaterThanEqualAndDtHoraLessThanEqual(GregorianCalendar Start, GregorianCalendar End);
    List<Pontos> findByDtHoraGreaterThanEqualAndDtHoraLessThanEqualAndIdFuncionario(GregorianCalendar Start,
                                                                                   GregorianCalendar End,
                                                                                   Integer IdFuncionario);*/

}
