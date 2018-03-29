package fr.ocelet.model.interpolationcsv;

import com.google.common.base.Objects;
import fr.ocelet.model.interpolationcsv.Csv;
import fr.ocelet.model.interpolationcsv.CsvData;
import fr.ocelet.model.interpolationcsv.CsvOut;
import fr.ocelet.runtime.Miscutils;
import fr.ocelet.runtime.model.AbstractModel;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;

@SuppressWarnings("all")
public class InterpolationCSV extends AbstractModel {
  public InterpolationCSV() {
    super("InterpolationCSV");
  }
  
  public static void main(final String[] args) {
    InterpolationCSV model_InterpolationCSV = new InterpolationCSV();
    model_InterpolationCSV.run_InterpolationCSV();
  }
  
  public void run_InterpolationCSV() {
    Miscutils.removeDir("output/CSV/");
    Csv csv = new Csv();
    List<CsvData> dataCsv = csv.readAll();
    int _size = dataCsv.size();
    int _minus = (_size - 1);
    IntegerRange _upTo = new IntegerRange(0, _minus);
    for (final Integer i : _upTo) {
      Double _vitesse_ms = dataCsv.get((i).intValue()).getVitesse_ms();
      boolean _equals = ((_vitesse_ms).doubleValue() == 0.0);
      if (_equals) {
        int j = ((i).intValue() - 1);
        while ((((dataCsv.get(j).getVitesse_ms()).doubleValue() == 0.0) && (j < (i).intValue()))) {
          {
            j--;
            InputOutput.<String>println(("j: " + Integer.valueOf(j)));
          }
        }
        int k = ((i).intValue() + 1);
        while ((((dataCsv.get(k).getVitesse_ms()).doubleValue() == 0.0) && (k <= (dataCsv.size() - 1)))) {
          {
            k++;
            InputOutput.<String>println(("k: " + Integer.valueOf(k)));
          }
        }
        CsvData _get = dataCsv.get((i).intValue());
        Double _vitesse_ms_1 = dataCsv.get(j).getVitesse_ms();
        Double _vitesse_ms_2 = dataCsv.get(k).getVitesse_ms();
        Double _vitesse_ms_3 = dataCsv.get(j).getVitesse_ms();
        double _minus_1 = DoubleExtensions.operator_minus(_vitesse_ms_2, _vitesse_ms_3);
        double _divide = (_minus_1 / (k - j));
        double _plus = ((_vitesse_ms_1).doubleValue() + _divide);
        _get.setVitesse_ms(Double.valueOf(_plus));
      }
    }
    String id_poste = dataCsv.get(0).getPoste();
    InputOutput.<String>println(("poste: " + id_poste));
    CsvOut csvOut = new CsvOut();
    csvOut.setFileName((("output/CSV/" + id_poste) + ".csv"));
    int _size_1 = dataCsv.size();
    int _minus_2 = (_size_1 - 1);
    IntegerRange _upTo_1 = new IntegerRange(0, _minus_2);
    for (final Integer i_1 : _upTo_1) {
      {
        if ((((i_1).intValue() < (dataCsv.size() - 1)) && Objects.equal(dataCsv.get((i_1).intValue()).getPoste(), id_poste))) {
          csvOut.append(dataCsv.get((i_1).intValue()));
          CsvData _get_1 = dataCsv.get((i_1).intValue());
          String _plus_1 = ("ajout\u00E9: " + _get_1);
          InputOutput.<String>println(_plus_1);
        }
        if ((((i_1).intValue() == (dataCsv.size() - 1)) && Objects.equal(dataCsv.get((i_1).intValue()).getPoste(), dataCsv.get(((i_1).intValue() - 1)).getPoste()))) {
          csvOut.append(dataCsv.get((i_1).intValue()));
          CsvData _get_2 = dataCsv.get((i_1).intValue());
          String _plus_2 = ("ajout\u00E9: " + _get_2);
          InputOutput.<String>println(_plus_2);
        }
        String _poste = dataCsv.get((i_1).intValue()).getPoste();
        boolean _notEquals = (!Objects.equal(_poste, id_poste));
        if (_notEquals) {
          id_poste = dataCsv.get((i_1).intValue()).getPoste();
          csvOut.setFileName((("output/CSV/" + id_poste) + ".csv"));
          InputOutput.<String>println(("csvOut: " + id_poste));
          csvOut.append(dataCsv.get((i_1).intValue()));
          CsvData _get_3 = dataCsv.get((i_1).intValue());
          String _plus_3 = ("ajout\u00E9: " + _get_3);
          InputOutput.<String>println(_plus_3);
        }
      }
    }
    InputOutput.<String>println("Namast\u00E9.");
  }
  
  public void simulate(final HashMap<String, Object> in_params) {
    run_InterpolationCSV();
  }
}
