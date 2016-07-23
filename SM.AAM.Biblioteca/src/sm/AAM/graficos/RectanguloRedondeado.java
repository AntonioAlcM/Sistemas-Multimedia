/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.List;

/**
 * Esta clase define un objeto de tipo rectangulo redondeado
 *
 * @author Antonio
 */
public class RectanguloRedondeado extends Forma {

    private RoundRectangle2D geometria;
    Point2D p1;
    Point2D p2;
    Point2D arc;
    Atributo atributo;

    /**
     * Crea un objeto de tipo rectangulo redondeado
     */
    public RectanguloRedondeado() {
        this.geometria = new RoundRectangle2D.Double();
        p1 = this.getP1();
        p2 = this.getP2();
        arc = this.getArc();
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo redondeado, pasandole como parámetros
     * dos puntos
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param arc - Curvatura de la esquina
     */
    public RectanguloRedondeado(Point2D p1, Point2D p2, Point2D arc) {
        this.geometria = new RoundRectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY(), arc.getX(), arc.getY());
        this.p1 = p1;
        this.p2 = p2;
        this.arc = arc;
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo redondeado, pasandole como parámetros
     * dos puntos y un borde
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param arc - Curvatura de la esquina
     * @param borde - Borde que se desea asignar a la forma
     */
    public RectanguloRedondeado(Point2D p1, Point2D p2, Point2D arc, Borde borde) {
        this.setAtributo(borde);
        this.p1 = p1;
        this.p2 = p2;
        this.arc = arc;
        this.geometria = new RoundRectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY(), arc.getX(), arc.getY());
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo redondeado, pasandole como parámetros
     * dos puntos y un relleno
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param arc - Curvatura de la esquina
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public RectanguloRedondeado(Point2D p1, Point2D p2, Point2D arc, Relleno relleno) {
        this.setAtributo(relleno);
        this.p1 = p1;
        this.p2 = p2;
        this.arc = arc;
        this.geometria = new RoundRectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY(), arc.getX(), arc.getY());
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo redondeado, pasandole como parámetros
     * dos puntos, un borde y un relleno
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param arc - Curvatura de la esquina
     * @param borde - Borde que se desea asignar a la forma
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public RectanguloRedondeado(Point2D p1, Point2D p2, Point2D arc, Borde borde, Relleno relleno) {
        this.setAtributo(borde);
        this.setAtributo(relleno);
        this.p1 = p1;
        this.p2 = p2;
        this.arc = arc;
        this.geometria = new RoundRectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY(), arc.getX(), arc.getY());
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo redondeado, pasandole como parámetros
     * dos puntos y un array de atributos
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param arc - Curvatura de la esquina
     * @param atributos - Atributos que se desea asignar a la forma
     */
    public RectanguloRedondeado(Point2D p1, Point2D p2, Point2D arc, List<Atributo> atributos) {
        this.setAtributo(atributos);
        this.p1 = p1;
        this.p2 = p2;
        this.arc = arc;
        this.geometria = new RoundRectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY(), arc.getX(), arc.getY());
        super.geometria = this.geometria;
    }

    /**
     * Método encargado de establecer la posición de la forma
     *
     * @param pos - Nueva posición a la que mover la forma
     */
    @Override
    public void setLocation(Point2D pos) {
        this.setFrame(pos, new Dimension((int) this.geometria.getWidth(), (int) this.geometria.getHeight()));
        List<Atributo> atributos = super.getAtributos();
        for (int i = 0; i < atributos.size(); i++) {
            if (atributos.get(i) instanceof Relleno) {
                if (atributos.get(i) instanceof RellenoDegradado) {
                    ((RellenoDegradado) atributos.get(i)).setPuntosDegradado(this.getP1(), this.getP2());
                } else if (atributos.get(i) instanceof RellenoRadial) {
                    ((RellenoRadial) atributos.get(i)).setCenterPoint(new Point2D.Double(this.geometria.getBounds().getCenterX(), this.geometria.getBounds().getCenterY()));
                }
            }
        }

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
     * Método encargado de devolver la altura
     *
     * @return Devuelve un double con la altura
     */
    public double getHeight() {
        return this.geometria.getHeight();
    }

    /**
     * Método encargado de devolver el ancho
     *
     * @return Devuelve un double con el ancho
     */
    public double getWidth() {
        return this.geometria.getWidth();
    }

    /**
     * Método encargado de devolver el ancho y el alto
     *
     * @return Devuelve un double con el ancho
     */
    public Point2D getArc() {
        return new Point2D.Double(this.geometria.getWidth(), this.geometria.getHeight());
    }

    /**
     * Método encargado de devolver la altura del arco de la esquina
     *
     * @return Devuelve un double con la altura
     */
    public double getArcHeight() {
        return this.geometria.getArcHeight();
    }

    /**
     * Método encargado de devolver el ancho del arco de la esquina
     *
     * @return Devuelve un double con el ancho
     */
    public double getArcWidth() {
        return this.geometria.getArcWidth();
    }

    /**
     *
     * @param arc
     */
    public void setArc(Point2D arc) {
        this.arc = arc;
        this.geometria.setRoundRect(this.p1.getX(), this.p1.getY(), this.getWidth(), this.getHeight(), this.arc.getX(), this.arc.getY());
        super.geometria = this.geometria;

    }

    /**
     *
     * @param alto
     */
    public void setArcHeight(int alto) {
        this.arc = new Point2D.Double(this.arc.getX(), alto);
        this.geometria.setRoundRect(this.p1.getX(), this.p1.getY(), this.getWidth(), this.getHeight(), this.arc.getX(), alto);
        super.geometria = this.geometria;
    }

    /**
     *
     * @param ancho
     */
    public void setArcWidth(int ancho) {
        this.arc = new Point2D.Double(ancho, this.arc.getY());
        this.geometria.setRoundRect(this.p1.getX(), this.p1.getY(), this.getWidth(), this.getHeight(), ancho, this.arc.getY());
        super.geometria = this.geometria;
    }

    /**
     * Método encargado de devolver el punto central de la forma
     *
     * @return Devuelve el punto de comienzo central de la forma
     */
    public Point2D getCenter() {
        return new Point2D.Double(this.geometria.getCenterX(), this.geometria.getCenterY());
    }

    /**
     * Método encargado de comparar la forma con un objeto
     *
     * @param obj - Objeto que va a ser comparado
     * @return Devuelve true si el objeto y la forma son iguales, false si no
     */
    public boolean equals(Object obj) {
        return this.geometria.equals(obj);
    }

    /**
     * Devuelve el código hash para este Rectangle2D.
     *
     * @return - Devuelve un int con el código hash
     */
    public int hashCode() {
        return this.geometria.hashCode();
    }

    /**
     * Establece la ubicación y el tamaño de los límites exteriores de este
     * Rectangle2D a los valores especificados rectangulares.
     *
     * @param loc - El punto donde se desea poner la figura
     * @param size - La dimensión de la forma
     */
    public void setFrame(Point2D loc, Dimension2D size) {
        this.geometria.setFrame(loc, size);
    }

    /**
     * Establece el rectángulo de encuadre de esta forma, pasandolé un
     * rectángulo
     *
     * @param r - Un rectangulo
     */
    public void setFrame(Rectangle2D r) {
        this.geometria.setFrame(r);
    }

    /**
     * Establece la diagonal del rectángulo, usando para ello dos puntos
     *
     * @param p1 - Punto de inicio
     * @param p2 - Punto final
     */
    public void setFrameFromDiagonal(Point2D p1, Point2D p2) {
        this.geometria.setFrameFromDiagonal(p1, p2);
    }

    /**
     * Establece el rectángulo de encuadre de esta forma basada en las
     * coordenadas del punto central especificada y coordenadas de los puntos de
     * esquina.
     *
     * @param center - Centro de la forma
     * @param corner - Esquina de la frma
     */
    public void setFrameFromCenter(Point2D center, Point2D corner) {
        this.geometria.setFrameFromCenter(center, corner);
    }

    /**
     * Comprueba si la figura está vacía
     *
     * @return Devuelve true esi la figura esta vacía
     */
    public boolean isEmpty() {
        return this.geometria.isEmpty();
    }

    /**
     * Devuelve el Rectangle2D de enmarcado que define la forma general de este
     * objeto.
     *
     * @return Devuelve un rectangle2D
     */
    public Rectangle2D getFrame() {
        return this.geometria.getFrame();
    }

    /**
     * Método encargado de establecer la localización del rectángulo
     *
     * @param punto - Esquina opuesta
     */
    @Override
    public void setGeometry(Point2D punto) {
        this.p2 = punto;
        this.setFrameFromDiagonal(this.p1, punto);
    }

    /**
     * Método encargado de devolver el punto de inicio de la forma
     *
     * @return Devuelve el punto de comienzo de la forma
     */
    @Override
    public Point2D getP1() {
        return new Point2D.Double(this.geometria.getMinX(), this.geometria.getMinY());
    }

    /**
     * Método encargado de devolver el punto final de la forma
     *
     * @return Devuelve el punto máximo de la forma
     */
    @Override
    public Point2D getP2() {
        return new Point2D.Double(this.geometria.getMaxX(), this.geometria.getMaxY());
    }

    /**
     * Método encargado de devolver el ancho y el alto
     *
     * @return Devuelve el punto con el ancho y el alto de la forma
     */
    public Point2D getAnchoAlto() {
        return new Point2D.Double(this.geometria.getWidth(), this.geometria.getHeight());
    }

    /**
     * Sitúa un rectángulo redondeado en lso puntos indicado
     *
     * @param p1 - Punto de origen
     * @param p2 - Ancho y alto
     * @param arc - Circunferencia de las esquinas
     */
    public void setRoundRect(Point2D p1, Point2D p2, Point2D arc) {
        this.geometria.setRoundRect(this.p1.getX(), this.p1.getY(), this.p2.getX(), this.p2.getY(), this.arc.getX(), this.arc.getY());
    }

}
