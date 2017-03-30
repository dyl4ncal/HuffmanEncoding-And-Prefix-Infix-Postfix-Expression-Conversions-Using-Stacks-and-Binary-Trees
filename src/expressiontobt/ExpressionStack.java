package expressiontobt;

/**
 * An array based stack for building an expression tree.
 * 
 * @author Dylan
 */
public class ExpressionStack
{
    private final ExpressionTreeNode[] stackArray;
    private final int size;
    private int topPointer;
 
    public ExpressionStack(int size) 
    {
        this.size = size;
        stackArray = new ExpressionTreeNode[size];
        topPointer = -1;
    }
    
    public void push(ExpressionTreeNode node)
    {
        topPointer++;
        stackArray[topPointer] = node;
    }
    
    public ExpressionTreeNode pop()
    {
       ExpressionTreeNode node = stackArray[topPointer];
       topPointer--;

       return node;
    }
}
