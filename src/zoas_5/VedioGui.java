package zoas_5;
import javax.swing.*;
import java.awt.*;


public class VedioGui {
	 //EmbeddedMediaPlayerComponent mediaPlayerComponent;
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
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/letter-z.png"));
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.getContentPane().setLayout(null);
	
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
