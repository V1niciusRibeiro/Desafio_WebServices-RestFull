package br.com.fiap.DesafioRestFull.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.DesafioRestFull.model.Criterio;
import br.com.fiap.DesafioRestFull.model.ProcessoSeletivo;




@Repository
public interface CriterioRepository  extends JpaRepository <Criterio, Integer> {
	 	Criterio findByIdAndProcesso(Integer id, ProcessoSeletivo processo);
	    List<Criterio> findByCriterio(Criterio criterio);
	    List<Criterio> findByNome(String nome);
	    
}
