import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
public class new_paitient extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame new_paitient_frame = new JFrame("Add New Paitient");
	
	JLabel lblname,lpid,lpfname, lpmname, lplname, lpage, lpbldgrp, lpdisease, lpweight, lpdob, lpaddress, lpmobileno;
	JTextField tpid, tpfname, tpmname, tplname, tpage, tpdisease, tpweight, tpdob, tpaddress, tpmobileno;
	JButton psubmit, pback_menu, pdisplay_info;
	JComboBox cmbpblood_group;
	
	Connection conn=null;
	PreparedStatement prestatement=null;
	Statement statement=null;
	new_paitient()
	{
		new_paitient_frame.setLayout(null);
		
		lblname = new JLabel("ADD NEW PAITIENT");
		lblname.setBounds(350,10,250,30);
		Font ftblname = new Font("Constantia",Font.PLAIN,22);
		lblname.setFont(ftblname);

		tpid = new JTextField();
		tpid.setBounds(150, 45, 160, 25);
		lpid = new JLabel("Paitient ID");
		lpid.setBounds(20,40,200,30);
		Font pidfont = new Font("Constantia",Font.PLAIN,18);
		lpid.setFont(pidfont);
	
		tpfname = new JTextField();
		tpfname.setBounds(150, 78, 160, 25);
		lpfname = new JLabel("First Name");
		lpfname.setBounds(20,75,200,30);
		Font ftpfname = new Font("Constantia",Font.PLAIN,18);
		lpfname.setFont(ftpfname);
	
		tpmname = new JTextField();
		tpmname.setBounds(500, 78, 160, 25);
		lpmname = new JLabel("Middle Name");
		lpmname.setBounds(390,75,200,30);
		Font ftpmname = new Font("Constantia",Font.PLAIN,18);
		lpmname.setFont(ftpmname);

	
		tplname = new JTextField();
		tplname.setBounds(800, 78, 150, 25);
		lplname = new JLabel("Last Name");
		lplname.setBounds(700,75,200,30);
		Font ftplname = new Font("Constantia",Font.PLAIN,18);
		lplname.setFont(ftplname);
		
		tpaddress = new JTextField();
		tpaddress.setBounds(150, 108, 160, 25);
		lpaddress = new JLabel("Address");
		lpaddress.setBounds(20,105,200,30);
		Font ftpaddress = new Font("Constantia",Font.PLAIN,18);
		lpaddress.setFont(ftpaddress);
		
		tpmobileno = new JTextField();
		tpmobileno.setBounds(150, 138, 160, 25);
		tpmobileno.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke)
			{
				char ch = ke.getKeyChar();
				if(!Character.isAlphabetic(ch))
				{
					if(tpmobileno.getText().length() <= 9)
					{
						tpmobileno.setEnabled(true);
					}
					else
					{
						tpmobileno.setEditable(false);
						JOptionPane.showMessageDialog(null, "Only 10 digit number is allowed");
						tpmobileno.setEditable(true);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Only numbers are allowed");
					tpmobileno.setText(null);
				}
			}
		});
		lpmobileno = new JLabel("Mobile Number");
		lpmobileno.setBounds(20,135,200,30);
		Font ftpmobileno = new Font("Constantia",Font.PLAIN,18);
		lpmobileno.setFont(ftpmobileno);
		
		tpdob = new JTextField();
		tpdob.setBounds(150, 168, 160, 25);
		lpdob= new JLabel("Date of Birth");
		lpdob.setBounds(20,165,200,30);
		Font ftpdob = new Font("Constantia",Font.PLAIN,18);
		lpdob.setFont(ftpdob);
		
		tpage = new JTextField();
		tpage.setBounds(150, 198, 160, 25);
		lpage = new JLabel("Age");
		lpage.setBounds(20,195,200,30);
		Font ftpage = new Font("Constantia",Font.PLAIN,18);
		lpage.setFont(ftpage);
		
		tpweight = new JTextField();
		tpweight.setBounds(150, 228, 160, 25);
		lpweight = new JLabel("Weight");
		lpweight.setBounds(20,225,200,30);
		Font ftpweight = new Font("Constantia",Font.PLAIN,18);
		lpweight.setFont(ftpweight);
	
		String blood_group_option[] = {"A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"};
		
		cmbpblood_group = new JComboBox(blood_group_option);
		cmbpblood_group.setBounds(150, 258, 160, 25);
		lpbldgrp = new JLabel("Blood group");
		lpbldgrp.setBounds(20,255,200,30);
		Font ftpbldgrp = new Font("Constantia",Font.PLAIN,18);
		lpbldgrp.setFont(ftpbldgrp);
	
	
		tpdisease = new JTextField();
		tpdisease.setBounds(150, 288, 160, 25);
		lpdisease = new JLabel("Disease");
		lpdisease.setBounds(20,285,200,30);
		Font ftpdisease = new Font("Constantia",Font.PLAIN,18);
		lpdisease.setFont(ftpdisease);
	
		new_paitient_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new_paitient_frame.add(lpid);
		new_paitient_frame.add(lpfname);
		new_paitient_frame.add(lpmname);
		new_paitient_frame.add(lplname);
		new_paitient_frame.add(lpage);
		new_paitient_frame.add(lpbldgrp);
		new_paitient_frame.add(lpdisease);
		new_paitient_frame.add(lpweight);
		new_paitient_frame.add(lpdob);
		new_paitient_frame.add(lpaddress);
		new_paitient_frame.add(lpmobileno);
		new_paitient_frame.add(lblname);
	
		new_paitient_frame.add(tpid);
		new_paitient_frame.add(tpfname);
		new_paitient_frame.add(tpmname);
		new_paitient_frame.add(tplname);
		new_paitient_frame.add(tpage);
		new_paitient_frame.add(cmbpblood_group);
		new_paitient_frame.add(tpdisease);
		new_paitient_frame.add(tpweight);
		new_paitient_frame.add(tpdob);
		new_paitient_frame.add(tpaddress);
		new_paitient_frame.add(tpmobileno);
		
		
		psubmit = new JButton("SUBMIT");
		psubmit.setBounds(180,400,160,35);
		psubmit.addActionListener(this);
		new_paitient_frame.add(psubmit);
		Font ftpsubmit = new Font("Constantia",Font.PLAIN,18);
		psubmit.setFont(ftpsubmit);
		
		pback_menu = new JButton("BACK TO MENU");
		pback_menu.setBounds(350,400,190,35);
		pback_menu.addActionListener(this);
		new_paitient_frame.add(pback_menu);
		Font ftpback_menu = new Font("Constantia",Font.PLAIN,18);
		pback_menu.setFont(ftpback_menu);
		
		pdisplay_info = new JButton("DISPLAY PAITIENT DETAILS");
		pdisplay_info.setBounds(550,400,300,35);
		pdisplay_info.addActionListener(this);
		new_paitient_frame.add(pdisplay_info);
		Font ftpdisplay_info = new Font("Constantia",Font.PLAIN,18);
		pdisplay_info.setFont(ftpdisplay_info);
		

		
		new_paitient_frame.setSize(1000,500);
		new_paitient_frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		if(e.getSource() == psubmit)
		{
			String pid = tpid.getText();			
			String pfname = tpfname.getText();
			String pmname = tpmname.getText();
			String plname = tplname.getText();
			String page = tpage.getText();
			String pbldgrp =(String) cmbpblood_group.getSelectedItem();
			String pdisease = tpdisease.getText();
			String pweight = tpweight.getText();
			String pdob = tpdob.getText();
			String paddress = tpaddress.getText();
			String pmobileno = tpmobileno.getText();
			
			Connection conn;
			
			int ipage=Integer.parseInt(page);
			int ipid = Integer.parseInt(pid);
			int iweight = Integer.parseInt(pweight);
			try 
			{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","sarthak333");
				statement=conn.createStatement();
				String query="insert into paitient_information(p_id,p_fname,p_mname,p_lname,p_age,p_bloodgroup,p_disease,p_weight,p_dob, p_address, p_mobile_number) "+" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				prestatement=conn.prepareStatement(query);
				prestatement.setInt(1, ipid);
				prestatement.setString(2, pfname);
				prestatement.setString(3, pmname);
				prestatement.setString(4, plname);
				prestatement.setInt(5, ipage);
				prestatement.setString(6, pbldgrp);
				prestatement.setString(7, pdisease);
				prestatement.setInt(8, iweight);
				prestatement.setString(9, pdob);
				prestatement.setString(10, paddress);
				prestatement.setString(11, pmobileno);
				prestatement.execute();
				conn.close();
				JOptionPane.showMessageDialog(null, "IFORMATION ADDED SUCCESSFULLY !!!");
			
			}
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == pback_menu)
		{
			new_paitient_frame.setVisible(false);
			new Menu();
		}
		if(e.getSource() == pdisplay_info)
		{
			new_paitient_frame.setVisible(false);
			new Paitient_Information(null);
		}
	}
	public static void main(String args[])
	{
		new new_paitient();
	}

}
