public class Q3 implements IState {
	int DELTA = 2;
	int BLACK = 1;
	int WHITE = 0;

	public int getWriting(int contentRead) {
		if (contentRead == WHITE) {
			return BLACK;
		}
		// else if (contentRead == BLACK) {
		// 	return WHITE;
		// }
		else if (contentRead == DELTA) {
			return DELTA;
		}
		else {
			return -1;
		}
	}
	public IState nextState(int contentRead) {
		if (contentRead == WHITE) {
			return ((IState)new Q1());
		}
		// else if (contentRead == BLACK) {
		// 	return ((IState)new Q5());
		// }
		else if (contentRead == DELTA) {
			return ((IState)new Q1());
		}
		else {
				System.out.println("wrong read");
			return (IState)new Q1(); //should not be reached
		}
	}
	public char getDir(int contentRead) {
		if (contentRead == WHITE) {
			return 'U';
		}
		// else if (contentRead == BLACK) {
		// 	return 'D';
		// }
		else if (contentRead == DELTA) {
			return 'U';
		}
		else {
			return 'R'; //should not be reached
		}
	}
}
