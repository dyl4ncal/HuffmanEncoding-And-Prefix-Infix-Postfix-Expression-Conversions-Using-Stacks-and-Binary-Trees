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
    private static final PriorityQueue<HuffmanTreeNode> priorityQueue = new PriorityQueue<>(26, new CustomComparator());
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
        createCharacterList();
        fillNodeQueue();
        constructPrefixCodeTree();
        HuffmanTreeNode node = priorityQueue.remove();
        depthFirstTreeTraverse(node, "");
        printHuffmanCodes();
    }
    
    //Creates a linked list of characters with their corresponding weights.
    public static void createCharacterList()
    {
        CharacterLinkedList list = new CharacterLinkedList(); 

        list.insertNode(characterArray[0], weightArray[0]);
       
        for(int i = 1; i < characterArray.length; i++)
        {
            list.insertNode(characterArray[i], weightArray[i]);
        }
    }
    
    //Fills the priority queue with tree nodes.
    public static PriorityQueue<HuffmanTreeNode> fillNodeQueue()
    {
        for (int i = 0; i < 26; i++)
        {
            priorityQueue.add(new HuffmanTreeNode(characterArray[i], weightArray[i], null, null));
        }
        return priorityQueue;
    }
    
    //Performs a depth first traversal of the huffman tree to produce the codes.
    public static void depthFirstTreeTraverse(HuffmanTreeNode n, String code) 
    {
        if (n != null)
        {
            int index = 0;
            for (int i = 0; i < 26; i++)
            {
                if (characterArray[i] == n.getCharacter()) 
                {
                    index = i;
                    break;
                }
            }
            huffmanCodes[index] = code;
            
            depthFirstTreeTraverse(n.getLeft(), code + "1");
            depthFirstTreeTraverse(n.getRight(), code + "0");
        }
    }

    //Builds the Huffman tree by taking the two lowest frequency nodes from
    //the priority queue and combining them.
    public static void constructPrefixCodeTree()
    {
        for(int i = 0; i < 26-1; i++) 
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
    public static void printHuffmanCodes() 
    {
        for(int i = 0; i < 26; i++)
        {
            System.out.println("Letter: " + characterArray[i] + " Code: " + huffmanCodes[i]);
        }
    }
}
