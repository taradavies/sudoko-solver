
public class SudokoMain {
	public static void main(String[] args) {
		/*
			you should have full name for var names
			it good for understanding and reading code
			for example you can return here in future
			SudokoBoard now reusable you can send diffrent puzzles
		*/
		SudokoBoard board = new SudokoBoard(MockData.PUZZLES);
		SudokoSolver sudokoSolver = new SudokoSolver(board);
		
		System.out.println("Pre: ");
		board.printBoard();
		
		sudokoSolver.solve();
		System.out.println("Post: ");
		board.printBoard();
		
	}
}
