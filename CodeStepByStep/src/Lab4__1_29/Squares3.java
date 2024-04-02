package Lab4__1_29;

import graphics.DrawingPanel;
import java.awt.*;

public class Squares3 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 300);
        panel.setBackground(Color.CYAN);
        Graphics g = panel.getGraphics();

        // Draw figures at specified positions with correct size increments
        drawFigure(g, 50, 50, 20);   // Original figure with size increment 20
        drawFigure(g, 250, 10, 10);  // Top-right figure with size increment 10
        drawFigure(g, 180, 115, 36); // Bottom-right figure with size increment 36
    }

    // Parameterized method to draw a figure at a given position and size increment
    public static void drawFigure(Graphics g, int x, int y, int sizeIncrement) {
        g.setColor(Color.RED);
        for (int i = 0; i < 5; i++) {
            g.drawRect(x, y, sizeIncrement * (i + 1), sizeIncrement * (i + 1));
        }

        g.setColor(Color.BLACK);
        for (int i = 0; i < 5; i++) {
            g.drawLine(x, y, x + sizeIncrement * (i + 1), y + sizeIncrement * (i + 1));
        }
    }
}
