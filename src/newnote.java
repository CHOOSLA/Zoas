import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class newnote extends JPanel {

	/**
	 * Create the panel.
	 */
	public newnote(JFrame frame) {
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(144, 0, 600, 411);
		panel_2.setVisible(true);
		frame.getContentPane().add(panel_2);
		
		/*----------?? ??? ???? ?г? ???? ???????----------*/
		JTextField textField = new JTextField("?????"){
			 @Override public void setBorder(Border border) {
			        // No!
			    }
		};
		textField.setFont(new Font("???? ???", Font.BOLD, 17));
		textField.setBounds(20, 23, 200, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel linepanel_1 = new JPanel();
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(15, 71, 565, 2);
		panel_2.add(linepanel_1);
		
		JLabel p2_lb2 = new JLabel("2021-10-26 ???? 7?? 38??");
		p2_lb2.setFont(new Font("???? ???", Font.PLAIN, 11));
		p2_lb2.setBounds(20, 43, 137, 15);
		panel_2.add(p2_lb2);
		
		JButton p2_Button1 = new JButton("???? ???????");
		p2_Button1.setForeground(Color.WHITE);
		p2_Button1.setFont(new Font("???? ???", Font.PLAIN, 14));
		p2_Button1.setBorderPainted(false);
		p2_Button1.setBackground(SystemColor.textHighlight);
		p2_Button1.setBounds(220, 206, 150, 60);
		panel_2.add(p2_Button1);
	}

}
