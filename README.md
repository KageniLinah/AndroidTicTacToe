# AndroidTicTacToe
Maseno University - Android Application Programming Tutorial 2
# Project Overview
This project is a simple Tic-Tac-Toe game developed for Android as part of Maseno University's Mobile Programming coursework. The application showcases core Android development concepts, including UI design with XML, integrating game logic with a user interface, event handling, and Android lifecycle management.

# Features
Interactive Game Board: The game board is represented by a 3x3 grid of buttons.
User vs. AI Gameplay:
Human player uses green X.
AI opponent uses red O with simple logic:
Win if possible.
Block human player from winning.
Make a random move otherwise.
Game Status Indicator: A TextView displays whose turn it is or if the game has ended (win, lose, or tie).
Reset Game Option: Start a new game via an options menu.
# Tools and Technologies
Programming Language: Java
Development Tools:
Android Studio/Eclipse
Android SDK
Target API Level: Android 2.2 (Froyo)
Emulator: Android Virtual Device (AVD)
# Project Structure
Game Logic
The game logic is handled in the TicTacToeGame class, which includes methods for:

Setting up the board.
Checking for a winner.
Implementing AI moves.
User Interface
The UI is built using XML layout files and includes:

A TableLayout for the game board buttons.
A TextView to display the game's status.
Event Handling
Game actions are managed through:

Button clicks for user moves.
AI logic triggered after user moves.
# How to Run
Clone Repository

bash
Copy code
git clone https://github.com/yourusername/AndroidTicTacToe-Tutorial2.git  
cd AndroidTicTacToe-Tutorial2  
Import Project
Open the project in Android Studio/Eclipse.

Configure Emulator

Open Android Virtual Device (AVD) Manager.
Create a new AVD targeting Android 2.2 (Froyo).
Run the App

Start the emulator.
Press Ctrl+F11 or use the Run button to deploy the app.

Gameplay
AI moves are displayed immediately after the human player.

End Game
Status updates show the game outcome (win, lose, or tie).

# Future Improvements
Add difficulty levels for AI.
Allow two-player mode.
Improve UI aesthetics.
Add sound effects.

# Author
This project was modified by Linah Kageni Njeru as part of the Mobile Programming coursework at Maseno University.

