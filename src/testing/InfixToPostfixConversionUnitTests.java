package testing;

import infixtopostfix.InfixToPostfixConversion;
import infixtopostfix.Stack;

/**
 * Some unit tests related to stack operations and 
 * expression notation conversion.
 *  
 * @author Dylan
 */
public class InfixToPostfixConversionUnitTests
{
    public static boolean testConvertInfixToPostfix()
    {
        String testExpression = "((4/(5-2+1))*(9-3)*6)";
        String actualResult = InfixToPostfixConversion.convertInfixToPostfix(testExpression);
        String expectedResult = "452-1+/93-*6*";

        Boolean result = actualResult.equals(expectedResult);
        System.out.print("convertInfixToPostfix() test passed? ");
        return result;
    }
    
    public static boolean testIsEmpty()
    {
        new Stack(4);
        boolean expectedResult = true;
        boolean actualResult = Stack.isEmpty();
        System.out.print("isEmpty() test passed? ");
        return expectedResult == actualResult;
    }
    
    public static boolean testIsFull()
    {
        Stack testStack = new Stack(0);
        boolean expectedResult = true;
        boolean actualResult = testStack.isFull();
        System.out.print("isFull() test passed? ");
        return expectedResult == actualResult;
    }
    
    public static boolean testPush()
    {
        new Stack(1);
        Stack.push('d');
        System.out.print("push() test passed? ");
        if(Stack.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    public static boolean testPop()
    {
        new Stack(1);
        Stack.push('d');
        Stack.pop();
        System.out.print("pop() test passed? ");
        if(Stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static void runTests()
    {
        System.out.println("\n/*Unit Tests Related to Infix To Postfix Converter:"
                + "(Stack-based Algorithm)*/");
        System.out.println(testIsEmpty());
        System.out.println(testIsFull());
        System.out.println(testPush());
        System.out.println(testPop());
        System.out.println(testConvertInfixToPostfix());
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
4

/*Testing Related to Huffman Encoding:*//*
Character Weights: 
'D'-1 'Y'-8 'L'-17 'A'-27 'N'-35 'C'-55 

Letter: D Code: 11000
Letter: Y Code: 11001
Letter: L Code: 1101
Letter: A Code: 111
Letter: N Code: 10
Letter: C Code: 0
performHuffmanEncoding() test passed? true

/*Unit Tests Related to Infix To Postfix Converter:(Stack-based Algorithm)*//*
isEmpty() test passed? true
isFull() test passed? true
push() test passed? true
pop() test passed? true
convertInfixToPostfix() test passed? true

/*Testing Related to Binary Expression Trees:*//*
Equivalent Notations:

Prefix: +*55/82
Infix: 5*5+8/2
Postfix: 55*82/+
-------------------------------
Expected Prefix Result: +*55/82
Expected Infix Result: 5*5+8/2
Expected Postfix Result: 55*82/+

Main Menu:
----------
1. Huffman Encoding Program
2. Infix to Postfix Program
3. Expression to Expression Tree Program
4. Run Unit Tests
5. Exit
5
BUILD SUCCESSFUL (total time: 18 seconds)
*/
