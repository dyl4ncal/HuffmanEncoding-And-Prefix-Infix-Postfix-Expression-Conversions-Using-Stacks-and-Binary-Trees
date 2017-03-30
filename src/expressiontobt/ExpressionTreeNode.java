package expressiontobt;

/**
 * A tree node for a binary expression tree.
 * 
 * @author Dylan
 */
public class ExpressionTreeNode
{
    private char data;
    private ExpressionTreeNode left;
    private ExpressionTreeNode right;
    
    public ExpressionTreeNode(char data)
    {
        left = null;
        right = null;
        this.data = data;
    }
    
    public void setData(char n)
    {
        this.data = n;
    }
    
    public void setLeft(ExpressionTreeNode n)
    {
        this.left = n;
    }
    
    public void setRight(ExpressionTreeNode n)
    {
        this.right = n;
    }
    
    public char getData()
    {
        return this.data;
    }
    
    public ExpressionTreeNode getLeft()
    {
        return this.left;
    }
    
    public ExpressionTreeNode getRight()
    {
        return this.right;
    }
}
