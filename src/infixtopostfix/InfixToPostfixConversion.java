package infixtopostfix;

import java.util.Scanner;

/**
 * Logic to perform a conversion on an infix arithmetic expression
 * to its equivalent postfix notation using a stack data structure.
 * Question C-8.59 on p.356;
 * 
 * @author Dylan
 */
public class InfixToPostfixConversion 
{
    private static String infixExpression;
    private static Scanner userInput = new Scanner(System.in);
    
    //Converts a user inputted expression into postfix notation.
    public static void performExpressionConversion()
    {
        System.out.println("Enter a fully parenthesized infix arithmetic expression[ E.g. (((5+2)*(8-3))/4) ]: ");
        String input = userInput.next();
        setInfixExpression(input);
        
        System.out.println("Equivalent postfix notation[ E.g. 52+83-*4/ ]: ");
        System.out.println(convertInfixToPostfix(infixExpression));
    }
   
    //Returns true if an operand is scanned.
    private static boolean isOperand(char op)
    {
        return (op >= '0' && op <= '9');
    }
    
    //Returns true if an operator is scanned.
    public static boolean isOperator(char op) 
    {
        return op == '(' || op == ')' || op == '^'|| op == '/' 
            || op == '*' || op == '+' || op == '-';
    }

    public static void setInfixExpression(String input)
    {
        infixExpression = input;
    }
    
    public static String getInfixExpression()
    {
        return infixExpression;
    }
    
    //Uses BEDMAS to determine precedence of operators.
    public static int getPrecedence(char op)
    {
        switch (op) 
        {
            case '^':
                return 2;
            case '*':
                return 1;
            case '/':
                return 1;
            case '+':
                return 0;
            case '-':
                return 0;    
        }
        return -1;
    }

    /*
    * If operand seen, output immediately.
    * When an operator is seen, use stack to see second operator.
    * For left associative operators, input ops are lower precedence than stack ops.
    * For right associative operators, input ops are higher precedence than stack ops.
    * For left parentheses, input is higher precedence than on stack.
    * If right parenthesis found, pop stack until left parenthesis found.
    * Operators are part of the output while parentheses are not.
    * Once the stack is Empty, return the postfix notation as a string.
    */
    public static String convertInfixToPostfix(String infixExpression)
    {
        char ch;
        StringBuilder postfixExp = new StringBuilder(infixExpression.length());
        Stack s = new Stack(50);

        for (int i = 0; i < infixExpression.length(); i++) 
        {
            ch = infixExpression.charAt(i);

            if (isOperand(ch))
            {
                postfixExp.append(ch);
            } 
            else if (ch == '(')
            {
                s.push(ch);
            }
            else if (ch == ')')
            {

                while (!s.isEmpty() && s.lookAtTop() != '(')
                {
                    postfixExp.append(s.pop());
                }
                if (!s.isEmpty() && s.lookAtTop() != '(')
                {
                    return null;
                }
                else if(!s.isEmpty())
                {
                    s.pop();
                }
            }
            else if (isOperator(ch))
            {
                if (!s.isEmpty() && getPrecedence(ch) <= getPrecedence(s.lookAtTop()))
                {
                    postfixExp.append(s.pop());
                }
                s.push(ch);
            }
        }
        while (!s.isEmpty()) 
        {
            postfixExp.append(s.pop());
        }
        return postfixExp.toString();
    }
}
/*
run:

Main Menu:
----------
1. Huffman Encoding Program
2. Infix to Postfix Program
3. Expression to Expression Tree Program
4. Run Unit Tests
5. Exit
2
Enter a fully parenthesized infix arithmetic expression[ E.g. (((5+2)*(8-3))/4) ]: 
(1+((61/(3+6))*7))
Equivalent postfix notation[ E.g. 52+83-*4/ ]: 
16136+/7*+

Main Menu:
----------
1. Huffman Encoding Program
2. Infix to Postfix Program
3. Expression to Expression Tree Program
4. Run Unit Tests
5. Exit
5
BUILD SUCCESSFUL (total time: 11 seconds)
*/
