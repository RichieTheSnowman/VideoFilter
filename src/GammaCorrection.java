import processing.core.PApplet;

import javax.swing.*;

public class GammaCorrection implements PixelFilter{
    private double gamma, k;
    short[] newValue = new short[256];

    public GammaCorrection(){
        this.gamma = Double.parseDouble(JOptionPane.showInputDialog("Enter a gamma value"));
        this.k = 255/Math.pow(255, gamma);


        for (int i = 0; i <= 255; i++) {
            newValue[i] = computeGammaCorrection(i);
        }

    }

    @Override
    public DImage processImage(DImage img) {
        short[][] pixels = img.getBWPixelGrid();

        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int val = pixels[r][c];
                pixels[r][c] = newValue[val];
            }
        }

        img.setPixels(pixels);
        return img;
    }

    private short computeGammaCorrection(double val) {
        return (short)(k*Math.pow(val, gamma));
    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {

    }
}
