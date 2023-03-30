package br.com.fiap.DesafioRestFull.model;

import java.io.Serializable;
import java.util.Objects;

public class ReajusteId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer holerite;

    public ReajusteId(){super();}

    public ReajusteId(Integer holerite) {
        super();
        this.holerite = holerite;
    }

    public Integer getHolerite() {
        return holerite;
    }

    public ReajusteId setHolerite(Integer holerite) {
        this.holerite = holerite;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReajusteId that = (ReajusteId) o;
        return Objects.equals(holerite, that.holerite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(holerite);
    }
}
