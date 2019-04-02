public interface IState {
	public int getWriting(int contentRead);
	public IState nextState(int contentRead);
	public char getDir(int contentRead);
}