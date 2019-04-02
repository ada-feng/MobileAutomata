public class Q4 implements IState {
	int DELTA = 2;
	int BLACK = 1;
	int WHITE = 0;

	public int getWriting(int contentRead) {
		// if (contentRead == WHITE) {
		// 	return WHITE;
		// }
		// else
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
		// 	return ((IState)new Q4());
		// }
		// else
		if (contentRead == BLACK) {
			return ((IState)new Q6());
		}
		else if (contentRead == DELTA) {
			return ((IState)new Q6());
		}
		else {
			System.out.println("wrong read");
			return (IState)new Q1(); //should not be reached
		}
	}
	public char getDir(int contentRead) {
		// if (contentRead == WHITE) {
		// 	return 'L';
		// }
		// else
		if (contentRead == BLACK) {
			return 'D';
		}
		else if (contentRead == DELTA) {
			return 'D';
		}
		else {
			return 'R'; //should not be reached
		}
	}
}
