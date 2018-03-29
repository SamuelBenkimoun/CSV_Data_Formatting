package fr.ocelet.model.interpolationcsv;

import fr.ocelet.datafacer.InputDataRecord;
import fr.ocelet.datafacer.ocltypes.Csvfile;
import fr.ocelet.model.interpolationcsv.CsvData;
import fr.ocelet.runtime.entity.Entity;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;

@SuppressWarnings("all")
public class Csv extends Csvfile {
  public Csv() {
    super("data/vent_2m_not_null.csv");
  }
  
  public List<CsvData> readAllCsvData() {
    List<CsvData> _elist = new List<CsvData>();
    for (InputDataRecord _record : this) {
      _elist.add(createCsvDataFromRecord(_record));
     }
    resetIterator();
    return _elist;
  }
  
  public List<CsvData> readAll() {
    return readAllCsvData();
  }
  
  public CsvData createCsvDataFromRecord(final InputDataRecord _rec) {
                      	    CsvData _entity = new CsvData();
    _entity.setProperty("nom",readString("Nom"));
    _entity.setProperty("poste",readString("Poste"));
    _entity.setProperty("date",readString("Date"));
    _entity.setProperty("vitesse_ms",readDouble("Vitesse_m.s-1"));
    return _entity;
  }
  
  public HashMap<String, String> getMatchdef() {
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("Nom","java.lang.String");
    hm.put("Poste","java.lang.String");
    hm.put("Date","java.lang.String");
    hm.put("Vitesse_m.s-1","java.lang.Double");
    return hm;
  }
  
  public String headerString() {
      StringBuffer sb = new StringBuffer();
    sb.append("Nom");
    sb.append(separator);                     
    sb.append("Poste");
    sb.append(separator);                     
    sb.append("Date");
    sb.append(separator);                     
    sb.append("Vitesse_m.s-1");
    return sb.toString();
  }
  
  public String propsString(final Entity _entity) {
      StringBuffer sb = new StringBuffer();
    sb.append(_entity.getProperty("nom").toString());
    sb.append(separator);                     
    sb.append(_entity.getProperty("poste").toString());
    sb.append(separator);                     
    sb.append(_entity.getProperty("date").toString());
    sb.append(separator);                     
    sb.append(_entity.getProperty("vitesse_ms").toString());
    return sb.toString();
  }
}
