import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
public class Menu extends JFrame implements ActionListener 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JFrame menu_frame = new JFrame("Menu");
	JLabel lb = new JLabel("AAROGYA HOSPITAL, PUNE");
	JLabel info = new JLabel("We provide the best paitient care with our integrated Hospital Management System");
	JLabel info1 = new JLabel("AAROGYA, a unified solution in Hospital Management System(HMS) for large too mid");
	JLabel info2 = new JLabel("sized hospital polyclinic fascilitate managing functioning of the whole Hospital day to day activities.");
	JButton add_paitient = new JButton("Add New Paitient");
	JButton add_doctor = new JButton("Add New Doctor");
	JButton paitient_info = new JButton("Paitients Information");
	JButton doctor_info = new JButton("Doctor's Information");
	JButton exit = new JButton("Exit");
	Menu()
	{
		menu_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lb.setBounds(250,10,300,30);
		Font flb = new Font("Constantia",Font.BOLD,18);
		lb.setFont(flb);
		info.setBounds(130,50,700,30);
		
		info1.setBounds(130,70,700,30);
		info2.setBounds(90,90,700,30);
		menu_frame.add(info);
		menu_frame.add(info1);
		menu_frame.add(info2);
		
		add_paitient.setBounds(250,130,200,30);
		add_paitient.addActionListener(this);
		
		add_doctor.setBounds(250,170,200,30);
		add_doctor.addActionListener(this);
		
		paitient_info.setBounds(250,210,200,30);
		paitient_info.addActionListener(this);
		
		doctor_info.setBounds(250,250,200,30);
		doctor_info.addActionListener(this);
		
		exit.setBounds(250,290,200,30);
		exit.addActionListener(this);
		
		
		menu_frame.add(add_paitient);
		menu_frame.add(add_doctor);
		menu_frame.add(paitient_info);  
		menu_frame.add(doctor_info);
		menu_frame.add(exit);
		menu_frame.add(lb);
		
		menu_frame.setSize(700, 500);
		menu_frame.setLocationRelativeTo(null);

		menu_frame.setLayout(null);
		menu_frame.setVisible(true);
		
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		if(e.getSource()==add_paitient) 
		{
			menu_frame.setVisible(false);
			new_paitient.main(new String[]{});
		}
		if(e.getSource()==add_doctor)
		{
			menu_frame.setVisible(false);
			new_doctor.main(new String[]{});
		}
		if(e.getSource() == paitient_info)
		{
			menu_frame.setVisible(false);
			Paitient_Information.main(new String[] {});
		}
		if(e.getSource()==doctor_info)
		{
			menu_frame.setVisible(false);
			Doctor_Information.main(new String[] {});
		}
		if(e.getSource()==exit)
		{
			new JOptionPane();
			int input = JOptionPane.showConfirmDialog(null, "Do you want to Exit ?");
			if(input == JOptionPane.OK_OPTION )
			{
				System.exit(0);
			}
			if(input == JOptionPane.CANCEL_OPTION)
			{
				menu_frame.setVisible(false);
				System.exit(0);
			}
		}
	}
	public static void main(String args[])
	{
		new Menu();
	}
}