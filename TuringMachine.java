import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TuringMachine {
	int DELTA = 2;
	int BLACK = 1;
	int WHITE = 0;
	BufferedImage tape;
	IState curr_state;
	int x_position;
	int y_position;

	public int read() {
		Color curr_color=new Color(tape.getRGB(x_position,y_position));
		if (curr_color.getRed()>200 && curr_color.getBlue()<50 && curr_color.getGreen()<50) {
			return DELTA;
		}
		else if (curr_color.getRed()<50 && curr_color.getBlue()<50 && curr_color.getGreen()<50) {
			return BLACK;
		}
		else if (curr_color.getRed()>200 && curr_color.getBlue()>200 && curr_color.getGreen()>200) {
			return WHITE;
		}
		else {
			return -1;
		}
	}

	public void write(int writing) {
		if (writing == BLACK) {
			tape.setRGB(x_position,y_position,0x000000);
		}
		else if (writing == WHITE) {
			tape.setRGB(x_position,y_position,0xffffff);
		}
		else if (writing == DELTA) {
			tape.setRGB(x_position,y_position,0xff0000);
		}
	}

	public void next(char direction) {


	//	System.out.print(direction);
		if(direction=='U'){
			y_position--;
		}else if(direction=='D') {
			y_position++;
		}else if(direction=='L') {
			x_position--;
		}else if(direction=='R') {
			x_position++;
		}
	}


	public static void main(String[] args) throws IOException {
		TuringMachine tm = new TuringMachine();
		tm.tape=new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
		for (int i1=0; i1< tm.tape.getWidth();i1++){
			tm.tape.setRGB(i1,0,0xff0000);
			tm.tape.setRGB(i1,299,0xff0000);
		}
		for (int i2=0; i2< tm.tape.getHeight();i2++){
			tm.tape.setRGB(0,i2,0xff0000);
			tm.tape.setRGB(299,i2,0xff0000);
		}
		 for (int i=1; i<299; i++){
		 	for (int j=1; j<299; j++){
		 		tm.tape.setRGB(i,j,0xffffff);
		 	}
		 }

		tm.x_position = tm.tape.getWidth()/2;
		tm.y_position = tm.tape.getHeight()/2;
		tm.curr_state = (IState) new Q1();
		for (int i = 0; i<10000; i++) {
			int contentRead;
			/*
			if(x_position<0||y_position<0){  //should not be reached
				System.out.println("!!!");
				break;
			}
			*/
			try{
				contentRead = tm.read();
				int wrtingGot = tm.curr_state.getWriting(contentRead);
				tm.write(wrtingGot);
				char dirGot = tm.curr_state.getDir(contentRead);
				//System.out.print(dirGot);
				tm.next(dirGot);
			}catch(ArrayIndexOutOfBoundsException e){
				break;
			}

			// if(tm.x_position>299){
			// 	tm.x_position--;
			// }
			// if(tm.y_position>299){
			// 	tm.y_position--;
			// }
			// if(tm.x_position<0){
			// 	tm.x_position++;
			// }
			// if(tm.y_position<0){
			// 	tm.y_position++;
			// }
			tm.curr_state = tm.curr_state.nextState(contentRead);
		}
		ImageIO.write(tm.tape, "png", new File("pattern1.png"));
	}
}
