package dip.lry.carnet;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel{
    private ArrayList <Echantillon> data = new ArrayList();
    private String[] title = {"Titre", "Nom", "Prénom", "Adresse"};

    /****************************************** CONSTRUCTEUR ****************************************/

    public ModeleTable() {
        this.data.add(new Echantillon("M", "Pech", "Thibault", "Une adresse"));
        this.data.add(new Echantillon("Mme", "Abc", "eeeeee", "Deux adresse"));
    }

    /****************************************** METHODES ****************************************/

    public void addData(String pTitre, String pNom, String pPrenom, String pAdresse) {
        this.data.add(new Echantillon(pTitre, pNom, pPrenom, pAdresse));
        this.fireTableRowsInserted(this.data.size() - 1, this.data.size() - 1);
    }

    public void removeData(int rowIndex) {
        this.data.remove(rowIndex);
        this.fireTableRowsDeleted(rowIndex, rowIndex);
    }

    /****************************************** GETTERS / SETTERS ****************************************/

    public int getRowCount() {
        return this.data.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.title.length;
    }

    public String getColumnName(int columnIndex) {
        return this.title[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
        case 0:
            return ((Echantillon) this.data.get(rowIndex)).getTitre();
        case 1:
            return ((Echantillon) this.data.get(rowIndex)).getPrenom();
        case 2:
            return ((Echantillon) this.data.get(rowIndex)).getNom();
        case 3:
            return ((Echantillon) this.data.get(rowIndex)).getAdresse();
        }
        return null;
    }
}
