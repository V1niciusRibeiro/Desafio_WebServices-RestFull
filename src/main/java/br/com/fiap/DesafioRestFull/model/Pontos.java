package br.com.fiap.DesafioRestFull.model;

import java.util.GregorianCalendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_PONTOS")
public class Pontos {

	@Id
	@SequenceGenerator(name = "ponto", sequenceName = "sq_tb_pontos", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ponto")
	@Column(name = "Id_Ponto")
	private Integer id;
	
	@Column(name = "Id_Funcionario")
	private Integer idFuncionario;
	
	@Column(name = "Marcacao")
	private GregorianCalendar dtHora;
	
	@Column(name = "Justificativa")
	private String justificativa;

	public Pontos(Integer id, Integer idFuncionario, GregorianCalendar dtHora, String justificativa) {
		super();
		this.id = id;
		this.idFuncionario = idFuncionario;
		this.dtHora = dtHora;
		this.justificativa = justificativa;
	}

	public Pontos() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public GregorianCalendar getDtHora() {
		return dtHora;
	}

	public void setDtHora(GregorianCalendar dtHora) {
		this.dtHora = dtHora;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

}
