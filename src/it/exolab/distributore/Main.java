package it.exolab.distributore;

import it.exolab.distributore.annotations.Ordering;
import it.exolab.distributore.interfaces.MultiplyCount;
import it.exolab.distributore.pojo.Bevanda;
import it.exolab.distributore.pojo.Distributore;
import it.exolab.distributore.utility.BevandeGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws RuntimeException {
        System.out.println("***EX1***");
        System.out.println("Costo totale: " + ex1());
        System.out.println("***EX2***");
        ex2();
        System.out.println("***EX3***");
        System.out.println("Numero bevande con l'aspartame: " + ex3());
        System.out.println("***EX4***");
        System.out.println("Costo totale: " + ex4());
    }

    /**********
     * EX1: Data una lista di bevande calcolare il prezzo totale
     * Regole: non si possono utilizzare iterazioni esplicite
     **********/
    private static double ex1() throws RuntimeException {

        Distributore distributore = new Distributore(BevandeGenerator.generateEx1());
        List<Bevanda> listaBevande = distributore.getBevande();
        /*
        .map(Bevanda::getCosto)  --> TRASFORMO LA LISTA DELLE BEVANDE IN UNA LISTA DI DOUBLE, SU OGNI BEVANDA VIENE INVOCATO IL GET COSTO
        .reduce(Double::sum)  --> PER OGNI SINGOLO ELEMENTO CHE E DI TIPO DOUBLE MI FAI LA SOMMA
        ---------------------------
        Optional<Double> x = listaBevande.stream().map(Bevanda::getCosto).reduce(Double::sum);
        ---------------------------
        .mapToDouble mi deve tornare un double
        Double d = listaBevande.stream().map(Bevanda::getCosto).mapToDouble(e1->e1).sum();
         */
        Method metodoCosto = Arrays.stream(Bevanda.class.getMethods()).filter(metodo -> metodo.getName().toLowerCase().contains("costo")).findFirst().orElse(null);
        return listaBevande.stream().mapToDouble(bevanda -> {
            try {
                if (Objects.nonNull(metodoCosto)) {
                    return (double) metodoCosto.invoke(bevanda);
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }).sum();
    }

    /**********
     * EX2: Data una lista di prodotti ordinarli per il proprio codice e stampare la lista per verificarne l'ordine
     * Regole: non si possono utilizzare iterazioni esplicite, bisogna utilizzare un'annotation personalizzata e l'override del toString in "Bevanda"s
     **********/
    private static void ex2() {
        Distributore distributore = new Distributore(BevandeGenerator.generateEx2());
        List<Bevanda> listaBevande = distributore.getBevande();
        listaBevande.stream()
                .sorted(Comparator.comparingInt(bevanda -> bevanda.getClass().getAnnotation(Ordering.class).codice()))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    /**********
     * EX3: Data una lista di bevande contare quante sono con l'aspartame
     * Regole: non si possono utilizzare iterazioni esplicite
     * Consiglio: utilizzare le reflection per capire quale elemento potrebbe avere il campo aspartame
     **********/

    private static long ex3() throws RuntimeException {
        Distributore distributore = new Distributore(BevandeGenerator.generateEx3());
        List<Bevanda> listaBevande = distributore.getBevande();
        return listaBevande.stream().mapToLong(bevanda -> {
            Optional<Method> isAspartame = Arrays.asList(bevanda.getClass().getMethods()).stream()
                    .filter(metodo -> metodo.getName().toLowerCase().contains("aspartame")).findFirst();
            /*
                OPPURE
                Method isAspartame = Arrays.asList(bevanda.getClass().getMethods()).stream()
                    .filter(metodo -> metodo.getName().toLowerCase().contains("aspartame")).findFirst().orElse(null);
             */
            if (isAspartame.isPresent()) {
                try {
                    System.out.println(bevanda.getClass().getSimpleName());
                    return (boolean) isAspartame.get().invoke(bevanda) ? 1 : 0;
                } catch (InvocationTargetException | IllegalAccessException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return 0;
        }).sum();
    }
     /*
         public static List<Field> getAllHierarchyFields(Class aClass) {
        List<Field> fields = new ArrayList<>();
        do {
            Collections.addAll(fields, aClass.getDeclaredFields());
            aClass = aClass.getSuperclass();
        } while (aClass != null);
        return fields;
    }
}
        */

    /**********
     * EX4: Data una mappa di bevande, avendo come chiave la bevanda e come valore il suo conteggio,
     *      calcolare il totale, stampare anche la mappa in modo da testare il risultato, visto che la mappa è randomica
     * Regole: non si possono utilizzare iterazioni esplicite e bisogna utilizzare un'interfaccia funzionale personalizzata
     *         creata nel package interfaces
     **********/
    private static double ex4() {
        Distributore distributore = new Distributore(BevandeGenerator.generateEx4());
        Map<Bevanda, Integer> listaBevande = distributore.getBevandeMap();
        listaBevande.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(bevanda -> bevanda.getKey().getCosto()))
                .forEach(e1 -> System.out.println("KEY: " + e1.getKey() + "------ VALUE: " + e1.getValue()));
        MultiplyCount<Map<Bevanda, Integer>> operazione = (a) -> a.entrySet().stream().mapToDouble(e -> (e.getKey().getCosto() * e.getValue())).sum();
        return operazione.esegui(listaBevande);
        /*return listaBevande.entrySet().stream().mapToInt(e -> {
            System.out.println("KEY: " + e.getKey() + "------ VALUE: " + e.getValue());
            return e.getValue();
        }).sum();*/
    }
}
