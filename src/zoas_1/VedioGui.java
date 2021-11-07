package zoas_1;
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;

public class VedioGui {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VedioGui window = new VedioGui();
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
	public VedioGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC601\uC0C1\uB098\uC624\uB294\uC911");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		lblNewLabel.setBounds(161, 118, 102, 15);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
