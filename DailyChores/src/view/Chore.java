package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Dimension2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Chore extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chore frame = new Chore();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		Color back= new Color(0,0,0,0);
		setBackground(back);
		
		JLabel lblChar = new JLabel("New label");
		lblChar.setBounds(290, 48, 200, 178);
		
		//lblChar.setSize(200, 165);
		ImageIcon iconChar = new ImageIcon(getClass().getResource("/images/Mayuri.png"));
		Image imgChar = iconChar.getImage() ;  
		Image newimgChar = imgChar.getScaledInstance( lblChar.getWidth(), lblChar.getHeight(),  Image.SCALE_SMOOTH ) ;  
		iconChar = new ImageIcon( newimgChar );
		lblChar.setIcon(iconChar);
		contentPane.add(lblChar);
		
		/*
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		textPane.setBounds(0, 48, 264, 165);
		textPane.setOpaque(false);
		contentPane.add(textPane);
		*/
		JTextArea textArea = new JTextArea();
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(textArea.getRows());
			}
		});
		textArea.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		textArea.setLineWrap(true);
		//textPane.setFont(new Font("Lucida Bright", Font.BOLD, 24));
		textArea.setBounds(16, 48, 264, 178);
		textArea.setOpaque(false);
		contentPane.add(textArea);
		
		System.out.println(textArea.getLineCount());
		
		 FrameDragListener frameDragListener = new FrameDragListener(this);
         addMouseListener(frameDragListener);
         addMouseMotionListener(frameDragListener);
		
		
		JLabel lblBkg = new JLabel("");
		lblBkg.setBounds(6, 36, 284, 200);
		ImageIcon iconBkg = new ImageIcon(getClass().getResource("/images/background.jpg"));
		Image imgBkg = iconBkg.getImage() ;  
		Image newimgBkg = imgBkg.getScaledInstance( lblBkg.getWidth(), lblBkg.getHeight(),  Image.SCALE_SMOOTH ) ;  
		iconBkg = new ImageIcon( newimgBkg );
		lblBkg.setIcon(iconBkg);
		contentPane.add(lblBkg);
		contentPane.add(lblBkg);
	}
	public static class FrameDragListener extends MouseAdapter {

        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame;
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
	
}
