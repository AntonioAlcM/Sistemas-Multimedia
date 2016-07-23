/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Color;
import java.awt.MultipleGradientPaint;
import java.awt.geom.Point2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Esta clase define un objeto de tipo degradado radial
 *
 * @author Antonio
 */
public class RellenoRadial extends Relleno {

    private RadialGradientPaint relleno;
    private Color[] colores;
    private float[] fracciones;
    private Point2D center;
    private float radio;
    private Point2D foco;
    MultipleGradientPaint.CycleMethod cycleMethod = null;
    MultipleGradientPaint.ColorSpaceType colorSpace = null;
    AffineTransform gradientTransform = null;

    /**
     * Creas un objeto de tipo degradado radial, pasandole como parámetro una
     * forma, el centro, un radio, unas distancias entre colores y unos colores.
     *
     * @param centro - Punto central del degradado
     * @param radio - El radio del círculo que define la extensión del degradado
     * @param fracciones - Un array de float con la distribución de los colores
     * @param colores - Un array de colores
     */
    public RellenoRadial(Point2D centro, float radio, float[] fracciones, Color[] colores) {
        this.center = centro;
        this.radio = radio;
        this.colores = colores;
        this.fracciones = fracciones;
        relleno = new RadialGradientPaint(centro, radio, fracciones, colores);
        super.relleno = this.relleno;
    }

    /**
     * Creas un objeto de tipo degradado radial, pasandole como parámetro una
     * forma, el centro, un radio, unas distancias entre colores, unos colores y
     * un tipo de ciclo.
     *
     * @param centro - Punto central del degradado
     * @param radio - El radio del círculo que define la extensión del degradado
     * @param fracciones - Un array de float con la distribución de los colores
     * @param colores - Un array de colores
     * @param cycleMethod - Tipos de ciclo
     */
    public RellenoRadial(Point2D centro, float radio, float[] fracciones, Color[] colores, MultipleGradientPaint.CycleMethod cycleMethod) {
        this.colores = colores;
        this.center = centro;
        this.radio = radio;
        this.fracciones = fracciones;
        relleno = new RadialGradientPaint(centro, radio, fracciones, colores, cycleMethod);
        super.relleno = this.relleno;
    }

    /**
     * Creas un objeto de tipo degradado radial, pasandole como parámetro una
     * forma, el centro, un radio, un foco, unas distancias entre colores, unos
     * colores y un tipo de ciclo.
     *
     * @param centro - Punto central del degradado
     * @param radio - El radio del círculo que define la extensión del degradado
     * @param foco - Un punto en el espacio de usuario al que se asigna el
     * primer color
     * @param fracciones - Un array de float con la distribución de los colores
     * @param colores - Un array de colores
     * @param cycleMethod - Tipos de ciclo
     */
    public RellenoRadial(Point2D centro, float radio, Point2D foco, float[] fracciones, Color[] colores, MultipleGradientPaint.CycleMethod cycleMethod) {
        this.colores = colores;
        this.center = centro;
        this.radio = radio;
        this.fracciones = fracciones;
        this.foco = foco;
        relleno = new RadialGradientPaint(centro, radio, foco, fracciones, colores, cycleMethod);
        super.relleno = this.relleno;
    }

    /**
     * /**
     * Creas un objeto de tipo degradado radial, pasandole como parámetro una
     * forma, el centro, un radio, un foco, unas distancias entre colores, unos
     * colores, un tipo de ciclo, un espacio de color y una transformación.
     *
     * @param centro - Punto central del degradado
     * @param radio - El radio del círculo que define la extensión del degradado
     * @param foco - Un punto en el espacio de usuario al que se asigna el
     * primer color
     * @param fracciones - Un array de float con la distribución de los colores
     * @param colores - Un array de colores
     * @param cycleMethod - Tipos de ciclo
     * @param colorSpace - Un espacio de color usado para interpolar
     * @param gradientTransform - Transformación a aplicar al gradiente
     */
    public RellenoRadial(Point2D centro, float radio, Point2D foco, float[] fracciones, Color[] colores, MultipleGradientPaint.CycleMethod cycleMethod, MultipleGradientPaint.ColorSpaceType colorSpace, AffineTransform gradientTransform) {
        this.center = centro;
        this.radio = radio;
        this.colores = colores;
        this.fracciones = fracciones;
        this.foco = foco;
        this.colorSpace = colorSpace;
        this.gradientTransform = gradientTransform;
        relleno = new RadialGradientPaint(centro, radio, foco, fracciones, colores, cycleMethod, colorSpace, gradientTransform);
        super.relleno = this.relleno;
    }

    /**
     * Creas un objeto de tipo degradado radial, pasandole como parámetro una
     * forma, el centro, un radio, unas distancias entre colores, unos colores y
     * un tipo de ciclo.
     *
     * @param gradientBounds - El cuadro delimitador, en el espacio del usuario,
     * del círculo que define la extensión más externa del gradiente
     * @param fracciones - Un array de float con la distribución de los colores
     * @param colores - Un array de colores
     * @param cycleMethod - Tipos de ciclo
     */
    public RellenoRadial(Rectangle2D gradientBounds, float[] fracciones, Color[] colores, MultipleGradientPaint.CycleMethod cycleMethod) {
        this.colores = colores;
        this.fracciones = fracciones;
        relleno = new RadialGradientPaint(gradientBounds, fracciones, colores, cycleMethod);
        super.relleno = this.relleno;
    }

    /**
     * Contructor de copia
     *
     * @param rellenoRadial - Relleno que va a ser copiado
     */
    public RellenoRadial(RellenoRadial rellenoRadial) {
        this.center = rellenoRadial.center;
        this.radio = rellenoRadial.radio;
        this.colores = rellenoRadial.colores;
        this.fracciones = rellenoRadial.fracciones;
        this.foco = rellenoRadial.foco;
        this.colorSpace = rellenoRadial.colorSpace;
        this.gradientTransform = rellenoRadial.gradientTransform;
        relleno = new RadialGradientPaint(center, radio, foco, fracciones, colores, cycleMethod, colorSpace, gradientTransform);
        super.relleno = this.relleno;
        super.setRenderizacion(rellenoRadial.getRenderizacion());
        super.setTransparencia(rellenoRadial.getTransparencia());
    }

    /**
     * Devuelve el radio del círculo que define la extensión del degradado
     *
     * @return - Un float con el radio
     */
    public float getRadius() {
        return this.relleno.getRadius();
    }

    /**
     * Devuelve el punto en el espacio de usuario al que se asigna el primer
     * color
     *
     * @return - Un punto
     */
    public Point2D getFocusPoint() {
        return this.relleno.getFocusPoint();
    }

    /**
     * Devuelve el punto central del degradado
     *
     * @return - Un punto
     */
    public Point2D getCenterPoint() {
        return this.relleno.getCenterPoint();
    }

    /**
     * Devuelve el array de float con la distribución de los colores
     *
     * @return - Un array de float
     */
    public float[] getFracciones() {
        return this.fracciones;
    }

    /**
     * Devuelve un array con los colores del degradado
     *
     * @return - Un array de Color
     */
    public Color[] getColores() {
        return this.colores;
    }

    /**
     * Método que modica el radio del círculo que define la extensión del
     * degradado
     *
     * @param radio - Nuevo radio del degradado
     */
    public void setRadio(float radio) {
        if (this.cycleMethod == null) {
            relleno = new RadialGradientPaint(center, radio, fracciones, colores);
            super.relleno = this.relleno;
        } else if (colorSpace == null) {
            relleno = new RadialGradientPaint(center, radio, foco, fracciones, colores, cycleMethod);
            super.relleno = this.relleno;
        } else {
            relleno = new RadialGradientPaint(center, this.radio, this.foco, fracciones, colores, cycleMethod, colorSpace, gradientTransform);
            super.relleno = this.relleno;
        }
    }

    /**
     * Método que modica el centro del degradado
     *
     * @param center - Nuevo centro del degradado
     */
    public void setCenterPoint(Point2D center) {
        if (this.cycleMethod == null) {
            relleno = new RadialGradientPaint(center, radio, fracciones, colores);
            super.relleno = this.relleno;
        } else if (colorSpace == null) {
            relleno = new RadialGradientPaint(center, radio, foco, fracciones, colores, cycleMethod);
            super.relleno = this.relleno;
        } else {
            relleno = new RadialGradientPaint(center, this.radio, this.foco, fracciones, colores, cycleMethod, colorSpace, gradientTransform);
            super.relleno = this.relleno;
        }
    }

    /**
     * Método que modica el array de float con la distribución de los colores
     *
     * @param fracciones - Nuevo array con la distribución de los colores
     */
    public void setFracciones(float[] fracciones) {
        if (this.cycleMethod == null) {
            relleno = new RadialGradientPaint(center, radio, fracciones, colores);
            super.relleno = this.relleno;
        } else if (colorSpace == null) {
            relleno = new RadialGradientPaint(center, radio, foco, fracciones, colores, cycleMethod);
            super.relleno = this.relleno;
        } else {
            relleno = new RadialGradientPaint(center, this.radio, this.foco, fracciones, colores, cycleMethod, colorSpace, gradientTransform);
            super.relleno = this.relleno;
        }
    }

    /**
     * Método que modica el array de colores del degradado
     *
     * @param colores - Nuevo array de colores
     */
    public void setColores(Color[] colores) {
        if (this.cycleMethod == null) {
            relleno = new RadialGradientPaint(center, radio, fracciones, colores);
            super.relleno = this.relleno;
        } else if (colorSpace == null) {
            relleno = new RadialGradientPaint(center, radio, foco, fracciones, colores, cycleMethod);
            super.relleno = this.relleno;
        } else {
            relleno = new RadialGradientPaint(center, this.radio, this.foco, fracciones, colores, cycleMethod, colorSpace, gradientTransform);
            super.relleno = this.relleno;
        }
    }

}
