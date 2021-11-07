package zoas_5;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import zoas_5.DataClass.NoteInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//��Ʈ�� ���� �ߴ� â �������� �ؽ�Ʈ�� �ҷ���
public class NoteForm extends JPanel {
	NoteInfo noteinfo;
	ArrayList<NoteInfo> notelist;
	ArrayList<String> keyword= new ArrayList<>();	//��� Ű���� ����	
	textHighlighter highlighter =new textHighlighter();

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
	
	JTextPane recordtextPane = new JTextPane();
	JTextPane summaryTextPane = new JTextPane();
	ImageIcon icon= new ImageIcon("");
	JLabel lblNewLabel = new JLabel("");
	
	public void set(){

		
	}
	/**
	 * Create the panel.
	 */
	public NoteForm() {
		setBackground(Color.WHITE);
		setBounds(144, 0, 840, 611);
		setLayout(null);
		setVisible(false);
		
		//��Ʈ �̸� 
		noteNameField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
//				int index=notelist.indexOf(noteinfo);
//				JTextField textField = (JTextField)e.getSource();
//				noteinfo.setName(textField.getText());
//				noteNameField.setText(noteinfo.getName());
//				
//				notelist.set(index,noteinfo);
//				Zoas.json.createJsonData(Zoas.user);				
				
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
		
		//'���'
		lblNewLabel_4.setBounds(470, 77, 45, 15);
		lblNewLabel_4.setFont(new Font("���� ���", Font.BOLD, 15));
		add(lblNewLabel_4);
		
		//���
		recordtextPane.setText("�� ������ ���� ������� ���� �����̴�. �������� ����� �غ���! � ������ ��������� �� ���̴�. �������.");
		recordtextPane.setBounds(15, 102, 435, 499);
		add(recordtextPane);
		
		//���
		summaryTextPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String s=summaryTextPane.getSelectedText();	//TextArea���� ���úκ� �ؽ�Ʈ�� ����
				if(s!=null) {	
					keyword.add(s);
					highlighter.highlightKeyword(recordtextPane,keyword);
					System.out.println(s);
					keyword.remove(s);
					
				}
			}
		});
		summaryTextPane.setText("�������� ����� �غ���! �������.");
		summaryTextPane.setBounds(470, 310, 356, 290);
		add(summaryTextPane);
		
		keyword.add("���");
		keyword.add("�������");
		highlighter.highlightKeyword(recordtextPane,keyword);
		
		//��� ���� ���� ���̺�
		lblNewLabel.setBounds(468, 102, 200, 200);
		icon=Zoas.imageSetSize(icon, 49, 49);
		lblNewLabel.setIcon(icon);
		add(lblNewLabel);
		
	}
}
