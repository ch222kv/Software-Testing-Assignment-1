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
		if(sticks == 0){
			return true;
		}
		return false;
	}

	public void beginGame() {
		sticks = 20;
		
	}

}
