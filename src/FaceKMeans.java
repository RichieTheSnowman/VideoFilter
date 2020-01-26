import processing.core.PApplet;

import javax.swing.*;
import java.util.ArrayList;

public class FaceKMeans implements PixelFilter {
    private int k;
    ArrayList<Cluster> clusters;

    public FaceKMeans() {
        clusters = new ArrayList<>();
        initClusters();

    }

    @Override
    public DImage processImage(DImage img) {
        short[][] bw = img.getBWPixelGrid();
        for (int i = 0; i < 12; i++) {
            for (int r = 0; r < bw.length; r++) {
                for (int c = 0; c < bw[0].length; c++) {
                    if (bw[r][c] == 255) {
                        addPoint(r, c);
                    }
                }
            }
        }
        calcCenter();
        Point ul = upLeft();
        return img;
    }

    private Point upLeft() {
        int minx = clusters.get(0).points.get(0).getX();
        int miny = clusters.get(0).points.get(0).getY();
        for (int i = 1; i < clusters.get(0).points.size(); i++) {
            if(minx > clusters.get(0).points.get(i).getX()){
                minx = clusters.get(0).points.get(i).getX();
            }

        }

        for (int i = 1; i < clusters.get(0).points.size(); i++) {
            if(minx > clusters.get(0).points.get(i).getY()){
                minx = clusters.get(0).points.get(i).getY();
            }

        }

        return new Point(minx, miny);


    }

    private void initClusters() {
        int x = (int) (Math.random() * 640);
        int y = (int) (Math.random() * 480);
        Cluster c = new Cluster(x, y);
        clusters.add(c);
    }

    public void addPoint(int x, int y) {
        clusters.get(0).add(x, y);
    }


    public double calcDistance(double x, double y, double x1, double y1) {
        return (x1 - x) * (x1 - x) + (y1 - y) * (y1 - y);
    }

    public void calcCenter() {
        for (int i = 0; i < clusters.size(); i++) {
            clusters.get(i).calcNewCenter();
        }
    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {
        window.fill(0);
        window.ellipse(clusters.get(0).getCenter().getY(), clusters.get(0).getCenter().getX(), 10, 10);
        window.ellipse(clusters.get(0).getCenter().getY(), clusters.get(0).getCenter().getX(), 10, 10);
        clusters.get(0).clear();

    }
}
