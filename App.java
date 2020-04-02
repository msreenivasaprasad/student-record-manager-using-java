import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class App {
	public static void main(String[] args) {
		JDBC.establish();
		mainframe.main();
SearchClass.main(args);
	}
}

class mainframe implements ActionListener {

	public static void main() {
		JButton reset = new JButton("Reset");
		JFrame mainframe = new JFrame();
		JLabel phnow = new JLabel("Enter 10 Digits");
		JLabel collegel = new JLabel("College");
		JTextField name = new JTextField();
		JTextField branch = new JTextField();
		JTextField id = new JTextField();
		JButton save = new JButton("Save");
		JTextField score = new JTextField();
		JTextField college = new JTextField();
		mainframe.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JDBC.terminate();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				JDBC.terminate();

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

		});
		JLabel idl = new JLabel("ID");
		JLabel namel = new JLabel("Name");
		JLabel cgpal = new JLabel("CGPA");
		JLabel branchl = new JLabel("Branch");
		JLabel scoreerror = new JLabel("CGPA must have 2 decimal places");
		JTextField phoneno = new JTextField();
		JLabel phonenol = new JLabel("Phone No");
        JButton clearrecord=new JButton("Clear Record");
		phnow.setFont(new Font("Verdana", Font.ITALIC, 10));
		phnow.setForeground(Color.RED);
              
		mainframe.setVisible(true);
		mainframe.setLayout(null);
		mainframe.setBounds(30,100,500, 300);
		mainframe.add(id);
		mainframe.add(phoneno);
		
		 JLabel mlabel=new JLabel("Save");
	        mlabel.setFont(new Font("TimesRoman",Font.ROMAN_BASELINE,30));
		mlabel.setBounds(100, 8, 100, 50);
		mainframe.add(mlabel);
		mlabel.setVisible(true);
		phoneno.setBounds(100, 150, 150, 20);
		phoneno.setVisible(true);
		mainframe.add(phonenol);
		phonenol.setBounds(40, 150, 100, 20);
		mainframe.add(clearrecord);
		clearrecord.setVisible(true);
		clearrecord.setBounds(300,200,120,20);
		clearrecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDBC.clearrecord();
				
			}
		});
		phonenol.setVisible(true);
		mainframe.add(phnow);
		phnow.setBounds(100, 165, 100, 20);
		phnow.setVisible(false);
		mainframe.add(scoreerror);
		scoreerror.setBounds(300, 70, 200, 20);
		scoreerror.setFont(new Font("Verdana", Font.ITALIC, 10));
		mainframe.add(college);
		mainframe.add(collegel);
		collegel.setVisible(true);
		collegel.setBounds(260, 150, 50, 20);
		college.setVisible(true);
		college.setBounds(320, 150, 150, 20);
		mainframe.add(reset);
		reset.setVisible(true);
		reset.setBounds(200, 200, 80, 20);
		reset.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				name.setText(null);
				branch.setText(null);
				id.setText(null);
				college.setText(null);
				phoneno.setText(null);
				score.setText(null);
				scoreerror.setVisible(false);
                phnow.setVisible(false);
			}

		});

		scoreerror.setVisible(false);
		id.setVisible(true);
		id.setBounds(100, 100, 150, 20);
		mainframe.add(branchl);
		branchl.setBounds(40, 50, 50, 20);
		mainframe.add(branch);
		mainframe.add(cgpal);
		cgpal.setVisible(true);
		cgpal.setBounds(260, 50, 40, 20);
		branch.setVisible(true);
		branch.setBounds(100, 50, 150, 20);
		mainframe.add(idl);
		idl.setBounds(40, 100, 30, 20);
		idl.setVisible(true);
		mainframe.add(namel);
		namel.setVisible(true);
		namel.setBounds(260, 100, 50, 20);
		mainframe.add(save);
		mainframe.add(score);
		score.setBounds(320, 50, 150, 20);
		score.setVisible(true);
		save.setBounds(100, 200, 80, 20);
		save.setVisible(true);
		mainframe.add(name);
		name.setVisible(true);
		name.setBounds(320, 100, 150, 20);

		save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String temp = new String(score.getText());
				char[] carray = new char[4];
				int flag = 0;
				carray = temp.toCharArray();
				if (temp.length() == 4) {
					if (carray[1] == '.') {
						flag = 1;
					}
				}

				if (flag == 1 && phoneno.getText().length() == 10) {
					
					JDBC.intodb(id.getText(), name.getText(), branch.getText(), score.getText(), phoneno.getText(),
							college.getText());
					name.setText(null);
					branch.setText(null);
					id.setText(null);
					college.setText(null);
					phoneno.setText(null);
					score.setText(null);
					
				} else {
					if (phoneno.getText().length() != 10) {
						phnow.setVisible(true);
					}

					if (flag == 0) {
						scoreerror.setVisible(true);

					}
				}

				flag = 0;
			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}