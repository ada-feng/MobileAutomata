public class Q11 implements IState {
	int DELTA = 2;
	int BLACK = 1;
	int WHITE = 0;

	public int getWriting(int contentRead) {
		// if (contentRead == WHITE) {
		// 	return BLACK;
		// }
		 if (contentRead == BLACK) {
			return BLACK;
		}
		else if (contentRead == DELTA) {
			return DELTA;
		}
		else {
			return -1;
		}
	}

	public IState nextState(int contentRead) {
		// if (contentRead == WHITE) {
		// 	return ((IState)new Q1());
		// }
		// else
		if (contentRead == BLACK) {
			return ((IState)new Q12());
		}
		else if (contentRead == DELTA) {
			return ((IState)new Q12());
		}
		else {
				System.out.println("wrong read");
			return (IState)new Q1(); //should not be reached
		}
	}
	public char getDir(int contentRead) {
		// if (contentRead == WHITE) {
		// 	return 'R';
		// }
		 if (contentRead == BLACK) {
			return 'R';
		}
		else if (contentRead == DELTA) {
			return 'R';
		}
		else {
			return 'R'; //should not be reached
		}
	}
}
