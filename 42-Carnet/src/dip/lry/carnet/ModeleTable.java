package dip.lry.carnet;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel{
    private ArrayList <Echantillon> data = new ArrayList<Echantillon>();
    private String[] title = {"Titre", "Nom", "Prénom", "Adresse"};


    public ModeleTable() {}
    
    public int getRowCount() {
        return 0;
    }
    
    public void addData(String pTitre, String pNom, String pPrenom, String pAdresse) {
        this.data.add(new Echantillon(pTitre, pNom, pPrenom, pAdresse));
    }

    public void removeData(int rowIndex) {
        this.data.remove(rowIndex);
    }






    
    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }
}
