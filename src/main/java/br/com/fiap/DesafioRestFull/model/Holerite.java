package br.com.fiap.DesafioRestFull.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "TB_HOLERITTE")
public class Holerite {

    @Id
    @SequenceGenerator(name="holerite",sequenceName="sq_tb_holerite",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="holerite")
    @Column(name = "Id_Holerite")
    private Integer id;

    @OneToMany(mappedBy = "holerite")
    private List<Reajuste> reajustes;

    @Column(name = "Id_Funcionario")
    private Integer idFuncionaro;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Dt_Holerite")
    private Calendar data;

    @Column(name = "Vl_Holerite")
    private Double valor;

    public Holerite(){}
    
    public Holerite(Integer id, Integer idFuncionaro, Calendar data) {
        this.id = id;
        this.idFuncionaro = idFuncionaro;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public Holerite setId(Integer id) {
        this.id = id;
        return this;
    }

    public List<Reajuste> getReajustes() {
        return reajustes;
    }

    public Holerite setReajustes(List<Reajuste> reajustes) {
        this.reajustes = reajustes;
        return this;
    }

    public Integer getIdFuncionaro() {
        return idFuncionaro;
    }

    public Holerite setIdFuncionaro(Integer idFuncionaro) {
        this.idFuncionaro = idFuncionaro;
        return this;
    }

    public Calendar getData() {
        return data;
    }

    public Holerite setData(Calendar data) {
        this.data = data;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Holerite setValor(Double valor) {
        this.valor = valor;
        return this;
    }

}
