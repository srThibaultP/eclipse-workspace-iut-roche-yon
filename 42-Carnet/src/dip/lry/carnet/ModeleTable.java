package dip.lry.carnet;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ModeleTable extends AbstractTableModel{
    private ArrayList <Echantillon> data;
    private String title;


    public ModeleTable() {}
    
    public int getRowCount() {
        return 0;
    }
    
    public void addData(String pTitre, String pNom, String pPrenom, String pAdresse) {}

    public void removeData(int rowIndex) {}






    
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }
}