CSC220 Programming Assignment #2
================================
 
Due Date: 11:55pm, Sunday, 11/4 

- Specification 
 
  Taken from Project 4, Chapter 5, Page 177
  I have modified specification and requirements of this project
 
  You will need to implement 
       (20%) MyLinkedStack.java
       (80%) two methods in InfixExpressionEvaluator class:

  		private String convertToPostfix(String infix)
		private double evaluatePostfix (String postfix)

  		Algorithms are given in InfixExpressionEvaluator class.

- Submission: Upload single zipfile containing 2 files, MyLinkedStack.java & 
  InfixExpressionEvaluator.java to ilearn

- Requirements

  - Must use MyLinkedStack & MyStackInterface in InfixExpressionEvaluator methods
    Must not use Java API java.util.Stack<E>
  - A set of valid variable names (single character) and their corresponding values (double)
    will be needed 
  - Assume all infix expressions are valid
  - Valid tokens in an expression are '(',')','+','-','*','/',and valid variable names
  - Display result as floting point number with at 2 decimal places

  - There may be any number of blank spaces, >= 0, in between tokens and any number of parethesis.
    Thus, the following expressions are valid:
    	((a +  b) - c)
    	(( a+b))  * c    / d
	((((( a )))))
  - Must not add new or modify existing data fields
  - Must not modify exsiting methods and implement only required methods : 
  - You may add new private methods

- Compile and run test programs
	
  javac PJ2/*.java
  javac *.java
	
  // Run tests 
  java PJ2.MyLinkedStack
  java QuickTest 
  java UserInputTest

 
- Sample Run

==================================================================================
$ java PJ2.MyLinkedStack


*******************************************************
Sample Expected output:

OK: stack is empty
Push 3 data: 10, 30, 50
Print stack [50,30,10,]
OK: stack size is 3
OK: peek stack top is 50
OK: stack is not empty
Pop 2 data: 50, 30
Print stack [30,10,]
Print stack [10,]
OK: stack pop data is 30
Clear stack
Print stack []

*******************************************************

Your Test output:

OK: stack is empty
Push 3 data: 10, 30, 50
Print stack [50,30,10,]
OK: stack size is 3
OK: peek stack top is 50
OK: stack is not empty
Pop 2 data: 50, 30
Print stack [30,10,]
Print stack [10,]
OK: stack pop data is 30
Clear stack
Print stack []


==================================================================================
$ java QuickTest


Variable table for quick test

Variable table :{A=5.5, B=-4.5, C=90.0, D=-5.0}

Convert infix expression to postfix expression: (A)
Equivalent postfix: A

Convert infix expression to postfix expression: (A+(B+C))
Equivalent postfix: ABC++

Convert infix expression to postfix expression: (A*(B+C))
Equivalent postfix: ABC+*

Convert infix expression to postfix expression: (A-(B+C)/D)
Equivalent postfix: ABC+D/-

Convert infix expression to postfix expression: A*(B+C-D)
Equivalent postfix: ABC+D-*

Convert infix expression to postfix expression: A*B+(C-D)-D*B
Equivalent postfix: AB*CD-+DB*-

Evaluate postfix expression: A
Result : 5.50

Evaluate postfix expression: ABC++
Result : 91.00

Evaluate postfix expression: ABC+*
Result : 470.25

Evaluate postfix expression: ABC+D/-
Result : 22.60

Evaluate postfix expression: ABC+D-*
Result : 497.75

Evaluate postfix expression: AB*CD-+DB*-
Result : 47.75

==================================================================================

$ java UserInputTest 


Create Variable Table, please input variable info:

Enter name and value, example: A 3.5 (enter 0 0 to exit) : A 3.5
Enter name and value, example: A 3.5 (enter 0 0 to exit) : B -4
Enter name and value, example: A 3.5 (enter 0 0 to exit) : C 9
Enter name and value, example: A 3.5 (enter 0 0 to exit) : D -5.5
Enter name and value, example: A 3.5 (enter 0 0 to exit) : 0 0

Variable table :{A=3.5, B=-4.0, C=9.0, D=-5.5}

Start to evaluate infix expressions....
Enter a valid infix expression string (enter "exit" to terminate):((((   A ))))
   Evaluate expression #1 : ((((   A ))))
   Equivalent postfix: A
   Result : 3.50
Enter a valid infix expression string (enter "exit" to terminate):(A+B)*C/D
   Evaluate expression #2 : (A+B)*C/D
   Equivalent postfix: AB+C*D/
   Result : 0.82
Enter a valid infix expression string (enter "exit" to terminate):A*B*C/D
   Evaluate expression #3 : A*B*C/D
   Equivalent postfix: AB*C*D/
   Result : 22.91
Enter a valid infix expression string (enter "exit" to terminate):A+B*C+D
   Evaluate expression #4 : A+B*C+D
   Equivalent postfix: ABC*+D+
   Result : -38.00
Enter a valid infix expression string (enter "exit" to terminate):((A)+B)
   Evaluate expression #5 : ((A)+B)
   Equivalent postfix: AB+
   Result : -0.50
Enter a valid infix expression string (enter "exit" to terminate):exit


