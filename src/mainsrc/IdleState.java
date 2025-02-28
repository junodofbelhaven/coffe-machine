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
public class IdleState implements State {

    CoffeMachine coffeMachine;

    public IdleState(CoffeMachine coffeMachine) {
        this.coffeMachine = coffeMachine;
    }

    @Override
    public void start() {

        coffeMachine.currentState = coffeMachine.brewingState;
        coffeMachine.view.idlePanel.setBackground(new Color(204, 204, 204));
        coffeMachine.view.brewingPanel.setBackground(new Color(255, 255, 153));
        coffeMachine.brewingState.start();

    }

    @Override
    public void filled(int numOfCups) {
        coffeMachine.totalCups += numOfCups;
        coffeMachine.view.filledCupsTextField.setText(String.valueOf(coffeMachine.totalCups));
        coffeMachine.view.showMessage(numOfCups + " cups has been added to machine.");
    }

    @Override
    public void reset() {
        coffeMachine.view.showMessage("The machine has been reset.");
        coffeMachine.view.idlePanel.setBackground(new Color(204, 204, 204));
        coffeMachine.initializeMachine();
        coffeMachine.view.filledCupsTextField.setText(String.valueOf(coffeMachine.totalCups));
        coffeMachine.view.clearLabels();
    }

}
