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
 * Clase que implementa el modo sepia de una imagen
 *
 * @author Antonio
 */
public class SepiaOp extends sm.image.BufferedImageOpAdapter {

    /**
     * Método que aplica el modo sepia a una imagen, 
     * el  modo sepia consiste en modificar el tono y la saturación 
     * para darle un aspecto de “fotografía antigua”.
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
                
                pixel = it.next();
                if(pixel.numSamples==3){
                double sepiaR = Math.min(255, this.comprobrarValores(0.393, 0.769, 0.189, pixel));
                double sepiaG = Math.min(255, this.comprobrarValores(0.349, 0.686, 0.168, pixel));
                double sepiaB = Math.min(255, this.comprobrarValores(0.272, 0.534, 0.131, pixel));
                pixel.sample[0] = (int) sepiaR;
                pixel.sample[1] = (int) sepiaG;
                pixel.sample[2] = (int) sepiaB;
                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
                }else{
                    double sepiaR = Math.min(255, (0.393 * pixel.sample[0]));
                    pixel.sample[0] = (int) sepiaR;
                    destRaster.setPixel(pixel.col, pixel.row, pixel.sample);  
                }
            }
            return dest;
        

    }

    /**
     * Comprueba que los componentes de un pixel, múltiplicado por un valor
     * determinado, no pasen de 255
     *
     * @param valor1 - Valor determinado, para el primer componente del pixel
     * @param valor2 - Valor determinado, para el segundo componente del pixel
     * @param valor3 - Valor determinado, para el tercer componente del pixel
     * @param pixel - pixel de una imagen.
     * @return Se devuelve el valor de la operación suma
     */
    private double comprobrarValores(double valor1, double valor2, double valor3, BufferedImagePixelIterator.PixelData pixel) {
        double resultado1 = valor1 * pixel.sample[0];
        double resultado2 = valor2 * pixel.sample[1];
        double resultado3 = valor3 * pixel.sample[2];
        if (resultado1 > 255) {
            resultado1 = 255;
        }
        if (resultado2 > 255) {
            resultado2 = 255;
        }
        if (resultado3 > 255) {
            resultado3 = 255;
        }
        double valor = resultado1 + resultado2 + resultado3;
        return valor;

    }

}
