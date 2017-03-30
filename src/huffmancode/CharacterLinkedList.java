package huffmancode;

/**
 * Logic for creating, inserting, printing, etc. a linked list
 * of character nodes.
 * 
 * @author Dylan
 */
public class CharacterLinkedList
{
    private static CharacterListNode head;
    
    public CharacterLinkedList()
    {
        head = new CharacterListNode();
        head = null;
    }
    
    //Method to add a new node to the linked list.
    public void insertNode(char c, int n)
    {
        CharacterListNode node = new CharacterListNode(c, n);
        node.next = head;
        head = node;
    }  
    
    //Prints linked list node data to console.
    public void printList() 
    {
        CharacterListNode n = head;

        while(n != null) 
        {
            System.out.println("Char: " + n.getCharacter() + " Weight: " + n.getWeight());
            n = n.getNext();
        }
    }
}
