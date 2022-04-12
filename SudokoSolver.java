
public class SudokoSolver {
	
	SudokoBoard b;
	
	public SudokoSolver(SudokoBoard b) {
		this.b = b;
	}
	
	public boolean solve() {
		// board is full can't find empty
		if (!b.findEmpty()) {
			return true;
		}
		
		for (int x = 1; x <= 9; x++) {
			if (b.isValid(x)) {
				
				b.getPuzzle()[b.getColPos()][b.getRowPos()] = x;
				
				if (solve()) 
					return true;
				else 
					b.getPuzzle()[b.getColPos()][b.getRowPos()] = 0;	
			}
			return false;
		}
		return true;
	}
	
}
