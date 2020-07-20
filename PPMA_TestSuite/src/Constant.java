
public class Constant {

	public static int randomNumber = 0;
	public static String userName = "suleman";
	public static String userPassword = "suleman@123";

	public static void generateRandomNumber() {
		int random1 = (int) (Math.random() * 100 + 0);
		randomNumber = random1;
	}
	

}
