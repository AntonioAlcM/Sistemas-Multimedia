/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Point2D;

/**
 * Esta clase define un objeto de tipo degradado
 *
 * @author Antonio
 */
public class RellenoDegradado extends Relleno {

    private GradientPaint relleno;
    private Point2D pc1;
    private Point2D pc2;
    private Color color1;
    private Color color2;
    private Boolean ciclico = false;

    /**
     * Crea un objeto de tipo degradado, pasandole como parámetro una forma, un
     * punto de inicio, un punto de fin, un primer color y un segundo color.
     *
     * @param pc1 - Punto de inicio
     * @param color1 - Color inicial del degradado
     * @param pc2 - Punto de fin
     * @param color2 - Color final del degradado
     */
    public RellenoDegradado(Point2D pc1, Color color1, Point2D pc2, Color color2) {
        this.pc1 = pc1;
        this.pc2 = pc2;
        this.color1 = color1;
        this.color2 = color2;
        relleno = new GradientPaint(pc1, color1, pc2, color2);
        super.relleno = this.relleno;
    }

    /**
     * Crea un objeto de tipo degradado, pasandole como parámetro una forma, un
     * punto de inicio, un punto de fin, un primer color y un segundo color.
     *
     * @param pc1 - Punto de inicio
     * @param color1 - Color inicial del degradado
     * @param pc2 - Punto de fin
     * @param color2 - Color final del degradado
     * @param ciclico - Establece si quieres que el degradado sea cíclico
     */
    public RellenoDegradado(Point2D pc1, Color color1, Point2D pc2, Color color2, boolean ciclico) {
        this.pc1 = pc1;
        this.pc2 = pc2;
        this.color1 = color1;
        this.color2 = color2;
        this.ciclico = ciclico;
        relleno = new GradientPaint(pc1, color1, pc2, color2, ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Contructor de copia
     *
     * @param rellenoDegradado - Relleno que va a ser copiado
     */
    public RellenoDegradado(RellenoDegradado rellenoDegradado) {
        this.pc1 = rellenoDegradado.pc1;
        this.pc2 = rellenoDegradado.pc2;
        this.color1 = rellenoDegradado.color1;
        this.color2 = rellenoDegradado.color2;
        this.ciclico = rellenoDegradado.ciclico;
        relleno = new GradientPaint(pc1, color1, pc2, color2, ciclico);
        super.relleno = this.relleno;
        super.setRenderizacion(rellenoDegradado.getRenderizacion());
        super.setTransparencia(rellenoDegradado.getTransparencia());
    }

    /**
     * Método que establece los colores del degradado
     *
     * @param color1 - Primer color del degradado
     * @param color2 - Segundo color del degradado
     */
    public void setColorDegradado(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
        relleno = new GradientPaint(pc1, color1, pc2, color2, ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Método que establece el primer color del degradado
     *
     * @param color1 - Primer color del degradado
     */
    public void setPrimerColorDegradado(Color color1) {
        this.color1 = color1;
        relleno = new GradientPaint(pc1, color1, pc2, color2, this.ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Método que establece el segundo color del degradado
     *
     * @param color2 - Segundo color del degradado
     */
    public void setSegundoColorDegradado(Color color2) {
        this.color2 = color2;
        relleno = new GradientPaint(pc1, this.color1, pc2, color2, this.ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Método que establece los puntos del degradado, según el tipo de degradado
     * modificará los puntos
     *
     * @param pc1 - Primer punto del degradado
     * @param pc2 - Segundo punto del degradado
     */
    public void setPuntosDegradado(Point2D pc1, Point2D pc2) {
        if (this.pc2.getX() == 0) {
            if (ciclico != true) {
                this.pc1 = new Point2D.Double(0, pc1.getY());
                this.pc2 = new Point2D.Double(0, pc2.getY());
            }
        } else if (this.pc2.getY() == 0) {
            if (ciclico != true) {
                this.pc1 = new Point2D.Double(pc1.getX(), 0);
                this.pc2 = new Point2D.Double(pc2.getX(), 0);
            }
        } else {
            double xFinal = Math.abs(figura.getP2().getX() - figura.getP1().getX());
            double yFinal = Math.abs(figura.getP2().getY() - figura.getP1().getY());
            double distancia = Math.sqrt(Math.pow(xFinal, 2) + Math.pow(yFinal, 2));
            this.pc1 = new Point2D.Double(figura.getP1().getX(), figura.getP1().getY());
            this.pc2 = new Point2D.Double(figura.getP1().getX() + distancia / 2, figura.getP1().getY() + distancia / 2);
        }
        relleno = new GradientPaint(this.pc1, this.color1, this.pc2, color2, this.ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Método que establece el primer punto del degradado
     *
     * @param pc1 - Primer punto del degradado
     */
    public void setPrimerPuntoDegradado(Point2D pc1) {
        if (this.pc2.getX() == 0) {
            if (ciclico != true) {
                this.pc1 = new Point2D.Double(0, pc1.getY());
            }

        } else if (this.pc2.getY() == 0) {
            if (ciclico != true) {
                this.pc1 = new Point2D.Double(pc1.getX(), 0);
            }
        } else {
            double xFinal = Math.abs(figura.getP2().getX() - figura.getP1().getX());
            this.pc1 = new Point2D.Double(figura.getP1().getX(), figura.getP1().getY());
        }
        relleno = new GradientPaint(this.pc1, this.color1, this.pc2, color2, this.ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Método que establece el segundo punto del degradado
     *
     * @param pc2 - Segundo punto del degradado
     */
    public void setSegundoPuntoDegradado(Point2D pc2) {
        if (this.pc2.getX() == 0) {
            if (ciclico != true) {
                this.pc2 = new Point2D.Double(0, pc2.getY());
            }

        } else if (this.pc2.getY() == 0) {
            if (ciclico != true) {
                this.pc2 = new Point2D.Double(pc2.getX(), 0);
            }
        } else {
            double xFinal = Math.abs(figura.getP2().getX() - figura.getP1().getX());
            double yFinal = Math.abs(figura.getP2().getY() - figura.getP1().getY());
            double distancia = Math.sqrt(Math.pow(xFinal, 2) + Math.pow(yFinal, 2));
            this.pc2 = new Point2D.Double(figura.getP1().getX() + distancia / 2, figura.getP1().getY() + distancia / 2);
        }
        relleno = new GradientPaint(this.pc1, this.color1, this.pc2, color2, this.ciclico);
        super.relleno = this.relleno;
    }

    /**
     * Método que devuelve el primer punto del degradado
     *
     * @return - Devuelve el primer punto del degradado
     */
    public Point2D getPrimerPuntoDegradado() {
        return this.pc1;
    }

    /**
     * Método que devuelve el segundo punto del degradado
     *
     * @return - Devuelve el segundo punto del degradado
     */
    public Point2D getSegundoPuntoDegradado() {
        return this.pc2;
    }

    /**
     * Método que devuelve el primer color del degradado
     *
     * @return - Devuelve el primer color del degradado
     */
    public Color getPrimerColorDegradado() {
        return this.color1;
    }

    /**
     * Método que devuelve el segundo color del degradado
     *
     * @return - Devuelve el segundo color del degradado
     */
    public Color getSegundoColorDegradado() {
        return this.color2;
    }

    /**
     * Devuelve si el relleno es ciclico
     *
     * @return - Devuelve un true si es ciclcico y false si no.
     */
    public boolean esCiclico() {
        return this.relleno.isCyclic();
    }

}
