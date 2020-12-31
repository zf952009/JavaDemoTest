package my.demo.api.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5361130997880602263L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMenu frame = new MyMenu();
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
	public MyMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("\u6587\u4EF6");
		menuBar.add(menu);

		JMenu menu_3 = new JMenu("\u6253\u5F00");
		menuBar.add(menu_3);

		JMenu menu_1 = new JMenu("\u64CD\u4F5C");
		menuBar.add(menu_1);

		JMenu menu_2 = new JMenu("\u65B0\u5EFA\u6587\u4EF6\u5939");
		menuBar.add(menu_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
