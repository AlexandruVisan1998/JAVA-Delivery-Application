package client.gui;

import client.controller.UserController;
import lib.dto.UserDTO;

import javax.swing.*;

public class LoginFrameForm extends JFrame {
    private JTextField textField1;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JButton logInButton;
    private JButton signInButton;

    JFrame frame = new JFrame();


        public LoginFrameForm() {

            frame.setTitle("Login");

            logInButton.addActionListener(ev -> {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());
                UserDTO userDTO = new UserDTO(username, password);

                try {
                    int id = UserController.getInstance().login(userDTO);

                    JOptionPane.showMessageDialog(null, "Conectat ca " + id);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Username sau parola gresita");
                    passwordField1.setText("");
                }
                new PlatesteFrameForm();
            });

            signInButton.addActionListener(ev -> {
                String username = textField1.getText();
                String password = new String(passwordField1.getPassword());
                UserDTO userDTO = new UserDTO(username, password);

                try {
                    int id = UserController.getInstance().signin(userDTO);

                    JOptionPane.showMessageDialog(null, "Intregistrat ca " + id);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Username deja folosit");
                    passwordField1.setText("");
                    textField1.setText("");
                }
                new PlatesteFrameForm();
            });

            setContentPane(panel1);
            pack();

            setLocationRelativeTo(null);
            setVisible(true);

        }
    }


