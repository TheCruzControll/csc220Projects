
import PJ1.*;

public class QuickTest 
{
	public static void compute(MixedNumberInterface firstOperand, MixedNumberInterface secondOperand)
	{
		MixedNumberInterface result = null;
		System.out.println(firstOperand + " and " + secondOperand);
		result = firstOperand.addMixedNumber(secondOperand);
		System.out.println("+ : " + result);
		result = firstOperand.subtractMixedNumber(secondOperand);
		System.out.println("- : " + result);
		result = firstOperand.multiplyMixedNumber(secondOperand);
		System.out.println("* : " + result);
		result = firstOperand.divideMixedNumber(secondOperand);
		System.out.println("/ : " + result);
	}


	public static void main(String[] args)
	{
		MixedNumberInterface firstOperand = null;
		MixedNumberInterface secondOperand = null;


		// 7/8,  9/16
		firstOperand  = new MixedNumber(0,new Fraction(7, 8));
		secondOperand = new MixedNumber(0,new Fraction(9, 16));
		System.out.println("=========================");
		compute(firstOperand,secondOperand);

		//-7/8,  -9/16
		firstOperand  = new MixedNumber(0,new Fraction(-7, 8));
		secondOperand = new MixedNumber(0,new Fraction(9, -16));
		System.out.println("=========================");
		compute(firstOperand,secondOperand);

		// -7 1/2,  5 1/4
		firstOperand.setMixedNumber(-7, 1, 2);
		secondOperand = new MixedNumber(5, new Fraction(1, 4));
		System.out.println("=========================");
		compute(firstOperand,secondOperand);

		// -10 1/2,  -3/7
		firstOperand  = new MixedNumber(-10, new Fraction(1, 2));
		secondOperand.setMixedNumber(0, new Fraction(-3, 7));
		System.out.println("=========================");
		compute(firstOperand,secondOperand);

		// 7 1/2 + -1 7/8
		firstOperand.setMixedNumber(7, 1, 2);
		secondOperand.setMixedNumber(-1, 7, 8);
		System.out.println("=========================");
		compute(firstOperand,secondOperand);


		// 7 10/2 + -1 70/8
		firstOperand.setMixedNumber(7, 10, 2);
		secondOperand.setMixedNumber(-1, 70, 8);
		System.out.println("=========================");
		compute(firstOperand,secondOperand);

		firstOperand.setMixedNumber(7, 1, 2);
		secondOperand.setMixedNumber(-1, 7, 8);
		// equality check
		System.out.println("=========================");
		System.out.println(firstOperand + " equals " + firstOperand + "?");
		if (firstOperand.equals(firstOperand))
			System.out.println("Identity of mixed numbers OK");
		else
			System.out.println("ERROR in identity of mixed numbers");

		secondOperand.setMixedNumber(0, -15, -2);
		System.out.println("=========================");
		System.out.println(firstOperand + " equals -15/-2?");
		if (firstOperand.equals(secondOperand))
			System.out.println("Equality of mixed numbers OK");
		else
			System.out.println("ERROR in equality of mixed numbers");

		// comparison check
		System.out.println("=========================");
		MixedNumber first  = (MixedNumber)firstOperand;
		MixedNumber second = (MixedNumber)secondOperand;
		
		System.out.println(first+ " compareTo " + second+ "?");
		if (first.compareTo(second) == 0)
			System.out.println("Mixed numbers == operator OK");
		else
			System.out.println("ERROR in mixed numbers == operator");

		first.setMixedNumber(2, 1, 2);
		second.setMixedNumber(2, 7, 8);
		System.out.println("=========================");
		System.out.println(first+ " compareTo " + second+ "?");
		if (first.compareTo(second) < 0)
			System.out.println("Mixed numbers < operator OK");
		else
			System.out.println("ERROR in fractions < operator");

		System.out.println("=========================");
		System.out.println(second + " compareTo " + first + "?");
		if (second.compareTo(first) > 0)
			System.out.println("Mixed numbers > operator OK");
		else
			System.out.println("ERROR in mixed numbers > operator");

		System.out.println("=========================");
		firstOperand  = new MixedNumber(0,new Fraction(0, 8));
		secondOperand = new MixedNumber(0,new Fraction(0, 90));
		try {
			firstOperand.divideMixedNumber(secondOperand);
		} catch (Project1Exception o) {
			System.out.println("Exception! "+ o.getMessage());
		}

		System.out.println("=========================");
		try {
			secondOperand = new MixedNumber(0,new Fraction(15,0));
		} catch (Project1Exception o) {
			System.out.println("Exception! "+ o.getMessage());
		}
	}	// end main
}
