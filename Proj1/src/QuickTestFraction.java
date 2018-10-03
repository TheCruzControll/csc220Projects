import PJ1.*;

class QuickTestFraction
{

	public static void main(String[] args)
	{
		FractionInterface firstOperand = null;
		FractionInterface secondOperand = null;
		FractionInterface result = null;

		firstOperand = new Fraction(-12, -20);
		System.out.println("Input numerator & denominator: -12 & -20");
		System.out.println("\t\tResult Fraction:" + firstOperand);
		secondOperand = new Fraction();
		secondOperand.setFraction(90, -40);
		System.out.println("input setFraction: 90 & -40");
		System.out.println("\t\tResult Fraction:" + secondOperand);
		result = firstOperand.add(secondOperand);
		System.out.println("The sum of " + firstOperand + " and " +
				secondOperand + " is \n\t\t" + result);

	}	// end main
} // end Fraction

