package it.exolab.distributore.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
-TARGET indica gli elementi a cui è destinata l'annotation
    TYPE,FIELD,METHOD,PARAMETERS....
-RETENTION indica il livello di visibilita che puo essere
    SOURCE visibile solo dal codice sorgente, usato per scopi informativi
    CLASS visibile dal compilatore,usato per scopi informativi, persiste in quanto si trova nel file class generato
    RUNTIME la piu visibile, durante l'esecuzione sulla JVM puo essere letta tramite la REFLECTION
-REPEATABLE per consentire di utilizzare l'annotazione piu volte sul target
-INHERITED viene utilizzata per creare una sorta di ereditarieta, se un annotazione viene definita sulla classe padre ma non sulla classe figlia
    la classe figlia prende l'annotazione con il valore del padre. Ha senso solo se viene utilizzata sulle classi, perde di significato e utilita
    per gli altri tipi di target
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ordering {
    int codice();

    String nome() default "Bevanda";   //PUO ESSERE INSERITO UN VALORE DI DEFAULT NEL CASO IN CUI NON VENGA DEFINITO NELL'ANNOTAZIONE
}
