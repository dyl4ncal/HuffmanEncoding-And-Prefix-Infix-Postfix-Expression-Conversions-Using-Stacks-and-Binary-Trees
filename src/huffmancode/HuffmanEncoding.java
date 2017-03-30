package huffmancode;

import java.util.*;

/**
 * Logic to produce Huffman codes using a Huffman tree.
 * 
 * @author Dylan
 */
public class HuffmanEncoding
{
    private static final String[] huffmanCodes = new String[26];
    private static final PriorityQueue<HuffmanTreeNode> priorityQueue = new PriorityQueue<>(huffmanCodes.length, new CustomComparator());
    private static final int[] weightArray = {7,2,2,3,11,2,2,6,6,1,1,4,3,7,9,2,1,6,6,8,4,1,2,1,2,1};
    private static final char[] characterArray = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                                            'O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    private static class CustomComparator implements Comparator<HuffmanTreeNode> 
    {
        @Override
        public int compare(HuffmanTreeNode n0, HuffmanTreeNode n1)
        {
            return n0.getWeight() - n1.getWeight();
        }
    }
    
    //Performs the steps needed in a Huffman code algorithm.
    public static void performHuffmanEncoding()
    {
        createCharacterList(characterArray, weightArray);
        fillNodeQueue(priorityQueue, characterArray, weightArray);
        constructPrefixCodeTree(priorityQueue, characterArray);
        HuffmanTreeNode node = priorityQueue.remove();
        depthFirstTreeTraverse(node, "", characterArray, huffmanCodes);
        printHuffmanCodes(characterArray, huffmanCodes);
    }
    
    //Creates a linked list of characters with their corresponding weights.
    public static void createCharacterList(char[] characterArray, int[] weightArray)
    {
        CharacterLinkedList list = new CharacterLinkedList(); 

        list.insertNode(characterArray[0], weightArray[0]);
       
        for(int i = 1; i < characterArray.length; i++)
        {
            list.insertNode(characterArray[i], weightArray[i]);
        }
    }
    
    //Fills the priority queue with tree nodes.
    public static PriorityQueue<HuffmanTreeNode> fillNodeQueue(PriorityQueue<HuffmanTreeNode> priorityQueue
            , char[] characterArray, int[] weightArray)
    {
        for (int i = 0; i < characterArray.length; i++)
        {
            priorityQueue.add(new HuffmanTreeNode(characterArray[i], weightArray[i], null, null));
        }
        return priorityQueue;
    }
    
    //Performs a depth first traversal of the huffman tree to produce the codes.
    public static void depthFirstTreeTraverse(HuffmanTreeNode n, String code, char[] characterArray, String[] huffmanCodes) 
    {
        if (n != null)
        {
            int index = 0;
            for (int i = 0; i < characterArray.length; i++)
            {
                if (characterArray[i] == n.getCharacter()) 
                {
                    index = i;
                    break;
                }
            }
            huffmanCodes[index] = code;
            
            depthFirstTreeTraverse(n.getLeft(), code + "1", characterArray, huffmanCodes);
            depthFirstTreeTraverse(n.getRight(), code + "0", characterArray,huffmanCodes);
        }
    }

    //Builds the Huffman tree by taking the two lowest frequency nodes from
    //the priority queue and combining them.
    public static void constructPrefixCodeTree(PriorityQueue<HuffmanTreeNode> priorityQueue, char[] characterArray)
    {
        for(int i = 0; i < characterArray.length-1; i++) 
        {
            HuffmanTreeNode parent = new HuffmanTreeNode();

            HuffmanTreeNode rightChild = priorityQueue.remove();
            parent.setRight(rightChild);

            
            HuffmanTreeNode leftChild = priorityQueue.remove();
            parent.setLeft(leftChild);
            
            parent.setWeight(rightChild.getWeight() + leftChild.getWeight());
            priorityQueue.add(parent);
        }
    }

    //Prints the charatcers and corresponding Huffman Codes to the console.
    public static void printHuffmanCodes(char[] characterArray, String[] huffmanCodes) 
    {
        System.out.println("\n");
        for(int i = 0; i < characterArray.length; i++)
        {
            System.out.println("Letter: " + characterArray[i] + " Code: " + huffmanCodes[i]);
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
1

Letter: A Code: 001
Letter: B Code: 111111
Letter: C Code: 110010
Letter: D Code: 10000
Letter: E Code: 010
Letter: F Code: 110000
Letter: G Code: 110011
Letter: H Code: 0011
Letter: I Code: 0110
Letter: J Code: 1101100
Letter: K Code: 1101101
Letter: L Code: 0010
Letter: M Code: 10001
Letter: N Code: 1011
Letter: O Code: 000
Letter: P Code: 110111
Letter: Q Code: 1100010
Letter: R Code: 1001
Letter: S Code: 0111
Letter: T Code: 1110
Letter: U Code: 11010
Letter: V Code: 1100011
Letter: W Code: 111100
Letter: X Code: 1111010
Letter: Y Code: 111110
Letter: Z Code: 1111011

Main Menu:
----------
1. Huffman Encoding Program
2. Infix to Postfix Program
3. Expression to Expression Tree Program
4. Run Unit Tests
5. Exit
5
BUILD SUCCESSFUL (total time: 5 seconds)
*/