/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;

import java.util.ArrayList;

/**
 *
 * @author David Fryer
 */
public class PolybusSq {

    static ArrayList<ArrayList<Integer>> square;
    private static String key;
    private static int y;
    private static int x;

    /**
     * A B C D E
     * F G H I K
     * L M N O P
     * Q R S T U
     * V W X Y Z
     * (65 to 90 [74 omitted]) 25 items
     *
     * FINAL SQUARE: 7x7
     * & : ; < > * +
     *
     *   1 2 3 4 5 6 7
     * 1 A B C D E F G
     * 2 H I K L M N O
     * 3 P Q R S T U V
     * 4 W X Y Z ! " #
     * 5 $ % ' ( ) , -
     * 6 . / 0 1 2 3 4
     * 7 5 6 7 8 9 = ?
     */
    static void PolybusSq() {
        square = new ArrayList<ArrayList<Integer>>(7);
        y = 0;
        x = 0;
        square.add(new ArrayList<Integer>(7));
        completeSquare();
    }

    /**
     *
     * @param key
     */
    static void PolybusSq(String key) {
        square = new ArrayList<ArrayList<Integer>>(7);
        y = 0;
        x = 0;
        setKey(key);
    }

    /**
     *
     * @param key
     */
    static void setKey(String keyWord) {
        key = removeWhitespace(keyWord.toUpperCase());
        square.add(new ArrayList<Integer>(7));
        for (int z = 0; z < key.length(); z++) {
            boolean contains = false;
            for (ArrayList<Integer> ints : square) {
                if (ints.contains(new Integer(key.charAt(z)))) {
                    contains = true;
                }
            }
            if (contains) {
                continue;
            }
            if (x < 7) {
                square.get(y).add(new Integer(key.charAt(z)));
                x++;
            } else {
                square.add(new ArrayList<Integer>(7));
                y++;
                x = 0;
                z--;
            }
        }
        completeSquare();
    }

    /**
     *
     * @param y
     * @param x
     */
    private static void completeSquare() {
        int codePoint = 65;
        while (y < 7) {
            boolean contains = false;
            if (codePoint > 90) {
                codePoint = 33;
            } else if (codePoint == 74) {
                codePoint = 75;
            } else if (codePoint == 38) {
                codePoint = 39;
            } else if (codePoint == 42) {
                codePoint = 44;
            } else if (codePoint == 58) {
                codePoint = 61;
            } else if (codePoint == 62) {
                codePoint = 63;
            }
            for (ArrayList<Integer> ints : square) {
                if (ints.contains(new Integer(codePoint))) {
                    contains = true;
                }
            }
            if (contains) {
                codePoint++;
                continue;
            }
            if (x < 7) {
                square.get(y).add(new Integer(codePoint));
                x++;
            } else {
                square.add(new ArrayList<Integer>(7));
                y++;
                x = 0;
            }
        }
    }

    /**
     *
     * @param loc
     * @return
     */
    static char getCharAt(Location loc) {
        checkLoc(loc);
        return (char) square.get(loc.getY()).get(loc.getX()).intValue();
    }

    private static Location checkLoc(Location l) {
        if (l.getY() >= 7) {
            l.setY(0);
        } else if (l.getY() < 0) {
            l.setY(6);
        }
        if (l.getX() >= 7) {
            l.setX(0);
        } else if (l.getX() < 0){
            l.setX(6);
        }
        return l;
    }

    /**
     *
     * @param c
     * @return the Location of c
     */
    static Location getLocationOf(char c) {
        c = Character.toUpperCase(c);
        if (c == 'J') {
            c = 'I';
        }
        for (int r = 0; r < 7; r++) {
            if (square.get(r).contains(new Integer(c))) {
                return new Location(square.get(r).indexOf(new Integer(c)), r);
            }
        }
        return null;
    }

    /**
     *
     * @param str
     * @return
     */
    private static String removeWhitespace(String str) {
        String noWhite = "";
        for (int z = 0; z < str.length(); z++) {
            if (!Character.isWhitespace(str.charAt(z))) {
                noWhite += str.charAt(z);
            }
        }
        return noWhite;
    }

    static void reset() {
        square.clear();
        x = 0;
        y = 0;
    }

    /**
     * 
     * @return
     */
    static String print() {
        String output = "";
        for (ArrayList<Integer> rows : square) {
            for (Integer i : rows) {
                output += (char) i.intValue();
                output += ' ';
            }
            output += '\n';
        }
        return output;
    }
}
