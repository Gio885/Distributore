package it.exolab.distributore.pojo;

import it.exolab.distributore.annotations.Ordering;

import java.lang.annotation.Annotation;

public abstract class Bevanda {

    protected double costo;

    protected Bevanda(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        //TODO per esercizio 2
        //Pattern: codice bevanda - nome bevanda - costo bevanda €
        String nome = "";
        int codice = -1;
        Annotation annotazioneOrdering = this.getClass().getAnnotation(Ordering.class);
        if (annotazioneOrdering instanceof Ordering) {
            codice = ((Ordering) annotazioneOrdering).codice();
            nome = ((Ordering) annotazioneOrdering).nome();
        }
        return "codice Bevanda " + codice + " - nome Bevanda " + nome + " - costo bevanda € " + costo;
    }
}
