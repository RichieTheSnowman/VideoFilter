import processing.core.PApplet;

public class Histogram implements PixelFilter{
    private int[] histogram;

    public Histogram(){
        histogram = new int[256];
    }

    @Override
    public DImage processImage(DImage img) {
        short[][] pixels = img.getBWPixelGrid();
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                int val = pixels[r][c];

            }
        }
        return null;
    }

    /*public short[][] pixelFunc(int num){
        short[][] newPix = new short[pixels.length][pixel]
    }*/



    @Override
    public void drawOverlay(PApplet window, DImage original, DImage filtered) {

    }
}
