package code;

public class Game {
	private int sticks = 20;

	public Object getSticksLeft() {
		// TODO Auto-generated method stub
		return sticks;
	}
	
	public boolean takeSticks(int i) {
		if(i == 20){
			return false;
		}
		sticks -= i;
		// TODO Auto-generated method stub
		return true;
	}

}
