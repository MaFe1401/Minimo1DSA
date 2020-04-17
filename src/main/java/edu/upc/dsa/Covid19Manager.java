package edu.upc.dsa;
import edu.upc.dsa.Caso;

import edu.upc.dsa.models.Brote;

import java.util.List;

public interface Covid19Manager {
    public String AddBrote();
    public Brote GetBrote(String id);
    public Brote AddBrote(Brote b);
    public List<Brote> GetBrotes();
    public int AddCaso(String idBrote, Caso c);
    public int size();
    public void liberarRecursos();



}
