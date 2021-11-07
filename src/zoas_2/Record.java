package zoas_2;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class Record extends JPanel {
	JPanel linepanel_w = new JPanel();
	JPanel linepanel_h = new JPanel();
	
	JLabel lblNewLabel_3 = new JLabel("���� ���");
	JLabel lblNewLabel_4 = new JLabel("���");
	JLabel noteDateLabel = new JLabel();
	
	JTextField noteNameField = new JTextField(){
		 @Override public void setBorder(Border border) {
		        // �ؽ�Ʈ�ʵ� �ܰ��� ����
		    }
	};
	
	JTextArea RecordtextArea = new JTextArea();
	JTextArea SummarytextArea = new JTextArea();
	
	public void set(){
		noteNameField.setText(Zoas.noteName);
		noteDateLabel.setText(Zoas.noteCreateDate);
		RecordtextArea.setText(" ");
		SummarytextArea.setText(" ");
	}
	/**
	 * Create the panel.
	 */
	public Record() {
		setBackground(Color.WHITE);
		setBounds(144, 0, 600, 411);
		setLayout(null);
		setVisible(false);
		
		set();
		
		//��Ʈ �̸� 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JTextField textField = (JTextField)e.getSource();
				Zoas.noteName=textField.getText();
				noteNameField.setText(Zoas.noteName);
			}
		});	
		noteNameField.setFont(new Font("���� ���", Font.BOLD, 17));
		noteNameField.setBounds(20, 23, 200, 22);
		add(noteNameField);
		noteNameField.setColumns(10);
				
		//��¥
		noteDateLabel.setFont(new Font("���� ���", Font.PLAIN, 11));
		noteDateLabel.setBounds(20, 43, 150, 15);
		add(noteDateLabel);
			
		//���μ��� ���� �г�(�̹����� �ٲ㵵 �ɵ�...?)
		linepanel_w.setBackground(Color.LIGHT_GRAY);
		linepanel_w.setBounds(15, 71, 565, 2);
		add(linepanel_w);
		
		//���μ��� ���� �г�(�̹����� �ٲ㵵 �ɵ�...?)
		linepanel_h.setBackground(Color.LIGHT_GRAY);
		linepanel_h.setBounds(343, 72, 2, 343);
		add(linepanel_h);
		
		//'���� ���'
		lblNewLabel_3.setBounds(15, 79, 67, 15);
		lblNewLabel_3.setFont(new Font("���� ���", Font.BOLD, 15));
		add(lblNewLabel_3);
		
		//���� ��� ����
		RecordtextArea.setBounds(15, 102, 321, 299);
		RecordtextArea.setFont(new Font("���� ���", Font.PLAIN, 12));
		add(RecordtextArea);
		
		//'���'
		lblNewLabel_4.setBounds(351, 77, 45, 15);
		lblNewLabel_4.setFont(new Font("���� ���", Font.BOLD, 15));
		add(lblNewLabel_4);
		
		//��� ����
		SummarytextArea.setLineWrap(true);
		SummarytextArea.setFont(new Font("���� ���", Font.PLAIN, 12));
		SummarytextArea.setBounds(350, 102, 240, 299);
		add(SummarytextArea);
		
	}
}
