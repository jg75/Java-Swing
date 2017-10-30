package examples.sumofmultiples;

import examples.SwingApp;

/**
 *
 * @author jgarner1
 */
public class Main extends SwingApp {
    
    /**
     * 
     * @param args the arguments
     */
    public static void main(String args[]) {
        setLookAndFeel();
        
        java.awt.EventQueue.invokeLater(() -> {
            new SumOfMultiplesGUI().setVisible(true);
        });
    }
}
