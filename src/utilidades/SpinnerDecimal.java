/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author negu2
 */
public class SpinnerDecimal extends JSpinner {

    private SpinnerNumberModel model;

    public SpinnerDecimal() {
        super();
        // Model setup
        model = new SpinnerNumberModel(0.0, -1000.0, 1000.0, 0.1);
        this.setModel(model);

        // Step recalculation
        this.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setStepSize(0.25);
            }
        });
    }

}
