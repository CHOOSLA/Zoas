import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class noteFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Note frame = new Note();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public noteFrame() {
		setBounds(100, 100, 600, 411);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 584, 381);
		getContentPane().add(panel);
		
		JTextField textField = new JTextField("ªı≥Î∆Æ"){
			 @Override public void setBorder(Border border) {
			        // No!
			    }
		};
		textField.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		textField.setBounds(20, 23, 200, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel linepanel_1 = new JPanel();
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(15, 71, 565, 2);
		panel.add(linepanel_1);
		
		JLabel p2_lb2 = new JLabel("2021-10-26 ø¿»ƒ 7Ω√ 38∫–");
		p2_lb2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 11));
		p2_lb2.setBounds(20, 43, 137, 15);
		panel.add(p2_lb2);
		
		JButton p2_Button1 = new JButton("∞≠¿« ø¨∞·«œ±‚");
		p2_Button1.setForeground(Color.WHITE);
		p2_Button1.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		p2_Button1.setBorderPainted(false);
		p2_Button1.setBackground(SystemColor.textHighlight);
		p2_Button1.setBounds(220, 206, 150, 60);
		panel.add(p2_Button1);

	}

}
