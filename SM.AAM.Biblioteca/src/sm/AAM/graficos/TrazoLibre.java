/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase define un objeto de tipo TrazoLibre
 *
 * @author Antonio
 */
public class TrazoLibre extends Forma {

    private List<Point2D> linea;

    /**
     * Crea un objeto de tipo TrazoLibre
     */
    public TrazoLibre() {
        this.linea = new ArrayList();
    }

    /**
     * Crea un objeto de tipo TrazoLibre
     *
     * @param punto - Punto de comienzo del trazo
     */
    public TrazoLibre(Point2D punto) {
        this.linea = new ArrayList();
        this.linea.add(punto);
    }

    /**
     * Crea un objeto de tipo TrazoLibre
     *
     * @param punto - Punto de comienzo del trazo
     * @param atributo - Atributo que se desea asignar a la forma
     */
    public TrazoLibre(Point2D punto, Atributo atributo) {
        this.linea = new ArrayList();
        this.linea.add(punto);
    }

    /**
     * Método encargado de añadir puntos al trazo
     *
     * @param punto - Punto del trazo
     */
    public void addPunto(Point2D punto) {
        this.linea.add(punto);
    }

    /**
     * Método encargado de establecer la localización del trazo
     *
     * @param punto - Último punto del trazo
     */

    public void setGeometry(Point2D punto) {
        this.addPunto(punto);

    }

    /**
     *
     * @param g2d
     */
    public void draw(Graphics2D g2d) {
        for (Atributo atr : super.getAtributos()) {
            atr.aplicar(g2d);
        }
        for (int i = 0; i < linea.size(); i++) {
            if (i == 0) {
                g2d.draw(new Line2D.Double(linea.get(i).getX(), linea.get(i).getY(), linea.get(i).getX(), linea.get(i).getY()));
            }
            if (i > 0) {
                g2d.draw(new Line2D.Double(linea.get(i).getX(), linea.get(i).getY(), linea.get(i - 1).getX(), linea.get(i - 1).getY()));
            }
        }
    }

    /**
     * Método no implementado
     *
     * @param pos
     */
    @Override
    public void setLocation(Point2D pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     */
    @Override
    public Point2D getP1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     */
    @Override
    public Point2D getP2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     */
    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     */
    @Override
    public Rectangle2D getBounds2D() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public boolean contains(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param p
     * @return
     */
    @Override
    public boolean contains(Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @return
     */
    @Override
    public boolean intersects(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param r
     * @return
     */
    @Override
    public boolean intersects(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @return
     */
    @Override
    public boolean contains(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param r
     * @return
     */
    @Override
    public boolean contains(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método no implementado
     *
     * @param at
     * @return
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param at
     * @param flatness
     * @return
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
