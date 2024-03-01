package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

//codice: 11
@Ordering(codice = 11, nome = "Coca Cola")
public class CocaCola extends Bevanda {

    protected final boolean aspartame;

    public CocaCola() {
        super(2.5);
        this.aspartame = false;
    }

    protected CocaCola(boolean aspartame) {
        super(2.5);
        this.aspartame = aspartame;
    }

    public boolean isAspartame() {
        return aspartame;
    }
}
