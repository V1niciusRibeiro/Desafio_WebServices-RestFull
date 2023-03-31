package br.com.fiap.DesafioRestFull.model;

import java.io.Serializable;
import java.util.Objects;

public class ReajusteId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Holerite holerite;

    public ReajusteId() {
        super();
    }

    public ReajusteId(Integer id, Holerite holerite) {
        this.id = id;
        this.holerite = holerite;
    }

    public Integer getId() {
        return id;
    }

    public ReajusteId setId(Integer id) {
        this.id = id;
        return this;
    }

    public Holerite getHolerite() {
        return holerite;
    }

    public ReajusteId setHolerite(Holerite holerite) {
        this.holerite = holerite;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReajusteId that = (ReajusteId) o;
        return Objects.equals(id, that.id) && Objects.equals(holerite, that.holerite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, holerite);
    }
}
