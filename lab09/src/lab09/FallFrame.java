package lab09;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class FallFrame extends JFrame{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FallFrame frame = new FallFrame();
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
	public FallFrame() throws InterruptedException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setSize(new Dimension(
				java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/2,
				java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/2));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JPanel SquarePanel = new JPanel();
		SquarePanel.setLayout(new BorderLayout());
		SquarePanel.setBackground(Color.YELLOW);
		SquarePanel.add(new SquareComponent());
		SquareComponent squareComponent = new SquareComponent();
		//contentPane.add(SquarePanel, BorderLayout.CENTER);
		squareComponent.setPreferredSize(new Dimension(SquarePanel.getSize()));
		SquarePanel.add(squareComponent,BorderLayout.CENTER);
		
		contentPane.add(SquarePanel);
		
		JButton btnNewButton_1 = new JButton("STOP");
		btnNewButton_1.addActionListener(e -> {
			squareComponent.stopNow();
		});
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("ADD NEXT SQUARE");
		btnNewButton.addActionListener(e -> {
			squareComponent.addSquare();
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("RESUME");
		btnNewButton_2.addActionListener(e -> {
			squareComponent.resumeNow();
		});
		panel.add(btnNewButton_2);
		
		
		
	}

}
