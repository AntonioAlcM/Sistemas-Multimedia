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
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * Esta clase define un objeto de tipo elipse
 *
 * @author Antonio
 */
public class Elipse extends Forma {

    private Ellipse2D geometria;
    Point2D p1;
    Point2D p2;

    /**
     * Crea un objeto de tipo elipse
     */
    public Elipse() {
        this.geometria = new Ellipse2D.Double();
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un ancho, un alto
     * y una esquina
     *
     * @param esquina - Esquina de comienzo de la forma
     * @param ancho - Ancho de la forma
     * @param alto - Alto de la forma
     */
    public Elipse(Point2D esquina, double ancho, double alto) {
        this.geometria = new Ellipse2D.Double(esquina.getX(), esquina.getY(), ancho, alto);
        this.p1 = esquina;
        this.p2 = new Point2D.Double(ancho, alto);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un ancho, un
     * alto, una esquina y un relleno
     *
     * @param esquina - Esquina de comienzo de la forma
     * @param ancho - Ancho de la forma
     * @param alto - Alto de la forma
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public Elipse(Point2D esquina, double ancho, double alto, Relleno relleno) {
        this.geometria = new Ellipse2D.Double(esquina.getX(), esquina.getY(), ancho, alto);
        this.p1 = esquina;
        this.p2 = new Point2D.Double(ancho, alto);
        this.setAtributo(relleno);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un ancho, un
     * alto, una esquina y un borde
     *
     * @param esquina - Esquina de comienzo de la forma
     * @param ancho - Ancho de la forma
     * @param alto - Alto de la forma
     * @param borde - Borde que se desea asignar a la forma
     */
    public Elipse(Point2D esquina, double ancho, double alto, Borde borde) {
        this.geometria = new Ellipse2D.Double(esquina.getX(), esquina.getY(), ancho, alto);
        this.p1 = esquina;
        this.p2 = new Point2D.Double(ancho, alto);
        this.setAtributo(borde);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un ancho, un
     * alto, una esquina, un borde y un relleno
     *
     * @param esquina - Esquina de comienzo de la forma
     * @param ancho - Ancho de la forma
     * @param alto - Alto de la forma
     * @param borde - Borde que se desea asignar a la forma
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public Elipse(Point2D esquina, double ancho, double alto, Borde borde, Relleno relleno) {
        this.geometria = new Ellipse2D.Double(esquina.getX(), esquina.getY(), ancho, alto);
        this.p1 = esquina;
        this.p2 = new Point2D.Double(ancho, alto);
        this.setAtributo(borde);
        this.setAtributo(relleno);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un ancho, un
     * alto, una esquina y un array de atributos
     *
     * @param esquina - Esquina de comienzo de la forma
     * @param ancho - Ancho de la forma
     * @param alto - Alto de la forma
     * @param atributos - Atributos que se desea asignar a la forma
     */
    public Elipse(Point2D esquina, double ancho, double alto, List<Atributo> atributos) {
        this.geometria = new Ellipse2D.Double(esquina.getX(), esquina.getY(), ancho, alto);
        this.p1 = esquina;
        this.p2 = new Point2D.Double(ancho, alto);
        this.setAtributo(atributos);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un punto de
     * comienzo y la esquina opuesta
     *
     * @param primerPunto - Esquina de comienzo de la forma
     * @param esquina - Esquina opuesta a la del comienzo
     */
    public Elipse(Point2D primerPunto, Point2D esquina) {
        this.geometria = new Ellipse2D.Double(primerPunto.getX(), primerPunto.getY(), esquina.getX(), esquina.getY());
        this.p1 = primerPunto;
        this.p2 = esquina;
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un punto de
     * comienzo, la esquina opuesta y un borde
     *
     * @param primerPunto - Esquina de comienzo de la forma
     * @param esquina - Esquina opuesta a la del comienzo
     * @param borde - Borde que se desea asignar a la forma
     */
    public Elipse(Point2D primerPunto, Point2D esquina, Borde borde) {

        this.geometria = new Ellipse2D.Double(primerPunto.getX(), primerPunto.getY(), esquina.getX(), esquina.getY());
        this.p1 = primerPunto;
        this.p2 = esquina;
        this.setAtributo(borde);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un punto de
     * comienzo, la esquina opuesta y un relleno
     *
     * @param primerPunto - Esquina de comienzo de la forma
     * @param esquina - Esquina opuesta a la del comienzo
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public Elipse(Point2D primerPunto, Point2D esquina, Relleno relleno) {

        this.geometria = new Ellipse2D.Double(primerPunto.getX(), primerPunto.getY(), esquina.getX(), esquina.getY());
        this.p1 = primerPunto;
        this.p2 = esquina;
        this.setAtributo(relleno);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un punto de
     * comienzo, la esquina opuesta, un borde y un relleno
     *
     * @param primerPunto - Esquina de comienzo de la forma
     * @param esquina - Esquina opuesta a la del comienzo
     * @param relleno - Relleno que se desea asignar a la forma
     * @param borde - Borde que se desea asignar a la forma
     */
    public Elipse(Point2D primerPunto, Point2D esquina, Borde borde, Relleno relleno) {

        this.geometria = new Ellipse2D.Double(primerPunto.getX(), primerPunto.getY(), esquina.getX(), esquina.getY());
        this.p1 = primerPunto;
        this.p2 = esquina;
        this.setAtributo(borde);
        this.setAtributo(relleno);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo elipse, pasandole como parámetro un punto de
     * comienzo, la esquina opuesta y un array de atributos
     *
     * @param primerPunto - Esquina de comienzo de la forma
     * @param esquina - Esquina opuesta a la del comienzo
     * @param atributos - Atributo que se desea asignar a la forma
     */
    public Elipse(Point2D primerPunto, Point2D esquina, List<Atributo> atributos) {

        this.geometria = new Ellipse2D.Double(primerPunto.getX(), primerPunto.getY(), esquina.getX(), esquina.getY());
        this.p1 = primerPunto;
        this.p2 = esquina;
        this.setAtributo(atributos);
        super.geometria = this.geometria;
    }

    /**
     * Método encargado de establecer la posición de la forma
     *
     * @param pos - Nueva posición a la que mover la forma
     */
    @Override
    public void setLocation(Point2D pos) {
        this.geometria.setFrame(pos, new Dimension((int) this.geometria.getWidth(), (int) this.geometria.getHeight()));
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
     * Método encargado de devolver el punto de inicio de la forma
     *
     * @return Devuelve el punto de comienzo de la forma
     */
    public Point2D getP1() {
        return new Point2D.Double(this.geometria.getX(), this.geometria.getY());
    }

    /**
     * Método encargado de devolver el punto final de la forma
     *
     * @return Devuelve el punto final de la forma
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
     * Método encargado de establecer la localización de la elipse
     *
     * @param punto - Esquina opuesta
     */
    @Override
    public void setGeometry(Point2D punto) {
        this.setFrameFromDiagonal(this.p1, punto);
    }

}
