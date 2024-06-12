package project2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Class: TileManager
 * 
 * Description:
 * This class manages a collection of Tile objects displayed within a
 * DrawingPanel.
 * 
 * @author Nathan Willett
 *         Section: 15596
 *         CS 142, Spring 2024
 */
public class TileManager {
    private ArrayList<Tile> tileList;

    // Constructs a new tile manager with an empty array list
    public TileManager() {
        tileList = new ArrayList<>();
    }

    /**
     * Adds a new tile to the ArrayList storing all of the tile objects
     * 
     * @param tile The tile to be added
     */
    public void addTile(Tile tile) {
        tileList.add(tile);
    }

    /**
     * Draws all of the tileList in the 'tileList' onto the graphics object.
     * 
     * @param g - the graphics object where the tileList are drawn.
     */
    public void drawAll(Graphics g) {
        for (Tile tile : tileList) {
            tile.draw(g);
        }
    }

    /**
     * A helper method used to check whether a mouse click is within the boundaries
     * of a tile.
     * 
     * @param tile The tile to check against the mouse click coordinates.
     * @param x    The x-coordinate of the mouse click.
     * @param y    The y-coordinate of the mouse click.
     * @return     'true' if the mouse click is within the tile's boundaries, 'false' otherwise.
     */
    private boolean withinRange(Tile tile, int x, int y) {
        // if x is between the left and right bounds of the tile
        return tile.getX() <= x && x <= tile.getX() + tile.getWidth() &&
            // and y is between the lower and upper bounds
            tile.getY() <= y && y <= tile.getY() + tile.getHeight();
    }
    
    /**
     * Iterates through the list of tileList starting from the last tile element (which
     * is drawn last and therefore at the top of the z-order) down to the first
     * tile element (the tile at the bottom of the z-order). This ensures that the
     * first tile found under the user's cursor is at the top of the z-order.
     * 
     * @param x The x-coordinate of the mouse click.
     * @param y The y-coordinate of the mouse click.
     */
    public void raise(int x, int y) {
        boolean tileMoved = false; // indicates whether a tile has been found and reordered in the list
        // iterate through the list until both i = zero and 'tileMoved' is true
        for (int i = tileList.size() - 1; i >= 0 && !tileMoved; i--) {
            Tile tile = tileList.get(i);
            if (withinRange(tile, x, y)) {
                // Move the tile to the end of the list to put it at the top of the z-order
                tileList.remove(i);
                tileList.add(tile);
                tileMoved = true; // exit the for loop since only one tile should be moved
            }
        }
    }

    /**
     * Moves the topmost tile that contains the given coordinates to the bottom of the z-order.
     * 
     * @param x The x-coordinate of the mouse click.
     * @param y The y-coordinate of the mouse click.
     */
    public void lower(int x, int y) {
        boolean tileMoved = false; // indicates whether a tile has been found and reordered in the list
        // iterate through the list until both i = zero and 'tileMoved' is true
        for (int i = tileList.size() - 1; i >= 0 && !tileMoved; i--) {
            Tile tile = tileList.get(i);
            if (withinRange(tile, x, y)) {
                tileList.remove(i); 
                tileList.add(0, tile);  // Move the tile to the beginning of the list
                tileMoved = true; // exit the for loop since only one tile should be moved
            }
        }
    }

    /**
     * Deletes the topmost tile from the graphics panel.
     * 
     * @param x The x-coordinate of the mouse click.
     * @param y The y-coordinate of the mouse click.
     */
    public void delete(int x, int y) {
        boolean tileDeleted = false;
        for (int i = tileList.size() - 1; i >= 0 && !tileDeleted; i--) {
            Tile tile = tileList.get(i);
            if (withinRange(tile, x, y)) {
                tileList.remove(i);
                tileDeleted = true;
            }
        }
    }

    /**
     * Deletes ALL tiles which overlap the mouse click coordinates.
     * 
     * @param x The x-coordinate of the mouse click.
     * @param y The y-coordinate of the mouse click.
     */
    public void deleteAll(int x, int y) {
        for (int i = tileList.size() - 1; i >= 0; i--) {
            Tile tile = tileList.get(i);
            if (withinRange(tile, x, y)) {
                tileList.remove(i); // Continue removing all tiles within the coord range
            }
        }
    }

    /**
     * Randomly shuffles the tileList and also repositions the tiles on the graphics panel
     * 
     * @param panelWidth The width of the graphics panel
     * @param panelHeight The height of the graphics panel
     */
    public void shuffle(int panelWidth, int panelHeight) {
        Collections.shuffle(tileList); // Randomly reorder the tileList
        Random rand = new Random();
        for (Tile tile : tileList) {
            // Reposition the tiles within the existing boundaries
            int newX = rand.nextInt(panelWidth - tile.getWidth());
            int newY = rand.nextInt(panelHeight - tile.getHeight());
            tile.setX(newX);
            tile.setY(newY);
        }
    }
}
