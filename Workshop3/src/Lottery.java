import java.util.*;

public class Lottery {
	
		private int pick;
		private int winningNumber;
		private Set<Integer> userPick;
		private Set<Integer> winningSet;
		
		
		void setPick(int pick)   { this.pick = pick; }
		int  getPick()           { return this.pick; }
		int  getWinningNumber()  { return this.winningNumber; }
		
		void setUserPick(int pick) {
			while(pick > 0) {
				
			}
		}
		
		void start() throws LotteryException {
			
			
			Scanner in = new Scanner(System.in);
			Random rnd = new Random();
			//random number from 1 to 999 (addition of 1 is to prevent 0 and 1000)
			winningNumber = rnd.nextInt(998) + 1;
			
			//get a value from user
			System.out.println("Please enter your choice: ");
			setPick(in.nextInt());
			
			//error check their pick
			if (getPick() < 0) {
				throw new LotteryException(pick);
			}
			if (getPick() > 999) {
				throw new LotteryException(pick);
			}
			//if pick is valid
			else {
				isWinner();
			}
		}
		
		void isWinner() {
			//all matching numbers are in correct order
			
			if(getWinningNumber() == getPick()) {
				System.out.println("Congratulations, you got the winning number correct. You're prize is $10,000");
			}
			
			//all numbers are correct
			if
			
			//one digit is correct
			
		}
		
		
		
		
		
		public static void main (String[] args) {
			Lottery l = new Lottery();
			
			try {
				l.start();
			}
			catch(LotteryException e) {
				System.out.println(e);
			}
			
		
		
	}
}
