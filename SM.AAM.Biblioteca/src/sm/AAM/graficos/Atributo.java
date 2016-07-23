/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Esta clase define un objeto de tipo atributo
 *
 * @author Antonio
 */
public abstract class Atributo {

    private RenderingHints render;
    private Composite comp;

    /**
     * Método que aplica los graphics de la imagen
     *
     * @param g2d
     */
    public abstract void aplicar(Graphics2D g2d);

    /**
     * Método que borrar el alisado
     */
    public void borrarRenderizacion() {
        this.render = null;
    }

    /**
     * Método que borra la transparencia
     */
    public void borrarTransparencia() {
        this.comp = null;
    }

    /**
     * Método que devuelve el alisado
     *
     * @return - Devuelve el alisado asociada al atributo
     */
    public RenderingHints getRenderizacion() {
        return render;
    }

    /**
     * Método que establece un alisado
     *
     * @param render - Alisado que deseas establecer;
     */
    public void setRenderizacion(RenderingHints render) {
        if (render != null) {
            this.render = (RenderingHints) render.clone();
        }
    }

    /**
     * Método que devuelve la transparencia
     *
     * @return - Devuelve la transparencia asociada al atributo
     */
    public Composite getTransparencia() {
        return this.comp;
    }

    /**
     * Método que establece una transparencia
     *
     * @param comp - Transparencia que deseas establecer;
     */
    public void setTransparencia(Composite comp) {
        this.comp = comp;
    }

    /**
     * Método que devuelve la clase del objeto
     *
     * @return - Devuelve la clase
     */
    public abstract Object getClaseAtributo();

}
