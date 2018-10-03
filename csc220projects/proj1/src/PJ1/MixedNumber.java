/**
 *********************************************************************************
 *
 * This class represents a mixed number which consist of sign (+ or -),integer 
 * and fraction parts of a number. Example: -10 3/5, 0 1/2, -0 3/4, 4 5/6
 * 
 * Requirements:
 * 1. Implement interfaces: MixedNumberInterface and Comparable (i.e. compareTo())
 * 2. Implement methods equals() and toString() from class Object
 * 3. Must work for both positive and negative mixed numbers
 *    Example: -3 5/6, -3 -5/-6, 0 -4/5, 0 4/-5
 *             are valid mixed numbers, all with sign '-'
 *             -3 -5/6, 3 -4/5, 3 4/-5 are invalid mixed numbers
 * 4. Must reduce to mixed number to lowest term, e.g. -3 14/4 --> -6 1/2 
 * 5. Must reduce result mixed number to lowest term for operations 
 *    add, subtract, multiply and divide, e.g. see test cases
 * 6. For input such as -2 -3/-10,  2 -3/-10 and 0 -4/-5 must convert them to 
 *    -2 3/10, 2 3/10 and 0 4/5 respectively 
 * 7. Must throw only Project1Exception in case of errors or invalid mixed numbers
 * 8. Must not add new or modify existing data fields
 * 9. Must not add new public methods
 * 10.May add private methods
 *
 * Hints:
 *
 * 1. You need to downcast reference parameter MixedNumberInterface to 
 *    MixedNumber if you want to use it as MixedNumber. 
 *    See add, subtract, multiply and divide methods
 *
 * 2. You need to downcast reference parameter FractionInterface to Fraction if  
 *    you want to use it as Fraction. 
 *
 * 3. Use "this" to access this object if it is needed
 *
 * 4. Use given Fraction class to simplify MixedNumber class implementations
 *    4.1 Fraction class always reduce fraction object to lowest term. 
 *        12/8 --> 3/2
 *    4.2 Fraction class always set denominator to > 0 and 
 *        numerator to +/- values.  Example: 3/-2 or -3/2 --> -3/2
 *    4.3 Look at Fraction interface for operations
 *    4.4 Additional Operations:
 *
 *        public Fraction()
 *        public Fraction(int num, int den)
 *        public boolean equals(Object other)
 *        public int compareTo(Fraction other)
 *        public String toString()    
 *
 ************************************************************************************/


package PJ1;

public class MixedNumber implements MixedNumberInterface, Comparable<MixedNumber>
{
        // Fields:

	// both integer and fraction parts are forced to >= 0
	// sign of a mixed number is stored as '+' or '-'
	private char              sign;	    // '+' or '-'
	private int               intPart;  // whole number portion >= 0
	private FractionInterface fracPart; // fraction portion in lowest terms >= 0


        // Methods:

	public MixedNumber()
	{
		setMixedNumber(0, 0, 1);
	}	// end default constructor


	public MixedNumber(int integerPart, int fracPartNumerator, 
			   int fracPartDenominator)
	{
		setMixedNumber(integerPart, fracPartNumerator, fracPartDenominator);
	}	// end constructor

	public MixedNumber(int integerPart, FractionInterface fractionPart)
	{
		setMixedNumber(integerPart, fractionPart);
	}	// end constructor


	public void setMixedNumber(int integerPart, FractionInterface fractionPart)
	{
            // add statements
            // set this object to the given values
            // make sure to reduce to lowest term
            // check for exception cases
            intPart = integerPart;
            fracPart = fractionPart;
            reduceToLowestForm(intPart, fracPart);
        }       // end setMixedNumber


	// check for exception cases
	public void setMixedNumber(int integerPart, 
		int fracPartNumerator, int fracPartDenominator)
	{
                // add statements
                // set this object to the given values
                // make sure to reduce to lowest term
                // check for exception cases
            intPart = integerPart;
            fracPart = new Fraction();
            fracPart.setFraction(fracPartNumerator, fracPartDenominator);
            reduceToLowestForm(intPart, fracPart);
        }       // end setMixedNumber

	public int getIntegerPart()
	{
                // add statements
	        // retrieve integer portion with correct (+ or -) sign 
            if (fracPart.getSign() == '-' && (intPart>1)){
		return (intPart*(-1));
            }
            else if (fracPart.getSign() == '+' && (intPart<1)){//Will a positive Fraction have a + or will it be normal?
                return (intPart*(-1));
            }
            else{
                return intPart;
            }
        }	// end getInteger

	public FractionInterface getFractionPart()
	{
                // add statements
	        // retrieve fraction portion, always + sign
		return fracPart;
	}	// end getFraction

	public MixedNumberInterface addMixedNumber(MixedNumberInterface operand)
	{
                // add statements
                // convert MixedNumber object to Fraction object
                // Use Fraction's add() method to obtain Fraction result
                // convert result to a new lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
            MixedNumberInterface selfMN = new MixedNumber(intPart,fracPart);
            FractionInterface selfFI = getFractionalEquivalent(selfMN);
            FractionInterface operandFI = getFractionalEquivalent(operand);
            selfFI = selfFI.add(operandFI);
            MixedNumberInterface result = new MixedNumber(0,selfFI);
            return (result); // change it
        } // end add


	public MixedNumberInterface subtractMixedNumber(MixedNumberInterface operand)
	{
                // add statements
                // convert MixedNumber object to Fraction object
                // Use Fraction's substrct() method to obtain Fraction result
                // convert result to a new lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
            
            return selfMixedNumber; // change it
	}	// end subtract

	public MixedNumberInterface multiplyMixedNumber(MixedNumberInterface operand)
	{
                // add statements
		// convert MixedNumber objects to Fraction objects
		// Use Fraction's multiply() method to obtain Fraction result
		// convert result to lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
            
            return selfMixedNumber; // change it
	}	// end multiply

	public MixedNumberInterface divideMixedNumber(MixedNumberInterface operand)
	{
                // add statements
		// convert MixedNumber objects to Fraction objects
		// Use Fraction's divide() method to obtain Fraction result
		// convert result to lowest term MixedNumber object
                // hint: return new MixedNumber(0,result);
            
            return selfMixedNumber; // change it
	}	// end divide


	public boolean equals(Object other)
	{
                // add statements
                // possible solution:
                // convert MixedNumber objects to Fraction objects
                // Use Fraction's equals() method to obtain boolean result
                return false; // change it
	  } // end if


	public int compareTo(MixedNumber other)
	{
                // add statements
                // possible solution:
                // convert MixedNumber objects to Fraction objects
                // Use Fraction's compareTo() method to obtain result
                return 0; // change it
	} // end compareTo

	public String toString()
	{
                // possible solution:
                // together with sign, integer and Fraction's toString() method
                // to obtain string value
                // add statements
                return(intPart+" "+fracPart); // change it
	} // end toString

	
	// Useful private methods:

	// reduce this MixedNumber object to lowest term MixedNumber 
        // object. E.g. 0 -50/7 --> -7 1/7; 4 25/8 --> 7 1/8
	private void reduceToLowestForm(int integerPart, FractionInterface fractionPart)
	{
                // add statements
            if ((fracPart.getNumerator()/fracPart.getDenominator()>1)){
                int fracPartNum = fracPart.getNumerator()%fracPart.getDenominator();
                int fracPartDenom = fracPart.getDenominator();
                fracPart.setFraction(fracPartNum, fracPartDenom);
                intPart = intPart+(fracPart.getNumerator()/fracPart.getDenominator());
            }
            else{
                intPart = integerPart;
                fracPart = fractionPart;
            }
	}	// end reduceToLowestForm


	// convert this MixedNumber object to a new Fraction object
        // object. E.g. -7 1/7 --> -50/7;  3 1/8 --> 25/8
	private FractionInterface getFractionalEquivalent(MixedNumberInterface mn)
	{
                // add statements
            int num = mn.getFractionPart().getNumerator()+ (mn.getFractionPart().getDenominator() * mn.getIntegerPart());
            int denom = mn.getFractionPart().getDenominator();
            FractionInterface fracEquivalent = new Fraction();
            fracEquivalent.setFraction(num,denom);
            return fracEquivalent;
	}	// end getFractionalEquivalent

} // end MixedNumber

