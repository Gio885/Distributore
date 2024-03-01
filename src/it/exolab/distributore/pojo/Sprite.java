package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

//codice: 14
@Ordering(codice = 14, nome = "Sprite")
public class Sprite extends Bevanda {

    public Sprite() {
        super(1.5);
    }

}
