# Coffee Machine Application

This application provides a visual interface for a coffee machine, tracks the date and time of coffee preparations, and records the remaining cup count in the machine. It demonstrates the use of the **State Design Pattern** and **SQL database** for logging and data persistence.

## Features
- **Visual Interface**: A user-friendly GUI for interacting with the coffee machine.
- **State Design Pattern Implementation**: Ensures structured state management for the coffee machine.
- **SQL Database Logging**: Records each coffee preparation with timestamp and updates the remaining cup count.
- **Real-time Cup Count Tracking**: Displays the number of cups left in the machine.

## Technologies Used
- **Programming Language**: Java 
- **GUI Framework**: Java Swing
- **Database**: MySQL
- **Design Pattern**: State Design Pattern

******************************************************************
  ![image](https://github.com/user-attachments/assets/7fdaa428-5aba-453d-9496-777c14ed80df)
******************************************************************

## How It Works
1. The application starts with an initial state where the machine is idle.
2. When a user selects a coffee option, the state transitions accordingly (e.g., `IdleState -> BrewingState`).
3. The coffee preparation is recorded in the SQL database with a timestamp.
4. The remaining cup count is updated in the database.
5. If no cups are left, the machine enters a `RefillState` and prompts for a refill.

## Database Structure
**Table: CoffeeLog**
| ID | Timestamp          | CupCount |
|----|-------------------|----------|
| 1  | 2025-03-01 10:30 | 9        |
| 2  | 2025-03-01 11:00 | 8        |

## Installation & Setup
To Clone the repository:
   ```bash
   git clone https://github.com/junodofbelhaven/coffee-machine-app.git
   ```


## State Design Pattern Overview
This application uses the **State Design Pattern** to manage different states of the coffee machine efficiently. The states include:
- **IdleState**: Waiting for user input.
- **BrewingState**: Preparing coffee.
- **RefillState**: Prompting user to refill cups.
- **MaintenanceState**: Handling cleaning or error conditions.

Each state transitions dynamically based on user interactions and internal logic.

## Future Improvements
- Add different coffee types with unique brewing times.
- Implement user authentication for tracking individual preferences.
- Enhance UI with modern design elements.

## License
This project is licensed under the MIT License.

## Contributions
Feel free to fork the repository, submit issues, or create pull requests to improve the application!

