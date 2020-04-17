package edu.upc.dsa;

import edu.upc.dsa.models.Brote;

import java.util.HashMap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.*;


public class CovidTest {
    public Covid19ManagerImpl manag = null;
    HashMap<String, Brote> brotes;
    @Before
    public void SetUp(){
        manag=Covid19ManagerImpl.getInstance();
        this.brotes=new HashMap<>();
    }
    @Test
    public void AddBrote() {
        Assert.assertEquals(0, manag.size());
        manag.AddBrote();
        Assert.assertEquals(1, manag.size());
    }
    @Test
   public void AddCaso(){
        Caso c = new Caso("Marc","Ferre Mancebo", "14/01/2000", "17/4/2020", "alto", "Hombre","marcf@gmail.com", 65504234,"mi casa", "sospechoso");
        Brote b =new Brote();
        b.AddCaso(c);
        Assert.assertEquals(1,b.GetCasos());

    }
    @After
    public void LiberarRecursos(){
        manag.liberarRecursos();
    }
}



