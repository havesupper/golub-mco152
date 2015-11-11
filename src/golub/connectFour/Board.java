package golub.connectFour;

public class Board {

	private int[][] gameBoard;

	public Board() {
		gameBoard = new int[6][7];
	}

	public void move(int player, int column) throws NoEmptySpaceColumnException {

		// check if column is full
		if (gameBoard[0][column] != 0) {
			throw new NoEmptySpaceColumnException();
		}

		// if column is partially full- put in bottom most
		// available space
		else {
			for (int i = 5; i >= 0; i--) {
				if (gameBoard[i][column] == 0) {
					gameBoard[i][column] = player;
					break;
				}
			}
		}
	}

	public boolean isWinner() {
		boolean winner = false;

		// check if four values are consecutive horizontally
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length - 3; column++) {
				if (gameBoard[row][column] == gameBoard[row][column + 1]
						&& gameBoard[row][column + 1] == gameBoard[row][column + 2]
						&& gameBoard[row][column + 2] == gameBoard[row][column + 3] && gameBoard[row][column] != 0) {
					winner = true;
					break;
				}
			}
		}

		// check if four values are consecutive vertically
		if (winner == false) {
			for (int row = 0; row < gameBoard.length - 3; row++) {
				for (int column = 0; column < gameBoard[row].length; column++) {

					if (gameBoard[row][column] == gameBoard[row + 1][column]
							&& gameBoard[row + 1][column] == gameBoard[row + 2][column]
							&& gameBoard[row + 2][column] == gameBoard[row + 3][column]
							&& gameBoard[row][column] != 0) {
						winner = true;
						break;
					}
				}
			}
		}

		// check if four values are diagonal
		if (winner == false) {
			for (int row = 0; row < gameBoard.length - 3; row++) {
				for (int column = 0; column < gameBoard[row].length - 3; column++) {

					if ((gameBoard[row][column] == gameBoard[row + 1][column + 1]
							&& gameBoard[row + 1][column + 1] == gameBoard[row + 2][column + 2]
							&& gameBoard[row + 2][column + 2] == gameBoard[row + 3][column + 3]
							&& gameBoard[row][column] != 0)|| (gameBoard[row][column + 3] == gameBoard[row + 1][column + 2]
									&& gameBoard[row + 1][column + 2] == gameBoard[row + 2][column + 1]
											&& gameBoard[row + 2][column + 1] == gameBoard[row + 3][column]
											&& gameBoard[row][column+3] != 0)) {
						winner = true;
						break;
					}
				}
			}
		}
		return winner;
	}

	public void display() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.print("\n");
		}
	}

	public void reset() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				gameBoard[i][j] = 0;
			}
		}
	}

}
