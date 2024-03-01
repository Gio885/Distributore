package it.exolab.distributore.pojo;

import java.util.List;
import java.util.Map;

public class Distributore {

    private List<Bevanda> bevande;
    private Map<Bevanda,Integer> bevandeMap;

    public Distributore(){}

    public Distributore(List<Bevanda> bevande){
        this.bevande = bevande;
    }

    public Distributore(Map<Bevanda,Integer> bevande){
        this.bevandeMap = bevande;
    }

    public List<Bevanda> getBevande(){
        return this.bevande;
    }

    public Map<Bevanda,Integer> getBevandeMap(){return this.bevandeMap;}

    public void setBevande(List<Bevanda> bevande){
        this.bevande = bevande;
    }

    public void setBevandeMap(Map<Bevanda,Integer> bevandeMap) {this.bevandeMap = bevandeMap;}
}
