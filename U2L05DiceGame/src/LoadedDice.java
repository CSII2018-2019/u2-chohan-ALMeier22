
public class LoadedDice extends Dice {

	public LoadedDice(int sides) {
		super(sides);
	}
	
	public int roll() {
		int number = super.roll();
		if (number % 2 == 0) {
			// roll again if even since we prefer odd
			return number;
		}
		return super.roll();
	}
	
}
