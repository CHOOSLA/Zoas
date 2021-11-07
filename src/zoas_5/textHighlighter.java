package zoas_5;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;

public class textHighlighter {
	
	public void highlightKeyword(JTextPane textComp, ArrayList<String> patternList) {
		//이전 하이라이트를 지운다
		removeHighlights(textComp);
		
		try
	    {
	        Highlighter hilite = textComp.getHighlighter();	//하이라이터 생성
	        Document doc = textComp.getDocument();
	        String text = doc.getText(0, doc.getLength());
	        int pos = 0;
	    
	        for(String pattern:patternList) {
	        	// 강조할 문자열의 위치를 찾는다
	        	// see I have updated now its not case sensitive 
	        	while ((pos = text.indexOf(pattern, pos)) >= 0)
	        	{
	        		// 강조 표시를 한다 using private painter and apply around pattern
	        		hilite.addHighlight(pos, pos+pattern.length(), myHighlightPainter);
	        		pos += pattern.length();
	        	}
	        }
	    } catch (BadLocationException e) {
	    }
		
	};
	
	public void removeHighlights(JTextPane textComp) {
		Highlighter hilite = textComp.getHighlighter();
	    Highlighter.Highlight[] hilites = hilite.getHighlights();
	    for (int i=0; i<hilites.length; i++)
	    {
	        if (hilites[i].getPainter() instanceof MyHighlightPainter)
	        {
	            hilite.removeHighlight(hilites[i]);
	        }
	    }
	}
	// An instance of the private subclass of the default highlight painter
	Highlighter.HighlightPainter myHighlightPainter = new MyHighlightPainter(Color.yellow);

	// A private subclass of the default highlight painter
	class MyHighlightPainter extends DefaultHighlighter.DefaultHighlightPainter
	{
	    public MyHighlightPainter(Color color)
	    {
	        super(color);
	    }
	}
//	public static void main(String[] args) {
//		
//		
//	};
}
