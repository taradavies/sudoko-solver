import java.awt.Point;

public class SudokoSolver {
	SudokoBoard board;
	int boardSize;
	
	public SudokoSolver(SudokoBoard board) {
		this.board = board;
	}
	
	// public boolean solve() {
	// 	// board is full can't find empty
	// 	if (!board.wasFoundEmpty()) {
	// 		return true;
	// 	}
	// 	// we should count it form 0 better
	// 	// you should get used to it
	// 	for (int x = FIRST_INDEX; x <= BOARD_SIZE; x++) {
	// 		if (board.isValid(x)) {
				
	// 			board.getPuzzle()[board.getColumnPos()][board.getRowPos()] = x;
				
	// 			if (solve()) 
	// 				return true;
	// 			else 
	// 				board.getPuzzle()[board.getColumnPos()][board.getRowPos()] = 0;	
	// 		}
	// 		return false;
	// 	}
	// 	return true;
	// }
	
	public boolean solve() {
		return false;
	}
	
}
