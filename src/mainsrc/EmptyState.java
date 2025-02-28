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
public class EmptyState implements State {

    CoffeMachine coffeMachine;

    public EmptyState(CoffeMachine CoffeMachine) {
        this.coffeMachine = CoffeMachine;
    }

    @Override
    public void start() {
        coffeMachine.view.showWarningMessage("Coffe machine is empty, please fill with cups and press filled to proceed.");
    }

    @Override
    public void filled(int numOfCups) {
        if (numOfCups > 0) {
            coffeMachine.totalCups = numOfCups;
            coffeMachine.view.filledCupsTextField.setText(String.valueOf(coffeMachine.totalCups));

            coffeMachine.currentState = coffeMachine.idleState;
            coffeMachine.view.idlePanel.setBackground(new Color(255, 255, 153));
        } else {
            coffeMachine.view.showWarningMessage("Number of cups must be greater than 0");
        }
    }

    @Override
    public void reset() {
        coffeMachine.view.showWarningMessage("Can't reset, machine is already empty.");
    }

}
