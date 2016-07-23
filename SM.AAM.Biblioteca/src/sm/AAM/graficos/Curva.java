/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase define un objeto de tipo curva
 *
 * @author Antonio
 */
public class Curva extends Forma {

    private Point2D puntoInicio;
    private Point2D puntoFinal;
    private Point2D puntoControl;
    private QuadCurve2D geometria;

    /**
     * Crea un objeto de tipo curva
     */
    public Curva() {
        this.geometria = new QuadCurve2D.Double();
    }

    /**
     * Crea un objeto de tipo curva, pasandole como parámetro un punto de inicio
     *
     * @param puntoInicio - Punto de inicio de la curva
     */
    public Curva(Point2D puntoInicio) {
        this.puntoInicio = puntoInicio;
        this.puntoControl = puntoInicio;
        double x = puntoInicio.getX();
        double y = puntoInicio.getY();
        this.geometria = new QuadCurve2D.Double(x, y, x, y, x, y);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo curva, pasandole como parámetro un punto de inicio
     * y un punto final.
     *
     * @param puntoInicio - Punto de inicio de la curva
     * @param puntoFinal - Punto final de la curva
     */
    public Curva(Point2D puntoInicio, Point2D puntoFinal) {
        this.puntoInicio = puntoInicio;
        this.puntoFinal = puntoFinal;
        this.puntoControl = puntoInicio;
        double x = puntoInicio.getX();
        double y = puntoInicio.getY();
        double x1 = puntoFinal.getX();
        double y2 = puntoFinal.getY();
        this.geometria = new QuadCurve2D.Double(x, y, x, y, x1, y2);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo curva, pasandole como parámetro un punto de
     * inicio, un punto final y un punto de control.
     *
     * @param puntoInicio - Punto de inicio de la curva
     * @param puntoFinal - Punto final de la curva
     * @param puntoControl - Punto que establece la posición de la curva
     */
    public Curva(Point2D puntoInicio, Point2D puntoFinal, Point2D puntoControl) {
        this.puntoInicio = puntoInicio;
        this.puntoFinal = puntoFinal;
        this.puntoControl = puntoControl;
        double x = puntoInicio.getX();
        double y = puntoInicio.getY();
        double x1 = puntoFinal.getX();
        double y2 = puntoFinal.getY();
        double xc = puntoControl.getX();
        double yc = puntoControl.getY();
        this.geometria = new QuadCurve2D.Double(x, y, xc, yc, x1, y2);
        super.geometria = this.geometria;
    }

    /**
     * /**
     * Crea un objeto de tipo curva, pasandole como parámetro un punto de inicio
     * y un borde
     *
     * @param puntoInicio - Punto de inicio de la curva
     * @param borde - Atributo asociado a la curva
     */
    public Curva(Point2D puntoInicio, Borde borde) {
        this.setAtributo(borde);
        this.puntoInicio = puntoInicio;
        this.puntoControl = puntoInicio;
        double x = puntoInicio.getX();
        double y = puntoInicio.getY();
        this.geometria = new QuadCurve2D.Double(x, y, x, y, x, y);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo curva, pasandole como parámetro un punto de
     * inicio, un punto final y un borde.
     *
     * @param puntoInicio - Punto de inicio de la curva
     * @param puntoFinal - Punto final de la curva
     * @param borde - Borde asociado a la curva
     */
    public Curva(Point2D puntoInicio, Point2D puntoFinal, Borde borde) {
        this.setAtributo(borde);
        this.puntoInicio = puntoInicio;
        this.puntoControl = puntoInicio;
        this.puntoFinal = puntoFinal;
        double x = puntoInicio.getX();
        double y = puntoInicio.getY();
        double x1 = puntoFinal.getX();
        double y2 = puntoFinal.getY();
        this.geometria = new QuadCurve2D.Double(x, y, x, y, x1, y2);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo curva, pasandole como parámetro un punto de
     * inicio, un punto final, un punto de control y un borde.
     *
     * @param puntoInicio - Punto de inicio de la curva
     * @param puntoFinal - Punto final de la curva
     * @param puntoControl - Punto que establece la posición de la curva
     * @param borde - Atributo asociado a la curva
     */
    public Curva(Point2D puntoInicio, Point2D puntoFinal, Point2D puntoControl, Borde borde) {
        this.setAtributo(borde);
        this.puntoInicio = puntoInicio;
        this.puntoFinal = puntoFinal;
        this.puntoControl = puntoControl;
        double x = puntoInicio.getX();
        double y = puntoInicio.getY();
        double x1 = puntoFinal.getX();
        double y2 = puntoFinal.getY();
        double xc = puntoControl.getX();
        double yc = puntoControl.getY();
        this.geometria = new QuadCurve2D.Double(x, y, xc, yc, x1, y2);
        super.geometria = this.geometria;
    }

    /**
     * Método encargado de establecer la posición de la forma
     *
     * @param pos - Nueva posición a la que mover la forma
     */
    @Override
    public void setLocation(Point2D pos) {
        double dx = pos.getX() - this.geometria.getX1();
        double dy = pos.getY() - this.geometria.getY1();
        Point2D.Double newp2 = new Point2D.Double(this.geometria.getX2() + dx, this.geometria.getY2() + dy);
        Point2D.Double newpc = new Point2D.Double(this.geometria.getCtrlX() + dx, this.geometria.getCtrlY() + dy);
        this.setCurve(pos, newpc, newp2);
    }

    /**
     * Devuelve un rectángulo entero que encierra completamente la forma.
     *
     * @return - Un rectángulo entero que encierra completamente la forma.
     */
    @Override
    public Rectangle getBounds() {
        return this.geometria.getBounds();
    }

    /**
     * Devuelve con una alta precisión y más exacta el contorno de la Forma, que
     * el método getBounds
     *
     * @return - Una instancia de Rectangle2D que es un borde de alta precisión
     * de la forma.
     */
    @Override
    public Rectangle2D getBounds2D() {
        return this.geometria.getBounds2D();
    }

    /**
     * Comprueba que las coordenadas esten dentro de la forma
     *
     * @param x - Coordenada a comprobar
     * @param y - Coordenada a comprobar
     * @return - Devuelve true si las coordenadas están dentro de la forma y
     * false si no
     */
    @Override
    public boolean contains(double x, double y) {
        return this.geometria.contains(x, y);
    }

    /**
     * Comprueba que el punto este dentro de la forma
     *
     * @param p - Punto a comprobar
     * @return - Devuelve true si el punto esta dentro de la forma y false si no
     */
    @Override
    public boolean contains(Point2D p) {
        return this.geometria.contains(p);
    }

    /**
     * Comprueba si el interior de la forma intersección con el interior de un
     * área rectangular especificada
     *
     * @param x - Coordenada x de la forma rectangular especificada
     * @param y - Coordenada y de la forma rectangular especificada
     * @param w - Ancho de la forma rectangular especificada
     * @param h - Alto de la forma rectangular especificada
     * @return - Devuelve true si se intersecan y false si no
     */
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return this.geometria.intersects(x, y, w, h);
    }

    /**
     * Comprueba si el interior de la forma intersección con el interior de un
     * área rectangular especificada
     *
     * @param r - Renctangle que deseas comprobar
     * @return - Devuelve true si se intersecan y false si no
     */
    @Override
    public boolean intersects(Rectangle2D r) {
        return this.geometria.intersects(r);
    }

    /**
     * Comprueba si el interior de la Forma contiene completamente el área
     * rectangular especificada.
     *
     * @param x - Coordenada x de la forma rectangular especificada
     * @param y - Coordenada y de la forma rectangular especificada
     * @param w - Ancho de la forma rectangular especificada
     * @param h - Alto de la forma rectangular especificada
     * @return - Devuelve true si la Forma contiene completamente el área
     * rectangular especificada y false si no
     */
    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.geometria.contains(x, y, w, h);
    }

    /**
     * Comprueba si el interior de la Forma contiene enteramente la Rectangle2D
     * especificado.
     *
     * @param r - Renctangle que deseas comprobar
     * @return - Devuelve true si la Forma contiene completamente el rectangle2D
     * especificada y false si no
     */
    @Override
    public boolean contains(Rectangle2D r) {
        return this.geometria.contains(r);
    }

    /**
     * Devuelve un objeto iterador que itera a lo largo del contorno de la forma
     * y proporciona acceso a la geometría del contorno de la forma.
     *
     * @param at - Un AffineTransform opcional que debe aplicarse a las
     * coordenadas, ya que se devuelven en la iteración, o null si se desean
     * coordenadas transformadas
     * @return - Un nuevo objeto PathIterator
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return this.geometria.getPathIterator(at);
    }

    /**
     * Devuelve un objeto iterador que repite a lo largo del contorno de la
     * forma y proporciona acceso a una vista aalisada de la geometría del
     * contorno de la forma.
     *
     * @param at - Un AffineTransform opcional que debe aplicarse a las
     * coordenadas, ya que se devuelven en la iteración, o null si se desean
     * coordenadas transformadas
     * @param flatness - la distancia máxima que los segmentos de línea
     * utilizados para aproximar los segmentos curvos pueden desviarse desde
     * cualquier punto de la curva original
     * @return - Un nuevo objeto PathIterator
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return this.geometria.getPathIterator(at, flatness);
    }

    /**
     * Crea un nuevo objeto de la misma clase que este objeto.
     *
     * @return - Devuelve un objeto de la misma clase que el objeto que va a ser
     * clonado
     */
    public Object clone() {
        return this.geometria.clone();
    }

    /**
     * Método que devuelve la posición donde se curva la línea
     *
     * @return - Devuelve el punto de la posición de la curva
     */
    public Point2D getCtrlPt() {
        return this.geometria.getCtrlPt();
    }

    /**
     * Método que devuelve la posición inicial de la curva
     *
     * @return - Devuelve el punto de inicio de la curva
     */
    public Point2D getP1() {
        return this.geometria.getP1();
    }

    /**
     * Método que devuelve la posición final de la curva
     *
     * @return - Devuelve el punto final de la curva
     */
    public Point2D getP2() {
        return this.geometria.getP2();
    }

    /**
     * Método que establece la posición inicila de la curva
     *
     * @param puntoInicio - Punto donde va a comenzar la curva
     */
    public void setP1(Point2D puntoInicio) {
        this.puntoInicio = puntoInicio;
        this.setCurve(puntoInicio, this.puntoControl, puntoFinal);
    }

    /**
     * Método que establece la posición final de la curva
     *
     * @param puntoFinal - Punto donde va a finalizar la curva
     */
    public void setP2(Point2D puntoFinal) {
        this.puntoFinal = puntoFinal;
        this.setCurve(puntoInicio, this.puntoControl, puntoFinal);
    }

    /**
     * Método que establece la posición de la curva
     *
     * @param puntoControl - Punto donde va a girar la curva
     */
    public void setPC(Point2D puntoControl) {
        this.puntoControl = puntoControl;
        this.geometria.setCurve(puntoInicio, puntoControl, puntoFinal);
    }

    /**
     * Devuelve el flatness o la distancia máxima de un punto de control de la
     * línea que conecta los puntos finales.
     *
     * @return Devuelve la distancia máxima
     */
    public double getFlatness() {
        return this.geometria.getFlatness();
    }

    /**
     * Devuelve el cuadrado del flatness o la distancia máxima de un punto de
     * control de la línea que conecta los puntos finales
     *
     * @return Devuelve la distancia máxima
     */
    public double getFlatnessSq() {
        return this.geometria.getFlatnessSq();
    }

    /**
     * Subdividide la QuadCurve2D y almacena las curvas resultantes en los
     * parámetros de izquierda y derecha.
     *
     * @param left - Almacena la mitad izquierda o la primera parte de la curva
     * subdividida
     * @param right - Almacena la mitad derecha o la segunda parte de la curva
     * subdividida
     */
    public void subdivide(QuadCurve2D left, QuadCurve2D right) {
        this.geometria.subdivide(left, right);
    }

    /**
     * Establece la ubicación de los puntos finales y del punto de control
     *
     * @param p1 - Punto de inicio de la curva.
     * @param cp - Punto de control de la curva
     * @param p2 - Punto final de la curva
     */
    public void setCurve(Point2D p1, Point2D cp, Point2D p2) {
        this.geometria.setCurve(p1, cp, p2);
    }

    /**
     * Establece la ubicación de una curva
     *
     * @param c - Curva que deseas establecer
     */
    public void setCurve(QuadCurve2D c) {
        this.geometria.setCurve(c);
    }

    /**
     * Método encargado de establecer la localización de la curva
     *
     * @param punto - Punto final de la curva
     */
    @Override
    public void setGeometry(Point2D punto) {
        this.puntoFinal = punto;
        this.setCurve(this.puntoInicio, this.puntoInicio, punto);
    }

    /**
     * Método encargado de asignar un atributo a una forma
     *
     * @param atributo - Atributo asociado a la forma
     */
    @Override
    public void setAtributo(Atributo atributo) {
        List<Atributo> atributos = new ArrayList();
        atributos = this.getAtributos();
        if (!atributos.equals(atributo)) {
            if (!(atributo instanceof RellenoSimple)) {
                super.setAtributo(atributo);
            }
        }
    }

}
