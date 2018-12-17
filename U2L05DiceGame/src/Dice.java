import java.util.Random;

public class Dice {
	private int sides;
	
	public Dice(int sides) {
		setSides(sides);
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
	
	public int roll() {
		Random r = new Random();
		int num = r.nextInt(getSides()) + 1;
		return num;
	}
	
	public String toString() {
		return "Dice with " + getSides() + " sides";
	}
}
