/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Avion;
import Modelo.Pasajero;
import controlador.EventoPasajero;
import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class VentanaPasajero extends JInternalFrame {

    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private GestionDato gD;

    public VentanaPasajero(GestionDato gD) {
        super("Datos del Pasajero", true, true, true, true);
        this.setSize(500, 500);
        this.gD = gD;
        this.iniciacomponente();
    }

    public void iniciacomponente() {
        this.etiquetaList = new ArrayList<JLabel>();
        this.etiquetaList.add(new JLabel("Id"));
        this.etiquetaList.add(new JLabel("Nombre:"));
        this.etiquetaList.add(new JLabel("Cedula: "));
        this.etiquetaList.add(new JLabel("Telefono: "));
        this.etiquetaList.add(new JLabel("Nacionalidad: "));

        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField(16));
        this.txtList.add(new JTextField(16));
        this.txtList.add(new JTextField(16));
        this.txtList.add(new JTextField(13));
        this.txtList.add(new JTextField(16));

        JPanel panel = new JPanel();
        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Nuevo"));
        
        this.botonList.get(0).addActionListener(new EventoPasajero(this));
        this.botonList.get(1).addActionListener(new EventoPasajero(this));
        
        this.encabezado = new Object[5];

        this.encabezado[0] = "Id";
        this.encabezado[1] = "Nombre";
        this.encabezado[2] = "Cedula";
        this.encabezado[3] = "Telefono";
        this.encabezado[4] = "Nacionalidad";

        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        panel.add(this.etiquetaList.get(0));
        panel.add(this.txtList.get(0));
        panel.add(this.etiquetaList.get(1));
        panel.add(this.txtList.get(1));
        panel.add(this.etiquetaList.get(2));
        panel.add(this.txtList.get(2));
        panel.add(this.etiquetaList.get(3));
        panel.add(this.txtList.get(3));
        panel.add(this.etiquetaList.get(4));
        panel.add(this.txtList.get(4));
        panel.add(botonList.get(0));
        panel.add(botonList.get(1));

        panel.add(this.scroll);
        this.add(panel);
    }
    
    public Object[][] cargaDatosTabla(int h, int w) {
        Object[][] retorno = new Object[h][w];
        int i = 0;
        for (Pasajero p : this.gD.leerPasajero()) {
            retorno[i][0] = p.getId();
            retorno[i][1] = p.getNombreYAp();
            retorno[i][2] = p.getCedula();
            retorno[i][3] = p.getTelefono();
            retorno[i][4] = p.getNacionalidad();
            i++;
        }
        return retorno;
    }


    public List<JLabel> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<JLabel> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

}
