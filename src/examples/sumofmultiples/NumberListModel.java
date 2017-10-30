package examples.sumofmultiples;

import java.util.Set;
import javax.swing.AbstractListModel;

/**
 * {@code AbstractListModel} implementation for {@code JList}.
 * @author jgarner1
 */
public class NumberListModel extends AbstractListModel<String> {
    
    private final String[] values;

    /**
     * Creates a new model {@code AbstractListModelImpl}.
     * @param set a set of objects
     */
    public NumberListModel(Set<? extends Number> set) {
        
        Number[] numbers = set.toArray(new Number[set.size()]);
        values = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            values[i] = String.format("%,d", numbers[i]);
        }
    }

    @Override
    public int getSize() {
        return values.length;
    }

    @Override
    public String getElementAt(int i) {
        return values[i];
    }
}
