import java.awt.Point;

public class SudokoBoard {
	public static final int BOARD_SIZE = 9;
	private static final int EMPTY_CHAR = 0;
	
	// we can use something like Point.
	// where x = row; y = column :). Or you can create own object
	// it will easier to return in method current position
	// private int rowPos;
	// private int colPos;

	Point currentPosition = new Point();
	int[][] puzzles;

	public SudokoBoard(int[][] puzzles) {
		this.puzzles = puzzles;
	}
	
	public void printBoard() {
		for (int column = 0; column < puzzles.length; column++) {
			
			if (column % 3 == 0 && column != 0) {
				System.out.println(" - - - - - - - - - - - - ");
			}
			
			for (int row = 0; row < puzzles[0].length; row++) {
				
				if (row % 3 == 0) {
					System.out.print("| ");
				}
				
				if (row == 8) {
					System.out.println(puzzles[column][row]);
				}
				else {
					System.out.print(puzzles[column][row] + " ");
				}
			}
		}
	}
	
	// for example here you can return position Point(row, column) where you found empty char
	public Point foundEmpty() {
		for (int column = 0; column < puzzles.length; column++) {
			for (int row = 0; row < puzzles[column].length; row++) {
				if (puzzles[column][row] == EMPTY_CHAR) {
					return new Point(row, column);
				}
			}
		}
		/* 
		another solution to use modern way "Optional"
		when you didn't find point return nil
		when you found point return Point in for
		*/
		return new Point();
	}

	public boolean wasFoundEmpty() {
		for (int column = 0; column < puzzles.length; column++) {
			for (int row = 0; row < puzzles[column].length; row++) {
				if (puzzles[column][row] == EMPTY_CHAR) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isValid(int num) {
		
		if (!wasFoundEmpty() ) {
			return false;
		}
		
		int[] posArr = {currentPosition.x, currentPosition.y};
		
		// posArr[0] --> column
		// posArr[1] --> row
		
		if (checkRows(num, posArr) && checkColumns(num, posArr) && checkBox(num, posArr))
			return true;
		return false;
	}
	
	private boolean checkRows(int num, int[] posArr) {
		for (int i = 0;  i < puzzles[0].length; i++) {
			// pos[0] != i means that we're looking for if the number is in the row
			// but not the number we just inserted
			if (puzzles[posArr[1]][i] == num && posArr[0] != i) 
				return false;
		}
		return true;
	}
	
	
	private boolean checkColumns(int num, int[] posArr) {
		for (int j = 0; j < puzzles.length; j++) {
			if (puzzles[j][posArr[0]] == num && posArr[1] != j) 
				return false;
		}
		return true;
	}
	
	private boolean checkBox(int num, int[] posArr) {
		
		int boxRow = posArr[1] / 3;
		int boxColumn = posArr[0] / 3;
		
		for (int column = boxColumn * 3; column < boxColumn*3 + 3; column++) {
			for (int row = boxRow * 3; row < boxRow*3 + 3; row++) {
				if (puzzles[column][row] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public int getColumnPos() {
		return currentPosition.x;
	}
	
	public int getRowPos() {
		return currentPosition.y;
	}
	
	public int[][] getPuzzle() {
		return puzzles;
	}
	
}
