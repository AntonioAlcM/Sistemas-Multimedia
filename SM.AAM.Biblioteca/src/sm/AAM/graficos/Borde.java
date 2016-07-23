/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.graficos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

/**
 * Esta clase define un objeto de tipo borde
 *
 * @author Antonio
 */
public class Borde extends Atributo {

    private Stroke trazo;
    private float grosor;
    private int estiloFinalLinea;
    private int estiloUnionLineas;
    private float corte;
    private float[] patronDiscontinuidad;
    private float comienzoDiscontinuidad;
    private Color color;

    /**
     * Crea un objeto de tipo borde
     */
    public Borde() {

        this.trazo = new BasicStroke();

    }

    /**
     * Crea un objeto de tipo borde, pasándole como parámetro un grosor.
     *
     * @param grosor - Le pasa un tamaño para el borde
     */
    public Borde(float grosor) {
        this.grosor = grosor;
        this.trazo = new BasicStroke(grosor);
        this.estiloFinalLinea = ((BasicStroke) trazo).getEndCap();
        this.estiloUnionLineas = ((BasicStroke) trazo).getLineJoin();
        this.corte = ((BasicStroke) trazo).getMiterLimit();
        this.patronDiscontinuidad = ((BasicStroke) trazo).getDashArray();
        this.comienzoDiscontinuidad = ((BasicStroke) trazo).getDashPhase();
    }

    /**
     * Crea un objeto de tipo borde, pasándole como parámetro un grosor y un
     * esilo de final de línea.
     *
     * @param grosor - Le pasa un tamaño para el borde
     * @param estiloFinalLinea - Le pasa un estilo de final de línea
     */
    public Borde(float grosor, int estiloFinalLinea) {
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, BasicStroke.JOIN_BEVEL);
        this.grosor = grosor;
        this.estiloFinalLinea = estiloFinalLinea;
        this.estiloUnionLineas = ((BasicStroke) trazo).getLineJoin();
        this.corte = ((BasicStroke) trazo).getMiterLimit();
        this.patronDiscontinuidad = ((BasicStroke) trazo).getDashArray();
        this.comienzoDiscontinuidad = ((BasicStroke) trazo).getDashPhase();

    }

    /**
     * Crea un objeto de tipo borde, pasándole como parámetro un grosor, un
     * esilo de final de línea y un estilo de unión de líneas.
     *
     * @param grosor - Le pasa un tamaño para el borde
     * @param estiloFinalLinea - Le pasa un estilo de final de línea
     * @param estiloUnionLineas - Le pasa un estilo de unión de líneas
     */
    public Borde(float grosor, int estiloFinalLinea, int estiloUnionLineas) {
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas);
        this.grosor = grosor;
        this.estiloFinalLinea = estiloFinalLinea;
        this.estiloUnionLineas = estiloUnionLineas;
        this.corte = ((BasicStroke) trazo).getMiterLimit();
        this.patronDiscontinuidad = ((BasicStroke) trazo).getDashArray();
        this.comienzoDiscontinuidad = ((BasicStroke) trazo).getDashPhase();

    }

    /**
     * Crea un objeto de tipo borde, pasándole como parámetro un grosor, un
     * esilo de final de línea, un estilo de unión de líneas, corte y patrón de
     * discontinuidad.
     *
     * @param grosor - Le pasa un tamaño para el borde
     * @param estiloFinalLinea - Le pasa un estilo de final de línea
     * @param estiloUnionLineas - Le pasa un estilo de unión de líneas
     * @param corte - Le pasamos una posición de corte
     * @param patronDiscontinuidad - Le pasamos un vector con la discontinuidad
     * de la línea
     */
    public Borde(float grosor, int estiloFinalLinea, int estiloUnionLineas, float corte, float[] patronDiscontinuidad) {
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, 0.0f);
        this.grosor = grosor;
        this.estiloFinalLinea = estiloFinalLinea;
        this.estiloUnionLineas = estiloUnionLineas;
        this.corte = corte;
        this.patronDiscontinuidad = patronDiscontinuidad;
        this.comienzoDiscontinuidad = ((BasicStroke) trazo).getDashPhase();

    }

    /**
     * Crea un objeto de tipo borde, pasándole como parámetro un grosor, un
     * esilo de final de línea, un estilo de unión de líneas y patrón de
     * discontinuidad.
     *
     * @param grosor - Le pasa un tamaño para el borde
     * @param estiloFinalLinea - Le pasa un estilo de final de línea
     * @param estiloUnionLineas - Le pasa un estilo de unión de líneas
     * @param patronDiscontinuidad - Le pasamos un vector con la discontinuidad
     * de la línea
     */
    public Borde(float grosor, int estiloFinalLinea, int estiloUnionLineas, float[] patronDiscontinuidad) {
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, 1.0f, patronDiscontinuidad, 0.0f);
        this.grosor = grosor;
        this.estiloFinalLinea = estiloFinalLinea;
        this.estiloUnionLineas = estiloUnionLineas;
        this.corte = ((BasicStroke) trazo).getMiterLimit();
        this.patronDiscontinuidad = patronDiscontinuidad;
        this.comienzoDiscontinuidad = ((BasicStroke) trazo).getDashPhase();

    }

    /**
     * Crea un objeto de tipo borde, pasándole como parámetro un grosor, un
     * esilo de final de línea, un estilo de unión de líneas, corte, patrón de
     * discontinuidad y comienzo de la discontinuidad.
     *
     * @param grosor - Le pasa un tamaño para el borde
     * @param estiloFinalLinea - Le pasa un estilo de final de línea
     * @param estiloUnionLineas - Le pasa un estilo de unión de líneas
     * @param corte - Le pasamos una posición de corte
     * @param patronDiscontinuidad - Le pasamos un vector con la discontinuidad
     * de la línea
     * @param comienzoDiscontinuidad - Le pasamos un valor de comienzo de la
     * discontinuidad
     */
    public Borde(float grosor, int estiloFinalLinea, int estiloUnionLineas, float corte, float[] patronDiscontinuidad, float comienzoDiscontinuidad) {
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);
        this.grosor = grosor;
        this.estiloFinalLinea = estiloFinalLinea;
        this.estiloUnionLineas = estiloUnionLineas;
        this.corte = corte;
        this.patronDiscontinuidad = patronDiscontinuidad;
        this.comienzoDiscontinuidad = comienzoDiscontinuidad;

    }

    public Borde(Borde borde) {
        this.trazo = new BasicStroke(borde.grosor, borde.estiloFinalLinea, borde.estiloUnionLineas, borde.corte, borde.patronDiscontinuidad, borde.comienzoDiscontinuidad);
        super.setRenderizacion(borde.getRenderizacion());
        super.setTransparencia(borde.getTransparencia());
    }

    /**
     * Método encargado de establecer un grosor determinado
     *
     * @param grosor - Le pasa un tamaño para el borde
     */
    public void setGrosor(float grosor) {
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);
    }

    /**
     * Método encargado de establecer un estilo final de la línea
     *
     * @param estiloFinalLinea - Le pasa un estilo de final de línea
     */
    public void setEstiloFinalLinea(int estiloFinalLinea) {
        this.estiloFinalLinea = estiloFinalLinea;
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);

    }

    /**
     * Método encargado de establecer un estilo de unión de líneas
     *
     * @param estiloUnionLineas - Le pasa un estilo de unión de líneas
     */
    public void setEstiloUnionLineas(int estiloUnionLineas) {
        this.estiloUnionLineas = estiloUnionLineas;
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);
    }

    /**
     * Método encargado de establecer la posición del corte de las líneas
     *
     * @param corte - Le pasamos una posición de corte
     */
    public void setCorte(float corte) {
        this.corte = corte;
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);
    }

    /**
     * Método encargado de establecer el patrón de discontinuidad
     *
     * @param patronDiscontinuidad - Le pasamos un vector con la discontinuidad
     * de la línea
     */
    public void setPatronDiscontinuidad(float[] patronDiscontinuidad) {
        this.patronDiscontinuidad = patronDiscontinuidad;
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);
    }

    /**
     * Método encargado de establecer el comienzo de la discontinuidad
     *
     * @param comienzoDiscontinuidad - Le pasamos un valor de comienzo de la
     * discontinuidad
     */
    public void setComienzoDiscontinuidad(float comienzoDiscontinuidad) {
        this.comienzoDiscontinuidad = comienzoDiscontinuidad;
        this.trazo = new BasicStroke(grosor, estiloFinalLinea, estiloUnionLineas, corte, patronDiscontinuidad, comienzoDiscontinuidad);
    }

    /**
     * Método encargado de devolver el valor del grosor
     *
     * @return - Devuelve un float con el grosor
     */
    public float getGrosor() {
        return this.grosor;
    }

    /**
     * Devuelve el estilo final del borde
     *
     * @return - Devuelve un int con el estilo
     */
    public int getEstiloFinalLinea() {
        return this.estiloFinalLinea;
    }

    /**
     * Devuelve el estilo de unión del borde
     *
     * @return - Devuelve un int con el estilo
     */
    public int getEstiloUnionLineas() {
        return this.estiloUnionLineas;

    }

    /**
     * Devuelve el estilo tamaño del corte
     *
     * @return - Devuelve un float con el tamaño del corte
     */
    public float getCorte() {
        return this.corte;
    }

    /**
     * Devuelve el patrón de discontinuidad
     *
     * @return - Devuelve un array de float con el patrón de discontinuidad
     */
    public float[] getPatronDiscontinuidad() {
        return this.patronDiscontinuidad;
    }

    /**
     * Devuelve el punto de comienzo de la discontinuidad
     *
     * @return - Devuelve un float con el comienzo de la discontinuidad
     */
    public float getComienzoDiscontinuidad() {
        return this.comienzoDiscontinuidad;
    }

    /**
     * Método que aplica los graphics de la imagen
     *
     * @param g2d - Graphics de la imagen
     */
    public void aplicar(Graphics2D g2d) {
        g2d.setColor(this.color);
        if (super.getTransparencia() != null) {
            g2d.setComposite(super.getTransparencia());
        }
        if (super.getRenderizacion() != null) {
            g2d.setRenderingHints(super.getRenderizacion());
        }
        g2d.setStroke(trazo);
    }

    /**
     * Método que devuelve la clase del objeto
     *
     * @return - Devuelve Borde como clase
     */
    @Override
    public Object getClaseAtributo() {
        return Borde.class;
    }

    /**
     * Devuelve el color
     *
     * @return - Devuelve el color asociado al atributo
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Establece un color
     *
     * @param color - Establece el color asociado al atributo
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
