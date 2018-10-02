/* This file specifies methods for FractionInterface	*/
/* Do not modify this file!			        */

package PJ1;

public interface FractionInterface 
{
        /** Task: Sets "this" fraction to a given value.
         *  @param num is the integer numerator
         *  @param den is the integer denominator
         *  @throw Project1Exception if denominator is 0 */
        public void setFraction(int num, int den);


	/** Task: Gets the fraction's numerator.
	 *  @return the fraction's numerator */
	public int getNumerator();

	/** Task: Gets the fraction's denominator.
	 *  @return the fraction's denominator */
	public int getDenominator();

	/** Task: Gets the fraction's sign.
	 *  @return the fraction's sign */
	public char getSign();

	/** Task: Sets the numerator's sign to the fraction's sign,
	 *	and sets the denominator's sign to +.
	 *	@param sign a character that represents the fraction's sign */
	public void setSign(char sign);


	/** Task: Adds two fractions.
	 *  @param secondFraction is a fraction that is the second operand of the addition
	 *  @return a new fraction which is the sum of "this" fraction and the secondFraction 
	 *          Note: do not reduce the returning fraction                               */
	public FractionInterface add(FractionInterface secondFraction);

	/** Task: Subtracts two fractions.
	 *  @param secondFraction a fraction that is the second operand of the subtraction
	 *  @return a new fraction which is the difference of "this" fraction and the second operand 
	 *          Note: do not reduce the returning fraction                               */
	public FractionInterface subtract(FractionInterface secondFraction);

	/** Task: Multiplies two fractions.
	 *  @param secondFraction a fraction that is the second operand of the multiplication
	 *  @return a new fraction which is the product of "this" fraction and the secondFraction
	 *          Note: do not reduce the returning fraction                               */
	public FractionInterface multiply(FractionInterface secondFraction);

	/** Task: Divides two fractions.
	 *  @param secondFraction a fraction that is the second operand of the division
	 *  @return a new fraction which the quotient of "this" fraction and the secondFraction
	 *          Note: do not reduce the returning fraction                               
         *  @throw Project1Exception if secondFraction is 0 */
	public FractionInterface divide(FractionInterface secondFraction);

}
