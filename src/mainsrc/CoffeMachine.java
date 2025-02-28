/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainsrc;

/**
 *
 * @author anil
 */
public class CoffeMachine {

    int totalCups = 0;
    View view;
    State brewingState;
    State doneState;
    State idleState;
    State emptyState;
    State currentState;

    public CoffeMachine(View view) {
        this.view = view;
        brewingState = new BrewingState(this);
        doneState = new DoneState(this);
        idleState = new IdleState(this);
        emptyState = new EmptyState(this);

        initializeMachine();
        DatabaseConnection.initializeDatabase();
    }

    void Start() {
        currentState.start();
    }

    void filled(int numOfCups) {
        currentState.filled(numOfCups);
    }

    void initializeMachine() {
        totalCups = 0;
        currentState = emptyState;
    }

    void reset() {
        currentState.reset();
    }

}
