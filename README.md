# final-proj_Tim_Ashley_Mike
Ultimate Tic-Tac-Toe game v1.0

Authors:
Timmy Hartke,
Ashley Douglas,
Mike Sims

We are creating this project for our CS222 class. This is the final iteration of the project. Some new features of this iteration include:

1. A fully functioning Ultimate Tic Tac Toe game. Some of the rules include:

a. The piece played before the current turn dictates where the current player can play. For example, if X plays in the top right quadrent of a board, O must play in the top right board of the playing field for their turn.

b. If a player is sent to a board that has already been won or tied, that player can play in any free space on the board

c. If a player wins three boards in a row horizontally, vertically, or diagonally, they win the game.


2. An AI with easy, medium, and hard difficulties

The easy AI is simply a random number generator that selects an open space to play

The medium AI is a random number generator that picks between the easy and hard difficulty

The hard AI uses a bit more strategy than the other two. If the center of a board is open, the hard AI plays in that space. If the AI is one space away from winning, the AI will play in that space. Otherwise, it resorts to a random number generator to pick a place to play. 

