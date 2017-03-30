package expressiontobt;

import infixtopostfix.InfixToPostfixConversion;
import java.util.Scanner;

/**
 * Logic to build a binary expression tree from an arithmetic
 * expression (infix and fully parenthesized).
 * 
 * @author Dylan
 */
public class ExpressionToBinaryTree 
{
    private static ExpressionTreeNode treeRoot;
    private static String userExpression;
    private static final Scanner userInput = new Scanner(System.in);
    private static final ExpressionToBinaryTree bt = new ExpressionToBinaryTree();
    
    public ExpressionToBinaryTree()
    {
        treeRoot = null;
    }
    
    //Builds the expression tree and performs tree traversals
    //to produce different equivalent expression notations.
    public static void performExpressionConversion()
    { 
        setUserInput();
        bt.buildTree(userExpression);
        System.out.println("Binary expression tree constructed.\n");
        printExpressionNotation();
    }
    
    //Prints prefix, infix, and postfix notations from the expression tree.
    public static void printExpressionNotation()
    {
        System.out.println("Equivalent Notations:\n");
        System.out.print("Prefix: ");
        preOrderTraversal(treeRoot);

        System.out.print("\nInfix: ");
        inOrderTraversal(treeRoot);

        System.out.print("\nPostfix: ");
        postOrderTraversal(treeRoot); 
        System.out.print("\n");
    }
    
    //Gets the fully parenthesized expression from the user.
    public static void setUserInput()
    {
        System.out.println("Enter a fully parenthesized arithmetic expression[ E.g. (1+((61/(3+6))*7)) ]:");
        String input = userInput.next();
        setUserExpression(input);
    }
    
    public static void setUserExpression(String input)
    {
        userExpression = input;
    }
    
    public static String getUserExpression()
    {
        return userExpression;
    }
    
    //Returns true if the argument is a digit.
    //This program ONLY converts expressions containing digits
    //and the legal operands defined below.
    public static boolean isNumber(char n)
    {
        return n <= '9' && n >= '0';
    }
    
    //Returns true if the argument is an operator.
    //This program does NOT convert expressions with exponents.
    public static boolean isOperator(char op)
    {
        return op == '/' || op == '*' || op == '+' || op == '-';
    }
    
    //Constructs the binary expression tree by utilizing
    //a stack to produce the correct order of operations.
    public void buildTree(String expression)
    {
        expression = InfixToPostfixConversion.convertInfixToPostfix(userExpression);
         
        ExpressionStack s = new ExpressionStack(expression.length());
        expression = expression + ".";
        ExpressionTreeNode node;
        
        int i = 0;
        char current = expression.charAt(i);
        
        while (current != '.')
        {
            if(isNumber(current))
            {
                node = new ExpressionTreeNode(current);
                s.push(node);
            } 
            else if(isOperator(current))
            {
                ExpressionTreeNode sNode1 = s.pop();
                ExpressionTreeNode sNode2 = s.pop();
                node = new ExpressionTreeNode(current);
                node.setLeft(sNode2);
                node.setRight(sNode1);
                s.push(node);
            }
            current = expression.charAt(++i);
        }
        treeRoot = s.pop();
    }
  
    //Performs a preorder traversal of the expression tree.
    public static void preOrderTraversal(ExpressionTreeNode currentNode)
    {
        if (currentNode != null)
        {
            System.out.print(currentNode.getData());
            preOrderTraversal(currentNode.getLeft());
            preOrderTraversal(currentNode.getRight());            
        }    
    }
    
    //Performs a postorder traversal of the expression tree.
    public static void postOrderTraversal(ExpressionTreeNode currentNode)
    {
        if (currentNode != null)
        {
            postOrderTraversal(currentNode.getLeft());            
            postOrderTraversal(currentNode.getRight());
            System.out.print(currentNode.getData());            
        }    
    }
    
    //Performs an inorder traversal of the expression tree.
    public static void inOrderTraversal(ExpressionTreeNode currentNode)
    {
        if (currentNode != null)
        {
            inOrderTraversal(currentNode.getLeft());
            System.out.print(currentNode.getData());
            inOrderTraversal(currentNode.getRight());            
        }    
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
3
Enter a fully parenthesized arithmetic expression[ E.g. (1+((61/(3+6))*7)) ]:
(((5+2)*(8-3))/4)
Binary expression tree constructed.

Equivalent Notations:

Prefix: /*+52-834
Infix: 5+2*8-3/4
Postfix: 52+83-*4/

Main Menu:
----------
1. Huffman Encoding Program
2. Infix to Postfix Program
3. Expression to Expression Tree Program
4. Run Unit Tests
5. Exit
5
BUILD SUCCESSFUL (total time: 6 seconds)
*/
