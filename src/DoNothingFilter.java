import processing.core.PApplet;

import javax.swing.*;

public class DoNothingFilter implements PixelFilter {
    private int num;

    public DoNothingFilter(){
        this.num = Integer.parseInt(JOptionPane.showInputDialog("Enter number of splits"));
    }

    @Override
    public DImage processImage(DImage img) {
        // we don't change the input image at all!
        return img;
    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {
        window.fill(255, 0, 0);
        window.ellipse(original.getWidth(), original.getHeight(), 10, 10);

        window.fill(0, 255, 0);
        window.ellipse(0, 0, 10, 10);

        window.stroke(255, 255, 255);

        for (int i = 0; i < num; i++) {
            window.line(original.getWidth()*i/num, 0, original.getWidth()*i/num, original.getHeight());
        }

        for (int i = 0; i < num; i++) {
            window.line(0, original.getHeight()*i/num, original.getWidth(), original.getHeight()*i/num);
        }



    }

}

