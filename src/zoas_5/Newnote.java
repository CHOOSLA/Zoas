package zoas_5;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.DocumentListener;

import zoas_5.DataClass.NoteInfo;

import javax.swing.event.DocumentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Newnote extends JPanel {
	DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("yyyy-MM-dd a h�� mm��");
	static public NoteInfo noteinfo;
	
	JPanel linepanel_1 = new JPanel();
	JButton ZoomBtn = new JButton("���� �����ϱ�");
	
	JLabel noteDateLabel = new JLabel();
	
	JTextField noteNameField = new JTextField(){
		 @Override public void setBorder(Border border) {
		        // �ؽ�Ʈ�ʵ� �ܰ��� ����
		    }
	};
	public void note_init() {
		noteinfo=new NoteInfo();
		LocalDateTime time =LocalDateTime.now();		
		String DateTime = datetimeformat.format(time);
		noteinfo.setName("����Ʈ");	//�⺻ �̸�
		noteinfo.setCreatDate(DateTime);	//���� ��¥
		noteinfo.setEditDate(DateTime);	//���� ��¥
		noteinfo.setRecordText(" ");	//���� ���
		noteinfo.setSummaryText(" ");	//���
	}
	public void set() {
		note_init();
		noteNameField.setText(noteinfo.getName());
		noteDateLabel.setText(noteinfo.getCreatDate());	
	}
	/**
	 * Create the panel.
	 */
	public Newnote() {
		setLayout(null);
		setBackground(Color.WHITE);
		setBounds(144, 0, 840, 611);
		
		//���μ��� ���� �г�(�̹����� �ٲ㵵 �ɵ�...?)
		linepanel_1.setBackground(Color.LIGHT_GRAY);
		linepanel_1.setBounds(12, 71, 815, 2);
		add(linepanel_1);
		ZoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//���� �����ϱ� ��ư
		ZoomBtn.setForeground(Color.WHITE);
		ZoomBtn.setFont(new Font("���� ���", Font.BOLD, 15));
		ZoomBtn.setBorderPainted(false);
		ZoomBtn.setBackground(SystemColor.textHighlight);
		ZoomBtn.setBounds(330, 200, 170, 76);
		add(ZoomBtn);
		
		//��Ʈ �̸� 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				JTextField textField = (JTextField)e.getSource();
				noteinfo.setName(textField.getText());
				noteNameField.setText(noteinfo.getName());
			}
		});
		noteNameField.setFont(new Font("���� ���", Font.BOLD, 17));
		noteNameField.setBounds(14, 25, 200, 22);
		add(noteNameField);
		noteNameField.setColumns(10);
				
		//��¥
		noteDateLabel.setFont(new Font("���� ���", Font.PLAIN, 11));
		noteDateLabel.setBounds(14, 46, 150, 15);
		add(noteDateLabel);
		
	}
	
	

}
