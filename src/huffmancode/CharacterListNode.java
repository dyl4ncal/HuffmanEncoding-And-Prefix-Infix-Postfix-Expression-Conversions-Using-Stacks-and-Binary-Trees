package huffmancode;

/**
 * Logic for creating a linked list using nodes
 * which contain a character and a weight value
 * (frequency of occurrences in a message).
 * 
 * @author Dylan
 */
public class CharacterListNode
{
    int weight;
    char character;
    CharacterListNode next;
    
    //Default constructor.
    public CharacterListNode()
    {
        weight = 0;
        next = null;
    }
    
    public CharacterListNode(char character, int weight)
    {
        this.character = character;
        this.weight = weight;
        next = null;
    }
    
    public void setNext(CharacterListNode n)
    {
        next = n;
    }
    
    public CharacterListNode getNext()
    {
        return next;
    } 
  
    public int getWeight()
    {
        return weight;
    }
    
    public char getCharacter()
    {
        return character;
    }
}
