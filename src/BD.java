import processing.core.PApplet;

public class BD implements PixelFilter, Clickable{
    Blur blur;
    ColorThreshold color;
    KMeans kmeans;

    public BD(){
        color = new ColorThreshold();
        blur = new Blur();
        kmeans = new KMeans();
    }

    @Override
    public DImage processImage(DImage img) {
        DImage b = new DImage(blur.processImage(img));
        DImage c = new DImage(color.processImage(b));
        DImage k = new DImage(kmeans.processImage(c));

        return k;
    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {
        kmeans.drawOverlay(window, original, filtered);    }


    @Override
    public void mouseClicked(int mouseX, int mouseY, DImage img) {
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();

        Ball x = new Ball(red[mouseY][mouseX], green[mouseY][mouseX], blue[mouseY][mouseX]);
        color.balls.add(x);
    }

    @Override
    public void keyPressed(char key) {
        color.keyPressed(key);
    }
}
