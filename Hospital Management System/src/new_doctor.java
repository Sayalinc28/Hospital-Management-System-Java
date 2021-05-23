import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement; 
public class new_doctor extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame add_doc=new JFrame("ADD DOCTOR");
	public JTextField first_name,middle_name,last_name,qualification, Internship;
	JTextField doc_id, doc_mob,doc_clgname,doc_age, doc_dob,doc_address;
	JLabel lblname,ldoc_id,lfirst_name,lmiddle_name,llast_name,lqualification,exp_label,ldoc_age,lacc_bal,ldoc_mob,ldoc_clgname, ldoc_dob,ldoc_address,lbInternship;
	JButton ddisplay_info,create_button,back_menu;
	JComboBox experience;
	
	Connection conn=null;
	PreparedStatement prestatement=null;
	Statement statement=null;
	
	new_doctor()
	{	 	
		lblname = new JLabel("ADD NEW DOCTOR");
		lblname.setBounds(350,10,250,30);
		Font ftblname = new Font("Constantia",Font.PLAIN,22);
		lblname.setFont(ftblname);
		
		doc_id = new JTextField();
		doc_id.setBounds(150, 45, 160, 25);
		ldoc_id = new JLabel("Doctor's ID:");
		ldoc_id.setBounds(20,40,200,30);
		Font ftdoc_id = new Font("Constantia",Font.PLAIN,18);
		ldoc_id.setFont(ftdoc_id);
		
		first_name=new JTextField();
		first_name.setBounds(150, 78, 160, 25);
		lfirst_name=new JLabel("First Name : ");
		lfirst_name.setBounds(20,75,200,30);
		Font ftfirst_name = new Font("Constantia",Font.PLAIN,18);
		lfirst_name.setFont(ftfirst_name);
		
		middle_name=new JTextField();
		middle_name.setBounds(500, 78, 160, 25);
		lmiddle_name=new JLabel("Middle Name : ");
		lmiddle_name.setBounds(390,75,200,30);
		Font ftmiddle_name = new Font("Constantia",Font.PLAIN,18);
		lmiddle_name.setFont(ftmiddle_name);
		
		last_name=new JTextField();
		last_name.setBounds(800, 78, 150, 25);
		llast_name=new JLabel(" Last Name : ");
		llast_name.setBounds(700,75,200,30);
		Font ftlast_name = new Font("Constantia",Font.PLAIN,18);
		llast_name.setFont(ftlast_name);
		
		doc_address=new JTextField();
		doc_address.setBounds(150, 108, 160, 25);
		ldoc_address=new JLabel("Address : ");
		ldoc_address.setBounds(20,105,200,30);
		Font ftdoc_address = new Font("Constantia",Font.PLAIN,18);
		ldoc_address.setFont(ftdoc_address);
		
		doc_mob=new JTextField();
		doc_mob.setBounds(150, 138, 160, 25);
		doc_mob.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke)
			{
				char ch = ke.getKeyChar();
				if(!Character.isAlphabetic(ch))
				{
					if(doc_mob.getText().length() <= 9)
					{
						doc_mob.setEnabled(true);
					}
					else
					{
						doc_mob.setEditable(false);
						JOptionPane.showMessageDialog(null, "Only 10 digit number is allowed");
						doc_mob.setEditable(true);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Only numbers are allowed");
					doc_mob.setText(null);
				}
			}
		});
		ldoc_mob=new JLabel("Mobile Number : ");
		ldoc_mob.setBounds(20,135,200,30);
		Font ftdoc_mob = new Font("Constantia",Font.PLAIN,18);
		ldoc_mob.setFont(ftdoc_mob);

		doc_dob=new JTextField();
		doc_dob.setBounds(150, 168, 160, 25);
		ldoc_dob=new JLabel("Date of Birth : ");
		ldoc_dob.setBounds(20,165,200,30);
		Font ftdoc_dob = new Font("Constantia",Font.PLAIN,18);
		ldoc_dob.setFont(ftdoc_dob);

		qualification=new JTextField();
		qualification.setBounds(150, 198, 160, 25);
		lqualification=new JLabel("Qualification : ");
		lqualification.setBounds(20,195,200,30);
		Font ftqualification = new Font("Constantia",Font.PLAIN,18);
		lqualification.setFont(ftqualification);
		
		String option[]= {"Yes","No"};
		
		experience = new JComboBox(option);
		experience.setBounds(150, 228, 160, 25);
		exp_label=new JLabel("Experience : ");
		exp_label.setBounds(20,225,200,30);
		Font ftexp_label = new Font("Constantia",Font.PLAIN,18);
		exp_label.setFont(ftexp_label);
		
		Internship=new JTextField();
		Internship.setBounds(150, 258, 160, 25);
		lbInternship=new JLabel("Internship : ");
		lbInternship.setBounds(20,255,200,30);
		Font ftInternship = new Font("Constantia",Font.PLAIN,18);
		lbInternship.setFont(ftInternship);
		
		doc_age=new JTextField();
		doc_age.setBounds(150, 288, 160, 25);
		ldoc_age=new JLabel("Age : ");
		ldoc_age.setBounds(20,285,200,30);
		Font ftdoc_age = new Font("Constantia",Font.PLAIN,18);
		
		
		ldoc_age.setFont(ftdoc_age);

		ddisplay_info=new JButton("DISPLAY DOCTOR DETAILS"); 
		ddisplay_info.setBounds(550,400,300,35);
		ddisplay_info.addActionListener(this);
		Font ftddisplay_info = new Font("Constantia",Font.PLAIN,18);
		ddisplay_info.setFont(ftddisplay_info);
		
		create_button=new JButton("ADD DOCTOR");
		create_button.setBounds(180,400,160,35);
		create_button.addActionListener(this);
		Font ftcreate_button = new Font("Constantia",Font.PLAIN,18);
		create_button.setFont(ftcreate_button);
		
		
		back_menu=new JButton("BACK TO MENU");
		back_menu.setBounds(350,400,190,35);
		back_menu.addActionListener(this);
		Font ftback_menu = new Font("Constantia",Font.PLAIN,18);
		back_menu.setFont(ftback_menu);

		add_doc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add_doc.add(lblname);
		add_doc.add(doc_id);
		add_doc.add(ldoc_id);
		add_doc.add(doc_age);
		add_doc.add(ldoc_age);
		add_doc.add(qualification);
		add_doc.add(lqualification);
		add_doc.add(experience);
		add_doc.add(doc_mob);
		add_doc.add(ldoc_mob);
		add_doc.add(exp_label);
		add_doc.add(middle_name);
		add_doc.add(lmiddle_name);
		add_doc.add(lfirst_name);
		add_doc.add(first_name);
		add_doc.add(last_name);
		add_doc.add(llast_name);
		add_doc.add(doc_address);
		add_doc.add(ldoc_address);
		add_doc.add(doc_dob);
		add_doc.add(ldoc_dob);
		add_doc.add(ddisplay_info);
		add_doc.add(create_button);
		add_doc.add(back_menu);
		add_doc.add(Internship);
		add_doc.add(lbInternship);
		add_doc.setSize(1000,500);
		add_doc.setLayout(null);
		add_doc.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource() == back_menu)
		{
			add_doc.setVisible(false);
			Menu.main(new String[] {});
		}
		if(e.getSource() == ddisplay_info)
		{
			add_doc.setVisible(false);
			Doctor_Information.main(new String[] {});
		}
		if(e.getSource() == create_button)
		{
			String did = doc_id.getText();
			String dfname = first_name.getText();
			String dmname = middle_name.getText();
			String dlname = last_name.getText();
			String dqualification = qualification.getText();
			String experience_option = (String) experience.getSelectedItem();
			String dmbno = doc_mob.getText();
			String dage = doc_age.getText();
			String daddress = doc_address.getText();
			String dInternship = Internship.getText();
			String ddob = doc_dob.getText();
		
			Connection conn;
			
			int idid = Integer.parseInt(did);
			
			try
			{
				if(!did.isEmpty() && !dfname.isEmpty() && !dmname.isEmpty() && !dlname.isEmpty() && !dqualification.isEmpty() && !dmbno.isEmpty()  && !daddress.isEmpty())
				{
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","sarthak333");
					statement=conn.createStatement();
					
					{
						String query="insert into doctor_information(d_id,d_fname,d_mname,d_lname,d_qualification,d_experience,d_mobile_number,d_age,d_address,d_internship, d_dob) "+" values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						prestatement=conn.prepareStatement(query);
						prestatement.setInt(1, idid);
						prestatement.setString(2, dfname);
						prestatement.setString(3, dmname);
						prestatement.setString(4, dlname);
						prestatement.setString(5, dqualification);
						prestatement.setString(6, experience_option);
						prestatement.setString(7,dmbno );
						prestatement.setString(8, dage);
						prestatement.setString(9, daddress);
						prestatement.setString(10, dInternship);
						prestatement.setString(11, ddob);
						prestatement.execute();
						conn.close();
						JOptionPane.showMessageDialog(null, "IFORMATION ADDED SUCCESSFULLY !!!");
					}
				}
				else
				{
					new JOptionPane();
					JOptionPane.showMessageDialog(null, "Enter All Fields");
				}
			}
			catch (SQLException e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	public static void main(String args[])
	{
		new new_doctor();
	}

}
