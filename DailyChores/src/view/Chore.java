package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Chore.class.getResource("/images/Mayuri.png")));
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
				//System.out.println(textArea.getRows());
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
		
		
		JLabel lblClose = new JLabel("Close");
		lblClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblClose.setBounds(454, 11, 32, 14);
		contentPane.add(lblClose);
		
		JLabel lblCloseBkg = new JLabel("");
		lblCloseBkg.setBounds(450, 11, 40, 14);
		ImageIcon iconCloseBkg = new ImageIcon(getClass().getResource("/images/background.jpg"));
		Image imgCloseBkg = iconCloseBkg.getImage() ;  
		Image newimgCloseBkg = imgCloseBkg.getScaledInstance( lblCloseBkg.getWidth(), lblCloseBkg.getHeight(),  Image.SCALE_SMOOTH ) ;  
		iconCloseBkg = new ImageIcon( newimgCloseBkg );
		lblCloseBkg.setIcon(iconCloseBkg);
		contentPane.add(lblCloseBkg);
		
		JLabel lblNewChore = new JLabel("New Chore");
		lblNewChore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Chore chore = new Chore();
				chore.setVisible(true);
			}
		});
		lblNewChore.setBounds(379, 11, 63, 14);
		contentPane.add(lblNewChore);
		
		JLabel lblNewChoreBkg = new JLabel("New label");
		lblNewChoreBkg.setBounds(371, 11, 65, 14);
		ImageIcon iconNewChoreBkg = new ImageIcon(getClass().getResource("/images/background.jpg"));
		Image imgNewChoreBkg = iconNewChoreBkg.getImage() ;  
		Image newimgNewChoreBkg = imgNewChoreBkg.getScaledInstance( lblNewChoreBkg.getWidth(), lblNewChoreBkg.getHeight(),  Image.SCALE_SMOOTH ) ;  
		iconNewChoreBkg = new ImageIcon( newimgNewChoreBkg );
		lblNewChoreBkg.setIcon(iconNewChoreBkg);
		contentPane.add(lblNewChoreBkg);
		
		JLabel lblTimer = new JLabel("  Timer");
		lblTimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                ActionListener actionListener = new ActionListener() {

                    public void actionPerformed(ActionEvent actionEvent) {
                        System.out.println("Hello");
                    }
                };
                Timer timer = new Timer(5000, actionListener);
                timer.setRepeats(false);
                timer.start();
			}
		});
		lblTimer.setBounds(310, 11, 39, 14);
		contentPane.add(lblTimer);
		
		JLabel lblBkgTimer = new JLabel("New label");
		lblBkgTimer.setBounds(310, 11, 42, 14);
		
		ImageIcon iconTimerBkg = new ImageIcon(getClass().getResource("/images/background.jpg"));
		Image imgTimerBkg = iconCloseBkg.getImage() ;  
		Image newimgTimerBkg = imgTimerBkg.getScaledInstance( lblBkgTimer.getWidth(), lblBkgTimer.getHeight(),  Image.SCALE_SMOOTH ) ;  
		iconTimerBkg = new ImageIcon( newimgTimerBkg );
		lblBkgTimer.setIcon(iconTimerBkg);
		
		contentPane.add(lblBkgTimer);
		
		
		
		
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
