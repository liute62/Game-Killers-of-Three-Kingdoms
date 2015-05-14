package com.gui.gaming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.system.constants.GUIConst;
import com.system.utils.ResUtil;
import org.easymock.internal.matchers.Null;

/**
 * this is a panel to show history of casting card and something.
 * @author liuh4
 *
 */
public class MessagePanel extends JPanel{
	private static final long serialVersionUID = -3747578749991283567L;
	private static MessagePanel instance = null;
	private BufferedImage bg;

    private JTextPane textArea;
    private JScrollPane scrollPane;
    private StyledDocument doc;
    private int currentId;

	public static MessagePanel Instance(){
		if(instance == null){
			instance = new MessagePanel();
		}
		return instance;
	}
	
	public MessagePanel(){
		this.setLayout(null);
		this.setOpaque(false);
		instance = this;
		resInitial();
		this.setSize(GUIConst.messagePanelWidth,GUIConst.messagePanelHeight);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.textArea = new JTextPane();
        this.scrollPane = new JScrollPane(this.textArea);
        this.doc = this.textArea.getStyledDocument();
        this.textArea.setSize(GUIConst.messagePanelWidth, GUIConst.messagePanelHeight);
        this.textArea.setLocation(0, 0);
        this.textArea.setBackground(new Color(0, 0, 0, 0));
        this.textArea.setOpaque(true);
        this.scrollPane.setSize(GUIConst.messagePanelWidth, GUIConst.messagePanelHeight);
        this.scrollPane.setLocation(0, 0);
        this.scrollPane.setBackground(new Color(0, 0, 0, 0));
        this.scrollPane.setOpaque(true);
        this.textArea.setEnabled(false);
        this.currentId = 0;
        this.add(this.scrollPane);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(), null);
		super.paint(g);

        // FIXME: This is a temporary solution
        try {
            SwingUtilities.updateComponentTreeUI(instance);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
	
	private void resInitial(){
		bg = ResUtil.getImgByName("bg", 0);
	}

    public void addAMessage(String msg){
        this.addAMessage(msg, 0);
	}
	
	/**
	 * 
	 * @param msg msg to show
	 * @param color 0:black 1:red 2:green 
	 */
	public void addAMessage(String msg, int color) {
        this.currentId++;
        Color c;
        Style s = this.textArea.addStyle(String.valueOf(this.currentId), null);
        if (color == 0) {
            c = Color.BLACK;
        } else if (color == 1) {
            c = Color.RED;
        } else if (color == 2) {
            c = Color.GREEN;
        } else {
            c = Color.BLACK;
        }
        StyleConstants.setForeground(s, c);
        try {
            int len = this.doc.getLength();
            this.doc.insertString(len, this.currentId + ": " + msg + "\r\n", s);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        try {
            //SwingUtilities.updateComponentTreeUI(instance);
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
	
	public void clear(){
        textArea.setText("");
	}

}
