package com.gui.gaming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import com.system.constants.GUIConst;
import com.system.utils.ResUtil;

/**
 * this is a panel to show history of casting card and something.
 * @author liuh4
 *
 */
public class MessagePanel extends JPanel{
    private static final int MAX_CHAR_IN_LINE = 22;
	private static final long serialVersionUID = -3747578749991283567L;
	private static MessagePanel instance = null;
	private List<String> msgList = new ArrayList<String>();
	private List<Integer> msgColor = new ArrayList<Integer>();
	List<JLabel> contents = new ArrayList<>();
	private BufferedImage bg;
	
	public static MessagePanel Instance(){
		if(instance == null){
			instance = new MessagePanel();
		}
		return instance;
	}
	
	public MessagePanel(){
		this.setLayout(null);
		instance = this;
		resInitial();
		this.setSize(GUIConst.messagePanelWidth,GUIConst.messagePanelHeight);
		//this.setBorder(BorderFactory.createLineBorder(Color.black));
		showAllMessage();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(bg, 0, 0, this.getWidth(), this.getHeight(),null);
		
	}
	
	private void resInitial(){
		bg = ResUtil.getImgByName("bg", 0);
	}
	
	private void showAllMessage(){
		for (int i = 0; i < msgList.size(); i++) {
			initialLabel(msgList.get(i), i,msgColor.get(i));
		}
		SwingUtilities.updateComponentTreeUI(instance);
	}
	
	private void showAMessage(int lastIndex){
		initialLabel(msgList.get(lastIndex),lastIndex, msgColor.get(lastIndex));
		SwingUtilities.updateComponentTreeUI(instance);
	}

    // Solution from http://stackoverflow.com/questions/11242208/splitting-string-in-java-into-fixed-length-chunks
    public static String[] splitString (String text, int chunkSize, int maxLength) {
        char[] data = text.toCharArray();
        int len = Math.min(data.length,maxLength);
        String[] result = new String[(len+chunkSize-1)/chunkSize];
        int linha = 0;
        for (int i=0; i < len; i+=chunkSize) {
            result[linha] = new String(data, i, Math.min(chunkSize,len-i));
            linha++;
        }
        return result;
    }

    public void addAMessage(String msg){
        String[] msgs = splitString(msg, MAX_CHAR_IN_LINE, msg.length());
        for (int i = 0; i < msgs.length; i++) {
            if (i != 0) {
                msgs[i] = "    " + msgs[i];
            }
            addAMessageHelper(msgs[i]);
        }
	}

    public void addAMessageHelper(String msg) {
        msgColor.add(0);
        int tmp = msgList.size();
        msgList.add(msg);
        showAMessage(tmp);
    }
	
	/**
	 * 
	 * @param msg msg to show
	 * @param color 0:black 1:red 2:green 
	 */
	public void addAMessage(String msg, int color){
		msgColor.add(color);
		int tmp = msgList.size();
		msgList.add(msg);
		showAMessage(tmp);
	}
	
	private void initialLabel(String text,int i,int color){
		JLabel jLabel = new JLabel(String.valueOf(i)+". "+text);
		if (color == 1) {
			jLabel.setForeground(Color.red);
		}else if(color == 2){
			jLabel.setForeground(Color.green);
		}else {
			jLabel.setForeground(Color.black);
		}
		jLabel.setSize(GUIConst.messagePanelWidth, GUIConst.messageLabelHeight);
		jLabel.setLocation(10,10+i * GUIConst.messageLabelHeight);
		contents.add(jLabel);
		this.add(jLabel);
	}
	
	public void clear(){
		msgColor.clear();
		msgList.clear();
		for (int i = 0; i < contents.size(); i++) {
			this.remove(contents.get(i));
		}
		contents.clear();
		showAllMessage();
	}

}
