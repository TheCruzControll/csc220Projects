/**
 * Goal: To evaluate infix expression using 3 steps below.
 *       Step 1 is done. You will need to implement Step 2 and Step 3
 *       Please look at algorithms in the methods
 *
 * Step 1: construct variable table
 *         Provide a set of valid variable names (single character) and
 *         and their corresponding values (double).
 *         These private methods are defined and available to use :
 *              getVariableValue(X) - get value of variable X
 *              checkValidVariable(X) - check if X is a variable
 *              checkValidOperator(X) - check if X is an operator
 *
 * Step 2: Convert a valid infix expression to a postfix expression
 *         Must only use variable names as defined in variable table
 *         Implement method: private String convertToPostfix(String infix)
 *
 * Step 3: Evaluate postfix expression from step 2
 *         Implement method: private double evaluatePostfix(String postfix)
 *         Use methods as given in Step 1 in this steps.
 *	
 * Look at algorithms in the methods
*/

package PJ2;

import java.util.*;

public class InfixExpressionEvaluator
{


   /** Convert a valid infix expression to a postfix expression 
       Must only use variable names as defined in variable table

       @param infix :  A valid infix expression.
       @return Equivalent postfix expression */
    
    private int precedenceLevel(char op)
        {
            switch (op) 
            {
                case '+':
                case '-':
                    return 0;
                case '*':
                case '/':
                    return 1;
                default:
                    throw new IllegalArgumentException("Operator unknown: " + op);
            }
        }
    
   private String convertToPostfix(String infix)
   {

      /* 
        Task: Convert an infix expression to a postfix expression

	Use MyStackInterface<Character> S to hold operator characters
        Valid characters are '(',')','+','-','*','/', predefined variable names
	Use a StringBuffer PE to hold postfix expression

	Need to consider : ‘(‘ & ‘)’, precedence of operators and left to right association

	Step 1. Process each character ch in infix expression from left to right

	switch(ch)
	{
		case operand 	: append to PE; break;
		case ‘(‘ 	: S.push(ch); break;
		case ‘)’ 	: repeat // loop until “(“
		                  {
				 	symbol = S.pop() 
					if symbol != ‘(‘ then append to PE
					else exit loop
				  }
			          break;
		case operator 	: get TopSymbol from S if S is not empty
				  while (S.size()!= 0) and (TopSymbol != ‘(‘) and
					(precedence(ch) <= precedence(TopSymbol)) 
				  {
					symbol = S.pop() 
					append symbol to PE
					get TopSymbol from S if S is not empty
				  }
				  S.push(ch)
				  break;
	} // end switch

	Step 2. After scanning the whole infix expression. Append remaining operators in S into PE

	while (Stack != empty) 
	{ 
	  symbol = S.pop(); 
	  append symbol to PE
	}

	Return PE.toString() // convert StringBuffer to String


	Example : (a*b+c) – (d-e*f) == ab*c+def*--	

	Char		Stack 		PE  
	(		(		
	a		(		a
	*		(*		a
	b		(*		ab
	+		(+		ab*
	c		(+		ab*c
	)				ab*c+
	-		-		ab*c+
	(		-(		ab*c+
	d		-(		ab*c+d
	-		-(-		ab*c+d
	e		-(-		ab*c+de
	*		-(-*		ab*c+de
	f		-(-*		ab*c+def
	)		-		ab*c+def*-
					ab*c+def*--		
	*/ 


      // add statements here
        
       int characterCount = infix.length();
       StringBuffer PE = new StringBuffer();
       MyStackInterface<Character> S = new MyLinkedStack();
       for(int index = 0;index<characterCount;index++)
       {
           char ch = infix.charAt(index);
           switch(ch)
            {
                default:
                {
                    PE.append(ch);
                    break;
                }
                
		case '(': 
                    S.push(ch); 
                    break;
                    
		case ')':// loop until “(“
		{
                    while((!S.empty() ) && (S.peek() != '(') ) 
                    {
			char symbol = S.pop(); 
                        PE.append(symbol);
                    }
                    S.pop();
                    break;   
                        
		}
                
		case '+':case'-':case'*':case'/': //get TopSymbol from S if S is not empty
                {
                    
                    while((!S.empty()) && (S.peek() != '(') && (precedenceLevel(ch) <= precedenceLevel(S.peek()))) 
                    {
			char symbol = S.pop(); 
                        PE.append(symbol);
                    }
                    S.push(ch);
                    break;
                }
                
        
            } // end switch
           
       }
       while(!S.empty())
       {
	  char symbol = S.pop(); 
          PE.append(symbol);
       }
       return PE.toString();
   } // end convertToPostfix


   /** Evaluates a postfix expression.
       Must only use variable names as defined in variable table

       @param postfix : A valid postfix expression.
       @return The double result of the postfix expression. */

   private double evaluatePostfix(String postfix)
   {
      /*
	  
  	Task: Evaluate a postfix expression

	Use a MyStackStack<Double> S to hold operands
	Process each character ch in postfix expression from left to right

		if a character is an operand : push into S 
		if a character is an operator :
			pop two operands from S 
			evaluate the result (need to consider +,-,*,/)
			push the result back to S 
	Final result is in S 

	Hint: Use getVariableValue(X) to get value of variable X
	      Use checkValidVariable(X) to check if X is a variable 
	      Use checkValidOperator(X) to check if X is an operator
      
	Example : Let A=2, B=3, C=4, D=5. 

		  Evaluate postfix expr “ABC+*D-“
		  234+*5- = 2 * (3+4) – 5 = 9



		  Char		Stack 			
		  2		2				
		  3		2,3				
		  4		2,3,4			
		  +		2,7	// 3 + 4		
	          *		14	// 2 * 7		
		  5		14,5				
	   	  -		9	// 14 - 5

		  Result = 9


	*/

      // add statements here
       int characterCount = postfix.length();
       MyStackInterface<Double> S = new MyLinkedStack();
       for(int index = 0;index<characterCount;index++)
       {
           char ch = postfix.charAt(index);
           if(checkValidVariable(ch) ==true)
           {
               S.push(getVariableValue(ch));
           }
           else if(checkValidOperator(ch)==true)
           {    
               
               switch(ch)
               {
                    case'+':
                    {
                        double op1 = S.pop();
                        double op2 = S.pop();
                        S.push(op2+op1);
                        break;
                    }
                    case'-':
                    {
                        double op1 = S.pop();
                        double op2 = S.pop();
                        S.push(op2-op1);
                        break;
                    }
                    case'*':
                    {
                        double op1 = S.pop();
                        double op2 = S.pop();
                        S.push(op2*op1);
                        break;
                    }
                    case'/':
                    {
                        double op1 = S.pop();
                        double op2 = S.pop();
                        S.push(op2/op1);
                        break;
                    }
               }
           }
       }
       return S.pop();
   } // end evaluatePostfix



   //----------------------------------------------------------------
   // Do not modify anything below 
   //----------------------------------------------------------------
   
   // This is a variable table. It contains <name,value> pairs
   Map<Character,Double> variableValues = new HashMap<>();
   
   // Check a character op is a valid operator, i.e. +, -, * or /  
   private boolean checkValidOperator(char op)
   {
      return ((op == '+') || (op == '-') || (op == '*') || (op == '/'));
   }

   // Check variable var is defined in variable table 
   private boolean checkValidVariable(char var)
   {
      return variableValues.containsKey(var);
   }

   // Retrieve variable values from variable table 
   private double getVariableValue(char var)
   {
      return variableValues.get(var).doubleValue();
   } 
    
   // Read variable values into a variable table 
   public void setupVariables() {
	   Scanner s = new Scanner(System.in);
	   char  var = 'A';
	   double val = 3.5; 
	   System.out.println("\n\nCreate Variable Table, please input variable info:\n");
	   while (var != '0') {
	   	System.out.print("Enter name and value, example: A 3.5 (enter 0 0 to exit) : ");
		var = s.next().charAt(0);
		val = s.nextDouble();
	        if (var == '0') continue;
   		variableValues.put(var, val);
	   }
	   System.out.println("\nVariable table :" + variableValues);
   }
   	

   // This starts infix evaluations
   // Must enter valid infix expressions, otherwise, may get unexpected results
   // Enter "exit" to terminate loop
   public void evaluate() {
	Scanner scanner;
	String inputInfix;
	String postfix;
	double result;
        int i=0;

	System.out.println("\nStart to evaluate infix expressions....");
       	scanner = new Scanner( System.in ); // scanner for input
        do                                                                  
        {                                                                   
	   try {
              System.out.print( "Enter a valid infix expression string (enter \"exit\" to terminate):" );

	      // scan next input line
              inputInfix = scanner.nextLine();                            

	      if (inputInfix.equals("exit"))
		 break; // loop

              i++;
              System.out.println("   Evaluate expression #"+ i+" : " + inputInfix);
              postfix=convertToPostfix(inputInfix);
              System.out.println("   Equivalent postfix: " + postfix);
              result =evaluatePostfix(postfix);
              System.out.printf("   Result : %.2f\n", result);
      	   } catch (Exception e) {
              System.out.println("   Exception...."+e.getMessage());
	   }
	   

        } while ( true ); // end do...while                         
 
   }  

   // Run quick tests
   public void quickTest() {
	   char  var = 'A';
	   double val = 3.5; 
	   String inputInfix=null;
	   String postfix=null;

	   System.out.println("\n\nVariable table for quick test");
   	   variableValues.put('A', 5.5);
   	   variableValues.put('B', -4.5);
   	   variableValues.put('C', 90.0);
   	   variableValues.put('D', -5.0);
	   System.out.println("\nVariable table :" + variableValues);

	   inputInfix="(A)";
           System.out.println("\nConvert infix expression to postfix expression: " + inputInfix);
           System.out.println("Equivalent postfix: " + convertToPostfix(inputInfix));

	   inputInfix="(A+(B+C))";
           System.out.println("\nConvert infix expression to postfix expression: " + inputInfix);
           System.out.println("Equivalent postfix: " + convertToPostfix(inputInfix));

	   inputInfix="(A*(B+C))";
           System.out.println("\nConvert infix expression to postfix expression: " + inputInfix);
           System.out.println("Equivalent postfix: " + convertToPostfix(inputInfix));

	   inputInfix="(A-(B+C)/D)";
           System.out.println("\nConvert infix expression to postfix expression: " + inputInfix);
           System.out.println("Equivalent postfix: " + convertToPostfix(inputInfix));

	   inputInfix="A*(B+C-D)";
           System.out.println("\nConvert infix expression to postfix expression: " + inputInfix);
           System.out.println("Equivalent postfix: " + convertToPostfix(inputInfix));

	   inputInfix="A*B+(C-D)-D*B";
           System.out.println("\nConvert infix expression to postfix expression: " + inputInfix);
           System.out.println("Equivalent postfix: " + convertToPostfix(inputInfix));

	   postfix="A";
           System.out.println("\nEvaluate postfix expression: " + postfix);
           System.out.printf("Result : %.2f\n", evaluatePostfix(postfix));

	   postfix="ABC++";
           System.out.println("\nEvaluate postfix expression: " + postfix);
           System.out.printf("Result : %.2f\n", evaluatePostfix(postfix));

	   postfix="ABC+*";
           System.out.println("\nEvaluate postfix expression: " + postfix);
           System.out.printf("Result : %.2f\n", evaluatePostfix(postfix));

	   postfix="ABC+D/-";
           System.out.println("\nEvaluate postfix expression: " + postfix);
           System.out.printf("Result : %.2f\n", evaluatePostfix(postfix));

	   postfix="ABC+D-*";
           System.out.println("\nEvaluate postfix expression: " + postfix);
           System.out.printf("Result : %.2f\n", evaluatePostfix(postfix));

	   postfix="AB*CD-+DB*-";
           System.out.println("\nEvaluate postfix expression: " + postfix);
           System.out.printf("Result : %.2f\n", evaluatePostfix(postfix));

   	   variableValues.clear();
   }

} 
                 
