

	import java.awt.*;
	import java.awt.event.*;
	import javax.swing.*;
	import java.util.*;
	import java.lang.NullPointerException;
	import java.io.IOException;

	public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener{

		private static JPanel gameWindow, board, commentBox,sidebar,timelineBox;
		private static JTextArea comment,timeline;
		private static JScrollPane scroll1,scroll2;
		public static void main(String[] args) {
			new GUI();
		}
		
		public GUI(){
			super("GO");
			setSize(1200,800);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			
			gameWindow = new JPanel(new FlowLayout());
			sidebar = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;

			board = new JPanel(new GridLayout(19,19,0,0));
			board.setPreferredSize(new Dimension(600,600));
			board.setVisible(true);
			board.setBackground(Color.black);
		
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
			timeline = new JTextArea(10,25);
			timeline.setEditable(true);
			timeline.setVisible(true);
			scroll2= new JScrollPane(timeline);
			scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			timelineBox.add(scroll2);
		
			
			c.ipady = 40;      //make this component tall
			c.weightx = 0.5;
			c.insets = new Insets(10,0,0,0);
			c.gridx = 0;
			c.gridy = 1;
			sidebar.add(timelineBox,c);
			gameWindow.add(board);
			sidebar.setVisible(true);
			
			gameWindow.add(sidebar);
			add(gameWindow);
			setVisible(true);
			
			
			
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}

