

	import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.NullPointerException;
import java.io.IOException;

public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

	private static JPanel gameWindow, board, commentBox, sidebar,timelineBox;
	private static JButton[] intersections = new JButton[361];
	private static GridBagConstraints gbc;
	private static JTextArea comment,timeline;
	private static JScrollPane scroll1,scroll2;
	private static ImageIcon black;
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI(){
		super("GO");
		setSize(2000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		
		gameWindow = new JPanel(new FlowLayout(1,30,40));
		board = new JPanel(new GridLayout(19,19,0,0));
		board.setPreferredSize(new Dimension(595, 595));
		board.setBounds(50,50,595,595);
		
		board.setBackground(new Color(181,129,32));
		
		
		
		
				String name="";
		for(int i = 0; i < 361; i++) {
				name = "int("+(i+1)+").jpg";
				intersections[i] = new JButton();
				if(i==0) {
				intersections[i].setIcon(new ImageIcon("intersections/corner1.jpg"));
				}
				else if(i==18) {
					intersections[i].setIcon(new ImageIcon("intersections/corner2.jpg"));
				}
				else if(i==342){
					intersections[i].setIcon(new ImageIcon("intersections/corner3.jpg"));
					
				}
				else if(i==360){
					intersections[i].setIcon(new ImageIcon("intersections/corner4.jpg"));
				}
				else if(i%19==0) {
					intersections[i].setIcon(new ImageIcon("intersections/left.jpg"));
					
				}
				else if(i%19==18) {
					intersections[i].setIcon(new ImageIcon("intersections/right.jpg"));
				}
				else if(i/19==0) {
					intersections[i].setIcon(new ImageIcon("intersections/top.jpg"));
					
				}
				else if(i/19==18) {
					intersections[i].setIcon(new ImageIcon("intersections/bottom.jpg"));
					
				}
				else if(i==60|i==66|i==72|i==174|i==180|i==186|i==288|i==294|i==300) {
					intersections[i].setIcon(new ImageIcon("intersections/star.jpg"));
					
				}
				else {
					intersections[i].setIcon(new ImageIcon("intersections/center.jpg"));
				}
				intersections[i].setBorder(BorderFactory.createEmptyBorder());
				intersections[i].setVisible(true);
				//intersections[i][j].add(new JLabel(black));
			
				intersections[i].addActionListener(this);
				board.add(intersections[i]);
			
		}
		
	
		
		sidebar = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		commentBox = new JPanel();
		commentBox.setPreferredSize(new Dimension(300,175));
		commentBox.setVisible(true);
		commentBox.setBackground(Color.WHITE);
		commentBox.setBorder(BorderFactory.createLineBorder(Color.black));
		comment = new JTextArea(10,25);
		comment.setEditable(true);
		comment.setVisible(true);
		scroll1 = new JScrollPane(comment);
		
		scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scroll1.setVisible(true);
		commentBox.add(scroll1);
		
		c.weightx = 0.5;
	
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		sidebar.add(commentBox,c);
		
		timelineBox = new JPanel();
		timelineBox.setPreferredSize(new Dimension(300,375));
		timelineBox.setVisible(true);
		timelineBox.setBackground(Color.WHITE);
		timelineBox.setBorder(BorderFactory.createLineBorder(Color.black));
		timeline = new JTextArea(25,25);
		timeline.setEditable(true);
		timeline.setVisible(true);
		scroll2= new JScrollPane(timeline);
		
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setVisible(true);
		timelineBox.add(scroll2);
		

		c.ipady = 40;      //make this component tall
		c.weightx = 0.5;
		c.insets = new Insets(10,0,0,0);
		c.gridx = 0;
		c.gridy = 1;
		sidebar.add(timelineBox,c);
		
		sidebar.setVisible(true);
		board.setVisible(true);
		board.setEnabled(true);
		board.addMouseListener(this);
		//gameWindow.add(boardMargin);
		gameWindow.add(board);
		gameWindow.add(sidebar);
		
		add(gameWindow);
		setVisible(true);
	}


	public void addConstraint(JPanel p, Component c, int x, int y, int w, int h, int f, int a) {
		gbc = new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = f;
		gbc.anchor = a;

		p.add(c, gbc);
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	public void mouseMoved(MouseEvent arg0) {
		
	}

	public void mouseClicked(MouseEvent e) {
		printCoordinate(e);
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {

		
	}


	public void mousePressed(MouseEvent e) {
		//printQuadrant(e);
	}

	public void mouseReleased(MouseEvent e) {
		placePiece(e);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		for(int i=0;i<361;i++) {
			if(arg0.getSource()==intersections[i]) {
				intersections[i].setIcon(new ImageIcon("intersections/blackCenter.jpg"));
				timeline.append(((i)/19+1)+","+(i+1)%19+"\n");
			}
		}
	}
	
	void placePiece(MouseEvent e) {
		int x = (int)Math.floor((double)e.getX()/43);
		int y = (int)Math.floor((double)e.getY()/43);
		System.out.println(x + "," + y);
		//intersections[y*19+x].add(new JLabel(black));
		
	}
	void printCoordinate(MouseEvent e) {
		Component c = board.getComponentAt(new Point(e.getX(), e.getY()));
		int mouseIndexX = (int)Math.floor(e.getX());
		int mouseIndexY = (int)Math.floor(e.getY());
		Dimension panelSize = c.getSize();
		
		timeline.append(((1 + (mouseIndexX+17)/panelSize.width)) + "," +(1 + (mouseIndexY+17)/panelSize.height) + "\n");
		
		
	}

}