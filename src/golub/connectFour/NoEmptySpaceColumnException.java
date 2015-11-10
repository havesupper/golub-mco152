package golub.connectFour;

public class NoEmptySpaceColumnException extends Exception {
	

	private static final long serialVersionUID = 1L;

	public NoEmptySpaceColumnException(){
		super("All spots in column filled.");
	}

}
