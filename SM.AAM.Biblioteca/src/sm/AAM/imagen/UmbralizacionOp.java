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
 * Clase que implementa la umbralización
 *
 * @author Antonio
 */
public class UmbralizacionOp extends sm.image.BufferedImageOpAdapter {

    private int umbral;

    /**
     * Constructo de la clase umbralización, pasandole como parámetro un valor
     * umbral
     *
     * @param umbral - Valor de umbralización
     */
    public UmbralizacionOp(int umbral) {
        this.umbral = umbral;
    }

    /**
     * Método encargado de implementar la umbralización basada en intensidad.
     * Los píxeles que superan un umbral se le asignará 255 y al resto 0. La
     * intensidad del pixel calculada como la media de sus componentes.
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
            dest = createCompatibleDestImage(src, null);//Aqui para la umbralizacion debes elegir si es una imagen de grises o rgb o etc..
        }
        WritableRaster destRaster = dest.getRaster();
        BufferedImagePixelIterator.PixelData pixel;
        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();) {
            pixel = it.next();
            int media = 0;
            int tope = pixel.numSamples;

            for (int i = 0; i < tope; i++) {
                media += pixel.sample[i];
            }
            media /= pixel.numSamples;
            if (pixel.numSamples == 3) {
                if (media >= this.umbral) {
                    pixel.sample[0] = (int) 255;
                    pixel.sample[1] = (int) 255;
                    pixel.sample[2] = (int) 255;
                } else {
                    pixel.sample[0] = (int) 0;
                    pixel.sample[1] = (int) 0;
                    pixel.sample[2] = (int) 0;
                }
            } else {
                if (media >= this.umbral) {
                    pixel.sample[0] = (int) 255;
                } else {
                    pixel.sample[0] = (int) 0;
                }
            }
            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
        }
        return dest;
    }
}
