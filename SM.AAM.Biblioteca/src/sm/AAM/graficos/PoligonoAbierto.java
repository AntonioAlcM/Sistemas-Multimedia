/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase define un objeto de tipo PoligonoAbierto
 *
 * @author Antonio
 */
public class PoligonoAbierto extends Forma {

    private Polygon geometria;

    /**
     * Crea un objeto de tipo poligono
     */
    public PoligonoAbierto() {
        geometria = new Polygon();
    }

    /**
     * Crea un objeto de tipo poligono, pasandole como parámetro un punto
     *
     * @param punto - Primer punto del polígono
     */
    public PoligonoAbierto(Point2D punto) {
        int[] coordenadasX = {(int) punto.getX()};
        int[] coordenadasY = {(int) punto.getY()};
        geometria = new Polygon(coordenadasX, coordenadasY, coordenadasX.length);
        super.geometria = geometria;
    }

    /**
     * Crea un objeto de tipo poligono, pasandole como parámetro un array de
     * puntos
     *
     * @param puntos - Array de puntos
     */
    public PoligonoAbierto(Point2D[] puntos) {
        int[] coordenadasX = new int[puntos.length];
        int[] coordenadasY = new int[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            coordenadasX[i] = (int) puntos[i].getX();
            coordenadasY[i] = (int) puntos[i].getY();
        }
        geometria = new Polygon(coordenadasX, coordenadasY, puntos.length);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo poligono, pasandole como parámetro un punto y un
     * borde
     *
     * @param punto - Primer punto del polígono
     * @param borde - Borde que se desea asignar a la forma
     */
    public PoligonoAbierto(Point2D punto, Borde borde) {
        this.setAtributo(borde);
        geometria = new Polygon();
        geometria.addPoint((int) punto.getX(), (int) punto.getY());
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo poligono, pasandole como parámetro un punto y un
     * array de atributos
     *
     * @param punto - Primer punto del polígono
     * @param atributos - Atributos que se desea asignar a la forma
     */
    public PoligonoAbierto(Point2D punto, List<Atributo> atributos) {
        this.setAtributo(atributos);
        geometria = new Polygon();
        geometria.addPoint((int) punto.getX(), (int) punto.getY());
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo poligono, pasandole como parámetro un array de
     * puntos y un borde
     *
     * @param puntos - Array de puntos
     * @param borde - Borde que se desea asignar a la forma
     */
    public PoligonoAbierto(Point2D[] puntos, Borde borde) {
        this.setAtributo(borde);
        int[] coordenadasX = new int[puntos.length];
        int[] coordenadasY = new int[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            coordenadasX[i] = (int) puntos[i].getX();
            coordenadasY[i] = (int) puntos[i].getY();
        }
        geometria = new Polygon(coordenadasX, coordenadasY, puntos.length);
        super.geometria = this.geometria;
    }

    /**
     * Crea un objeto de tipo poligono, pasandole como parámetro un array de
     * puntos y un array de atributos
     *
     * @param puntos - Array de puntos
     * @param atributos - Atributos que se desea asignar a la forma
     */
    public PoligonoAbierto(Point2D[] puntos, List<Atributo> atributos) {
        this.setAtributo(atributos);
        int[] coordenadasX = new int[puntos.length];
        int[] coordenadasY = new int[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            coordenadasX[i] = (int) puntos[i].getX();
            coordenadasY[i] = (int) puntos[i].getY();
        }
        geometria = new Polygon(coordenadasX, coordenadasY, puntos.length);
        super.geometria = this.geometria;
    }

    /**
     * Método encargado de establecer la posición de la forma
     *
     * @param pos - Nueva posición a la que mover la forma
     */
    @Override
    public void setLocation(Point2D pos) {
        double dx = pos.getX() - this.getP1().getX();
        double dy = pos.getY() - this.getP1().getY();
        Point2D.Double newp2 = new Point2D.Double(dx, dy);
        this.translate(newp2);
        List<Atributo> atributos = super.getAtributos();
        for (int i = 0; i < atributos.size(); i++) {
            if (atributos.get(i) instanceof Relleno) {
                if (atributos.get(i) instanceof RellenoDegradado) {
                    ((RellenoDegradado) atributos.get(i)).setPuntosDegradado(new Point2D.Double(this.geometria.getBounds().getX(), this.geometria.getBounds().getY()), new Point2D.Double(this.geometria.getBounds().getMaxX(), this.geometria.getBounds().getMaxY()));
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
     * Método encargado de añadir puntos al polígono
     *
     * @param p - Punto que va a ser añadido al polígono
     */
    public void addPoint(Point2D p) {
        int x = (int) p.getX();
        int y = (int) p.getY();
        this.geometria.addPoint(x, y);
    }

    /**
     * Invalida o elimina cualquier dato almacenado en caché internamente que
     * depende del vértice coordenadas de este polígono.
     */
    public void invalidate() {
        this.invalidate();
    }

    /**
     * Traslada los vértices del polígono al punto pasado como parámetro.
     *
     * @param p - Punto donde se trasladará el polígono
     */
    public void translate(Point2D p) {
        this.geometria.translate((int) p.getX(), (int) p.getY());
    }

    /**
     * Reinicia el polígono a un polígono vacío
     */
    public void reset() {
        this.geometria.reset();
    }

    /**
     * Método encargado de establecer la localización del polígono
     *
     * @param punto - Punto final del trazo
     */
    @Override
    public void setGeometry(Point2D punto) {
        this.addPoint(punto);

    }

    /**
     * Método encargado de devolver el punto de inicio de la forma
     *
     * @return Devuelve el punto de comienzo de la forma
     */
    @Override
    public Point2D getP1() {
        Point2D p1 = new Point2D.Double(this.geometria.getBounds().getMinX(), this.geometria.getBounds().getMinY());
        return p1;
    }

    /**
     * Método encargado de devolver el punto final de la forma
     *
     * @return Devuelve el punto final de la forma
     */
    @Override
    public Point2D getP2() {
        Point2D p2 = new Point2D.Double(this.geometria.getBounds().getMaxX(), this.geometria.getBounds().getMaxY());
        return p2;
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

    /**
     * Método encargado de dibujar la forma
     *
     * @param g2d - Graphics de la forma
     */
    @Override
    public void draw(Graphics2D g2d) {
        for (Atributo atr : super.getAtributos()) {
            atr.aplicar(g2d);
            if (atr instanceof Borde) {
                g2d.drawPolyline(this.geometria.xpoints, this.geometria.ypoints, this.geometria.npoints);
            }
        }
    }
}
