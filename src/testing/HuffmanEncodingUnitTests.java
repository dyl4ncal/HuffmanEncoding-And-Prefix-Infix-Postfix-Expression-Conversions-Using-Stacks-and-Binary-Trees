package testing;

import static huffmancode.HuffmanEncoding.*;
import huffmancode.HuffmanTreeNode;
import java.util.*;

/**
 * Some unit tests related to Huffman encoding data compression.
 * 
 * @author Dylan
 */
public class HuffmanEncodingUnitTests
{
    private static final String[] codes = new String[6];
    private static final PriorityQueue<HuffmanTreeNode> pQueue = new PriorityQueue<>(codes.length, new CustomComparator());
    private static final int[] weightArray = {1,8,17,27,35,55};
    private static final char[] charArray = {'D','Y','L','A','N','C'};
    
    private static class CustomComparator implements Comparator<HuffmanTreeNode> 
    {
        @Override
        public int compare(HuffmanTreeNode n0, HuffmanTreeNode n1)
        {
            return n0.getWeight() - n1.getWeight();
        }
    }
    
    public static boolean testPerformHuffmanEncoding()
    {
        createCharacterList(charArray, weightArray);
        fillNodeQueue(pQueue, charArray, weightArray);
        constructPrefixCodeTree(pQueue, charArray);
        HuffmanTreeNode node = pQueue.remove();
        depthFirstTreeTraverse(node, "", charArray, codes);
        System.out.print("Character Weights: \n");
        for(int i = 0; i < charArray.length; i++)
        {
            System.out.print("'"+charArray[i]+"'"+"-"+weightArray[i]+" ");
        }
        printHuffmanCodes(charArray, codes);
        
        Boolean result = false;
        System.out.print("performHuffmanEncoding() test passed? ");
        if(codes[0].length() >= codes[1].length() && codes[2].length() >= 
           codes[3].length() && codes[4].length() >= codes[5].length())
        {
            result = true;
        }
        return result;
    }
    
    public static void runTests()
    {
        System.out.println("\n/*Testing Related to Huffman Encoding:*/");
        System.out.println(testPerformHuffmanEncoding());
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
