package br.com.fiap.DesafioRestFull.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.fiap.DesafioRestFull.model.ProcessoSeletivo;


@Repository
public interface ProcessoSeletivoRepository extends JpaRepository<ProcessoSeletivo, Integer> {
		
	List<ProcessoSeletivo> findByidProcessoSeletivo(Integer idProcesso);
	List<ProcessoSeletivo> findByDtIniGreaterThanEqualAndDtFimLessThanEqual(Calendar Start, Calendar End);	
}
