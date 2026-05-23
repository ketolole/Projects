/**
*  Binary tree lab
*
* @author     G. Peck
* @created    July 2, 2003
*
* Modified by Jason Quesenberry and Nancy Quesenberry
* February 9, 2006
*/
import java.util.Scanner;
import java.io.*;
public class BSTree
{
	private Scanner console;
	public BSTree()
	{
		console = new Scanner(System.in);
	}
	void testFind(BinarySearchTree temp)
	{
		String idToFind = null;
		String location;
		System.out.println("Testing search algorithm\n");
		System.out.print("Enter Id letter to search for (-1 to quit) --> ");
		if(console.hasNextLine())
		{
			idToFind = console.nextLine();
		}
		else
		{
			System.out.println("Type something");
			testFind(temp);
		}
		while(!idToFind.equals("-1"))
		{
			location = (String) temp.find(idToFind);
			if(location == null)
			{
				System.out.println("Letter: " + idToFind + "  No such value");
			}
			else
			{
				String foundString = (String) location;
				System.out.println("Letter: " + idToFind + " found.");
			}
			System.out.println();
			System.out.print("Enter a letter to search for (-1 to quit) --> ");
			idToFind = console.nextLine();
		}
	}
	public void testDelete(BinarySearchTree temp)
	{
		String idToDelete;
		boolean success;
		System.out.println("Testing delete algorithm\n");
		System.out.print("Enter letter to delete (-1 to quit) --> ");
		idToDelete = console.nextLine();
		while(!idToDelete.equals("-1"))
		{
			if(temp.find(idToDelete) == null)
			{
				System.out.println("Id letter " + idToDelete + " No such value");
			}
			else
			{
				temp.delete(idToDelete);
				System.out.println("Id letter " + idToDelete + " was deleted");
			}
			System.out.println();
			System.out.print("Enter Id letter to delete (-1 to quit) --> ");
			idToDelete = console.nextLine();
		}
	}
	public void readData(BinarySearchTree temp)
	{
		Scanner inFile;
		String id;
		try
		{
			System.out.print("File name?(-1 to cancel, enter for default file): ");
			String fileName = console.nextLine();
			if(fileName.equals("-1"))
			{
				return;
			}
			if(fileName.equals(""))
			{
				fileName = "fileB.txt";
			}
			inFile = new Scanner(new File(fileName));
			//System.out.println();
			while(inFile.hasNext())
			{
				id = inFile.nextLine();
				temp.insert(id);
			}
			inFile.close();
		} catch (
		IOException i)
		{
			System.out.println("Error: " + i.getMessage());
			readData(temp);
		}
	}
	public void ancestorCheckTest(BinarySearchTree root)
	{
		System.out.print("Give an ancestor(-1 to cancel): ");
		String ancestorCheck = console.nextLine();
		if(ancestorCheck.equals("-1"))
		{
			return;
		}
		System.out.println();
		System.out.print("Give a descendant(-1 to cancel): ");
		String descendantCheck = console.nextLine();
		if(descendantCheck.equals("-1"))
		{
			return;
		}
		System.out.println();
		boolean isAnAncestor = root.isAncestor(ancestorCheck, descendantCheck);
		if(isAnAncestor)
			System.out.println("Root " + ancestorCheck + " is an ancestor of " + descendantCheck);
		else
			System.out.println("Root " + ancestorCheck + " is NOT an ancestor of " + descendantCheck);
		System.out.print("Continue?(-1 to exit, enter to continue): ");
		String continueCheck = console.nextLine();
		if(!continueCheck.equals("-1"))
		{
			System.out.println();
			ancestorCheckTest(root);
		}
		
	}
	public void mainMenu(BinarySearchTree root)
	{
		String choice;
		do
		{
			System.out.println("\nBinary tree menu\n");
			System.out.println("(1) Fill the tree from a file");
			System.out.println("(2) Print tree preorder");
			System.out.println("(3) Print tree inorder");
			System.out.println("(4) Print tree postorder");
			System.out.println("(5) Count nodes in tree");
			System.out.println("(6) Count the leaves in the tree");
			System.out.println("(7) Find the height of the tree");
			System.out.println("(8) Find the width of the tree");
			System.out.println("(9) Clear the tree");
			System.out.println("(10) Interchange the tree(mirror image)");
			System.out.println("(11) Print levels");
			System.out.println("(12) isAncestor");
			System.out.println("(13) Find");
			System.out.println("(14) Delete");
			System.out.println("(15) Print by level");
			System.out.println("(Q) Quit\n");
			System.out.print("Choice ---> ");
			choice = console.nextLine() + "";
			System.out.println();
			switch (choice)
			{
			case "1":
				readData(root);
				break;
			case "2":
				System.out.println("The tree printed preorder\n");
				root.printPreorder();
				System.out.println();
				break;
			case "3":
				System.out.println("The tree printed inorder\n");
				root.printInorder();
				System.out.println();
				break;
			case "4":
				System.out.println("The tree printed postorder\n");
				root.printPostorder();
				System.out.println();
				break;
			case "5":
				System.out.println("Number of nodes = " + root.countNodes());
				break;
			case "6":
				System.out.println("Number of leaves = " + root.countLeaves());
				break;
			case "7":
				System.out.println("Tree height: " + root.height());
				break;
			case "8":
				System.out.println("Tree width: " + root.width());
				break;
			case "9":
				System.out.println("Tree cleared");
				root.clearTree();
				break;
			case "10":
				System.out.println("Tree interchanged");
				root.interchange();
				break;
			case "11":
				System.out.print("Print level (-1 to quit): ");
				int level = console.nextInt();
				while(level != -1)
				{
					root.printLevel(level);
					System.out.println("\n");
					System.out.print("Print level (-1 to quit): ");
					level = console.nextInt();
				}
				if(console.hasNextLine())
				{
					console.nextLine();
				}
				break;
			case "12":
				ancestorCheckTest(root);
				break;
			case "13":
				testFind(root);
				break;
			case "14":
				testDelete(root);
				break;
			case "15":
				root.printByLevel();
				break;
			case "Q":// idk nothing happens;
				break;
			case "q":
				break;
			}
		}
		while(!choice.equals("Q") && !choice.equals("q"));
		console.close();
	}
}


