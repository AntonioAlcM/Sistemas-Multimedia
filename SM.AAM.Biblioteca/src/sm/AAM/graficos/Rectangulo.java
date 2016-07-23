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
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * Esta clase define un objeto de tipo rectangulo
 *
 * @author Antonio
 */
public class Rectangulo extends Forma {

    private Rectangle2D geometria;
    Point2D p1;
    Point2D p2;
    Atributo atributo;

    /**
     * Crea un objeto de tipo rectangulo
     */
    public Rectangulo() {
        this.geometria = new Rectangle2D.Double();
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo, pasandole como parámetros dos puntos
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     */
    public Rectangulo(Point2D p1, Point2D p2) {
        this.geometria = new Rectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.p1 = p1;
        this.p2 = p2;
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo, pasandole como parámetros dos puntos y
     * un atributo
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param atributo - Atributo que se desea asignar a la forma
     */
    public Rectangulo(Point2D p1, Point2D p2, Atributo atributo) {

        this.geometria = new Rectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.p1 = p1;
        this.p2 = p2;
        this.setAtributo(atributo);
        this.setAtributo(atributo);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo, pasandole como parámetros dos puntos y
     * un borde
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param borde - Borde que se desea asignar a la forma
     */
    public Rectangulo(Point2D p1, Point2D p2, Borde borde) {

        this.geometria = new Rectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.p1 = p1;
        this.p2 = p2;
        this.setAtributo(borde);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo, pasandole como parámetros dos puntos y
     * un relleno
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public Rectangulo(Point2D p1, Point2D p2, Relleno relleno) {

        this.geometria = new Rectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.p1 = p1;
        this.p2 = p2;
        this.setAtributo(relleno);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo, pasandole como parámetros dos puntos,
     * un borde y un atributo
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param borde - Borde que se desea asignar a la forma
     * @param relleno - Relleno que se desea asignar a la forma
     */
    public Rectangulo(Point2D p1, Point2D p2, Borde borde, Relleno relleno) {

        this.geometria = new Rectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.p1 = p1;
        this.p2 = p2;
        this.setAtributo(borde);
        this.setAtributo(relleno);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo rectangulo, pasandole como parámetros dos puntos y
     * un array de atributos
     *
     * @param p1 - Esquina de comienzo de la forma
     * @param p2 - Esquina opuesta
     * @param atributos - Atributos que se desea asignar a la forma
     */
    public Rectangulo(Point2D p1, Point2D p2, List<Atributo> atributos) {

        this.geometria = new Rectangle2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        this.p1 = p1;
        this.p2 = p2;
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
     * Método encargado de devolver el punto central de la forma
     *
     * @return Devuelve el punto de comienzo central de la forma
     */
    public Point2D getCenter() {
        return new Point2D.Double(this.geometria.getCenterX(), this.geometria.getCenterY());
    }

    /**
     * Añade un punto al objeto rectángulo
     *
     * @param pt - Punto que se desea añadir
     */
    public void add(Point2D pt) {
        this.geometria.add(pt);
    }

    /**
     * Añade un rectángulo al objeto rectángulo
     *
     * @param r - Rectángulo que se desea añadir
     */
    public void add(Rectangle2D r) {
        this.geometria.add(r);
    }

    /**
     * Devuelve un nuevo objeto Rectangle2D que representa la intersección de
     * este Rectangle2D con el Rectangle2D especificado.
     *
     * @param r - Rectángulo para la interseción
     * @return - Devuelve un objeto rectangle2D
     */
    public Rectangle2D createIntersection(Rectangle2D r) {
        return this.geometria.createIntersection(r);
    }

    /**
     * Devuelve un nuevo objeto Rectangle2D que representa la unión de este
     * Rectangle2D con el Rectangle2D especificado.
     *
     * @param r - Rectángulo para la unión
     * @return - Devuelve un objeto rectangle2D
     */
    public Rectangle2D createUnion(Rectangle2D r) {
        return this.geometria.createUnion(r);
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
     * Comprueba si el segmento de línea especificado intersectan con el
     * interior de este Rectangle2D.
     *
     * @param l - Línea usada para comprobar la intersección
     * @return - Devuelve true si se intersectan la líneas, si no devuelve false
     */
    public boolean intersectsLine(Line2D l) {
        return this.geometria.intersectsLine(l);
    }

    /**
     * Determina donde el punto especificado se encuentra con respecto a este
     * Rectangle2D.
     *
     * @param p Punto para comprobar la distancia
     * @return Devuelve el valor donde se encuentra el punto
     */
    public int outcode(Point2D p) {
        return this.geometria.outcode(p);
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
     * Establece la ubicación y el tamaño de este Rectangle2D, basandose en los
     * valores especificados.
     *
     * @param p1 Punto de la esquina superior izquierda
     * @param p2 Punto de la esquina opuesta
     */
    public void setRect(Point2D p1, Point2D p2) {
        this.geometria.setRect(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    /**
     * Establece un rectangle igual al que se le pasa como parámetro
     *
     * @param r Rectágulo que sirve de plantilla
     */
    public void setRect(Rectangle r) {
        this.geometria.setRect(r);
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
     * @param punto- Esquina opuesta
     */
    @Override
    public void setGeometry(Point2D punto) {
        this.setFrameFromDiagonal(this.p1, punto);
    }

    /**
     * Método encargado de devolver el punto de inicio de la forma
     *
     * @return Devuelve el punto de comienzo de la forma
     */
    @Override
    public Point2D getP1() {
        return new Point2D.Double(this.geometria.getX(), this.geometria.getY());
    }

    /**
     * Método encargado de devolver el punto máximo de la forma
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

}
