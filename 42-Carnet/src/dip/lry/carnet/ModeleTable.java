package dip.lry.carnet;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel{
    private ArrayList <Echantillon> data = new ArrayList<Echantillon>();
    private String[] title = {"Titre", "Nom", "Prénom", "Adresse"};


    public ModeleTable() {}
    
    public void addData(String pTitre, String pNom, String pPrenom, String pAdresse) {
        this.data.add(new Echantillon(pTitre, pNom, pPrenom, pAdresse));
    }

    public void removeData(int rowIndex) {
        this.data.remove(rowIndex);
    }

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
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }
}
