/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Color;

/**
 * Esta clase define un objeto de tipo relleno
 *
 * @author Antonio
 */
public class RellenoSimple extends Relleno {

    private Color color;

    /**
     * Creas un objeto de tipo relleno, pasandole como parámetro una forma y un
     * color.
     *
     * @param color - Color que deseas para el relleno
     */
    public RellenoSimple(Color color) {
        this.color = color;
        super.relleno = this.color;
    }

    /**
     * Contructor de copia
     *
     * @param rellenoSimple - Relleno que va a ser copiado
     */
    public RellenoSimple(RellenoSimple rellenoSimple) {
        this.color = rellenoSimple.getColor();
        super.relleno = this.color;
        super.setRenderizacion(rellenoSimple.getRenderizacion());
        super.setTransparencia(rellenoSimple.getTransparencia());
    }

    /**
     * Método que establece el color del relleno
     *
     * @param color - Color del relleno
     */
    public void setColorRelleno(Color color) {
        this.relleno = color;
        super.relleno = this.relleno;

    }

    /**
     * Devuelve el color
     *
     * @return - Devuelve el color asociado al atributo
     */
    public Color getColor() {
        return this.color;
    }

}
