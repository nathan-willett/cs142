// Allison Obourn
// CS 142, Spring 2024
// Lecture 17

// Opens a 500 pixel wide and 200 pixel tall window with a white
// background that contains a dark grey square and two light
// grey squares

import java.awt.*;

public class Drawing {
    public static void main(String[] args) {
        // open a new window to draw on
        DrawingPanel panel = new DrawingPanel(500, 200);
        
        // get a pen to draw on the panel with
        Graphics g = panel.getGraphics();
        
        // dip our paintbrush in dark greyand draw a square
        g.setColor(new Color(100, 100, 100));
        g.fillRect(100, 100, 50, 50);
        
        // dip our paintbrush in light grey and draw two squares
        g.setColor(new Color(200, 200, 200));
        g.fillRect(200, 100, 50, 50);
        g.fillRect(200, 0, 50, 50);
        
    }
}