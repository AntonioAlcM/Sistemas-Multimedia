/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImagePixelIterator;

/**
 * Clase que implementa una operación inventada por mi.
 *
 * @author Antonio
 */
public class CosraiOp extends sm.image.BufferedImageOpAdapter {

    private double w;

    /**
     * Creas un objeto pasandole una frecuencia como parámetro
     *
     * @param w - Valor de frecuencia
     */
    public CosraiOp(double w) {
        this.w = w;
    }

    /**
     * Este método, aplica a cada componente de un pixel, la siguiente operación
     * matemática A cada componente del pixel le múltiplico una frecuencia(w), a
     * este valor le hago el coseno y al resultado le hago la raíz cuadrada. Por
     * si saliera valores negativos me quedo con el valor absoluto. Obtenido el
     * valor absoluto lo múltiplico por el valor máximo que puede alcanzar la
     * función(k).
     *
     * @param src - Imagen sobre la que se va a trabajar
     * @param dest - Imagen donde se va almacenar la imagen modificada
     * @return Devuelve una imagen con el resultado de la operación
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster destRaster = dest.getRaster();
        BufferedImagePixelIterator.PixelData pixel;
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            double k = 255.0;
            pixel = it.next();
            for (int i = 0; i < pixel.numSamples; i++) {
                pixel.sample[i] = (int) (k * Math.abs(Math.sqrt(Math.cos(w * pixel.sample[i]))));
            }
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        return dest;
    }
}
