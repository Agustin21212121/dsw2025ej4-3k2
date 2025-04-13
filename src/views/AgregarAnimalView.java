package views;

import data.Persistencia;
import domain.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InvalidPropertiesFormatException;

public class AgregarAnimalView extends JFrame {
    private JTextField txtEdad, txtPeso, txtValorFijo;
    private JComboBox<Especie> cmbEspecie;
    private JComboBox<Sector> cmbSector;
    private JComboBox<Pais> cmbPais;
    private JButton btnGuardar;

    public AgregarAnimalView() {
        setTitle("Agregar Animal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblEspecie = new JLabel("Especie:");
        lblEspecie.setBounds(20, 20, 100, 25);
        add(lblEspecie);

        cmbEspecie = new JComboBox<>(Persistencia.getEspecies().toArray(new Especie[0]));
        cmbEspecie.setBounds(130, 20, 200, 25);
        add(cmbEspecie);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(20, 60, 100, 25);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(130, 60, 200, 25);
        add(txtEdad);

        JLabel lblPeso = new JLabel("Peso:");
        lblPeso.setBounds(20, 100, 100, 25);
        add(lblPeso);

        txtPeso = new JTextField();
        txtPeso.setBounds(130, 100, 200, 25);
        add(txtPeso);

        JLabel lblValorFijo = new JLabel("Valor Fijo (solo Herbívoros):");
        lblValorFijo.setBounds(20, 140, 200, 25);
        add(lblValorFijo);

        txtValorFijo = new JTextField();
        txtValorFijo.setBounds(230, 140, 100, 25);
        add(txtValorFijo);

        JLabel lblSector = new JLabel("Sector:");
        lblSector.setBounds(20, 180, 100, 25);
        add(lblSector);

        cmbSector = new JComboBox<>(Persistencia.getSectores().toArray(new Sector[0]));
        cmbSector.setBounds(130, 180, 200, 25);
        add(cmbSector);

        JLabel lblPais = new JLabel("País:");
        lblPais.setBounds(20, 220, 100, 25);
        add(lblPais);

        cmbPais = new JComboBox<>(Persistencia.getPaises().toArray(new Pais[0]));
        cmbPais.setBounds(130, 220, 200, 25);
        add(cmbPais);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 270, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarAnimal();
            }
        });
    }

    private void guardarAnimal() {
        try {
            Especie especie = (Especie) cmbEspecie.getSelectedItem();
            int edad = Integer.parseInt(txtEdad.getText());
            double peso = Double.parseDouble(txtPeso.getText());
            Sector sector = (Sector) cmbSector.getSelectedItem();
            Pais pais = (Pais) cmbPais.getSelectedItem();

            if (especie.getTipoAlimentacion().esCarnivoro()) {
                Mamifero nuevo = new Carnivoro(edad, peso, especie, sector, pais);
                Persistencia.getAnimales().add(nuevo);
            } else {
                double valorFijo = Double.parseDouble(txtValorFijo.getText());
                Mamifero nuevo = new Herbivoro(edad, peso, especie, sector, valorFijo, pais);
                Persistencia.getAnimales().add(nuevo);
            }

            JOptionPane.showMessageDialog(this, "Animal agregado con éxito.");
            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}