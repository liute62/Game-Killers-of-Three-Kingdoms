package com.gui.gaming;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.system.constants.GUIConst;

/**
 * this is a panel to show history of casting card and something.
 * @author liuh4
 *
 */
public class MessagePanel extends JPanel{

	private static final long serialVersionUID = -3747578749991283567L;
	private static MessagePanel instance = null;
	private List<String> msgList = new ArrayList<String>();
	List<JLabel> contents = new ArrayList<>();
	
	public static MessagePanel Instance(){
		if(instance == null){
			instance = new MessagePanel();
		}
		return instance;
	}
	
	public MessagePanel(){
		//this.setLayout(null);
		instance = this;
		this.setSize(GUIConst.messagePanelWidth,GUIConst.messagePanelHeight);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		showMessage();
	}
	
	private void showMessage(){
		for (int i = 0; i < msgList.size(); i++) {
			initialLabel(msgList.get(i), i);
		}
		SwingUtilities.updateComponentTreeUI(instance);
	}
	
	public void addAMessage(String msg){
		msgList.add(msg);
		for (int i = 0; i < contents.size(); i++) {
			this.remove(contents.get(i));
		}
		showMessage();
	}
	
	private void initialLabel(String text,int i){
		JLabel jLabel = new JLabel(String.valueOf(i)+". "+text);
		jLabel.setForeground(Color.black);
		jLabel.setBackground(Color.black);
		jLabel.setSize(GUIConst.messagePanelWidth, 50);
		jLabel.setLocation(0,0+i * 50);
		contents.add(jLabel);
		this.add(jLabel);
	}

}
