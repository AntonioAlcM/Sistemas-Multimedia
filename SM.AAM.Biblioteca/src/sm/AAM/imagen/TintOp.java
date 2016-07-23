/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.imagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageSampleIterator;

/**
 * Clase que implementa el modo sepia de una imagen
 *
 * @author Antonio
 */
public class TintOp extends sm.image.BufferedImageOpAdapter {

    private float alpha;
    private float[] color;

    public TintOp(Color color, float alpha) {
        this.alpha = alpha;
        this.color = color.getColorComponents(null);
        for (int b = 0; b < this.color.length; b++) {
            this.color[b] *= 255;
        }
    }

    /**
     * Método que aplica el modo tintado a una imagen, el modo tintado consiste
     * en pasar un color y el grado de titado que desees aplicar.
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
        for (BufferedImageSampleIterator it = new BufferedImageSampleIterator(src); it.hasNext();) {
            BufferedImageSampleIterator.SampleData sample = it.next();
            sample.value = (int) (alpha * color[sample.band] + (1.0f - alpha) * sample.value);
            destRaster.setSample(sample.col, sample.row, sample.band, sample.value);
        }
        return dest;
    }

}
