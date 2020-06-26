package client.gui;

import javax.swing.*;

public class PlatesteFrameForm extends JFrame{
    private JPanel panel1;
    private JButton platestePrinCardButton;
    private JButton platesteCashLaLivrareButton;

    JFrame frame = new JFrame();

    String plata = null;



    public PlatesteFrameForm()
    {

        frame.setTitle("Plata");

        platesteCashLaLivrareButton.addActionListener(e ->
        {
            plata = "cash";

            dispose();
            new ComenziFrameForm();
        });

        platestePrinCardButton.addActionListener(e ->
        {
            plata = "card";

            dispose();
            new ComenziFrameForm();
        });

        setContentPane(panel1);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

    }
}
