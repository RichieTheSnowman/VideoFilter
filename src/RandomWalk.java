import processing.core.PApplet;

import java.util.ArrayList;

public class RandomWalk implements PixelFilter{
    ArrayList<Dot> points = new ArrayList<>();

    public RandomWalk(){
        for (int i = 0; i < 10; i++) {
            points.add(new Dot(200, 200));
        }

    }
    @Override
    public DImage processImage(DImage img) {
        return img;
    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {

        for (int i = 0; i < points.size(); i++) {
            window.fill(255, 0, 0);
            window.ellipse(points.get(i).getX(), points.get(i).getY(), 10, 10);
            points.get(i).takeRandomStep();
        }


    }
}
