package client.gui;

import client.controller.UserController;
import lib.dto.UserDTO;

import javax.swing.*;

public class ComenziFrameForm extends JFrame {
    private JTextField textField4;
    private JButton anuleazaComandaButton;
    private JButton adaugaAdresaDeLivrareButton;
    private JButton livreazaLaDomiciliuButton;
    private JButton livreazaLaEasyBoxVictorieiButton;
    private JPanel panel;

    JFrame frame = new JFrame();

    private String undeLivreaza =  null; // il putem folosi pentru a decide mai incolo evolutia livrarii
                                 // ca un boolean

    String adresaLivrare;

    public ComenziFrameForm()
    {

        frame.setTitle("comanda");

        anuleazaComandaButton.addActionListener(e ->
        {

            dispose();
        });

        adaugaAdresaDeLivrareButton.addActionListener(e ->
        {

            adresaLivrare = textField4.getText();
            System.out.println("adresa adaugata este " + adresaLivrare);
            dispose();
        });

        livreazaLaDomiciliuButton.addActionListener(e ->
        {
            undeLivreaza = "domiciliu";
            System.out.println("adresa adaugata este domiciliu");
            dispose();
        });

        livreazaLaEasyBoxVictorieiButton.addActionListener(e -> {

            undeLivreaza = "EasyBoxVictoriei";
            dispose();
        }
        );

        setContentPane(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
