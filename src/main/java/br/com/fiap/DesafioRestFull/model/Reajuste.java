package br.com.fiap.DesafioRestFull.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_REAJUSTE")
@IdClass(ReajusteId.class)
public class Reajuste {

    @Id
    @SequenceGenerator(name="reajuste",sequenceName="sq_tb_reajuste",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="reajuste")
    @Column(name = "Id_Reajuste")
    private Integer id;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name="Id_Holerite")
    private Holerite holerite;

    @Column(name = "Nm_Reajuste")
    private String nome;

    @Column(name = "Vl_Reajuste")
    private Double valor;

    public Reajuste() {}

    public Reajuste(Integer id, Holerite holerite, String nome, Double valor) {
        this.id = id;
        this.holerite = holerite;
        this.nome = nome;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public Reajuste setId(Integer id) {
        this.id = id;
        return this;
    }

    public Holerite getHolerite() {
        return holerite;
    }

    public Reajuste setHolerite(Holerite holerite) {
        this.holerite = holerite;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Reajuste setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Double getValor() {
        return valor;
    }

    public Reajuste setValor(Double valor) {
        this.valor = valor;
        return this;
    }

}
