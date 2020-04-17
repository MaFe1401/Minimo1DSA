package edu.upc.dsa.models;
import edu.upc.dsa.Caso;
import edu.upc.dsa.utils.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class Brote {
    String identificador;
    List<Caso> casos =null;

    public Brote (){
        this.identificador= RandomUtils.getId();
        List<Caso> casos =new LinkedList<>();
    }
    public String GetIdentificador(){
        return this.identificador;
    }
    public void AddCaso(Caso c){
        this.casos.add(c);
    }
    public int GetCasos(){
        return this.casos.size();
    }
}
