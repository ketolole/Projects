package finalproj;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;
import java.awt.Component;
import java.io.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
public class Registration extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldLastName;
	private JTextField textFieldFirstName;
	private JTextField textFieldID;
	private JTable table;
	private JTextField textFieldSearch;
	private DefaultTableModel model;
	private ArrayList<Student> stuList = new ArrayList<Student>();
	private Registration myReg;
	private ArrayList<Student> currentList;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Registration() {
		myReg = this;
		currentList = stuList;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(20, 10, 65, 23);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(20, 35, 65, 23);
		contentPane.add(lblFirstName);
		
		JLabel lblID = new JLabel("ID");
		lblID.setBounds(20, 60, 65, 23);
		contentPane.add(lblID);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setBounds(20, 85, 39, 23);
		contentPane.add(lblGrade);
		
		JLabel lblRadioLabel = new JLabel("");
		lblRadioLabel.setBounds(375, 53, 139, 14);
		contentPane.add(lblRadioLabel);
		
		JRadioButton rdbtnG9 = new JRadioButton("9");
		rdbtnG9.setBounds(69, 85, 39, 23);
		contentPane.add(rdbtnG9);
		
		JRadioButton rdbtnG10 = new JRadioButton("10");
		
		rdbtnG10.setBounds(110, 85, 39, 23);
		contentPane.add(rdbtnG10);
		
		JRadioButton rdbtnG11 = new JRadioButton("11");
		rdbtnG11.setBounds(164, 85, 39, 23);
		contentPane.add(rdbtnG11);
		
		JRadioButton rdbtnG12 = new JRadioButton("12");
		rdbtnG12.setBounds(216, 85, 39, 23);
		contentPane.add(rdbtnG12);
		
		ButtonGroup groupPeriod = new ButtonGroup();
		groupPeriod.add(rdbtnG9);
		groupPeriod.add(rdbtnG10);
		groupPeriod.add(rdbtnG11);
		groupPeriod.add(rdbtnG12);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(85, 10, 175, 20);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(85, 35, 175, 20);
		contentPane.add(textFieldFirstName);
		
		textFieldID = new JTextField();
		textFieldID.setColumns(10);
		textFieldID.setBounds(85, 60, 175, 20);
		contentPane.add(textFieldID);
		
		
		String[] headings = {"Last Name","First Name", "ID", "Grade"};
		 model = new DefaultTableModel(headings,0)
				{
				public boolean isCellEditable(int row, int col)
				{
				return false;
				}
				
				};
				
				
				
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setEnabled(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				if(!SwingUtilities.isRightMouseButton(event))
				{
					int row = table.getSelectedRow();
					Student stu = currentList.get(row);
					StudentInfoWindow infoWindow = new StudentInfoWindow(myReg, stu);
					infoWindow.setVisible(true);
					myReg.setVisible(false);
				}
			}
		});
		scrollPane.setBounds(297,13,369,231);
		contentPane.add(scrollPane);
		table.getTableHeader().setReorderingAllowed(false);
		table.setAlignmentX(CENTER_ALIGNMENT);
		
		loadFile();
		
		String[] periods = {"Search by:","Last Name","First Name","ID","Grade"};
		JComboBox<String> comboBoxSearchBy = new JComboBox(periods);
		comboBoxSearchBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBoxSearchBy.getSelectedIndex();
				if(index != 0)
				{
					textFieldSearch.setEnabled(true);
				}
				else
				{
					textFieldSearch.setEnabled(false);
				}
			}
		});
		comboBoxSearchBy.setMaximumRowCount(5);
		comboBoxSearchBy.setBounds(20, 205, 181, 23);
		contentPane.add(comboBoxSearchBy);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setEnabled(false);
		textFieldSearch.setColumns(10);
		textFieldSearch.setBounds(20, 232, 181, 20);
		contentPane.add(textFieldSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = comboBoxSearchBy.getSelectedIndex();
				
				
				if(index==0)
				{
					JOptionPane.showMessageDialog(null,"Choose a search option","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String searchValue = textFieldSearch.getText();
					
					currentList = findStudents(index,searchValue);
					
					refreshTable(currentList);
					
					//comboBoxSearchBy.setSelectedIndex(0);
					textFieldSearch.setText("");
				}
			}
		});
		btnSearch.setBounds(20, 180, 181, 23);
		contentPane.add(btnSearch);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writeToFile();
				JOptionPane.showMessageDialog(null,"Info saved to file!","Success!",JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnSave.setBounds(473, 272, 181, 23);
		contentPane.add(btnSave);
		
		JButton btnRefresh = new JButton("Refresh Table");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				currentList = stuList;
				refreshTable(stuList);
			}
		});
		btnRefresh.setBounds(20, 263, 181, 23);
		contentPane.add(btnRefresh);
		
		JButton btnAddStu = new JButton("Add Student");
		btnAddStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String last = textFieldLastName.getText();
				String first = textFieldFirstName.getText();
				String id = textFieldID.getText();
				String grade = getSelectedGrade(groupPeriod);
				
				if(isValidInfo(last, first, id, grade))
				{
					
					last = last.substring(0,1).toUpperCase() + last.substring(1);
					first = first.substring(0,1).toUpperCase() + first.substring(1);
					
					String[] stuInfo = {last,first,id, grade};
					Student aStu = new Student(textFieldLastName.getText(),textFieldFirstName.getText(), textFieldID.getText(), getSelectedGrade(groupPeriod));
					model.insertRow(findLocToAdd(aStu),stuInfo);
					stuList.add(findLocToAdd(aStu),aStu);
					textFieldLastName.setText("");
					textFieldFirstName.setText("");
					textFieldID.setText("");
					groupPeriod.clearSelection();
					JOptionPane.showMessageDialog(null,"Student Added","Success!",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});
		btnAddStu.setBounds(79, 119, 181, 23);
		contentPane.add(btnAddStu);
		
		
	}
	
	public int findLocToAdd(Student stu)
	{
		int index = 0;
		if(stuList.size() == 0)
		{
			return 0;
		}
		while(index < stuList.size() && stu.compareTo(stuList.get(index))> 0)
		{
			index++;
		}
		return index;
		
	}
	
	
	public ArrayList<Student> findByLastName(String searchFor)
	{
		ArrayList<Student> contains = new ArrayList<Student>();
		
		for(Student stu : stuList)
		{
			if(stu.getLastName().toLowerCase().indexOf(searchFor.toLowerCase()) !=-1)
			{
				contains.add(stu);
			}
			
		}
		
		return contains;
		
	}
	public ArrayList<Student> findStudents(int searchType, String searchFor)
	{
		
		if(searchType == 1)
		{
			return findByLastName(searchFor);
		}
		else if(searchType == 2)
		{
			return findByFirstName(searchFor);
		}
		else if(searchType == 3)
		{
			return findById(searchFor);
		}
		else if(searchType == 4)
		{
			return findByGrade(searchFor);
		}
		else
		{
		return new ArrayList<Student>();
		}
	}
	
	public ArrayList<Student> findByFirstName(String searchFor)
	{
		
		ArrayList<Student> contains = new ArrayList<Student>();
		
		for(Student stu : stuList)
		{
			if(stu.getFirstName().toLowerCase().indexOf(searchFor.toLowerCase()) !=-1)
			{
				contains.add(stu);
			}
			
		}
		
		return contains;
	}
	
	public ArrayList<Student> findById (String searchFor)
	{
		
		
		ArrayList<Student> contains = new ArrayList<Student>();
		
		for(Student stu : stuList)
		{
			if(stu.getID().indexOf(searchFor) !=-1)
			{
				contains.add(stu);
			}
			
		}
		
		return contains;
	}
	
	public ArrayList<Student> findByGrade (String searchFor)
	{
		
		ArrayList<Student> contains = new ArrayList<Student>();
		
		for(Student stu : stuList)
		{
			if(stu.getGrade().indexOf(searchFor) !=-1)
			{
				contains.add(stu);
			}
			
		}
		
		return contains;
	}
	public void writeToFile()
	{
		writeToFile("students.txt");
	}
	
	public void writeToFile(String fileName)
	{
		try
		{
			FileWriter writer = new FileWriter(fileName);
			
			// loop though array and write th student info into file
			for (Student stu : stuList)
			  {
				  for(String info: stu.getStudentInfo())
				  {
					  writer.write(info+"\n");
				  }
				
			  }
			writer.close();
		}
		catch(Exception err)
		{
			JOptionPane.showMessageDialog(null,err.getMessage(),"Uh oh",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void loadFile()
	{
		
		loadFile("students.txt");
		
		
	}
	public void loadFile(String fileName)
	{
		
		  try
		  {
		File file = new File(fileName);
		if(file.exists())
		{
		  Scanner inFile = new Scanner(file);
		 while(inFile.hasNextLine())
		 {
			 String last = inFile.nextLine();
			String first =inFile.nextLine();
			String id =inFile.nextLine();
			String grade =inFile.nextLine();
			Student addedStu = new Student(last, first, id, grade);
			int index = findLocToAdd(addedStu);
			stuList.add(index,addedStu);
			model.insertRow(index, addedStu.getStudentInfo());
		 }
			inFile.close();
		}
		else
			writeToFile(fileName);
		  }
		   catch(Exception err) {
			   JOptionPane.showMessageDialog(null,err.getMessage(),"Uh oh",JOptionPane.ERROR_MESSAGE);
		  }
		}
		
	
	public String getSelectedGrade(ButtonGroup group)
	{
		Enumeration<AbstractButton> buttons = group.getElements();
		while(buttons.hasMoreElements())
		{
			AbstractButton button = buttons.nextElement();
			if(button.isSelected())
			{
				return button.getText();
			}
		}
		return "";
	}
	public boolean isValidInfo(String last, String first, String id, String grade)
	{
		//not valid if info empty or grad enot sleced or id does not have exact 6 digits or id has non digits or id taken
		String errorMsg= "";
		
		if (last.length() == 0)
		{
			errorMsg += "Last name is missing.\n";
		}
		if (first.length() == 0)
		{
			errorMsg += "First name is missing.\n";
		}
		if (!isValidID(id))
		{
			errorMsg += "6-digits needed for ID.\n";
		}
		if (!isUniqueId(id))
		{
			errorMsg += "ID is already taken, choose another ID.\n";
		}
		if (grade.length() == 0)
		{
			errorMsg += "Grade level is not selected.\n";
		}
		
		if (errorMsg.length()>0) //there is problem
		{
			JOptionPane.showMessageDialog(null,errorMsg,"Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean isValidID(String id)
	{
		if(id.length() != 6)
		{
			return false;
		}
		else if(!hasOnlyDigits(id))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean hasOnlyDigits(String id)
	{
		try
		{
		Integer.parseInt(id); //crash --> not all numbers
		return true;	
		}
		catch(Exception err)
		{
			return false;
		}
	}
	public boolean isUniqueId(String id)
	{
		
		for(Student stu: stuList)
		{
			if (stu.getID().equals(id))
			{
				return false;
			}
		}
		return true;
	}
	public void removeAllRows()
	{
		for(int i = 0; i <stuList.size(); i++ )
		{
			model.removeRow(i);
			i--;
		}
	}
	public ArrayList<Student> getStudentList()
	{
		return stuList;
	}
	public void refreshTable(ArrayList<Student> foundList)
	{
		model.setRowCount(0);
		for(Student aStu : foundList)
		{
			model.addRow(aStu.getStudentInfo());
		}
	}
}



