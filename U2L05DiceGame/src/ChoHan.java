import javax.swing.JOptionPane;
import java.util.Random;

public class ChoHan {

	private int rounds;
	private Dice[] dice;
	private int pointsPlayer1;
	private int pointsPlayer2;

	ChoHan(int rounds) {
		Random r = new Random();
		setRounds(rounds);
		dice = new Dice[5];
		for(int i=0; i<dice.length; i++) {
			if(r.nextInt(2) == 0) {
				dice[i] = new Dice(6);				
			}
			else {
				dice[i] = new LoadedDice(6);
			}
		}
	}
	
	public int getRounds() {
		return rounds;
	}


	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public void play() {
		pointsPlayer1 = 0;
		pointsPlayer2 = 0;
		for(int r=0; r<getRounds(); r++) {
			playRound(r);
		}
		if(pointsPlayer1 > pointsPlayer2) {
			System.out.println("Player 1 won !!!");
		}
		else if (pointsPlayer2 > pointsPlayer1) {
			System.out.println("Player 2 won !!!");
		}
		else {
			System.out.println("Its a tie !!!");
		}
	}
	
	private void playRound(int round) {
		System.out.println("Round " + round);
		
		String answer1 = JOptionPane.showInputDialog("Round " + round + ":  Player1 - odd or even ?");
		String answer2 = JOptionPane.showInputDialog("Round " + round + ":  Player2 - odd or even ?");
		
		System.out.println("Player 1 guesses " + answer1);
		System.out.println("Player 2 guesses " + answer2);
		
		int sum = 0;
		for(int d=0; d<dice.length; d++) {
			int number = dice[d].roll();
			sum = sum + number;
			System.out.println("dice " + d + " has a value of " + number);
		}
		boolean isEven = (sum % 2 == 0);
		if(isEven) {
			System.out.println("the sum is Cho");
			if(answer1.equals("even")) {
				pointsPlayer1 = pointsPlayer1 + 1;
			}
			if(answer2.equals("even")) {
				pointsPlayer1 = pointsPlayer2 + 1;
			}
		}
		else {
			System.out.println("the sum is Han");
			if(answer1.equals("odd")) {
				pointsPlayer1 = pointsPlayer1 + 1;
			}
			if(answer2.equals("odd")) {
				pointsPlayer1 = pointsPlayer2 + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		ChoHan game = new ChoHan(5);
		game.play(); 

	}

}
