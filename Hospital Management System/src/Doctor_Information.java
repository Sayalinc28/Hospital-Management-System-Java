import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Doctor_Information extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame display_doctor_info_frame = new JFrame();
	JButton dback_menu;
	
	private boolean status;
	
	Doctor_Information(String title) 
	{
		
		dback_menu = new JButton("BACK TO MENU.");
		dback_menu.setBounds(584,410,190,35);
		display_doctor_info_frame.add(dback_menu);
		dback_menu.addActionListener(this);
		display_doctor_info_frame.add(dback_menu);
		Font ftback_menu = new Font("Constantia",Font.PLAIN,18);
		dback_menu.setFont(ftback_menu);

		display_doctor_info_frame.setTitle(title);
		
		display_doctor_info_frame.setSize(800, 500);

		// Adding Table View
		display_doctor_info_frame.add(getTablePanel());

		display_doctor_info_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		display_doctor_info_frame.setVisible(true);
	}

	private JPanel getTablePanel() 
	{

		JPanel tableJPanel = new JPanel();
			
		tableJPanel.setLayout(new BorderLayout());
		// Column Header
		String[] columns = {"Doctor ID", "First Name", "Middle Name","Last Name", "qualification", "Experience", "Mobile Number","Age", "Address", "Internship",  "DOB"};

		// Getting Data for Table from Database
		Object[][] data = getDoctorDetails();
		
		// Creating JTable object passing data and header
		JTable paitientTable = new JTable(data, columns);
		tableJPanel.add(paitientTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(paitientTable, BorderLayout.CENTER);
		
		return tableJPanel;
	}

	private Object[][] getDoctorDetails()
	{
		Object[][] data = null;

		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Hospital";
		final String USERNAME = "root";
		final String PASSWORD = "sarthak333";
		
		final String QUERY = "Select d_id, d_fname, d_mname, d_lname, d_qualification, d_experience,d_mobile_number, d_age, d_address, d_internship, d_dob from doctor_information";

		try
		{
			Class.forName(DRIVER_NAME);
			Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(QUERY);

			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rs.beforeFirst();
			int i = 0;
			
			while (rs.next()) 
			{

				int j = 0;
				
				data[i][j++] = rs.getInt("d_id");
				data[i][j++] = rs.getString("d_fname");
				data[i][j++] = rs.getString("d_mname");
				data[i][j++] = rs.getString("d_lname");
				data[i][j++] = rs.getString("d_qualification");
				data[i][j++] = rs.getString("d_experience");
				data[i][j++] = rs.getString("d_mobile_number");
				data[i][j++] = rs.getString("d_age");
				data[i][j++] = rs.getString("d_address");
				data[i][j++] = rs.getString("d_internship");
				data[i][j++] = rs.getString("d_dob");
					
				i++;
			}

			status = true;
				
			 // Closing the Resources;
			statement.close();
			connection.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
	private int getRowCount(ResultSet rs) 
	{
		try 
		{			
			if(rs != null) 
			{
				rs.last();			
				return rs.getRow(); 
			}	
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
		return 0;
	}

	// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) 
	{
		try
		{
			if(rs != null)
			return rs.getMetaData().getColumnCount();
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public String toString() 
	{		
		return (status) ? "Data Listed Successfully" : "Application Error Occured";
	}

	public static void main(String[] args) 
	{

		String title = "Display Doctor Details";

		Doctor_Information doctorDetails = new Doctor_Information(title);

		System.out.println(doctorDetails);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == dback_menu)
		{
			display_doctor_info_frame.setVisible(false);
			Menu.main(new String[] {});
		}
		
	}

}