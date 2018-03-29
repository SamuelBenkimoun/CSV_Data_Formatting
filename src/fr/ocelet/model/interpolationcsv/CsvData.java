package fr.ocelet.model.interpolationcsv;

import fr.ocelet.runtime.entity.AbstractEntity;
import fr.ocelet.runtime.entity.Hproperty;

@SuppressWarnings("all")
public class CsvData extends AbstractEntity {
  public void setNom(final String nom) {
    setProperty("nom",nom);
  }
  
  public String getNom() {
    return getProperty("nom");
  }
  
  public void setPoste(final String poste) {
    setProperty("poste",poste);
  }
  
  public String getPoste() {
    return getProperty("poste");
  }
  
  public void setDate(final String date) {
    setProperty("date",date);
  }
  
  public String getDate() {
    return getProperty("date");
  }
  
  public void setVitesse_ms(final Double vitesse_ms) {
    setProperty("vitesse_ms",vitesse_ms);
  }
  
  public Double getVitesse_ms() {
    return getProperty("vitesse_ms");
  }
  
  public void interpolation() {
  }
  
  public CsvData() {
    super();
    defProperty("nom",new Hproperty<String>());
    setNom(new String());
    defProperty("poste",new Hproperty<String>());
    setPoste(new String());
    defProperty("date",new Hproperty<String>());
    setDate(new String());
    defProperty("vitesse_ms",new Hproperty<Double>());
    setVitesse_ms(new Double("0"));
  }
}
