import processing.core.PApplet;

public class Inverse implements PixelFilter {
    @Override
    public DImage processImage(DImage img) {
        short[][] red = img.getRedChannel();
        short[][] green = img.getGreenChannel();
        short[][] blue = img.getBlueChannel();

        for (int r = 0; r < red.length; r++) {
            for (int c = 0; c < red[0].length; c++) {

                red[r][c] = (short) (255 - red[r][c]);
                green[r][c] = (short) (255 - green[r][c]);
                blue[r][c] = (short) (255 - blue[r][c]);
            }
        }

        img.setColorChannels(red, green, blue);
        return img;
    }

    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {

    }
}
