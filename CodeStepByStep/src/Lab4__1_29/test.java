package Lab4__1_29;

import graphics.DrawingPanel;
import java.awt.*;

public class test {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 300);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();

        // Draw figures at specified positions
        drawFigure(g, 50, 50);
        drawFigure(g, 250, 10);
        drawFigure(g, 180, 115);
    }

    // Parameterized method to draw a figure at a given position
    public static void drawFigure(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        for (int i = 1; i <= 5; i++) {
            g.drawRect(x, y, 20 * i, 20 * i);
        }

        g.setColor(Color.BLACK);
        for (int i = 1; i <= 5; i++) {
            g.drawLine(x, y, x + 20 * i, y + 20 * i);
        }
    }
}
