package it.exolab.distributore.utility;

import it.exolab.distributore.pojo.*;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BevandeGenerator {

    public static List<Bevanda> generateEx1(){
        Stream<Bevanda> bevande = Stream.of(new CocaCola(),new CocaCola(),new CocaCola(),
                new CocaColaZero(),new CocaColaZero(),new AcquaNaturale(),
                new AcquaMinerale(),new Fanta(),new Fanta(),new Sprite(),
                new Sprite(),new Sprite());
        return bevande.collect(Collectors.toList());
    }

    public static List<Bevanda> generateEx2(){
        Stream<Bevanda> bevande = Stream.of(new Sprite(),new CocaCola(),new AcquaMinerale(),
                new AcquaNaturale(),new CocaColaZero(),new Fanta());
        return bevande.collect(Collectors.toList());
    }

    public static List<Bevanda> generateEx3(){
        Stream<Bevanda> bevande = Stream.of(new CocaCola(),new CocaColaZero(),
                new CocaColaZero(),new CocaCola(),new Fanta(),
                new Sprite(), new AcquaNaturale(),new CocaColaZero());
        return bevande.collect(Collectors.toList());
    }

    public static Map<Bevanda,Integer> generateEx4(){
        return Stream.of(new CocaCola(),new CocaColaZero(), new Fanta(),
                new Sprite(),new AcquaNaturale(),new AcquaMinerale())
                .collect(Collectors.toMap(Function.identity(), (value) -> new Random().nextInt(4)));
    }
}
