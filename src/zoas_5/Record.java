package zoas_5;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import zoas_5.DataClass.NoteInfo;

public class Record extends JPanel {
	NoteInfo noteinfo;
	ArrayList<NoteInfo> notelist;
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
	private final JPanel panel = new JPanel();
	
	public void set(){
		noteinfo=Newnote.noteinfo;
		notelist=Zoas.user.getNoteList();
		noteNameField.setText(noteinfo.getName());
		noteDateLabel.setText(noteinfo.getCreatDate());	
		
		RecordtextArea.setText(noteinfo.getRecordText());
		SummarytextArea.setText(noteinfo.getSummaryText());
		
		notelist.add(noteinfo);	//��Ʈ ����Ʈ�� ��Ʈ�� �߰��ȴ�.
		Zoas.user.setNoteList(notelist);	//���� ��Ʈ ����Ʈ	
		Zoas.json.ObjectToJson(Zoas.user);
		
	}
	/**
	 * Create the panel.
	 */
	public Record() {
		setBackground(Color.WHITE);
		setBounds(144, 0, 840, 611);
		setLayout(null);
		setVisible(false);
		
		//��Ʈ �̸� 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int index=notelist.indexOf(noteinfo);
				JTextField textField = (JTextField)e.getSource();
				noteinfo.setName(textField.getText());
				noteNameField.setText(noteinfo.getName());
				
				notelist.set(index,noteinfo);
				Zoas.json.ObjectToJson(Zoas.user);				
				
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
			
		//���μ��� ���� �г�(�̹����� �ٲ㵵 �ɵ�...?)
		linepanel_w.setBackground(Color.LIGHT_GRAY);
		linepanel_w.setBounds(12, 71, 815, 2);
		add(linepanel_w);
		
		//���μ��� ���� �г�(�̹����� �ٲ㵵 �ɵ�...?)
		linepanel_h.setBackground(Color.LIGHT_GRAY);
		linepanel_h.setBounds(458, 72, 2, 600);
		add(linepanel_h);
		
		//'���� ���'
		lblNewLabel_3.setBounds(15, 79, 67, 15);
		lblNewLabel_3.setFont(new Font("���� ���", Font.BOLD, 15));
		add(lblNewLabel_3);
		
		//���� ��� ����
		RecordtextArea.setBounds(15, 102, 435, 499);
		RecordtextArea.setFont(new Font("���� ���", Font.PLAIN, 12));
		add(RecordtextArea);
		
		//'���'
		lblNewLabel_4.setBounds(470, 77, 45, 15);
		lblNewLabel_4.setFont(new Font("���� ���", Font.BOLD, 15));
		add(lblNewLabel_4);
		
		//��� ����
		SummarytextArea.setLineWrap(true);
		SummarytextArea.setFont(new Font("���� ���", Font.PLAIN, 12));
		SummarytextArea.setBounds(470, 310, 360, 290);
		add(SummarytextArea);
		panel.setBounds(468, 102, 200, 200);
		
		add(panel);
		
		
	}
}
