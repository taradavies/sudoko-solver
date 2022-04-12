
public class SudokoBoard {
	
	private int rowPos;
	private int colPos;
	
	private int[][] puzzle = {
			{5, 3, 0, 0, 7, 0, 0, 0, 0}, 
			{6, 0, 0, 1, 9, 5, 0, 0, 0},
			{0, 9, 8, 0, 0, 0, 0, 6, 0},
			{8, 0, 0, 0, 6, 0, 0, 0, 3},
			{4, 0, 0, 8, 0, 3, 0, 0, 1},
			{7, 0, 0, 0, 2, 0, 0, 0, 6},
			{0, 6, 0, 0, 0, 0, 2, 8, 0},
			{0, 0, 0, 4, 1, 9, 0, 0, 5},
			{0, 0, 0, 0, 8, 0, 0, 7, 9},
	};
	
	/*\
	 * Answer:
	     	{5, 3, 4, 6, 7, 8, 9, 1, 2}, 
			{6, 7, 2, 1, 9, 5, 3, 4, 8},
			{1, 9, 8, 3, 4, 2, 5, 6, 7},
			{8, 5, 9, 7, 6, 1, 4, 2, 3},
			{4, 2, 6, 8, 5, 3, 7, 9, 1},
			{7, 1, 3, 9, 2, 4, 8, 5, 6},
			{9, 6, 1, 5, 3, 7, 2, 8, 4},
			{2, 8, 7, 4, 1, 9, 6, 3, 5},
			{3, 4, 5, 2, 8, 6, 1, 7, 9},
	  
	*/
	
	public void printBoard() {
		for (int cols = 0; cols < puzzle.length; cols++) {
			
			if (cols % 3 == 0 && cols != 0) {
				System.out.println(" - - - - - - - - - - - - ");
			}
			
			for (int rows = 0; rows < puzzle[0].length; rows++) {
				
				if (rows % 3 == 0) {
					System.out.print("| ");
				}
				
				if (rows == 8) {
					System.out.println(puzzle[cols][rows]);
				}
				else {
					System.out.print(puzzle[cols][rows] + " ");
				}
			}
		}
	}
	
	public boolean findEmpty() {
		for (int cols = 0; cols < puzzle.length; cols ++) {
			for (int rows = 0; rows < puzzle[0].length; rows++) {
				if (puzzle[cols][rows] == 0) {
					rowPos = rows;
					colPos = cols;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isValid(int num) {
		
		if (!findEmpty() ) {
			return false;
		}
		
		int[] posArr = {colPos, rowPos};
		
		// posArr[0] --> cols
		// posArr[1] --> rows
		
		if (checkRows(num, posArr) && checkColumns(num, posArr) && checkBox(num, posArr))
			return true;
		return false;
	}
	
	private boolean checkRows(int num, int[] posArr) {
		for (int i = 0;  i < puzzle[0].length; i++) {
			// pos[0] != i means that we're looking for if the number is in the row
			// but not the number we just inserted
			if (puzzle[posArr[1]][i] == num && posArr[0] != i) 
				return false;
		}
		return true;
	}
	
	
	private boolean checkColumns(int num, int[] posArr) {
		for (int j = 0; j < puzzle.length; j++) {
			if (puzzle[j][posArr[0]] == num && posArr[1] != j) 
				return false;
		}
		return true;
	}
	
	private boolean checkBox(int num, int[] posArr) {
		
		int boxRow = posArr[1] / 3;
		int boxColumn = posArr[0] / 3;
		
		for (int cols = boxColumn * 3; cols < boxColumn*3 + 3; cols++) {
			for (int rows = boxRow * 3; rows < boxRow*3 + 3; rows++) {
				if (puzzle[cols][rows] == num) {
					return false;
				}
			}
		}
		return true;
	}

	public int getColPos() {
		return colPos;
	}
	
	public int getRowPos() {
		return colPos;
	}
	
	public int[][] getPuzzle() {
		return puzzle;
	}
	
}
