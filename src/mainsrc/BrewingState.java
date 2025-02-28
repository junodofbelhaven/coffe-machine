/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainsrc;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author anil
 */
public class BrewingState implements State {

    CoffeMachine coffeMachine;
    View view;
    boolean isCountingDown = false;

    public BrewingState(CoffeMachine coffeMachine) {
        this.coffeMachine = coffeMachine;
        view = coffeMachine.view;
    }

    @Override
    public void start() {
        startCountdown(5);
    }

    public void startCountdown(int seconds) {
        if (!isCountingDown) {
            isCountingDown = true;

            Timer timer = new Timer(1000, new ActionListener() {
                int remainingTime = seconds;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (remainingTime > 0) {
                        view.showMessage("Time remaining: " + remainingTime + " seconds");
                        remainingTime--;
                    } else {
                        view.showMessage("Coffee is ready!");
                        coffeMachine.totalCups--;
                        coffeMachine.view.filledCupsTextField.setText(String.valueOf(coffeMachine.totalCups));
                        coffeMachine.currentState = coffeMachine.doneState;
                        coffeMachine.view.brewingPanel.setBackground(new Color(204, 204, 204));
                        coffeMachine.view.donePanel.setBackground(new Color(255, 255, 153));
                        ((Timer) e.getSource()).stop();
                        isCountingDown = false;
                    }
                }
            });

            timer.start();

        } else {
            view.showWarningMessage("Coffe is already brewing, please wait.");
        }
    }

    @Override
    public void filled(int numOfCups) {
        view.showWarningMessage("Cannot refill the cups while brewing.");
    }

    @Override
    public void reset() {
        view.showWarningMessage("Cannot reset while brewing.");
    }

}
