import processing.core.PApplet;

import java.util.ArrayList;

public class Threshold implements PixelFilter, Clickable {
    private int threshold = 20;
    private ArrayList<Ball> balls;

    public Threshold(){
        balls = new ArrayList<>();
    }


    @Override
    public DImage processImage(DImage img) {
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();
        short[][] bw = img.getBWPixelGrid();


        for (int r = 0; r < red.length; r++) {
            for (int c = 0; c < red[0].length; c++) {

                if(compare(red[r][c], green[r][c], blue[r][c])){
                    bw[r][c] = 255;
                }else{
                    bw[r][c] = 0;
                }
            }
        }

        img.setPixels(bw);
        return img;
    }

    public boolean compare(int r, int g, int b){
        for(Ball x: balls){
            if (Math.abs(r - x.getRed()) < threshold && Math.abs(g - x.getGreen()) < threshold && Math.abs(b - x.getBlue()) < threshold){
                return true;
            }
        }
        return false;

    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {

    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, DImage img) {
        short[][] red = img.getGreenChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();

        balls.add(new Ball(red[mouseY][mouseX], green[mouseY][mouseX], blue[mouseY][mouseX]));


    }

    @Override
    public void keyPressed(char key) {
        if(key == '+') threshold += 5;
        if(key == '-') threshold -= 5;
    }
}
