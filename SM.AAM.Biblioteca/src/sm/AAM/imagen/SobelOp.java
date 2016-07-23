/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.AAM.imagen;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.WritableRaster;
import sm.image.ImageTools;

/**
 * Clase que implementa la umbralización
 *
 * @author Antonio
 */
public class SobelOp extends sm.image.BufferedImageOpAdapter {

    private int valorX;
    private int valorY;
    private int magnitud;
    private int row;
    private int col;
    private int band;

    /**
     * Método encargado de implementar la función sobel, sobre una imagen.
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
        Kernel kx = sm.image.KernelProducer.createKernel(5);
        ConvolveOp copx = new ConvolveOp(kx, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage imgGradienteX = copx.filter(src, null);
        Kernel ky = sm.image.KernelProducer.createKernel(6);
        ConvolveOp copy = new ConvolveOp(ky, ConvolveOp.EDGE_NO_OP, null);
        BufferedImage imgGradienteY = copy.filter(src, null);

        WritableRaster destRaster = dest.getRaster();
        WritableRaster gradienteX = imgGradienteX.getRaster();
        WritableRaster gradienteY = imgGradienteY.getRaster();
        for (row = 0; row < src.getHeight(); row++) {
            for (col = 0; col < src.getWidth(); col++) {
                valorX = 0;
                valorY = 0;
                for (band = 0; band < src.getRaster().getNumBands(); band++) {
                    valorX += gradienteX.getSample(col, row, band);
                    valorY += gradienteY.getSample(col, row, band);
                }
                magnitud = (int) Math.hypot(valorX, valorY);
                magnitud = ImageTools.clampRange(magnitud, 0, 255);

                for (band = 0; band < src.getRaster().getNumBands(); band++) {
                    destRaster.setSample(col, row, band, magnitud);
                }
            }
        }
        return dest;
    }
}
