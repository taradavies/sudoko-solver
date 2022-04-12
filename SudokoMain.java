
public class SudokoMain {
	public static void main(String[] args) {
		SudokoBoard b = new SudokoBoard();
		SudokoSolver s = new SudokoSolver(b);
		
		System.out.println("Pre: ");
		b.printBoard();
		
		s.solve();
		System.out.println("Post: ");
		b.printBoard();
		
	}
}
