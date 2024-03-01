package it.exolab.distributore.pojo;

public abstract class Acqua extends Bevanda {

    protected boolean naturale;

    protected Acqua(double costo, boolean naturale) {
        super(costo);
        this.naturale = naturale;
    }

    public boolean isNaturale() {
        return this.naturale;
    }

    public void setNaturale(boolean naturale) {
        this.naturale = naturale;
    }
}
