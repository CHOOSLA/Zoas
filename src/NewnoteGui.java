import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewnoteGui {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewnoteGui window = new NewnoteGui();
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
	public NewnoteGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 760, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 144, 411);
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("ZOAS");
		lblNewLabel.setFont(new Font("ÈÞ¸ÕµÕ±ÙÇìµå¶óÀÎ", Font.PLAIN, 21));
		lblNewLabel.setBounds(36, 24, 74, 26);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\uC0C8 \uB178\uD2B8 \uB9CC\uB4E4\uAE30");
		btnNewButton.setFont(new Font("¸¼Àº °íµñ Semilight", Font.PLAIN, 12));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(16, 70, 116, 36);
		btnNewButton.setBorderPainted(false); // ¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\uC804\uCCB4\uB178\uD2B8");
		lblNewLabel_1.setBounds(40, 126, 57, 15);
		panel.add(lblNewLabel_1);
		
		ImageIcon icon1= new ImageIcon("image/note.png");
		Image img1=icon1.getImage();
		Image changeimg1=img1.getScaledInstance(17,17,Image.SCALE_SMOOTH);
		ImageIcon noteicon=new ImageIcon(changeimg1);
		
		JLabel NoteIcon = new JLabel("",noteicon,JLabel.CENTER);
		NoteIcon.setBounds(22, 126, 15, 15);
		panel.add(NoteIcon);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(156, 71, 560, 2);
		panel_1.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uC0C8\uB178\uD2B8");
		lblNewLabel_2.setBounds(165, 23, 57, 15);
		lblNewLabel_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_6 = new JLabel("2021-10-26 \uC624\uD6C4 7\uC2DC 38\uBD84");
		lblNewLabel_6.setBounds(164, 43, 137, 15);
		lblNewLabel_6.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 11));
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("\uAC15\uC758 \uC5F0\uACB0\uD558\uAE30");
		btnNewButton_1.setBounds(370, 200, 150, 60);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 14));
		btnNewButton_1.setBorderPainted(false); // ¹öÆ° Å×µÎ¸® ¼³Á¤ÇØÁ¦
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(btnNewButton_1);
	}

}
