import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {
	static int point = 0;// global variable for win condition
	private JFrame setupframe;
	private JFrame gameframe;
	private JFrame endframe;
	private static JButton monkeybtn1;
	private static JButton monkeybtn2;
	private static JButton monkeybtn3;
	private static JButton monkeybtn4;
	private static JButton monkeybtn5;
	private static JButton monkeybtn6;
	private static JButton monkeybtn7;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.setupframe.setVisible(true);// 3 frames for start screen, game screen and end screen
					window.gameframe.setVisible(false);
					window.endframe.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupframe = new JFrame();
		setupframe.getContentPane().setBackground(Color.BLACK);
		setupframe.setBounds(100, 100, 657, 480);

		setupframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupframe.getContentPane().setLayout(null);

		JLabel titlelbl = new JLabel("Monkey Game");
		titlelbl.setForeground(Color.WHITE);
		titlelbl.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 50));
		titlelbl.setBounds(202, 109, 234, 68);
		setupframe.getContentPane().add(titlelbl);

		JButton startbtn = new JButton("Start\r\n");
		startbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setupframe.setVisible(false); // makes the setup frame go to the game frame
				gameframe.setVisible(true);
			}
		});
		startbtn.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 25));
		startbtn.setBounds(204, 200, 215, 61);
		setupframe.getContentPane().add(startbtn);
		
		endframe = new JFrame();
		endframe.getContentPane().setBackground(Color.BLACK);
		endframe.getContentPane().setLayout(null);

		JLabel monekyendlbl = new JLabel("You've Become");
		monekyendlbl.setForeground(Color.WHITE);
		monekyendlbl.setFont(new Font("Tahoma", Font.PLAIN, 28));
		monekyendlbl.setBounds(198, 128, 253, 99);
		endframe.getContentPane().add(monekyendlbl);

		JLabel winloselbl = new JLabel("...");
		winloselbl.setForeground(Color.WHITE);
		winloselbl.setFont(new Font("Tahoma", Font.PLAIN, 28));
		winloselbl.setBounds(252, 250, 199, 48);
		endframe.getContentPane().add(winloselbl);
		winloselbl.setText("Human");// will always set text human(lose) unless btn 7 is to pressed to win

		JButton exitbtn = new JButton("Exit");
		exitbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // leaves game
			}
		});
		exitbtn.setBounds(508, 119, 93, 210);

		endframe.getContentPane().add(exitbtn);

		JButton restartbutt = new JButton("Restart");
		restartbutt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		restartbutt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initialize(); // restarts the method intialize in which the whole program is basically reset
				setupframe.setVisible(true);
				endframe.setVisible(false);
				gameframe.setVisible(false);
				point = 0; // resets point system
			}
		});
		restartbutt.setBounds(31, 128, 93, 192);
		endframe.getContentPane().add(restartbutt);
		endframe.setBounds(100, 100, 657, 480);
		endframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		int coordinatey[][] = new int[5][8]; // sets up a 2d array coordinate system so that the boxes can appear at a
												// give coordinate
		int coordinatex[][] = new int[5][8];
		int w = 640;
		int y = 400;
		int s = 80;
		for (int i = 0; i < y / s; i++) {
			for (int j = 0; j < w / s; j++) {
				coordinatey[i][j] = 80 * i;
				coordinatex[i][j] = 80 * j;
			}
		}

		gameframe = new JFrame();
		gameframe.getContentPane().setBackground(Color.BLACK);
		gameframe.setBounds(100, 100, 657, 480);
		gameframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameframe.getContentPane().setLayout(null);

		monkeybtn1 = new JButton("1");
		monkeybtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttons();
				if (point == 0) {// Disappears and sets point to 2 for the game to continue
					point += 2;
					monkeybtn1.setVisible(false);
				} else {
					gameframe.setVisible(false);
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn1.setBounds(22, 0, 80, 80);
		gameframe.getContentPane().add(monkeybtn1);
		monkeybtn1.setVisible(false);

		monkeybtn2 = new JButton("2");
		monkeybtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(point);
				if (point == 2) {
					point += 2;
					monkeybtn2.setVisible(false);
				} else {
					gameframe.setVisible(false);// if pressed out of order game will end and you lose switching screens
												// to end screen
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn2.setBounds(149, 0, 80, 80);
		gameframe.getContentPane().add(monkeybtn2);
		monkeybtn2.setVisible(false);

		monkeybtn3 = new JButton("3\r\n");
		monkeybtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(point);
				if (point == 4) {
					point += 2;
					monkeybtn3.setVisible(false);
				} else {
					gameframe.setVisible(false);
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn3.setBounds(288, 0, 80, 80);
		gameframe.getContentPane().add(monkeybtn3);
		monkeybtn3.setVisible(false);

		monkeybtn4 = new JButton("4");
		monkeybtn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (point == 6) {
					point += 2;
					monkeybtn4.setVisible(false);
				} else {
					gameframe.setVisible(false);
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn4.setBounds(424, 0, 80, 80);
		gameframe.getContentPane().add(monkeybtn4);
		monkeybtn4.setVisible(false);

		monkeybtn5 = new JButton("5\r\n");
		monkeybtn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (point == 8) {
					point += 2;
					monkeybtn5.setVisible(false);
				} else {
					gameframe.setVisible(false);
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn5.setBounds(539, 0, 80, 80);
		gameframe.getContentPane().add(monkeybtn5);
		monkeybtn5.setVisible(false);

		monkeybtn6 = new JButton("6");
		monkeybtn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (point == 10) {
					point += 2;
					monkeybtn6.setVisible(false);
				} else {
					gameframe.setVisible(false);
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn6.setBounds(22, 96, 80, 80);
		gameframe.getContentPane().add(monkeybtn6);
		monkeybtn6.setVisible(false);

		monkeybtn7 = new JButton("7");
		monkeybtn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (point == 12) {
					point += 2;
					monkeybtn7.setVisible(false);// if got to btn 7 it will show monkey in which you win
					gameframe.setVisible(false);
					endframe.setVisible(true);
					winloselbl.setText("Monkey");
				} else {
					gameframe.setVisible(false);
					endframe.setVisible(true);
				}
			}
		});
		monkeybtn7.setBounds(539, 91, 80, 80);
		gameframe.getContentPane().add(monkeybtn7);
		monkeybtn7.setVisible(false);

		JButton startmonkeybtn = new JButton("START");
		startmonkeybtn.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 28));
		startmonkeybtn.setForeground(Color.WHITE);
		startmonkeybtn.setBackground(Color.LIGHT_GRAY);
		startmonkeybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startmonkeybtn.setVisible(false);// disapears for game to start
				visibility();
				Integer[] randomplacex = new Integer[8]; // array to choice random set of numbers with no repeats
				Integer[] randomplacey = new Integer[5];
				for (int i = 0; i < 8; i++) {
					randomplacex[i] = i;
				}
				for (int i = 0; i < 5; i++) {
					randomplacey[i] = i;
				}
				Collections.shuffle(Arrays.asList(randomplacex));// shuffles the order of the arrays
				Collections.shuffle(Arrays.asList(randomplacey));
				monkeybtn1.setBounds(coordinatex[0][randomplacex[0]], coordinatey[randomplacey[0]][0], 80, 80);// sets
																												// the
																												// bounds
																												// of
																												// the
																												// monkey
																												// btns
				monkeybtn2.setBounds(coordinatex[0][randomplacex[1]], coordinatey[randomplacey[1]][0], 80, 80);
				monkeybtn3.setBounds(coordinatex[0][randomplacex[2]], coordinatey[randomplacey[2]][0], 80, 80);
				monkeybtn4.setBounds(coordinatex[0][randomplacex[3]], coordinatey[randomplacey[3]][0], 80, 80);
				monkeybtn5.setBounds(coordinatex[0][randomplacex[4]], coordinatey[randomplacey[4]][0], 80, 80);
				monkeybtn6.setBounds(coordinatex[0][randomplacex[5]], coordinatey[randomplacey[3]][0], 80, 80);
				monkeybtn7.setBounds(coordinatex[0][randomplacex[6]], coordinatey[randomplacey[2]][0], 80, 80);
			}

		});
		startmonkeybtn.setBounds(210, 166, 201, 75);
		gameframe.getContentPane().add(startmonkeybtn);

	}

	// Set all monkey buttons visible
	// @para n/a
	// @returns visible buttons
	private static void visibility() {
		monkeybtn1.setVisible(true);
		monkeybtn2.setVisible(true);
		monkeybtn3.setVisible(true);
		monkeybtn4.setVisible(true);
		monkeybtn5.setVisible(true);
		monkeybtn6.setVisible(true);
		monkeybtn7.setVisible(true);
	}

	// Set all monkey buttons to have no text
	// @para n/a
	// @returns buttons with no text
	private static void buttons() {
		monkeybtn2.setText("");
		monkeybtn3.setText("");
		monkeybtn4.setText("");
		monkeybtn5.setText("");
		monkeybtn6.setText("");
		monkeybtn7.setText("");
	}
}