package examples;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jgarner1
 */
public abstract class SwingApp {
    
    public static final String LOOK_AND_FEEL = "Nimbus";
    public static final Logger LOGGER = Logger.getLogger(SwingApp.class.getName());
    
    /**
     * Sets the default look and feel.
     */
    public static void setLookAndFeel() {
        
        for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if (info.getName().equals(LOOK_AND_FEEL)) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    LOGGER.log(Level.SEVERE, null, ex);
                }
                return;
            }
        }
    }
}
