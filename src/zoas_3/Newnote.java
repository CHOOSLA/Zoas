package zoas_3;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Newnote extends JPanel {
	//JPanel panel = new JPanel();
	
	JPanel linepanel_1 = new JPanel();
	JButton ZoomBtn = new JButton("���� �����ϱ�");
	
	JLabel noteDateLabel = new JLabel();
	
	JTextField noteNameField = new JTextField(){
		 @Override public void setBorder(Border border) {
		        // �ؽ�Ʈ�ʵ� �ܰ��� ����
		    }
	};
	
	public void set() {
		noteNameField.setText(Zoas.noteName);
		noteDateLabel.setText(Zoas.noteCreateDate);	
	}
	/**
	 * Create the panel.
	 */
	public Newnote() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(144, 0, 600, 411);
		
		set();
		
		//���μ��� ���� �г�(�̹����� �ٲ㵵 �ɵ�...?)
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(15, 71, 565, 2);
		add(linepanel_1);
		
		//���� �����ϱ� ��ư
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("���� ���", Font.PLAIN, 14));
		ZoomBtn.setBorderPainted(false);
		ZoomBtn.setBackground(SystemColor.textHighlight);
		ZoomBtn.setBounds(210, 135, 150, 60);
		add(ZoomBtn);
		
		//��Ʈ �̸� 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JTextField textField = (JTextField)e.getSource();
				Zoas.noteName=textField.getText();
				noteNameField.setText(Zoas.noteName);
			}
		});
		Zoas.noteName=noteNameField.getText();
		noteNameField.setFont(new Font("���� ���", Font.BOLD, 17));
		noteNameField.setBounds(20, 23, 200, 22);
		add(noteNameField);
		noteNameField.setColumns(10);
				
		//��¥
		Zoas.noteCreateDate=noteDateLabel.getText();	//��Ʈ ���� ��¥ ������Ʈ
		noteDateLabel.setFont(new Font("���� ���", Font.PLAIN, 11));
		noteDateLabel.setBounds(20, 43, 150, 15);
		add(noteDateLabel);
		
		//panel.setBounds(12, 75, 568, 332);
		
		
		
		
	}
	
	

}
