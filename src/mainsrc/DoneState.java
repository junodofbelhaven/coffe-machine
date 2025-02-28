/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainsrc;

import java.awt.Color;

/**
 *
 * @author anil
 */
public class DoneState implements State {

    CoffeMachine coffeMachine;

    public DoneState(CoffeMachine coffeMachine) {
        this.coffeMachine = coffeMachine;
    }

    @Override
    public void start() {
        coffeMachine.view.showMessage("Here is your coffe, enjoy!");
        DatabaseConnection.record(coffeMachine.totalCups);
        coffeMachine.view.showWarningMessage("");
        if (coffeMachine.totalCups <= 0) {
            coffeMachine.view.showMessage("Machine is out of cups, please fill with cups to use again.");
            coffeMachine.initializeMachine();
            coffeMachine.view.filledCupsTextField.setText(String.valueOf(coffeMachine.totalCups));
            coffeMachine.view.donePanel.setBackground(new Color(204, 204, 204));
        } else {
            coffeMachine.currentState = coffeMachine.idleState;
            coffeMachine.view.idlePanel.setBackground(new Color(255, 255, 153));
            coffeMachine.view.donePanel.setBackground(new Color(204, 204, 204));
        }
    }

    @Override
    public void filled(int numOfCups) {
        coffeMachine.view.showWarningMessage("Please reset the machine to fill.");
    }

    @Override
    public void reset() {
        coffeMachine.view.donePanel.setBackground(new Color(204, 204, 204));
        coffeMachine.initializeMachine();
        coffeMachine.view.filledCupsTextField.setText(String.valueOf(coffeMachine.totalCups));
        coffeMachine.view.clearLabels();
    }

}
