
public class LotteryException extends Exception {
	
	LotteryException(int n){
		if (n < 0)   { System.out.println("Your pick must greater than 0"); }
		if (n > 999) { System.out.println("Your pick must be less than 1000"); }
	}
}
