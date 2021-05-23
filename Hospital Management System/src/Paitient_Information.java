import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Paitient_Information extends JFrame implements ActionListener

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	JFrame display_paitient_info_frame = new JFrame();
	JButton back_menu;
	
	private boolean status;
	
	Paitient_Information(String title) 
	{			
		back_menu = new JButton("BACK TO MENU");
		back_menu.setBounds(584,410,190,35);
		back_menu.addActionListener(this);
		display_paitient_info_frame.add(back_menu);
		Font ftback_menu = new Font("Constantia",Font.PLAIN,18);
		back_menu.setFont(ftback_menu);
		
		display_paitient_info_frame.setTitle(title);
		display_paitient_info_frame.setSize(800, 500);

		// Adding Table View
		display_paitient_info_frame.add(getTablePanel());

		display_paitient_info_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display_paitient_info_frame.setVisible(true);
	}

	private JPanel getTablePanel() 
	{
		JPanel tableJPanel = new JPanel();			
		tableJPanel.setLayout(new BorderLayout());
			
		// Column Header
		String[] columns = {
				"paitient ID", "First Name", "Middle Name",
					"Last Name", "Age", "Blood Group", "Disease", "Weight", "DOB", "Address", "Mobile Number" };

		// Getting Data for Table from Database
		Object[][] data = getPaitientDetails();

		// Creating JTable object passing data and header
		JTable paitientTable = new JTable(data, columns);
		tableJPanel.add(paitientTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(paitientTable, BorderLayout.CENTER);
			
		return tableJPanel;
	}

	private Object[][] getPaitientDetails()
	{

		Object[][] data = null;

		final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
		final String CONNECTION_URL = "jdbc:mysql://localhost:3306/Hospital";
		final String USERNAME = "root";
		final String PASSWORD = "sarthak333";

		final String QUERY = "Select p_id, p_fname, p_mname, p_lname, p_age, p_bloodgroup, p_disease, p_weight, p_dob, p_address, p_mobile_number from paitient_information";

		try
		{

			// Loading the Driver
			Class.forName(DRIVER_NAME);

			// Getting Database Connection Object by Passing URL, Username and Password
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

				data[i][j++] = rs.getInt("p_id");
				data[i][j++] = rs.getString("p_fname");
				data[i][j++] = rs.getString("p_mname");
				data[i][j++] = rs.getString("p_lname");
				data[i][j++] = rs.getInt("p_age");
				data[i][j++] = rs.getString("p_bloodgroup");
				data[i][j++] = rs.getString("p_disease");
				data[i][j++] = rs.getInt("p_weight");
				data[i][j++] = rs.getString("p_dob");
				data[i][j++] = rs.getString("p_address");
				data[i][j++] = rs.getString("p_mobile_number");
				
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

		String title = "Paitient Details Table";

		Paitient_Information paitientDetails = new Paitient_Information(title);

		System.out.println(paitientDetails);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == back_menu)
		{
			display_paitient_info_frame.setVisible(false);
			Menu.main(new String[] {});
		}
	}

}
