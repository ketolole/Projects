package finalproj;
import java.awt.Image;
import java.awt.image.BufferedImage;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Student {


private String myLastName;
private String myFirstName;
private String myGrade;
private String myID;


private BufferedImage myImg;
private ImageIcon icon;


	public Student(String lastName, String firstName,  String id, String grade)
	{
		myLastName = lastName;
		myFirstName = firstName;
		myGrade = grade;
		myID = id;
		updateIcon();
	}
	public ImageIcon getIcon()
	{
		//updateIcon();
		return icon;
	}
	
	public void updateIcon()
	{
		try
		{
			myImg = ImageIO.read(this.getClass().getResource(myID +".jpg"));
			icon = new ImageIcon(myImg.getScaledInstance(213,257,Image.SCALE_SMOOTH));
		}
		catch(Exception err)
		{
			try
			{
				myImg = ImageIO.read(this.getClass().getResource("000000"+".jpg"));
				icon = new ImageIcon(myImg.getScaledInstance(213,257,Image.SCALE_SMOOTH));
			}
			catch(Exception error)
			{
				JOptionPane.showMessageDialog(null,err.getMessage()+ myID+" not found","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public BufferedImage getPhoto()
	{
		return myImg;
	}
	
	public String getLastName()
	{
		return myLastName;
		
	}
	
	public String getFirstName()
	{
		return myFirstName;
		
	}
	
	public String getGrade()
	{
		return myGrade;
		
	}
	
	public String getID()
	{
		return myID;
		
	}
	
	public String[] getStudentInfo()
	{
		String[] info = {myLastName, myFirstName, myID, myGrade};
		return info;
		
	}
	
	public int compareTo(Object other)
	{
		Student otherStu = (Student)other;
		int compare = compareByLastName(otherStu);
		if(compare == 0)
		{
			compare = compareByFirstName(otherStu);
			if(compare == 0)
			{
				compare = compareByID(otherStu);
				if(compare == 0)
				{
					compare = compareByID(otherStu);
				}
			}
		}
	return compare;
	}
	
	public int compareByLastName(Student stu)
	{
	return myLastName.compareTo(stu.getLastName());	
	}
	public int compareByFirstName(Student stu)
	{
		return myFirstName.compareTo(stu.getFirstName());	
		
	}
	public int compareByGrade(Student stu)
	{
		return myGrade.compareTo(stu.getGrade());	
		
	}
	public int compareByID(Student stu)
	{
		return myID.compareTo(stu.getID());	
		
	}


	public void setLastName(String last) {
		myLastName = last;
		
	}
	public void setFirstName(String first) {
		myFirstName = first;
		
	}
	public void setID(String id) {
		myID = id;
		
	}
	public void setGrade(String grade) {
		myGrade = grade;
		
	}
}






