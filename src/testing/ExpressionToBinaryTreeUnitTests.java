package testing;

import expressiontobt.ExpressionToBinaryTree;

import expressiontobt.ExpressionTreeNode;


/**
 * Test related to constructing a BT
 * from an expression and representing it in different
 * notations.
 * 
 * @author Dylan
 */
public class ExpressionToBinaryTreeUnitTests
{
    private static ExpressionTreeNode treeRoot;
    private static String userExpression;
    //private static final Scanner userInput = new Scanner(System.in);
    private static final ExpressionToBinaryTree bt = new ExpressionToBinaryTree();
    
    public static void testExpressionTreeConversions()
    {
        ExpressionToBinaryTree.setUserExpression("((5*5)+(8/2))");
        bt.buildTree(userExpression);
        ExpressionToBinaryTree.printExpressionNotation();
        String r1 = "Expected Prefix Result: +*55/82";
        String r2 = "Expected Infix Result: 5*5+8/2";
        String r3 = "Expected Postfix Result: 55*82/+";
        System.out.println("-------------------------------\n" + r1 + "\n" + r2 + "\n" + r3);
    }
    
    public static void runTests()
    {
        System.out.println("\n/*Testing Related to Binary Expression Trees:*/");
        testExpressionTreeConversions();
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
