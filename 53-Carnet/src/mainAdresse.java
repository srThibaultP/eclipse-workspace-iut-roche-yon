/**
 * @Author: Thibault PECH
 * @Date:   2022-01-05 11:18:14
 * @Last Modified by:   Thibault PECH
 * @Last Modified time: 2022-01-28 13:10:12
 */

import java.sql.SQLException;

import dip.lry.carnet.*;

public class mainAdresse {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Création de la fenêtre principale
        new GUI(560, 400, false, "Carnet d'adresse");
    }
}