/**
 * This file specifies methods for MixedNumberInterface.
 * All result mixed numbers must be reduced to lowest term
 * Do not modify this file!
 */

package PJ1;

public interface MixedNumberInterface 
{
	/** Task: Sets a MixedNumber to a given value.
	 *  @param integerPart  the whole number
	 *  @param fractioPart  the fraction */
	public void setMixedNumber(int integerPart, FractionInterface fractionPart);

	/** Task: Sets a MixedNumber to a given value.
	 *  @param integerPart  the whole number
	 *  @param fractionNumerator  the integer numerator
	 *  @param fractionDenominator  the integer denominator */
	public void setMixedNumber(int integerPart, int fractionNumerator, int fractionDenominator);

	/** Task: Gets the MixedNumber's whole part.
	 *  @return the MixedNumber's whole part */
	public int getIntegerPart();

	/** Task: Gets the MixedNumber's fraction
	 *  @return the MixedNumber's fraction */
	public FractionInterface getFractionPart();

 	/** Task: Adds two MixedNumbers.
	 *  @param operand  a MixedNumber that is the second operand of the addition
	 *  @return the sum of the invoking MixedNumber and the second operand */
	public MixedNumberInterface addMixedNumber(MixedNumberInterface operand);

	/** Task: Subtracts two MixedNumbers.
	 *  @param operand  a MixedNumber that is the second operand of the subtraction
	 *  @return the difference of the invoking MixedNumber and the second operand */
	public MixedNumberInterface subtractMixedNumber(MixedNumberInterface operand);

	/** Task: Multiplie two MixedNumbers.
	 *  @param operand  a MixedNumber that is the second operand of the multiplication
	 *  @return the product of the invoking MixedNumber and the second operand */
	public MixedNumberInterface multiplyMixedNumber(MixedNumberInterface operand);

	/** Task: Divides two MixedNumbers.
	 *  @param operand  a MixedNumber that is the second operand of the division
	 *  @return the quotient of the invoking MixedNumber and the second operand */
	public MixedNumberInterface divideMixedNumber(MixedNumberInterface operand);

}

