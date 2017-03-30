package huffmancode;

/**
 * Logic for creating a binary tree using nodes.
 * 
 * @author Dylan
 */
public class HuffmanTreeNode
{
    char character;
    private int weight;
    private HuffmanTreeNode left;
    private HuffmanTreeNode right;
    
    public HuffmanTreeNode()
    {
        character = ' ';
        weight = 0;
        left = null;
        right = null;
    }

    public HuffmanTreeNode(char ch, int freq, HuffmanTreeNode left, HuffmanTreeNode right) 
    {
        this.character = ch;
        this.weight = freq;
        this.left = left;
        this.right = right;
    }

    public HuffmanTreeNode(char c, int w) 
    {
        character = c;
        weight = w;
        left = null;
        right = null;
    }
    
    public void setCharacter(char c)
    {
        character = c;
    }
    
    public void setWeight(int w)
    {
        weight = w;
    }
    
    public void setLeft(HuffmanTreeNode n)
    {
        left = n;
    }
    
    public void setRight(HuffmanTreeNode n)
    {
        right = n;
    }
    
    public char getCharacter()
    {
        return character;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public HuffmanTreeNode getLeft()
    {
        return left;
    }
    
    public HuffmanTreeNode getRight()
    {
        return right;
    }
}
