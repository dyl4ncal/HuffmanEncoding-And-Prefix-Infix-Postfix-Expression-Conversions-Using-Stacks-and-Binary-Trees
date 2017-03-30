package main;

import expressiontobt.ExpressionToBinaryTree;
import huffmancode.HuffmanEncoding;
import infixtopostfix.InfixToPostfixConversion;
import java.util.Scanner;
import testing.ExpressionToBinaryTreeUnitTests;
import testing.HuffmanEncodingUnitTests;
import testing.InfixToPostfixConversionUnitTests;

/**
 * A menu for the user to select and use different programs.
 * 
 * @author Dylan
 */
public class UserInterface
{
    private static final Scanner userInput = new Scanner(System.in);
  
    public static void runUI()
    {
        while (true)
        {
            System.out.println("\nMain Menu:\n----------");
            System.out.println("1. Huffman Encoding Program\n"
                + "2. Infix to Postfix Program\n3. Expression to Expression Tree Program\n"
                + "4. Run Unit Tests\n5. Exit");
            
            switch(userInput.next()) 
            {
                case "1":
                    HuffmanEncoding.performHuffmanEncoding();
                    break;
                case "2":
                    InfixToPostfixConversion.performExpressionConversion();
                    break;
                case "3":
                    ExpressionToBinaryTree.performExpressionConversion();
                    break;
                case "4":
                    runTests();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    
    //Method to run all program's unit tests at once.
    public static void runTests()
    {
        HuffmanEncodingUnitTests.runTests();
        InfixToPostfixConversionUnitTests.runTests();
        ExpressionToBinaryTreeUnitTests.runTests();
    }
}
