package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

//codice: 22
@Ordering(codice = 22, nome = "Acqua Naturale")
public class AcquaNaturale extends Acqua {
    public AcquaNaturale() {
        super(0.5, true);
    }
}
