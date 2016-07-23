/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Graphics2D;
import java.awt.Paint;

/**
 *
 * @author Antonio
 */
public abstract class Relleno extends Atributo {

    Forma figura;
    Paint relleno;

    /**
     * Método que aplica los graphics de la imagen
     *
     * @param g2d - Graphics de la imagen
     */
    public void aplicar(Graphics2D g2d) {
        g2d.setPaint(this.relleno);
        if (super.getTransparencia() != null) {
            g2d.setComposite(this.getTransparencia());
        }
        if (super.getRenderizacion() != null) {
            g2d.setRenderingHints(this.getRenderizacion());
        }
    }

    /**
     * Método que establece un relleno
     *
     * @param relleno - Se le pasa un relleno, que sustituirá el relleno actual
     */
    public void setRelleno(Paint relleno) {
        this.relleno = relleno;
    }

    /**
     * Método que devuelve el relleno
     *
     * @return Devuelve el relleno
     */
    public Paint getRelleno() {
        return this.relleno;
    }

    /**
     * Método que devuelve la clase del objeto
     *
     * @return - Devuelve RellenoSimple como clase
     */
    @Override
    public Object getClaseAtributo() {
        return Relleno.class;
    }

}
