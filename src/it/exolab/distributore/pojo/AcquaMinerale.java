package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

//codice: 21
@Ordering(codice = 21, nome = "Acqua Minerale")
public class AcquaMinerale extends Acqua {

    public AcquaMinerale() {
        super(0.75, false);
    }

}
