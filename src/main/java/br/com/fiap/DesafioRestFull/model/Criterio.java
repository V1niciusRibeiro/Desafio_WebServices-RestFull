package br.com.fiap.DesafioRestFull.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;  
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CRITERIO")
public class Criterio {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID_CRITERIO")
	    private int id;

	    @Column(name = "NOME_CRITERIO")
	    private String nomeCriterio;

	    @Column(name = "NOTA_CRITERIO")
	    private Integer notaCriterio;
	    

	    
	    @ManyToOne
	    @JoinColumn(name = "ID_PROCESSO_SELETIVO")
	    private ProcessoSeletivo processoSeletivo;



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getNomeCriterio() {
			return nomeCriterio;
		}



		public void setNomeCriterio(String nomeCriterio) {
			this.nomeCriterio = nomeCriterio;
		}



		public Integer getNotaCriterio() {
			return notaCriterio;
		}



		public void setNotaCriterio(Integer notaCriterio) {
			this.notaCriterio = notaCriterio;
		}



		public ProcessoSeletivo getProcessoSeletivo() {
			return processoSeletivo;
		}



		public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
			this.processoSeletivo = processoSeletivo;
		}



		public Criterio(int id, String nomeCriterio, Integer notaCriterio, ProcessoSeletivo processoSeletivo) {
			super();
			this.id = id;
			this.nomeCriterio = nomeCriterio;
			this.notaCriterio = notaCriterio;
			this.processoSeletivo = processoSeletivo;
		}



		public Criterio() {}
	    
	    
	    
}
