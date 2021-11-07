package zoas_1;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;

public class RecordGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordGui window = new RecordGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecordGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.LIGHT_GRAY);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 760, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 144, 411);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("ZOAS");
		lblNewLabel.setFont(new Font("»ﬁ∏’µ’±Ÿ«ÏµÂ∂Û¿Œ", Font.PLAIN, 21));
		lblNewLabel.setBounds(36, 24, 74, 26);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC0C8 \uB178\uD2B8 \uB9CC\uB4E4\uAE30");
		btnNewButton.setFont(new Font("∏º¿∫ ∞ÌµÒ Semilight", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(16, 70, 116, 36);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uCCB4\uB178\uD2B8");
		lblNewLabel_1.setBounds(40, 126, 57, 15);
		panel.add(lblNewLabel_1);
		
		ImageIcon icon1= new ImageIcon("image/note.png");
		Image img1=icon1.getImage();
		Image changeimg1=img1.getScaledInstance(17,17,Image.SCALE_SMOOTH);
		ImageIcon noteicon=new ImageIcon(changeimg1);
		
		JLabel NoteIcon = new JLabel("", noteicon, SwingConstants.CENTER);
		NoteIcon.setBounds(22, 126, 15, 15);
		panel.add(NoteIcon);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0C8\uB178\uD2B8");
		lblNewLabel_2.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 17));
		lblNewLabel_2.setBounds(165, 21, 57, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("2021-10-26 \uC624\uD6C4 7\uC2DC 38\uBD84");
		lblNewLabel_6.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(164, 40, 137, 15);
		frame.getContentPane().add(lblNewLabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(156, 71, 560, 2);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(493, 71, 2, 340);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC74C\uC131 \uAE30\uB85D");
		lblNewLabel_3.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		lblNewLabel_3.setBounds(165, 87, 67, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		textArea.setText("\uB124\uD2B8\uC6CC\uD06C\uAC00 \uBB50\uC57C? \uC9D1\uC911\uD574\uBD10~~");
		textArea.setBounds(165, 120, 318, 278);
		frame.getContentPane().add(textArea);
		
		JLabel lblNewLabel_4 = new JLabel("\uC694\uC57D");
		lblNewLabel_4.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 15));
		lblNewLabel_4.setBounds(512, 87, 45, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextArea txtrRdt = new JTextArea();
		txtrRdt.setLineWrap(true);
		txtrRdt.setText("\u2022 rdt 2.0\uC740 nak\uACFC ack\uAC00 \uC788\uC5B4\uC694. \uADF8\uAC8C \uBB50\uB0D0?~\r\n\u2022 ~~\r\n\u2022 ~~\r\n\u2022 \uB124\uD2B8\uC6CC\uD06C \uD30C\uC774\uD504\uB77C\uC774\uB2DD\uC740 \uB9D0\uC774\uC8E0 \uCEF4\uD4E8\uD130 \uAD6C\uC870 \uC2DC\uAC04\uC5D0 \uBC30\uC6E0\uC9C0? \uD30C\uC774\uD504\uB77C\uC778\uC774 \uBB50\uC57C");
		txtrRdt.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 12));
		txtrRdt.setBounds(500, 120, 239, 278);
		frame.getContentPane().add(txtrRdt);
	}
}
