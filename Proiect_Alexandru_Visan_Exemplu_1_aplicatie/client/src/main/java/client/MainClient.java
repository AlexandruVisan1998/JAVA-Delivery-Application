package client;

import client.gui.ComenziFrameForm;
import client.gui.LoginFrameForm;
import client.gui.PlatesteFrameForm;

public class MainClient {

    public static void main(String[] args) {

        //new LoginFrameForm(); // crapa comunicatia cu baza de date cand vrem sa trimitem datele de login
                                // dar logica aplicatiei client si server functioneaza

        new PlatesteFrameForm();

    }
}
