/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaFinal;

/**
 * Clase que crea una ventana interna.
 *
 * @author Antonio
 */
public class VentanaInterna extends javax.swing.JInternalFrame {

    /**
     * Creates new form VentanaInterna
     */
    public VentanaInterna() {
        initComponents();
    }

    /**
     * Comprueba si la ventanaInterna es de tipo VentanaInternaImagen
     *
     * @return Devuelve true si es de tipo VentanaInternaImagen
     */
    public boolean isImagen() {
        return this instanceof VentanaInternaImagen;
    }

    /**
     * Comprueba si la ventanaInterna es de tipo VentanaInternaCamara
     *
     * @return Devuelve true si es de tipo VentanaInternaCamara
     */
    public boolean isCamara() {
        return this instanceof VentanaInternaCamara;
    }

    /**
     * Comprueba si la ventanaInterna es de tipo VentanaInternaReproduccionVideo
     *
     * @return Devuelve true si es de tipo VentanaInternaReproduccionVideo
     */
    public boolean isVideo() {
        return this instanceof VentanaInternaReproduccionVideo;
    }

    /**
     * Comprueba si la ventanaInterna es de tipo VentanaInternaSonido
     *
     * @return Devuelve true si es de tipo VentanaInternaSonido
     */
    public boolean isSonido() {
        return this instanceof VentanaInternaSonido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}