package zoas_4;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import zoas_4.DataClass.NoteInfo;

public class Record extends JPanel {
	NoteInfo noteinfo;
	ArrayList<NoteInfo> notelist;
	JPanel linepanel_w = new JPanel();
	JPanel linepanel_h = new JPanel();
	
	JLabel lblNewLabel_3 = new JLabel("음성 기록");
	JLabel lblNewLabel_4 = new JLabel("요약");
	JLabel noteDateLabel = new JLabel();
	
	JTextField noteNameField = new JTextField(){
		 @Override public void setBorder(Border border) {
		        // 텍스트필드 외곽선 제거
		    }
	};
	
	JTextArea RecordtextArea = new JTextArea();
	JTextArea SummarytextArea = new JTextArea();
	
	public void set(){
		noteinfo=Newnote.noteinfo;
		notelist=Zoas.user.getNoteList();
		noteNameField.setText(noteinfo.getName());
		noteDateLabel.setText(noteinfo.getCreatDate());	
		
		RecordtextArea.setText(noteinfo.getRecordText());
		SummarytextArea.setText(noteinfo.getSummaryText());
		
		notelist.add(noteinfo);	//노트 리스트에 노트가 추가된다.
		Zoas.user.setNoteList(notelist);	//최종 노트 리스트	
		Zoas.json.createJsonData(Zoas.user);
		
	}
	/**
	 * Create the panel.
	 */
	public Record() {
		setBackground(Color.WHITE);
		setBounds(144, 0, 600, 411);
		setLayout(null);
		setVisible(false);
		
		//노트 이름 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int index=notelist.indexOf(noteinfo);
				JTextField textField = (JTextField)e.getSource();
				noteinfo.setName(textField.getText());
				noteNameField.setText(noteinfo.getName());
				
				notelist.set(index,noteinfo);
				Zoas.json.createJsonData(Zoas.user);				
				
			}
		});	
		noteNameField.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		noteNameField.setBounds(20, 23, 200, 22);
		add(noteNameField);
		noteNameField.setColumns(10);
				
		//날짜
		noteDateLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		noteDateLabel.setBounds(20, 43, 150, 15);
		add(noteDateLabel);
			
		//가로선을 위한 패널(이미지로 바꿔도 될듯...?)
		linepanel_w.setBackground(Color.LIGHT_GRAY);
		linepanel_w.setBounds(15, 71, 565, 2);
		add(linepanel_w);
		
		//세로선을 위한 패널(이미지로 바꿔도 될듯...?)
		linepanel_h.setBackground(Color.LIGHT_GRAY);
		linepanel_h.setBounds(343, 72, 2, 343);
		add(linepanel_h);
		
		//'음성 기록'
		lblNewLabel_3.setBounds(15, 79, 67, 15);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(lblNewLabel_3);
		
		//음성 기록 공간
		RecordtextArea.setBounds(15, 102, 321, 299);
		RecordtextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		add(RecordtextArea);
		
		//'요약'
		lblNewLabel_4.setBounds(351, 77, 45, 15);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(lblNewLabel_4);
		
		//요약 공간
		SummarytextArea.setLineWrap(true);
		SummarytextArea.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		SummarytextArea.setBounds(350, 102, 240, 299);
		add(SummarytextArea);
		
		
	}
}
