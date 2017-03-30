package infixtopostfix;

/**
 * Logic to build a stack and perform stack operations in it.
 * 
 * @author Dylan
 */
public class Stack 
{
    private static char[] stack;
    private static int topCurser;
    
    public Stack(int stackSize)
    {
        stack = new char[stackSize];
        topCurser = -1;
    }
    
    //Returns true if stack is empty.
    public static boolean isEmpty()
    {
        return topCurser == -1;
    }
    
    //Returns true if stack is full.
    public static boolean isFull()
    {
        return topCurser == stack.length-1;
    }
    
    //Adds an element to the top of the stack.
    public static void push(char character)
    {
        if(!isFull())
        {
            topCurser++;
            stack[topCurser] = character;  
        }
        else
        {}
    }

    //Pops the top of the stack and returns the element.
    public static char pop()
    {
        char element;
        
        if(isEmpty())
        {
            return ' ';
        }
        else
        {
            element = stack[topCurser];
            topCurser--;
            return element;
        }    
    }
    
    //Returns the top of the stack without removing it.
    public static char lookAtTop()
    {
        char element;
        
        if(isEmpty())
        {
            return ' ';
        }
        else
        {
            return stack[topCurser];
        }    
    }
}
