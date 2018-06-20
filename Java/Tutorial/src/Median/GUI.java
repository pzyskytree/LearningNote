package Median;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class GUI {
	
	public static void main(String[] args) {
		//Window
////		JFrame f = new JFrame("LOL");
////		f.setSize(400,300);
////		f.setLocation(200,200);
////		f.setLayout(null);
////		
////		JButton b = new JButton("Start");
////		b.setBounds(50,50, 280, 30); //Set position and size
////		
////		f.add(b);
////		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Once close the window exit the program
////		f.setVisible(true);
//		
//		//EventListener
//		//1. ActionListener Button Press Listener interface
//		JFrame f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(580, 200);
//		f.setLayout(null);
//		final JLabel l = new JLabel();
//		ImageIcon i = new ImageIcon("E:\\JavaWeb\\shana.png");
//		l.setIcon(i);
//		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
//		
//		JButton b = new JButton("Hide Picture");
//		b.setBounds(150, 200, 100, 30);
//		//Button ActionListener()
//		b.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				l.setVisible(false);
//			}
//		});
//		
//		f.add(l);
//		f.add(b);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		f.setVisible(true);
//		
//		
//		
//		//2. Key board : KeyListener
//		//keyPressed:down keyReleased:up keyTyped:down and up
//		//KeyEvent.getKeyCode(): get key 
//		f = new JFrame("LOL");
//		f.setSize(400,300);
//		f.setLocation(180, 200);
//		f.setLayout(null);
//		final JLabel l2 = new JLabel();
//		i = new ImageIcon("E:\\JavaWeb\\shana.png");
//		l2.setIcon(i);
//		l2.setBounds(50,50, i.getIconWidth(), i.getIconHeight());//First two parameter for position
//		
//		f.addKeyListener(new KeyListener() {
//
//			@Override
//			public void keyPressed(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//				l2.setLocation(l2.getX() + 3, l2.getY());
//				System.out.println(arg0.getKeyChar());
//				
//			}
//
//			@Override
//			public void keyReleased(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//				l2.setLocation(l2.getX(), l2.getY() - 3);
//			}
// 
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		f.add(l2);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		f.setVisible(true);
//		
//		
//		//3. Mouse MouseListener
//		JFrame f1 = new JFrame("LOL");
//		f1.setSize(800, 600);
//		f1.setLocationRelativeTo(null);
//		f1.setLayout(null);
//		final JLabel l3 = new JLabel();
//		i = new ImageIcon("E:\\JavaWeb\\shana_heiheihei.png");
//		l3.setIcon(i);
//		l3.setBounds(375, 275, i.getIconWidth(), i.getIconHeight());
//		f1.add(l3);
//		f1.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				Random r = new Random();
//				int x = r.nextInt(f1.getWidth() - l3.getWidth());
//				int y = r.nextInt(f1.getHeight() - l3.getHeight());
//				l3.setLocation(x, y);
//				
//			}
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//			
//			}
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
//		//MouseAdapter
//		l3.addMouseListener(new MouseAdapter() {
//			// Not all the methods
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				Random r = new Random();
//				int x = r.nextInt(f1.getWidth() - l3.getWidth());
//				int y = r.nextInt(f1.getHeight() - l3.getHeight());
//				l3.setLocation(x, y);
//			}
//		});
////		f1.setVisible(true);
//		
//		
//		//Container
//		//Window Container JFrame JDialog
//		//JFrame
//		JFrame jf = new JFrame("LOL");
//		jf.setSize(400, 300);
//		jf.setLocation(200, 200);
//		jf.setLayout(null);
//		JButton jb = new JButton("kill");
//		jb.setBounds(50, 50, 280, 30);
//		jf.add(jb);
//		jf.setResizable(false);//Cannot resize
////		jf.setVisible(true);
//		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//JDialog
//		JDialog jd = new JDialog();
//		jd.setTitle("LOL");
//		jd.setSize(400, 300);
//		jd.setLocation(100, 500);
//		jd.setLayout(null);
//		jb = new JButton("kill");
//		jb.setBounds(50, 50, 280, 30);
//		jd.add(jb);
////		jd.setVisible(true);
////		jd.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
//		
//		//Modal JDialog The outer window is not activated except that the sub window is close
//		jf = new JFrame("Outer Window");
//		jf.setSize(800, 600);
//		jf.setLocation(100, 100);
//		jd = new JDialog(jf);
//		jd.setModal(true);
//		jd.setTitle("Modal Dialog");
//		jd.setSize(400, 300);
//		jd.setLocation(200, 200);
//		jd.setLayout(null);
//		jb = new JButton("kiil");
//		jb.setBounds(50, 50, 280, 30);
//		jd.add(jb);
////		jf.setVisible(true);
////		jd.setVisible(true);
//		
//		//Layout: Decide the loaction and size of container
//		//Absolute Location
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		//All the element inside the container should be set the location and size;
//		f.setLayout(null);
//		JButton b1 = new JButton("Hero 1");
//		b1.setBounds(50, 50, 80, 30);
//		JButton b2 = new JButton("Hero 2");
//		b2.setBounds(100, 50, 80, 30);
//		JButton b3 = new JButton("Hero 3");
//		b3.setBounds(150, 50, 80, 30);
//		JButton b4 = new JButton("Hero 4");
//		f.add(b1);
//		f.add(b2);
//		f.add(b3);
//		//b4 is not set size and location it will not appear in f;
//		f.add(b4);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//1. Flow Layout: Put items horizontally
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		b1 = new JButton("Hero 1");
//		b2 = new JButton("Hero 2");
//		b3 = new JButton("Hero 3");
//		f.add(b1);
//		f.add(b2);
//		f.add(b3);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//2. BorderLayout: north south east west and middle
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new BorderLayout());
//		b1 = new JButton("Hero 1");
//		b2 = new JButton("Hero 2");
//		b3 = new JButton("Hero 3");
//		f.add(b1, BorderLayout.NORTH);
//		f.add(b2, BorderLayout.EAST);
//		f.add(b3, BorderLayout.WEST);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//3 GridLayout : Grid n rows m columns
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new GridLayout(2, 3));//2 rows 3 columns
//		b1 = new JButton("Hero 1");
//		b2 = new JButton("Hero 2");
//		b3 = new JButton("Hero 3");
//		f.add(b1);
//		f.add(b2);
//		f.add(b3);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//Set prefered size for FlowLayout not for GridLayout
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		b1 = new JButton("Hero 1");
//		b2 = new JButton("Hero 2");
//		b3 = new JButton("Hero 3");
////		b3.setSize(100, 100);//Not work
//		b3.setPreferredSize(new Dimension(100, 100));
//		f.add(b1);
//		f.add(b2);
//		f.add(b3);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		//Element
//		//1. JLabel : Display the words.
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		JLabel label = new JLabel("Words");
//		label.setBounds(50, 50, 280, 30);
//		label.setForeground(Color.RED);
//		f.add(label);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//Use JLable to show picture
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		label = new JLabel();
//		i = new ImageIcon("E:\\javaweb\\shana.png");
//		label.setIcon(i);
//		label.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
//		label.setForeground(Color.RED);
//		f.add(label);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//2. JButton 
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		b = new JButton("Button");
//		b.setBounds(100, 100, 100,20);
//		f.add(b);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//3. JCheckBox
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		JCheckBox jcb1 = new JCheckBox("Super Hero");
//		jcb1.setSelected(true);
//		jcb1.setBounds(50, 50, 130, 30);
//		JCheckBox jcb2 = new JCheckBox("Eveil");
//		jcb2.setBounds(50, 100, 130, 30);
//		System.out.println(jcb2.isSelected());
//		f.add(jcb1);
//		f.add(jcb2);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//4. JRadioButton
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		JRadioButton jrb1 = new JRadioButton("Super Hero");
//		jrb1.setSelected(true);
//		jrb1.setBounds(50, 50, 130, 30);
//		JRadioButton jrb2 = new JRadioButton("Eveil");
//		jrb2.setBounds(50, 100, 130, 30);
//		
//		ButtonGroup bg = new ButtonGroup();//Put two radio button in the same group, so that they cannot be
//		//selected at the same time.
//		bg.add(jrb1);
//		bg.add(jrb2);
//		
//		System.out.println(jcb2.isSelected());
//		f.add(jrb1);
//		f.add(jrb2);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//5. JComboBox
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		String[] heros = new String[] {"Garen", "Teem", "Shana"};
//		
//		JComboBox<String> jcb = new JComboBox<String>(heros);
//		jcb.setBounds(50, 50, 80, 30);
//		System.out.println(jcb.getSelectedItem());
//		jcb.setSelectedItem(heros[2]);
//		
//		f.add(jcb);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		//6. JOptionPane: Dialog Field
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
////		int option =  JOptionPane.showConfirmDialog(f, "Have you cheated ?");
////		if (JOptionPane.OK_OPTION == option) {
////			String answer = JOptionPane.showInputDialog(f, "Please input yes");
////			if (answer.equals("yes")) {
////				JOptionPane.showMessageDialog(f, "You are catched cheating");
////			}
////		}
//		
//		//7. JTextField : Single Line text 
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		JLabel account = new JLabel("Account:");
//		
//		//TextField
//		JTextField tfName = new JTextField("");
//		tfName.setText("Please Intput Account");
//		tfName.setPreferredSize(new Dimension(100, 30));
//		System.out.println(tfName.getText());
//		JLabel password = new JLabel("Password:");
//		JTextField tfPassword = new JTextField("");
//		tfPassword.setText("Please Input Password");
//		tfPassword.setPreferredSize(new Dimension(100, 30));
//		f.add(account);
//		f.add(tfName);
//		f.add(password);
//		f.add(tfPassword);
//		tfPassword.grabFocus();
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		//8. JPasswordField
//		f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		password = new JLabel("Password:");
//		JPasswordField pf = new JPasswordField("");
//		pf.setText("hjkhgewkj");
//		pf.setPreferredSize(new Dimension(80, 30));
//		
//		char[] words = pf.getPassword();
//		System.out.println(String.valueOf(words));
//		f.add(password);
//		f.add(pf);
////		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//9. TextArea
//		JFrame f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		
//		JLabel text = new JLabel("Text Area");
//		JTextArea ta = new JTextArea();
//		ta.setPreferredSize(new Dimension(200, 150));
//		ta.setText("Great!!\n");
//		ta.append("Hello world this is a great place, welcome to the world of Java");
//		ta.setLineWrap(true);
//		f.add(text);
//		f.add(ta);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//10. JProgressBar
//		JFrame f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		JProgressBar pb = new JProgressBar();
//		pb.setMaximum(1000);
//		pb.setValue(50);
//		pb.setStringPainted(true);//Display the percent
//		f.add(pb);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//11. JFileChooser: File Selector
//		JFrame f = new JFrame("LOL");
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(new FlowLayout());
//		JFileChooser fc = new JFileChooser();
//		fc.setFileFilter(new FileFilter() {
//
//			@Override
//			public boolean accept(File f) {
//				// TODO Auto-generated method stub
//				return f.getName().toLowerCase().endsWith(".txt");
//			}
//
//			@Override
//			public String getDescription() {
//				// TODO Auto-generated method stub
//				return ".txt";
//			}
//			
//		});
//		JButton open = new JButton("Open");
//		JButton save = new JButton("Save");
//		
//		f.add(open);
//		f.add(save);
//		
//		open.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				int returnValue = fc.showOpenDialog(f);
//				File file = fc.getSelectedFile();
//				if (returnValue == JFileChooser.APPROVE_OPTION) {
//					JOptionPane.showMessageDialog(f, "Plan to open file " + file.getAbsolutePath());
//				}
//			}
//			
//		});
//		
//		save.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				int returnValue = fc.showSaveDialog(f);
//				File file = fc.getSelectedFile();
//				if (returnValue == JFileChooser.APPROVE_OPTION) {
//					JOptionPane.showMessageDialog(f, "Save the file " + file.getAbsolutePath());
//				}
//			}
//			
//		});
//		
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Panel
		//1. JPanel : Middle Container
//		JFrame f = new JFrame();
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		
//		JPanel p1 = new JPanel();
//		p1.setBounds(50, 50, 300, 60);
//		p1.setBackground(Color.RED);
//		p1.setLayout(new FlowLayout());
//		
//		JButton b1 = new JButton("Hero 1");
//		JButton b2 = new JButton("Hero 2");
//		JButton b3 = new JButton("Hero 3");
//		
//		p1.add(b1);
//		p1.add(b2);
//		p1.add(b3);
//		
//		JPanel p2 = new JPanel();
//		p2.setBounds(50, 150, 300, 60);
//		p2.setBackground(Color.BLUE);
//		p2.setLayout(new FlowLayout());
//		
//		JButton b4 = new JButton("Hero 4");
//		JButton b5 = new JButton("Hero 5");
//		JButton b6 = new JButton("Hero 6");
//		
//		p2.add(b4);
//		p2.add(b5);
//		p2.add(b6);
//		
//		f.add(p1);
//		f.add(p2);
//		
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//2. f.getContentPane()
//		JFrame f = new JFrame();
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		JButton b = new JButton("Hero 1");
//		b.setBounds(50, 50, 100, 30);
////		f.add(b);
//		f.getContentPane().add(b);
//		
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//JSplit Pane
//		JFrame f = new JFrame();
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		
//		JPanel p1 = new JPanel();
//		p1.setBounds(50, 50, 300, 60);
//		p1.setBackground(Color.RED);
//		p1.setLayout(new FlowLayout());
//		
//		JButton b1 = new JButton("Hero 1");
//		JButton b2 = new JButton("Hero 2");
//		JButton b3 = new JButton("Hero 3");
//		
//		p1.add(b1);
//		p1.add(b2);
//		p1.add(b3);
//		
//		JPanel p2 = new JPanel();
//		p2.setBounds(50, 150, 300, 60);
//		p2.setBackground(Color.BLUE);
//		p2.setLayout(new FlowLayout());
//		
//		JButton b4 = new JButton("Hero 4");
//		JButton b5 = new JButton("Hero 5");
//		JButton b6 = new JButton("Hero 6");
//		
//		p2.add(b4);
//		p2.add(b5);
//		p2.add(b6);
//		
//		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
//		sp.setDividerLocation(200);//Middle sperator
//		
//		f.setContentPane(sp);//Set content Pane
//		
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//3. JScrollPane
//		JFrame f = new JFrame();
//		f.setBounds(200, 200, 400, 300);
//		f.setLayout(null);
//		
//		JTextArea ta = new JTextArea();
//		for (int i = 0; i < 1000; i++) {
//			ta.append(String.valueOf(i));
//		}
//		ta.setLineWrap(true);
//		
//		JScrollPane sp = new JScrollPane(ta);
//		f.setContentPane(sp);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//4. Tabbed Panel
//		JFrame f = new JFrame();
//		f.setSize(400, 300);
//		f.setLocation(200, 200);
//		f.setLayout(null);
//		
//		JPanel p1 = new JPanel();
//		p1.setBounds(50, 50, 300, 60);
//		p1.setBackground(Color.RED);
//		p1.setLayout(new FlowLayout());
//		
//		JButton b1 = new JButton("Hero 1");
//		JButton b2 = new JButton("Hero 2");
//		JButton b3 = new JButton("Hero 3");
//		
//		p1.add(b1);
//		p1.add(b2);
//		p1.add(b3);
//		
//		JPanel p2 = new JPanel();
//		p2.setBounds(50, 150, 300, 60);
//		p2.setBackground(Color.BLUE);
//		p2.setLayout(new FlowLayout());
//		
//		JButton b4 = new JButton("Hero 4");
//		JButton b5 = new JButton("Hero 5");
//		JButton b6 = new JButton("Hero 6");
//		
//		p2.add(b4);
//		p2.add(b5);
//		p2.add(b6);
//		
//		JTabbedPane tp = new JTabbedPane();
//		tp.add(p1);
//		tp.add(p2);
//		
//		tp.setTitleAt(0, "Red Tab");
//		tp.setTitleAt(1, "Blue Tab");
//		
//		ImageIcon i = new ImageIcon("e://Java//Test//j.png");
//		tp.setIconAt(0, i);
//		tp.setIconAt(1, i);
//		
//		f.setContentPane(tp);
//		
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//5.CardPane
//		JFrame f = new JFrame();
//		f.setBounds(200, 200, 250, 150);
//		
//		JPanel comboPanel = new JPanel();
//		String buttonPanel = "Button Panel";
//		String inputPanel = "Input Panel";
//		String[] items = {buttonPanel, inputPanel};
//		JComboBox<String> cb = new JComboBox<>(items);
//		comboPanel.add(cb);
//		
//		JPanel card1 = new JPanel();
//		card1.add(new JButton("B1"));
//		card1.add(new JButton("B2"));
//		card1.add(new JButton("B3"));
//		
//		JPanel card2 = new JPanel();
//		card2.add(new JTextField(20));
//		
//		JPanel cards = new JPanel(new CardLayout());
//		cards.add(card1, buttonPanel);
//		cards.add(card2, inputPanel);
//		
//		f.add(comboPanel, BorderLayout.NORTH);
//		f.add(cards, BorderLayout.SOUTH);
//		
//		f.setVisible(true);
//		
//		cb.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent arg0) {
//				// TODO Auto-generated method stub
//				CardLayout cl = (CardLayout) (cards.getLayout());
//				cl.show(cards, (String)arg0.getItem());
//			}
//			
//		});
		
		
		splitPanel();
//		calculator();
//		windowPractice();
//		move();
//		displayTrigger();
//		startWindows();
	}
	
	//Practice
	
	public static void splitPanel() {
	
	}
	 
	public static void calculator() {
		JFrame f = new JFrame("Calculator");
		f.setSize(600, 500);
		f.setLocation(200, 200);
		f.setLayout(new GridLayout(4, 1));
		JButton b1 = new JButton("7");
		JButton b2 = new JButton("8");
		JButton b3 = new JButton("9");
		JButton b4 = new JButton("/");
		JButton b5 = new JButton("sq");
		JButton b6 = new JButton("4");
		JButton b7 = new JButton("5");
		JButton b8 = new JButton("6");
		JButton b9 = new JButton("*");
		JButton b10 = new JButton("%");
		JButton b11 = new JButton("1");
		JButton b12 = new JButton("2");
		JButton b13 = new JButton("3");
		JButton b14 = new JButton("-");
		JButton b15 = new JButton("1/x");
		JButton b16 = new JButton("0");
		JButton b17 = new JButton("+/-");
		JButton b18 = new JButton(".");
		JButton b19 = new JButton("+");
		JButton b20 = new JButton("=");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);
		f.add(b10);
		f.add(b11);
		f.add(b12);
		f.add(b13);
		f.add(b14);
		f.add(b15);
		f.add(b16);
		f.add(b17);
		f.add(b18);
		f.add(b19);
		f.add(b20);
		f.setVisible(true);
	}
	
	public static void windowPractice() {
		final JFrame f = new JFrame("Test");
		f.setSize(500, 300);
		f.setLocation(200, 200);
		f.setLayout(null);
		JButton b = new JButton("Open a Modal Window");
		b.setBounds(50, 10, 400, 30);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				final JDialog d = new JDialog(f);
				d.setModal(true);
				d.setBounds(300, 300, 300, 200);
				d.setLayout(null);
				JButton b1 = new JButton("Lock Size");
				b1.setBounds(50, 100, 200, 30);
				d.add(b1);
				b1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if (d.isResizable()) {
							d.setResizable(false);
							b1.setText("UnLock Size");
						}else {
							d.setResizable(true);
							b1.setText("Lock Size");
						}
					}
					
				});
				d.setVisible(true);
			}
			
		});
		f.add(b);
		f.setVisible(true);
	}
	
	
	public static void move() {
		JFrame f = new JFrame("LOL");
		f.setSize(400, 400);
		f.setLocation(300, 300);
		f.setLayout(null);
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("E:\\javaweb\\shana.png");
		l.setIcon(i);
		l.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());
		l.setLocation(10, 10);
		f.add(l);
		f.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				int step = 3;
				if (arg0.getKeyCode() == 38) {
					l.setLocation(l.getX(), l.getY() - step);
				}else if (arg0.getKeyCode() == 40) {
					l.setLocation(l.getX(), l.getY() + step);
				}else if (arg0.getKeyCode() == 37) {
					l.setLocation(l.getX() - step, l.getY());
				}else if (arg0.getKeyCode() == 39) {
					l.setLocation(l.getX() + step, l.getY());
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		f.setVisible(true);
	}
	
	public static void displayTrigger() {
		JFrame f = new JFrame("LOL");
		f.setSize(400, 300);
		f.setLocation(300, 300);
		f.setLayout(null);
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("e:\\JavaWeb\\shana.png");
		l.setIcon(i);
		l.setBounds(140, 50, i.getIconWidth(), i.getIconHeight());
		JButton b = new JButton("Hide");
		b.setSize(100, 20);
		b.setLocation(150, 200);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (l.isVisible()) {
					l.setVisible(false);
					b.setText("Display");
				}else {
					l.setVisible(true);
					b.setText("Hide");
				}
			}
		});
		f.add(l);
		f.add(b);
		f.setVisible(true);	
	}
	public static void startWindows() {
		File file = new File("e:\\Java\\Test\\location.txt");
		Point p = new Point(200, 200);
		try(FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis)){
			if (file.exists() && file.length() > 0) {
				p.x = dis.readInt();
				p.y = dis.readInt();
			}
		}catch(IOException e) {
			e.printStackTrace();
			p.x = 200;
			p.y = 200;
		}
		JFrame f = new JFrame();
		f.setSize(400, 300);
		f.setLocation(p);
		f.setLayout(null);
		Thread t = new Thread() {
			public void run() {
				while (true) {
					int currentX = f.getX();
					int currentY = f.getY();
					try(FileOutputStream fos = new FileOutputStream(file);
						DataOutputStream dos = new DataOutputStream(fos)){
						dos.writeInt(currentX);
						dos.writeInt(currentY);
					}catch(IOException e) {
						e.printStackTrace();
					}
					try {
						Thread.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
