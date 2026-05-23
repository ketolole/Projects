import java.util.*;

/**
 * Implements a Binary Search Tree
 *
 * @author G. Peck
 * @created July 2, 2003
 *
 *          Modified by Jason Quesenberry and Nancy Quesenberry February 9, 2006
 */
public class BinarySearchTree
{
	private TreeNode myRoot;

	public BinarySearchTree()
	{
		myRoot = null;
	}

	public void insert(Comparable next)
	{
		// post: next added to tree so as to preserve binary search tree
		myRoot = insertHelper(myRoot, next);
	}

	private TreeNode insertHelper(TreeNode root, Comparable next)
	{
		// pre : root points to a binary search tree
		// post: next added to tree so as to preserve binary search tree
		if(next == null)
		{
			return null;
		}
		if(root == null)
		{
			return new TreeNode(next);
		}
		int result = next.compareTo(root.getValue());
		if(result < 0)
		{
			root.setLeft(insertHelper(root.getLeft(), next));
		}
		else if(result > 0)
		{
			root.setRight(insertHelper(root.getRight(), next));
		}
		return root;
	}

	public Object find(Comparable target)
	{
		return findHelper(myRoot, target);
	}

	private Object findHelper(TreeNode root, Comparable target)
	{
		if(root == null)
		{
			return null;
		}
		int result = target.compareTo(root.getValue());
		if(result == 0)
		{
			return root.getValue();
		}
		else if(result < 0)
		{
			return findHelper(root.getLeft(), target);
		}
		else// if(result > 0)
		{
			return findHelper(root.getRight(), target);
		}
	}

	public int countNodes()
	{
		return countNodesHelper(myRoot);
	}

	private int countNodesHelper(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return 1 + countNodesHelper(root.getLeft()) + countNodesHelper(root.getRight());
		}
	}

	public void printInorder()
	{
		// post: prints the data fields of the tree, one per line
		printInorderHelper(myRoot);
	}

	private void printInorderHelper(TreeNode root)
	{
		// pre : root points to a binary search tree
		// post: prints the data fields of the tree using an inorder traversal
		if(root != null)
		{
			printInorderHelper(root.getLeft());
			System.out.print(root.getValue());
			printInorderHelper(root.getRight());
		}
	}

	public void printPreorder()
	{
		// post: prints the data fields of the tree, one per line
		printPreorderHelper(myRoot);
	}

	private void printPreorderHelper(TreeNode root)
	{
		// pre : root points to a binary search tree
		// post: prints the data fields of the tree using an inorder traversal
		if(root != null)
		{
			System.out.print(root.getValue());
			printPreorderHelper(root.getLeft());
			printPreorderHelper(root.getRight());
		}
	}

	public void printPostorder()
	{
		// post: prints the data fields of the tree, one per line
		printPostorderHelper(myRoot);
	}

	private void printPostorderHelper(TreeNode root)
	{
		// pre : root points to a binary search tree
		// post: prints the data fields of the tree using an inorder traversal
		if(root != null)
		{
			printPostorderHelper(root.getLeft());
			printPostorderHelper(root.getRight());
			System.out.print(root.getValue());
		}
	}

	public void delete(Comparable target)
	{
		// post: deletes a node with data equal to target, if present,
		// preserving binary search tree property
		myRoot = deleteHelper(myRoot, target);
	}

	private TreeNode deleteHelper(TreeNode node, Comparable target)
	{
		// pre : node points to a non-empty binary search tree
		// post: deletes a node with data equal to target, if present,
		// preserving binary search tree property
		if(node == null)
		{
			throw new NoSuchElementException();
		}
		else if(target.equals(node.getValue()))
		{
			return deleteTargetNode(node);
		}
		else if(target.compareTo(node.getValue()) < 0)
		{
			node.setLeft(deleteHelper(node.getLeft(), target));
			return node;
		}
		else
		{ // target.compareTo(root.getValue()) > 0
			node.setRight(deleteHelper(node.getRight(), target));
			return node;
		}
	}

	private TreeNode deleteTargetNode(TreeNode target)
	{
		if(target.getRight() == null)
		{
			return target.getLeft();
		}
		else if(target.getLeft() == null)
		{
			return target.getRight();
		}
		else if(target.getRight().getLeft() == null)
		{
			target.setValue(target.getRight().getValue());
			target.setRight(target.getRight().getRight());
			return target;
		}
		else
		{
			TreeNode marker = target.getRight();
			while (marker.getLeft().getLeft() != null)
				marker = marker.getLeft();
			target.setValue(marker.getLeft().getValue());
			marker.setLeft(marker.getLeft().getRight());
			return target;
		}
	}

	public int countLeaves()
	{
		return countLeaves(myRoot);
	}

	private int countLeaves(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else if(root.getLeft() == null && root.getRight() == null)
		{
			return 1;
		}
		else
		{
			return countLeaves(root.getLeft()) + countLeaves(root.getRight());
		}
	}

	public int height()
	{
		return height(myRoot);
	}

	private int height(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int rightHeight = height(root.getRight());
		int leftHeight = height(root.getLeft());
		return 1 + max(rightHeight, leftHeight);
	}

	public int width()
	{
		return width(myRoot);
	}

	private int width(TreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int leftWidth = width(root.getLeft());
		int rightWidth = width(root.getRight());
		int pathThroughRoot = height(root.getLeft()) + height(root.getRight()) + 1;
		int maxSubtreeWidth = max(leftWidth, rightWidth);
		return max(maxSubtreeWidth, pathThroughRoot);
	}

	private int max(int a, int b)
	{
		return Math.max(a, b);
	}

	public void clearTree()
	{
		myRoot = null;
	}

	public void interchange()
	// post: tree becomes a mirror image of itself
	{
		interchange(myRoot);
	}

	private void interchange(TreeNode root)
	{
		if(root == null)
		{
			return;
		}
		TreeNode temp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(temp);
		interchange(root.getLeft());
		interchange(root.getRight());
	}

	public boolean isAncestor(Comparable ancestor, Comparable descendant)
	{
		// post: returns true if descendant is a "child" of ancestor; false otherwise
		// i.e., true if descendant belongs to ancestor's subtree
		if(ancestor.equals(descendant))
		{
			return false;
		}
		return isAncestor(myRoot, ancestor, descendant);
	}

	private boolean isAncestor(TreeNode root, Comparable a, Comparable d)
	{
		if(findPtr(findPtr(root, a), d) != null)
			return true;
		else
			return false;
	}

	private TreeNode findPtr(TreeNode root, Comparable target)
	{
		if(root == null)
		{
			return null;
		}
		else if(root.getValue().equals(target))
		{
			return root;
		}
		else if(((Comparable) root.getValue()).compareTo(target) < 0)
		{
			return findPtr(root.getRight(), target);
		}
		else
		{
			return findPtr(root.getLeft(), target);
		}
	}

	public void printLevel(int level)
	// post: prints the data fields of the tree, one per line
	{
		printLevel(myRoot, level);
		// System.out.println();
	}

	private void printLevel(TreeNode root, int level)
	{
		if(root == null)
		{
			return;
		}
		if(level == 0)
		{
			System.out.print(root.getValue() + "");
		}
		else if(level > 0)
		{
			printLevel(root.getLeft(), level - 1);
			printLevel(root.getRight(), level - 1);
		}
	}

	public void printInOrder()
	{
		Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
		TreeNode tempNode = myRoot;
		do
		{
			while (tempNode != null)
			{
				TreeNode copyNode = tempNode;
				treeNodeStack.push(copyNode);
				tempNode = tempNode.getLeft();
			}
			if(!treeNodeStack.empty())
			{
				tempNode = treeNodeStack.pop();
				System.out.print(tempNode.getValue());
				tempNode = tempNode.getRight();
			}
		} while (tempNode != null || !treeNodeStack.empty());
		System.out.println();
	}

	public void printByLevel()
	{
		if(myRoot == null)
		{
			return;
		}
		Queue<TreeNode> levelQueue = new LinkedList<TreeNode>();
		levelQueue.add(myRoot);
		while(!levelQueue.isEmpty())
		{
		TreeNode tempNode = levelQueue.remove(); 
		//:OOOO uses removed value, adds the left and right of that value to queue, then in order of line repeat 
		System.out.print(tempNode.getValue() + " ");
			if (tempNode.getLeft() != null) 
			{
				levelQueue.add(tempNode.getLeft());
	        }
	        if (tempNode.getRight() != null) 
	        {
	        	levelQueue.add(tempNode.getRight());
	        }
		}
        System.out.println();
		
		
	}

}
