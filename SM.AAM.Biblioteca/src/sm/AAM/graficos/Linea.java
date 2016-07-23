/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase define un objeto de tipo linea
 *
 * @author Antonio
 */
public class Linea extends Forma {

    private Line2D geometria;

    /**
     * Crea un objeto de tipo linea
     */
    public Linea() {
        this.geometria = new Line2D.Double();
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo linea, pasándole como parámetro dos puntos
     *
     * @param p1 - Punto de inicio
     * @param p2 - Punto final
     */
    public Linea(Point2D p1, Point2D p2) {
        this.geometria = new Line2D.Double(p1, p2);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo linea, pasándole como parámetro dos puntos y un
     * borde
     *
     * @param p1 - Punto de inicio
     * @param p2 - Punto final
     * @param borde - Atributo que se desea asignar a la forma
     */
    public Linea(Point2D p1, Point2D p2, Borde borde) {
        this.setAtributo(borde);
        this.geometria = new Line2D.Double(p1, p2);
        super.geometria = this.geometria;
    }

    /**
     * Método encargado de devolver el punto de comienzo
     *
     * @return - devuelve el punto de comienzo
     */
    public Point2D getP1() {
        return this.geometria.getP1();
    }

    /**
     * Método encargado de devolver el punto final
     *
     * @return - devuelve el punto final
     */
    public Point2D getP2() {
        return this.geometria.getP2();
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
     * Método que comprueba si un punto esta cerca de la forma
     *
     * @param punto - Punto a comprobar
     * @return Devuelve true si esta cerca de la forma
     */
    public boolean isNear(Point2D punto) {
        return this.ptLineDist(punto) <= 2.0;
    }

    /**
     * Comprueba que el punto este dentro de la forma
     *
     * @param p - Punto a comprobar
     * @return - Devuelve true si el punto esta dentro de la forma y false si no
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
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
     * Establece la linea, en los puntos pasados como parámetros
     *
     * @param p1 - Punto de comienzo
     * @param p2 - Punto final
     */
    public void setLine(Point2D p1, Point2D p2) {
        this.geometria = new Line2D.Float(p1, p2);
    }

    /**
     * Establece la linea, en los puntos de la línea pasada como parámetros
     *
     * @param l - Línea pasada como parámetro
     */
    public void setLine(Line2D l) {
        this.geometria.setLine(l);
    }

    /**
     * Devuelve un valor que indica a como se encuentra el punto especificado
     * con respecto a este segmento de línea.
     *
     * @param p - Punto para comparar la distancia
     * @return - Devuelve una distancia
     */
    public int relativeCCW(Point2D p) {
        return this.geometria.relativeCCW(p);
    }

    /**
     * Devuelve la distancia desde un punto a la linea
     *
     * @param pt - Punto desde el que se medirá las distancia
     * @return - Devuelve la distancia
     */
    public double ptLineDist(Point2D pt) {
        return this.geometria.ptLineDist(pt);
    }

    /**
     * Devuelve el cuadrado de la distancia a partir de un determinado Point2D a
     * esta línea.
     *
     * @param pt - Punto desde el que se medirá las distancia
     * @return - Devuelve la distancia
     */
    public double ptLineDistSq(Point2D pt) {
        return this.geometria.ptLineDistSq(pt);
    }

    /**
     * Devuelve la distancia desde un punto a este segmento de línea.
     *
     * @param pt - Punto desde el que se medirá las distancia
     * @return - Devuelve la distancia
     */
    public double ptSegDist(Point2D pt) {
        return this.geometria.ptSegDist(pt);
    }

    /**
     * Devuelve el cuadrado de la distancia desde un punto a este segmento de
     * línea.
     *
     * @param pt - Punto desde el que se medirá las distancia
     * @return - Devuelve la distancia
     */
    public double ptSegDistSq(Point2D pt) {
        return this.geometria.ptSegDistSq(pt);
    }

    /**
     * Comprueba si el segmento de línea especificado intersecta el segmento de
     * línea.
     *
     * @param l - Linea usada pra comprobar si intersecta
     * @return - Devuelve la distancia
     */
    public boolean intersectsLine(Line2D l) {
        return this.geometria.intersectsLine(l);
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
        this.setLine(pos, newp2);
    }

    /**
     * Método encargado de establecer la localización del polígono
     *
     * @param punto - Final de la línea
     */
    @Override
    public void setGeometry(Point2D punto) {
        this.geometria.setLine(this.getP1(), punto);
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
