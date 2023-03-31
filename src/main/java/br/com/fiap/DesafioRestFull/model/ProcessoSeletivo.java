package br.com.fiap.DesafioRestFull.model;

import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_PROCESSO_SELETIVO")
public class ProcessoSeletivo {

	@Id
    @SequenceGenerator(name="processo",sequenceName="sq_tb_processo_seletivo",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="processo")
    @Column(name = "Id_Processo")
    private Integer idProcessoSeletivo;

 
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Dt_Ini")
    private Calendar dtIni;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Dt_Fim")
    private Calendar dtFim;
    
   
    @OneToMany(mappedBy = "processoSeletivo", cascade = CascadeType.ALL)
    private List<Criterio> criterios;

	public Integer getId() {
		return idProcessoSeletivo;
	}

	public void setId(Integer id) {
		this.idProcessoSeletivo = id;
	}



	public Calendar getDtIni() {
		return dtIni;
	}

	public void setDtIni(Calendar dtIni) {
		this.dtIni = dtIni;
	}

	public Calendar getDtFim() {
		return dtFim;
	}


	public void setDtFim(Calendar dtFim) {
		this.dtFim = dtFim;
	}

	
	public List<Criterio> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
	}

	public ProcessoSeletivo(Integer idProcessoSeletivo, Calendar dtIni, Calendar dtFim, List<Criterio> criterios) {
		super();
		this.idProcessoSeletivo = idProcessoSeletivo;
		this.dtIni = dtIni;
		this.dtFim = dtFim;
		this.criterios = criterios;
	}
	
	public ProcessoSeletivo() {}


    
		
}
