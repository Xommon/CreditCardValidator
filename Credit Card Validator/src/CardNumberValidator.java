
public class CardNumberValidator {
	public static void main(String []args)
	{
        Validate("4347691210788352");
    }
	
	private static Boolean Validate(String input) 
	{
		if (input.length() > 16) 
		{
			System.out.print("Invalid credit card number: number is too long.");
			return false;
		}
		else if (input.length() < 16) 
		{
			System.out.print("Invalid credit card number: number is too short.");
			return false;
		}
		
		// Convert input to int
		int[] creditCardInt = new int[input.length()];
		
		for (int i = 0; i < input.length(); i++) 
		{
			creditCardInt[i] = Integer.parseInt(input.substring(i, i + 1));
		}
		
		// Starting from right, double each other digit
		for (int i = creditCardInt.length - 2; i >= 0; i = i - 2) 
		{
			int tempValue = creditCardInt[i];
			tempValue = tempValue * 2;
			if (tempValue > 9) {
				tempValue = tempValue % 10 + 1;
			}
			creditCardInt[i] = tempValue;
		}
		
		// Add up all digits
		int total = 0;
		for (int i = 0; i <creditCardInt.length; i++) 
		{
			total += creditCardInt[i];
		}
		
		// Check if number is a multiple of 10
		if (total % 10 == 0) 
		{
			System.out.print("Valid credit card number.");
			return true;
		}
		else
		{
			System.out.print("Invalid credit card number.");
			return false;
		}
	}
}
