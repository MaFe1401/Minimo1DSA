package edu.upc.dsa;

import edu.upc.dsa.models.Brote;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class Covid19ManagerImpl implements Covid19Manager {
    final static Logger logger = Logger.getLogger(Covid19ManagerImpl.class);
    private HashMap<String, Brote> brotes;
    private List<Caso> casos;
    private static Covid19ManagerImpl instance;
    private Covid19ManagerImpl(){
        this.brotes=new HashMap<>();
        this.casos=new LinkedList<>();
    }
    public static Covid19ManagerImpl getInstance(){
        if(instance==null)
            instance=new Covid19ManagerImpl();
        return instance;
    }

    @Override
    public String AddBrote() {
        Brote x = new Brote();
        String id = x.GetIdentificador();
        try{
            this.brotes.put(id,x);
            logger.info("Brote "+id+" added");
            return x.GetIdentificador();

        }
        catch(IndexOutOfBoundsException ex){
            logger.error("Tabla llena");
            return null;
        }


    }

    @Override
    public Brote GetBrote(String id) {
        return this.brotes.get(id);
    }

    @Override
    public Brote AddBrote(Brote b) {
       String id= b.GetIdentificador();
        try{
            this.brotes.put(id,b);
            logger.info("Brote "+id+" added");
            return b;

        }
        catch(IndexOutOfBoundsException ex){
            logger.error("Tabla llena");
            return null;
        }

    }

    @Override
    public List<Brote> GetBrotes() {
        if (this.brotes.size()==0)
        {
            logger.info("no hay brotes");
            return null;
        }
        logger.info("Brotes: "+this.brotes.values());
        return new LinkedList<>(this.brotes.values());
    }

    @Override
    public int AddCaso(String idBrote, Caso c) {
       Brote b= this.brotes.get(idBrote);
       if(b!=null){
           b.AddCaso(c);
           logger.info("caso "+c.GetId()+" added");
           return 0;
       }
       logger.info("caso "+c.GetId()+" not added");
       return 1;
    }

    @Override
    public int size() {
        int ret= this.brotes.size();
        logger.info("tamano "+ret);
        return ret;
    }

    @Override
    public void liberarRecursos() {
        this.brotes.clear();
        this.casos.clear();

    }
}
