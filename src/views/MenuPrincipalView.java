package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MenuPrincipalView extends JFrame {

    private JButton btnListar;
    private JButton btnAgregar;

    public MenuPrincipalView() {
        setTitle("Menú Principal - Zoológico");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Centrar ventana

        // Crear botones
        btnListar = new JButton("Listar Animales");
        btnAgregar = new JButton("Agregar Animal");

        // Panel con layout vertical
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(30)); // Espaciado arriba
        panel.add(btnListar);
        panel.add(Box.createVerticalStrut(10)); // Espacio entre botones
        panel.add(btnAgregar);

        add(panel);

        // Acción para el botón Listar
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListarAnimalesView view = new ListarAnimalesView();
                view.setVisible(true);
            }
        });

        // Acción para el botón Agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarAnimalView view = new AgregarAnimalView();
                view.setVisible(true);
            }
        });
    }
}
