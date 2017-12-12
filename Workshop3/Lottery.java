import java.util.*;

public class Lottery {

		private int pick;
		private int winningNumber;
		private ArrayList<Integer> userPick = new ArrayList<Integer>();
		private ArrayList<Integer> winningPick = new ArrayList<Integer>();
		
		
		void setPick(int pick)   { this.pick = pick; }
		int  getPick()           { return this.pick; }
		int  getWinningNumber()  { return this.winningNumber; }
		ArrayList<Integer> getUserPick() { return this.userPick; }
		ArrayList<Integer> getWinningPick() { return this.winningPick; }
		
		
		//set userPick
		void setUserDigits(int number) {
			int digitOne = number / 100;
			userPick.add(digitOne);
			int digitTwo = ((number/ 10) % 10);
			userPick.add(digitTwo);
			int digitThree = number/((int)(Math.pow(10,(int)Math.log(number))));
			userPick.add(digitThree);
		}
		
		//set winningPick
		void setWinningDigits(int number) {
			int digitOne = number / 100;
			winningPick.add(digitOne);
			int digitTwo = ((number/ 10) % 10);
			winningPick.add(digitTwo);
			int digitThree = ((((number/10))/10) % 10);
			winningPick.add(digitThree);
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
			int count = 0;
			ArrayList<Integer> playPicks = new ArrayList<Integer>();
			//set user and winning picks
			setUserDigits(getPick());
			setWinningDigits(getWinningNumber());
			
			System.out.println("Your pick is: " + getPick());
			System.out.println("The winning number is: " + getWinningNumber());
			
		
			
			//gather a count of matching numbers
			for (Integer number: getUserPick()) {
				if (getWinningPick().contains(number)) {
					count++;
				}
			}
			
			//all matching numbers are in correct order
			
			if(getUserPick().equals(getWinningPick())) {
				System.out.println("Congratulations, you got the winning number correct. You're prize is $10,000");
			}
			
			else if (count == 1) {
				System.out.println("Congratulations, you got one number correct. You're prize is $1000");
			}
			
			else if (count == 2) {
				System.out.println("Congratulations, you got two numbers correct. You're prize is $2000");
			}
			
			else if (count == 3) {
				System.out.println("Congratulations, you got two numbers correct. You're prize is $2000");
			}
			
		
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
