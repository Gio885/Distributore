package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

//codice: 12
@Ordering(codice = 12, nome = "Coca Cola Zero")
public class CocaColaZero extends CocaCola {

    public CocaColaZero() {
        super(true);
    }

}
