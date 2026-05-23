import java.util.*;
import java.io.*;

public class RPNCalc
{
	private Scanner console;
	private Stack<String> myNumbersStack;
	private Queue<String> myMathQueue;

	public RPNCalc()
	{
		myNumbersStack = new Stack<String>();
		myMathQueue = new LinkedList<String>();
		console = new Scanner(System.in);
	}

	public void mainInput()
	{
		System.out.println("RPN Calculator");
		System.out.println("Type '=' to calculate \n");
		String choice;
		do
		{
			System.out.print("Type a number or math symbol: ");
			choice = console.nextLine() + "";
			System.out.println();
			postFix(choice);
		} while (!choice.equals("=") && !choice.equals("q"));
		
		if(!myMathQueue.isEmpty())
		{
			while (!myMathQueue.isEmpty())
			{
				System.out.print(myMathQueue.remove() + " ");
			}
			System.out.println("= " + myNumbersStack.pop() + "\n");
		}
		System.out.print("Continue?(-1 exit, enter to contunue): ");
		choice = console.nextLine() + "";
		System.out.println();
		if(!choice.equals("-1"))
		{
			mainInput();
		}
	}

	// modularize!!!!!1!!!!111!
	private boolean isLegalAction()
	{
		if(myNumbersStack.empty())
		{
			System.out.println("Add another number");
			return false;
		}
		else
		{
			return true;
		}
	}

	private void add()
	{
		int valueOne;
		int valueTwo;
		if(!isLegalAction())
		{
			return;
		}
		valueOne = Integer.valueOf(myNumbersStack.pop());
		if(!isLegalAction())
		{
			myNumbersStack.push(Integer.toString(valueOne));
			return;
		}
		valueTwo = Integer.valueOf(myNumbersStack.pop());
		myNumbersStack.push(Integer.toString(valueOne + valueTwo));
		myMathQueue.add("+");
	}

	private void subtract()
	{
		int valueOne;
		int valueTwo;
		if(!isLegalAction())
		{
			return;
		}
		valueOne = Integer.valueOf(myNumbersStack.pop());
		if(!isLegalAction())
		{
			myNumbersStack.push(Integer.toString(valueOne));
			return;
		}
		valueTwo = Integer.valueOf(myNumbersStack.pop());
		myNumbersStack.push(Integer.toString(valueTwo - valueOne));
		myMathQueue.add("-");
	}

	private void multiply()
	{
		int valueOne;
		int valueTwo;
		if(!isLegalAction())
		{
			return;
		}
		valueOne = Integer.valueOf(myNumbersStack.pop());
		if(!isLegalAction())
		{
			myNumbersStack.push(Integer.toString(valueOne));
			return;
		}
		valueTwo = Integer.valueOf(myNumbersStack.pop());
		myNumbersStack.push(Integer.toString(valueOne * valueTwo));
		myMathQueue.add("*");
	}

	private void divide()
	{
		int valueOne;
		int valueTwo;
		if(!isLegalAction())
		{
			return;
		}
		valueOne = Integer.valueOf(myNumbersStack.pop());
		if(!isLegalAction())
		{
			myNumbersStack.push(Integer.toString(valueOne));
			return;
		}
		valueTwo = Integer.valueOf(myNumbersStack.pop());
		myNumbersStack.push(Integer.toString(valueTwo / valueOne));
		myMathQueue.add("/");
		return;
	}

	private void postFix(String input)
	{
		// IMPORTANT!: deal w/ special cases
		if(input.equals(""))
		{
			return;
		}
		switch (input)
		{
		case "q":
			break;
		case "=":
			break;
		case "+":
			add();
			break;
		case "-":
			subtract();
			break;
		case "*":
			multiply();
			break;
		case "/":
			divide();
			break;
		default:
			myNumbersStack.push(input);
			myMathQueue.add(input);
			break;
		}
	}
}
