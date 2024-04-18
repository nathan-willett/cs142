package main.java.project2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Class: TileManager
 * 
 * Description:
 * This class manages a collection of Tile objects displayed within a DrawingPanel.
 * 
 * @author Nathan Willett
 * Section: 15596
 * CS 142, Spring 2024
 */
public class TileManager {
    private ArrayList<Tile> tiles;

    // Constructs a new tile manager with an empty array list
    public TileManager() {
        tileList = new ArrayList<>();
    }

    /**
     * Adds a new tile to the ArrayList storing all of the tile objects
     * @param rect 
     */ 
    public void addTile(Tile rect) {
        tiles.add(tile);
    }

    /**
     * Draws all of the tiles in the 'tileList' onto the drawing panel.
     * @param g - the 
     */
    public void drawAll(Graphics g) {
        for (Tile tile : tileList) {
            tile.draw(g);
        }
    }

    /**
     * Moves the topmost tile that contains the given coordinates to the top of the z-order.
     * Checks tiles from the topmost down to the bottommost in the list (last drawn to first drawn),
     * ensuring that the first tile it finds under the coordinates is the one that visually appears on top.
     * Once found, the tile is moved to the end of the list, making it the last to be drawn in future renderings,
     * which places it visually above all other tiles.
     *
     * @param x The x-coordinate of the mouse click.
     * @param y The y-coordinate of the mouse click.
     */
    public void raise(int x, int y) {
        for (int i = tiles.size() - 1; i >= 0; i--) {
            Tile tile = tiles.get(i);
            if (tile.getX() <= x && x <= tile.getX() + tile.getWidth() &&       // 
                tile.getY() <= y && y <= tile.getY() + tile.getHeight()) {      // 
                tiles.add(tiles.remove(i));
                break; // get rid of this
            }
        }
    }

    /**
     * 
     * @param x
     * @param y
     */
    public void lower(int x, int y) {

    }

    /**
     * 
     * @param x
     * @param y
     */
    public void delete(int x, int y) {

    }

    /**
     * 
     * @param x
     * @param y
     */
    public void deleteAll(int x, int y) {

    }

    /**
     * 
     * @param width
     * @param height
     */
    public void shuffle(int width, int height) {
        
    }
}
