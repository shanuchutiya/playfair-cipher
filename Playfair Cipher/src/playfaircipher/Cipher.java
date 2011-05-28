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
public class Cipher {

    static String encrypt(String plaintext, String key) {
        PolybusSq.reset();
        PolybusSq.PolybusSq(key);
        plaintext = removeWhitespace(plaintext);
        ArrayList<String> toEncrypt = getDigraphs(plaintext);
        ArrayList<String> encrypted = new ArrayList<String>();
        for (String s : toEncrypt) {
            encrypted.add(swapE(s));
        }
        String ciphertext = "";
        for (String s : encrypted) {
            ciphertext += s;
        }
        return ciphertext;
    }

    static String decrypt(String ciphertext, String key) {
        PolybusSq.reset();
        PolybusSq.PolybusSq(key);
        ciphertext = removeWhitespace(ciphertext);
        ArrayList<String> toDecrypt = getDigraphs(ciphertext);
        ArrayList<String> decrypted = new ArrayList<String>();
        for (String s : toDecrypt) {
            decrypted.add(swapD(s));
        }
        String plaintext = "";
        for (String s : decrypted) {
            plaintext += s;
        }
        return plaintext;
    }

    private static String removeWhitespace(String str) {
        String noWhite = "";
        for (int z = 0; z < str.length(); z++) {
            if (!Character.isWhitespace(str.charAt(z))) {
                noWhite += str.charAt(z);
            }
        }
        return noWhite;
    }

    private static ArrayList<String> getDigraphs(String str) {
        ArrayList<String> digraphs = new ArrayList<String>();
        if (str.length() % 2 != 0) {
            str += "x";
        }
        for (int x = 0; x <= str.length() - 2; x += 2) {
            digraphs.add(str.substring(x, x + 2));
        }
        return digraphs;
    }

    private static String swapE(String s) {
        String sE = "";
        Location l1 = PolybusSq.getLocationOf(s.charAt(0));
        Location l2 = PolybusSq.getLocationOf(s.charAt(1));
        if (l1.compareTo(l2) == 0) {
            l2 = PolybusSq.getLocationOf('x');
        }
        if (l1.compareTo(l2) == 1) {
            sE += PolybusSq.getCharAt(new Location(l1.getX(), l1.getY() + 1));
            sE += PolybusSq.getCharAt(new Location(l2.getX(), l2.getY() + 1));
        } else if (l1.compareTo(l2) == 2) {
            sE += PolybusSq.getCharAt(new Location(l1.getX() + 1, l1.getY()));
            sE += PolybusSq.getCharAt(new Location(l2.getX() + 1, l1.getY()));
        } else if (l1.compareTo(l2) < 0) {
            sE += PolybusSq.getCharAt(new Location(l2.getX(), l1.getY()));
            sE += PolybusSq.getCharAt(new Location(l1.getX(), l2.getY()));
        }
        return sE;
    }
    
    private static String swapD(String s) {
        String sE = "";
        Location l1 = PolybusSq.getLocationOf(s.charAt(0));
        Location l2 = PolybusSq.getLocationOf(s.charAt(1));
        if (l1.compareTo(l2) == 0) {
            l2 = PolybusSq.getLocationOf('x');
        }
        if (l1.compareTo(l2) == 1) {
            sE += PolybusSq.getCharAt(new Location(l1.getX(), l1.getY() - 1));
            sE += PolybusSq.getCharAt(new Location(l2.getX(), l2.getY() - 1));
        } else if (l1.compareTo(l2) == 2) {
            sE += PolybusSq.getCharAt(new Location(l1.getX() - 1, l1.getY()));
            sE += PolybusSq.getCharAt(new Location(l2.getX() - 1, l1.getY()));
        } else if (l1.compareTo(l2) < 0) {
            sE += PolybusSq.getCharAt(new Location(l2.getX(), l1.getY()));
            sE += PolybusSq.getCharAt(new Location(l1.getX(), l2.getY()));
        }
        return sE;
    }
}
