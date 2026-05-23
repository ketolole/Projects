package finalproj;
import java.awt.EventQueue;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class StudentInfoWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	private JTextField textFieldLastName;
	private JTextField textFieldFirstName;
	private JTextField textFieldID;
	private JRadioButton rdbtnG9;
	private JRadioButton rdbtnG10;
	private JRadioButton rdbtnG11;
	private JRadioButton rdbtnG12;
	private Registration myReg;
	
	private Student myStudent;
	
// =^._.^=
	/**
	 * Create the frame.
	 */
	public StudentInfoWindow(Registration reg, Student stu) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				myReg.setVisible(true);
			}
		});
		
		myReg = reg;
		myStudent = stu;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 457, 300);
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
		
		rdbtnG9 = new JRadioButton("9");
		rdbtnG9.setEnabled(false);
		rdbtnG9.setBounds(95, 85, 39, 23);
		contentPane.add(rdbtnG9);
		
		 rdbtnG10 = new JRadioButton("10");
		rdbtnG10.setEnabled(false);
		rdbtnG10.setBounds(175, 85, 39, 23);
		contentPane.add(rdbtnG10);
		
		 rdbtnG11 = new JRadioButton("11");
		rdbtnG11.setEnabled(false);
		rdbtnG11.setBounds(94, 110, 39, 23);
		contentPane.add(rdbtnG11);
		
		 rdbtnG12 = new JRadioButton("12");
		rdbtnG12.setEnabled(false);
		rdbtnG12.setBounds(174, 110, 39, 23);
		contentPane.add(rdbtnG12);
		
		ButtonGroup groupPeriod = new ButtonGroup();
		groupPeriod.add(rdbtnG9);
		groupPeriod.add(rdbtnG10);
		groupPeriod.add(rdbtnG11);
		groupPeriod.add(rdbtnG12);
		selectButton(myStudent.getGrade());
		
		textFieldLastName = new JTextField(stu.getLastName());
		textFieldLastName.setEnabled(false);
		textFieldLastName.setBounds(85, 10, 139, 20);
		contentPane.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldFirstName = new JTextField(stu.getFirstName());
		textFieldFirstName.setEnabled(false);
		textFieldFirstName.setBounds(85, 35, 139, 20);
		textFieldFirstName.setColumns(10);
		contentPane.add(textFieldFirstName);
		
		textFieldID = new JTextField(stu.getID());
		textFieldID.setEnabled(false);
		textFieldID.setBounds(85, 60, 139, 20);
		textFieldID.setColumns(10);
		contentPane.add(textFieldID);
		
		JButton btnEdit = new JButton("Click to edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enableButtons(groupPeriod);
				textFieldLastName.setEnabled(true);
				textFieldFirstName.setEnabled(true);
				textFieldID.setEnabled(true);
			}
		});
		btnEdit.setBounds(20, 150, 152, 23);
		contentPane.add(btnEdit);
		
		JLabel lblImage = new JLabel("\"Image\"");
		
		lblImage.setIcon(myStudent.getIcon());
		
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(241, 11, 183, 240);
		contentPane.add(lblImage);
		
		JButton btnEditSave = new JButton("Save edits");
		btnEditSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String last = textFieldLastName.getText();
				String first = textFieldFirstName.getText();
				String id = textFieldID.getText();
				String grade = myReg.getSelectedGrade(groupPeriod);
				
				ArrayList<Student> stuList = myReg.getStudentList();
				stuList.remove(myStudent);
				
				if(myReg.isValidInfo(last, first, id, grade))
				{
					String[] stuInfo = {last,first,id, grade};
					
					myStudent.setLastName(last);
					myStudent.setFirstName(first);
					myStudent.setID(id);
					myStudent.setGrade(grade);
					
					myStudent.updateIcon();
					lblImage.setIcon(myStudent.getIcon());
					
					//groupPeriod.clearSelection();
					
					disableButtons(groupPeriod);
					textFieldLastName.setEnabled(false);
					textFieldFirstName.setEnabled(false);
					textFieldID.setEnabled(false);
					
					JOptionPane.showMessageDialog(null,"Student Info Saved","Success!",JOptionPane.INFORMATION_MESSAGE);
				}
				stuList.add(myReg.findLocToAdd(myStudent),myStudent);
				myReg.refreshTable(stuList);
			}
		});
		btnEditSave.setBounds(20, 184, 152, 23);
		contentPane.add(btnEditSave);
		
		JButton btnRemove = new JButton("Remove students");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Student> stuList = myReg.getStudentList();
				
				stuList.remove(myStudent);
				myReg.refreshTable(stuList);
				myReg.setVisible(true);
				setVisible(false);
			}
		});
		btnRemove.setBounds(20, 218, 152, 23);
		contentPane.add(btnRemove);
		




		;
	}
	private void enableButtons(ButtonGroup group)
	{
		Enumeration<AbstractButton> buttons = group.getElements();
		while(buttons.hasMoreElements())
		{
			AbstractButton button = buttons.nextElement();
			button.setEnabled(true);
		}
	}
	
	private void disableButtons(ButtonGroup group)
	{
		Enumeration<AbstractButton> buttons = group.getElements();
		while(buttons.hasMoreElements())
		{
			AbstractButton button = buttons.nextElement();
			button.setEnabled(false);
		}
	}
	
	private void selectButton(String grade)
	{
		if(grade.equals("9"))
		{
			rdbtnG9.setSelected(true);
		}
		if(grade.equals("10"))
		{
			rdbtnG10.setSelected(true);
		}
		if(grade.equals("11"))
		{
			rdbtnG11.setSelected(true);
		}
		if(grade.equals("12"))
		{
			rdbtnG12.setSelected(true);
		}
	}
}



















