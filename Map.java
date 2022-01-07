import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Map {

	private JFrame frame;
	private JTextField inputPanel;
	private JTextField txtEmpireOfPersia;
	private JTextField txtEmpireOfRome;
	private JTextField txtEmpireOfEgypt;
	private JTextField txtEmpireOfMacedonia;
	static ArrayList<String> chat = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void map() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Map window = new Map();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Map() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1330, 702);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/*
		 * Creates the Buttons takes as parameter the number of warriors takes the color
		 * of the Empires
		 */

		JButton SpartaButton = new JButton("3");
		SpartaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		SpartaButton.setBackground(new Color(51, 204, 255));
		SpartaButton.setBounds(807, 125, 36, 28);
		frame.getContentPane().add(SpartaButton);

		JButton BabylonButton = new JButton("3");
		BabylonButton.setFont(new Font("Arial", Font.PLAIN, 12));
		BabylonButton.setBackground(new Color(255, 0, 0));
		BabylonButton.setBounds(862, 250, 36, 28);
		frame.getContentPane().add(BabylonButton);

		JButton RomeButton = new JButton("3");
		RomeButton.setFont(new Font("Arial", Font.PLAIN, 12));
		RomeButton.setBackground(new Color(255, 255, 0));
		RomeButton.setBounds(843, 361, 36, 28);
		frame.getContentPane().add(RomeButton);

		JButton RavennaButton = new JButton("3");
		RavennaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		RavennaButton.setBackground(new Color(255, 255, 0));
		RavennaButton.setBounds(521, 199, 36, 28);
		frame.getContentPane().add(RavennaButton);

		JButton AlexandriaButton = new JButton("3");
		AlexandriaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		AlexandriaButton.setBackground(Color.GREEN);
		AlexandriaButton.setBounds(535, 389, 36, 28);
		frame.getContentPane().add(AlexandriaButton);

		JButton ThinisButton = new JButton("3");
		ThinisButton.setFont(new Font("Arial", Font.PLAIN, 12));
		ThinisButton.setBackground(Color.GREEN);
		ThinisButton.setBounds(862, 171, 36, 28);
		frame.getContentPane().add(ThinisButton);

		JButton CorinthButton = new JButton("3");
		CorinthButton.setFont(new Font("Arial", Font.PLAIN, 12));
		CorinthButton.setBackground(new Color(51, 204, 255));
		CorinthButton.setBounds(961, 267, 36, 28);
		frame.getContentPane().add(CorinthButton);

		JButton SusaButton = new JButton("3");
		SusaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		SusaButton.setBackground(new Color(255, 0, 0));
		SusaButton.setBounds(483, 267, 36, 28);
		frame.getContentPane().add(SusaButton);

		JButton TanisButton = new JButton("3");
		TanisButton.setFont(new Font("Arial", Font.PLAIN, 12));
		TanisButton.setBackground(Color.GREEN);
		TanisButton.setBounds(619, 518, 36, 28);
		frame.getContentPane().add(TanisButton);

		JButton AvarisButton = new JButton("3");
		AvarisButton.setFont(new Font("Arial", Font.PLAIN, 12));
		AvarisButton.setBackground(Color.GREEN);
		AvarisButton.setBounds(619, 149, 36, 28);
		frame.getContentPane().add(AvarisButton);

		JButton SicilyButton = new JButton("3");
		SicilyButton.setFont(new Font("Arial", Font.PLAIN, 12));
		SicilyButton.setBackground(new Color(255, 255, 0));
		SicilyButton.setBounds(494, 475, 36, 28);
		frame.getContentPane().add(SicilyButton);

		JButton FlorenceButton = new JButton("3");
		FlorenceButton.setFont(new Font("Arial", Font.PLAIN, 12));
		FlorenceButton.setBackground(new Color(255, 255, 0));
		FlorenceButton.setBounds(739, 125, 36, 28);
		frame.getContentPane().add(FlorenceButton);

		JButton SardiniaButton = new JButton("3");
		SardiniaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		SardiniaButton.setBackground(new Color(255, 255, 0));
		SardiniaButton.setBounds(1122, 361, 36, 28);
		frame.getContentPane().add(SardiniaButton);

		JButton CreteButton = new JButton("3");
		CreteButton.setFont(new Font("Arial", Font.PLAIN, 12));
		CreteButton.setBackground(new Color(51, 204, 255));
		CreteButton.setBounds(1122, 434, 36, 28);
		frame.getContentPane().add(CreteButton);

		JButton AthensButton = new JButton("3");
		AthensButton.setFont(new Font("Arial", Font.PLAIN, 12));
		AthensButton.setBackground(new Color(51, 204, 255));
		AthensButton.setBounds(521, 546, 36, 28);
		frame.getContentPane().add(AthensButton);

		JButton PersepolisButton = new JButton("3");
		PersepolisButton.setFont(new Font("Arial", Font.PLAIN, 12));
		PersepolisButton.setBackground(new Color(255, 0, 0));
		PersepolisButton.setBounds(717, 434, 36, 28);
		frame.getContentPane().add(PersepolisButton);

		JButton NinevehButton = new JButton("3");
		NinevehButton.setFont(new Font("Arial", Font.PLAIN, 12));
		NinevehButton.setBackground(new Color(255, 0, 0));
		NinevehButton.setBounds(1059, 348, 36, 28);
		frame.getContentPane().add(NinevehButton);

		JButton MemphisButton = new JButton("3");
		MemphisButton.setFont(new Font("Arial", Font.PLAIN, 12));
		MemphisButton.setBackground(Color.GREEN);
		MemphisButton.setBounds(961, 338, 36, 28);
		frame.getContentPane().add(MemphisButton);

		JButton AshulButton = new JButton("3");
		AshulButton.setFont(new Font("Arial", Font.PLAIN, 12));
		AshulButton.setBackground(new Color(255, 0, 0));
		AshulButton.setBounds(936, 378, 36, 28);
		frame.getContentPane().add(AshulButton);

		JButton MacedoniaButton = new JButton("3");
		MacedoniaButton.setFont(new Font("Arial", Font.PLAIN, 12));
		MacedoniaButton.setBackground(new Color(51, 204, 255));
		MacedoniaButton.setBounds(693, 267, 36, 28);
		frame.getContentPane().add(MacedoniaButton);

		JTextPane outputPanel = new JTextPane();
		outputPanel.setEditable(false);
		outputPanel.setBounds(0, 6, 363, 592);
		frame.getContentPane().add(outputPanel);

		inputPanel = new JTextField();
		inputPanel.setFont(new Font("SansSerif", Font.PLAIN, 20));
		inputPanel.setBounds(0, 610, 256, 49);
		frame.getContentPane().add(inputPanel);
		inputPanel.setColumns(10);

		JButton SendButton = new JButton("Send");
		SendButton.setFont(new Font("SansSerif", Font.PLAIN, 23));
		SendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// outputPanel.setText(chat);
			}
		});
		SendButton.setBounds(268, 613, 99, 46);
		frame.getContentPane().add(SendButton);

		/*
		 * The Map as a png file
		 */

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(383, 12, 927, 647); //
		frame.getContentPane().add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("Map.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));

		/*
		 * The legend, which Empires has each color
		 */

		txtEmpireOfPersia = new JTextField();
		txtEmpireOfPersia.setEditable(false);
		txtEmpireOfPersia.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtEmpireOfPersia.setBackground(new Color(255, 51, 0));
		txtEmpireOfPersia.setText("Empire of Persia");
		txtEmpireOfPersia.setBounds(1111, 631, 174, 28);
		frame.getContentPane().add(txtEmpireOfPersia);
		txtEmpireOfPersia.setColumns(10);

		txtEmpireOfRome = new JTextField();
		txtEmpireOfRome.setEditable(false);
		txtEmpireOfRome.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtEmpireOfRome.setText("Empire of Rome");
		txtEmpireOfRome.setBackground(new Color(255, 255, 51));
		txtEmpireOfRome.setColumns(10);
		txtEmpireOfRome.setBounds(1111, 597, 174, 28);
		frame.getContentPane().add(txtEmpireOfRome);

		txtEmpireOfEgypt = new JTextField();
		txtEmpireOfEgypt.setEditable(false);
		txtEmpireOfEgypt.setFont(new Font("SansSerif", Font.PLAIN, 15));
		txtEmpireOfEgypt.setBackground(new Color(102, 255, 51));
		txtEmpireOfEgypt.setText("Empire of Egypt");
		txtEmpireOfEgypt.setColumns(10);
		txtEmpireOfEgypt.setBounds(1111, 563, 174, 28);
		frame.getContentPane().add(txtEmpireOfEgypt);

		txtEmpireOfMacedonia = new JTextField();
		txtEmpireOfMacedonia.setBackground(new Color(51, 204, 255));
		txtEmpireOfMacedonia.setFont(new Font("SansSerif", Font.PLAIN, 16));
		txtEmpireOfMacedonia.setText("Empire of Macedonia");
		txtEmpireOfMacedonia.setEditable(false);
		txtEmpireOfMacedonia.setColumns(10);
		txtEmpireOfMacedonia.setBounds(1111, 529, 174, 28);
		frame.getContentPane().add(txtEmpireOfMacedonia);

	}
}
