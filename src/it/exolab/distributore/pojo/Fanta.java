package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

//codice: 13
@Ordering(codice = 13, nome = "Fanta")
public class Fanta extends Bevanda {

    public Fanta() {
        super(2);
    }

}
