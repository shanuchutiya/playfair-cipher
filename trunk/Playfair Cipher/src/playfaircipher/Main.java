/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playfaircipher;


/**
 * FOR HELP::http://www.ssec.wisc.edu/~tomw/java/unicode.html#x0000
 * Goto: Basic Latin
 * @author David Fryer
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        gui.setSize(500, 350);
        gui.setLookAndFeel("MOTIF");
        gui.setResizable(false);
        gui.setLocationRelativeTo(null);
        gui.setTitle("Playfair");
        gui.setVisible(true);
    }
}
