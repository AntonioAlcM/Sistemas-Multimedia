package sm.AAM.iu;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Esta clase define objetos que contienen una lista de colores
 *
 * @author Antonio
 */
public class IconoColor extends javax.swing.JPanel implements ListCellRenderer<Color> {

    /**
     * Creates new form miCelda
     */
    public IconoColor() {
        initComponents();
    }

    /**
     * Establece el color del fondo de la celda
     *
     * @param color - Color que se desea para la celda
     */
    public void setBackgroundCelda(Color color) {
        this.setBackground(color);
    }

    /**
     * Obtiene el color de la celda
     *
     * @return devuelve el color del fondo de la celda
     */
    public Color getBackgroundCelda() {
        return this.getBackground();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDoubleBuffered(false);
        setMaximumSize(new java.awt.Dimension(34, 33));
        setMinimumSize(new java.awt.Dimension(34, 33));
        setPreferredSize(new java.awt.Dimension(34, 33));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 1, 1));

        jButton1.setMaximumSize(new java.awt.Dimension(28, 28));
        jButton1.setMinimumSize(new java.awt.Dimension(28, 28));
        jButton1.setPreferredSize(new java.awt.Dimension(28, 28));
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
    /**
     * Crea una lista de botones de colores
     *
     * @param list - La lista de los componentes que van a ser pintados
     * @param value - Devuelve el valor de la lista
     * @param index - El índice de las celdas
     * @param isSelected - Verdadero si se ha seleccionado la celda
     * especificada.
     * @param cellHasFocus - Verdadero si la celda especificada tiene el foco.
     * @return - Devuelve el valor del componente
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
        this.jButton1.setBackground(value);
        Color background;
        Color foreground;

        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = list.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            background = Color.BLUE;
            foreground = Color.WHITE;

            // check if this cell is selected
        } else if (isSelected) {
            background = Color.GRAY;
            foreground = Color.WHITE;

            // unselected, and not the DnD drop location
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        };

        setBackground(background);
        setForeground(foreground);
        return this;
    }
}
