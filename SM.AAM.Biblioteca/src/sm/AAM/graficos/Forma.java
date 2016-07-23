/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antonio
 */
public abstract class Forma implements Shape {

    Shape geometria;
    private List<Atributo> atributos = new ArrayList();

    /**
     * Método encargado de establecer la posición de la forma
     *
     * @param pos - Nueva posición a la que mover la forma
     */
    public abstract void setLocation(Point2D pos);

    /**
     * Método encargado de devolver el punto de inicio de la forma
     *
     * @return Devuelve el punto de comienzo de la forma
     */
    public abstract Point2D getP1();

    /**
     * Método encargado de devolver el punto final de la forma
     *
     * @return Devuelve el punto final de la forma
     */
    public abstract Point2D getP2();

    /**
     * Método encargado de establecer la localización del rectángulo
     *
     * @param punto - Esquina opuesta
     */
    public abstract void setGeometry(Point2D punto);

    /**
     * Método encargado de devolver la lista de atributos
     *
     * @return Devuelve la lista de atributos
     */
    public List<Atributo> getAtributos() {
        return atributos;
    }

    /**
     * Método encargado de añadir un atributo a la lista de atributos,
     * Comprobamos que la clase del atributo no este repetido, en caso de que
     * este repetido, se borrará el antiguo y se añadirá el nuevo.
     *
     * @param atributo - atributo que se desea añadir a la lsita de atributos.
     */
    public void setAtributo(Atributo atributo) {
        if (!this.atributos.equals(atributo)) {
            Atributo borrar = null;
            for (Atributo s : atributos) {
                if (s.getClaseAtributo() == atributo.getClaseAtributo()) {
                    borrar = s;
                }
            }
            if (borrar != null) {
                this.removeAtributo(borrar);
            }
            if (atributo instanceof Borde) {
                atributo = new Borde((Borde) atributo);
            } else if (atributo instanceof Relleno) {
                if (atributo instanceof RellenoSimple) {
                    atributo = new RellenoSimple((RellenoSimple) atributo);
                } else if (atributo instanceof RellenoDegradado) {
                    atributo = new RellenoDegradado((RellenoDegradado) atributo);
                } else if (atributo instanceof RellenoRadial) {
                    atributo = new RellenoRadial((RellenoRadial) atributo);
                }
            }
            atributos.add(atributo);
        }
    }

    /**
     * Método encargado de añadir una lista de atributos nueva, borrando los
     * atributos que hubiera antes
     *
     * @param atributos - Lista nueva de atributos.
     */
    public void setAtributo(List<Atributo> atributos) {
        if (!this.atributos.equals(atributos)) {
            this.atributos.clear();
            for (Atributo s : atributos) {
                if (s instanceof Borde) {
                    s = new Borde((Borde) s);
                } else if (s instanceof Relleno) {
                    if (s instanceof RellenoSimple) {
                        s = new RellenoSimple((RellenoSimple) s);
                    } else if (s instanceof RellenoDegradado) {
                        s = new RellenoDegradado((RellenoDegradado) s);
                    } else if (s instanceof RellenoRadial) {
                        s = new RellenoRadial((RellenoRadial) s);
                    }
                }
                this.atributos.add(s);
            }
        }
    }

    /**
     * Método encargado de borrar un atributo de la lista de atributos
     *
     * @param atributo - Atributo que deseas borrar
     */
    public void removeAtributo(Atributo atributo) {
        atributos.remove(atributo);
    }

    /**
     * Método encargado de dibujar la forma
     *
     * @param g2d - Graphics de la forma
     */
    public void draw(Graphics2D g2d) {
        for (Atributo atr : atributos) {
            atr.aplicar(g2d);
            if (atr instanceof Borde) {
                g2d.draw(geometria);
            } else {
                g2d.fill(geometria);
            }
        }

    }

}
