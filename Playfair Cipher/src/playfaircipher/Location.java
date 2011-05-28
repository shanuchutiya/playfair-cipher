/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

/**
 *
 * @author David Fryer
 */
public class Location implements Comparable<Location> {

    private int x;
    private int y;

    /**
     *
     */
    public Location() {
        x = 0;
        y = 0;
    }

    /**
     *
     * @param x
     * @param y
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * 
     * @param o
     * @return
     */
    public int compareTo(Location o) {
        if ((this.getX() == o.getX()) && (this.getY() == o.getY())) {
            return 0;
        } else if (this.getX() == o.getX()) {
            return 1;
        } else if (this.getY() == o.getY()) {
            return 2;
        } else {
            return -1;
        }
    }
}
