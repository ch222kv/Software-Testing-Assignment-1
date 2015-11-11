package code;

public class Game {
	private int sticks = 20;

	public int getSticksLeft() {
		// TODO Auto-generated method stub
		return sticks;
	}
	
	public boolean takeSticks(int i) {
		if(i > sticks){
			return false;
		}
		sticks -= i;
		// TODO Auto-generated method stub
		return true;
	}

	public boolean hasEnded() {
		// TODO Auto-generated method stub
		return false;
	}

}
