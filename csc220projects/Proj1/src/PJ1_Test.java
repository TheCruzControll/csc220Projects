/*  This program is used to test PJ1.MixedNumber class
 *  More info are given in Readme file
 */

import java.util.*;
import PJ1.*;

class PJ1_Test
{
    static private Scanner scanner;

    private static MixedNumber readMixedNumber() {
        System.out.print( "\nTry to read a mixed number a b/c, please enter a b c : " );
        int a = scanner.nextInt();                            
        int b = scanner.nextInt();                          
        int c = scanner.nextInt();                          
        MixedNumber m1 = new MixedNumber(a, b, c);
	Fraction f = new Fraction(b,c);
        MixedNumber m2 = new MixedNumber(a, f);
        System.out.println( "\t\tRead OK");
        System.out.println( "\t\tConstructor #1 MixedNumber(a,b,c) :"+m1);
        System.out.println( "\t\tConstructor #2 MixedNumber(a,Fraction(b,c)) :"+m2);
	return m1;
    }

    private static void printOperations() {
	System.out.println("==============================================");
        System.out.println("\nOperations:");
        System.out.println("  0) exit \t1) add \t\t2) subtract \t3) multiply \t4) divide");
	System.out.println("  5) compareTo \t6) equals");
        System.out.println("  7) setMixedNumber(a,b,c) & setMixedNumber(a, Frction(b,c))");
	System.out.println("  8) getIntegerPart & getFractionPart");  
	System.out.println("  Note: toString() method must work correctly");
        System.out.print( "\nEnter an operation number: ");
    }

    public static void main( String args[] )
    {
       	scanner = new Scanner( System.in ); // scanner for input
       	boolean continueLoop = true; // determines if more input is needed
	MixedNumber n1=null;
	MixedNumber n2=null;
	int op,x,y;
  
        do                                                                  
        {                                                                   
           try // read two numbers and calculate quotient              `     
           {                                                                
    	      printOperations();
              op= scanner.nextInt();                            

	      if (op == 0) {
		break;
	      } else if ((op >0) && (op <7)) {
		n1 = readMixedNumber();
		n2 = readMixedNumber();
	      } else if (op == 7) {
                n1 = new MixedNumber();
	      } else if (op ==8) {
		n1 = readMixedNumber();
	      } else {
                  System.out.print( "\nInvalid input... try again\n" );
		  continue;
	      } 

	      System.out.println("\nTests:\n");
	      switch (op) {
            	case 1:  
			System.out.println("\t" + n1 + " + " + n1 + " = " + n1.addMixedNumber(n1));
            		System.out.println("\t" + n2 + " + " + n2 + " = " + n2.addMixedNumber(n2));
            		System.out.println("\t" + n1 + " + " + n2 + " = " + n1.addMixedNumber(n2));
            		System.out.println("\t" + n2 + " + " + n1 + " = " + n2.addMixedNumber(n1));
		        break;
            	case 2: 
			System.out.println("\t" + n1 + " - " + n1 + " = " + n1.subtractMixedNumber(n1));
            		System.out.println("\t" + n2 + " - " + n2 + " = " + n2.subtractMixedNumber(n2));
            		System.out.println("\t" + n1 + " - " + n2 + " = " + n1.subtractMixedNumber(n2));
            		System.out.println("\t" + n2 + " - " + n1 + " = " + n2.subtractMixedNumber(n1));
		        break;
            	case 3:  
			System.out.println("\t" + n1 + " * " + n1 + " = " + n1.multiplyMixedNumber(n1));
            		System.out.println("\t" + n2 + " * " + n2 + " = " + n2.multiplyMixedNumber(n2));
            		System.out.println("\t" + n1 + " * " + n2 + " = " + n1.multiplyMixedNumber(n2));
            		System.out.println("\t" + n2 + " * " + n1 + " = " + n2.multiplyMixedNumber(n1));
		        break;
            	case 4:  
			System.out.println("\t" + n1 + " / " + n1 + " = " + n1.divideMixedNumber(n1));
            		System.out.println("\t" + n2 + " / " + n2 + " = " + n2.divideMixedNumber(n2));
            		System.out.println("\t" + n1 + " / " + n2 + " = " + n1.divideMixedNumber(n2));
            		System.out.println("\t" + n2 + " / " + n1 + " = " + n2.divideMixedNumber(n1));
		        break;
            	case 5:  
			System.out.println("\t" + n1 + " ct " + n1 + " = " + n1.compareTo(n1));
            		System.out.println("\t" + n2 + " ct " + n2 + " = " + n2.compareTo(n2));
            		System.out.println("\t" + n1 + " ct " + n2 + " = " + n1.compareTo(n2));
            		System.out.println("\t" + n2 + " ct " + n1 + " = " + n2.compareTo(n1));
		        break;
            	case 6:  
			System.out.println("\t" + n1 + " eq "+ n1 + " = " + n1.equals(n1));
            		System.out.println("\t" + n2 + " eq "+ n2 + " = " + n2.equals(n2));
            		System.out.println("\t" + n1 + " eq "+ n2 + " = " + n1.equals(n2));
            		System.out.println("\t" + n2 + " eq "+ n1 + " = " + n2.equals(n1));
		        break;
		case 7:  
                        System.out.print("read a mixed number a b/c, please enter a b c : " );
                        int a1= scanner.nextInt();
                        int b1= scanner.nextInt();
                        int c1= scanner.nextInt();
                        n1.setMixedNumber(a1,b1,c1);
                        System.out.print("\t setMixedNumber(a,b,c) = ");
                        System.out.println(n1);
			Fraction f1 = new Fraction(b1,c1);
                        System.out.println("\t fraction(b,c) = "+f1);
                        n1.setMixedNumber(a1,f1);
                        System.out.print("\t setMixedNumber(a,Fraction(b,c)) = ");
                        System.out.println(n1);
                        break;
                case 8:
                        System.out.println("\t getIntegerPart  = " + n1.getIntegerPart());
                        System.out.println("\t getFractionPart = " + n1.getFractionPart());
                        break;
	      }

           } // end try                                                     
           catch ( Project1Exception e)                
           {                                                                
              System.err.printf( "\nException: %s\n", e);
           } // end catch                                                   
        } while ( continueLoop ); // end do...while                         
    } // end main
} // end class 






