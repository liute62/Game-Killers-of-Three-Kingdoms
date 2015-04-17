package com.gui.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import com.system.constants.GUIConst;

public class SelectHeroPanel extends JPanel{


	private static final long serialVersionUID = -9183774209495732143L;
	JPanel showPanel;
	SubSelectPanel subSelectPanel;
	JScrollPane scrollPane;
	ClickPanel clickPanel;
	TitledBorder titledBorder;
    ClickPanel cancelPanel;
	ClickPanel surePanel;
	
	public SelectHeroPanel(){
		initial();
		showPanel.setPreferredSize(new Dimension(GUIConst.proxyWidth * 5,
				GUIConst.proxyHeight * 1));
		showPanel.setLayout(new GridLayout(0, 7, 2, 2));
		showPanel.setBackground(Color.black);
		scrollPane = new JScrollPane(showPanel);
		scrollPane.setSize(GUIConst.proxyWidth * 5 + 10, GUIConst.selectHeroPanelHeight - 300);
		scrollPane.setLocation(GUIConst.proxyWidth/2+10, 10);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setOpaque(false);
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane.getHorizontalScrollBar().setBlockIncrement(80);
		titledBorder = BorderFactory.createTitledBorder(GUIConst.selectHeroTitle);
		titledBorder.setTitlePosition(TitledBorder.TOP);
		Font font = new Font("Arial", Font.BOLD, 30);
		titledBorder.setTitleFont(font);
		titledBorder.setTitleColor(Color.white);
		scrollPane.setBorder(titledBorder);
		scrollPane.getViewport().setOpaque(false);
		add(scrollPane);
		subSelectPanel.setSize(GUIConst.proxyWidth * 6+20, GUIConst.proxyHeight + 50);
		subSelectPanel.setLocation(10, scrollPane.getHeight() + 20);
		subSelectPanel.setOpaque(false);
		TitledBorder tb2 = BorderFactory.createTitledBorder("");
		tb2.setTitleFont(font);
		tb2.setTitleColor(Color.white);
		tb2.setBorder(null);
		subSelectPanel.setLayout(null);
		cancelPanel.setLocation(GUIConst.proxyWidth * 4 + 18, 40);
		surePanel.setLocation(GUIConst.proxyWidth * 4 + 18,  subSelectPanel.getHeight()-surePanel.getHeight()-20);
		subSelectPanel.add(cancelPanel);
		subSelectPanel.add(surePanel);
		add(subSelectPanel);
	}
	
	private void initial(){
		this.setSize(GUIConst.selectHeroPanelWidth, GUIConst.selectHeroPanelHeight);
		this.setLocation(0, 0);
		this.setLayout(null);
		showPanel = new JPanel();
		subSelectPanel = new SubSelectPanel();
		cancelPanel = new ClickPanel("cancel",0);
		surePanel = new ClickPanel("sure", 1);
	}
	
	private class ClickPanel extends JPanel{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 4268154810503808021L;
		JLabel text = new JLabel();
		MouseListener listener;
		public ClickPanel(String name,int type){
			this.setSize(140, 60);
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Font f = new Font("Arial", Font.BOLD, 40);
			text.setFont(f);
			text.setForeground(Color.BLACK);
			text.setText(name);
			this.add(text);
			if(type==0){
				listener = cancle;
			}else{
				listener = sure;
			}
			if(getMouseListeners().length==0)addMouseListener(listener);
			repaint();
		}
		
		MouseListener cancle = new MyClickListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
			}
			
		};
		
		MouseListener sure = new MyClickListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				
			}
			@Override
			public void mousePressed(MouseEvent e) 
			{
				MainFrame.getInstance().loadMain();
			};
			
		};
		
		class MyClickListener extends MouseAdapter {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				MainFrame.getInstance().loadMain();
			}
		}
	}
	
	private class SubSelectPanel extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = -2296174949018817295L;
		
	}
}
