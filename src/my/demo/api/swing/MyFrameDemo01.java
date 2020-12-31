package my.demo.api.swing;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class MyFrameDemo01 extends JFrame {

	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 16161L;
	protected static final String LINE_SEPARATOR = System.getProperty("line.separator");
	private JPanel contentPane;
	private JTextField textField;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrameDemo01 frame = new MyFrameDemo01();
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
	public MyFrameDemo01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 342);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();

		textField.setBounds(154, 10, 186, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		/*
		 * 点击转到按钮，就根据输入的路径显示该路径下的文件和文件夹
		 * 
		 */

		JButton button = new JButton("\u8F6C\u5230");
		button.setBounds(375, 9, 81, 23);
		contentPane.add(button);

		JTextArea textArea0 = new JTextArea();
		textArea0.setWrapStyleWord(true);
		textArea0.setBounds(10, 42, 474, 252);
		contentPane.add(textArea0);

		textPane = new JTextPane();
		textPane.setBounds(10, 42, 474, 252);
		contentPane.add(textPane);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(467, 42, 17, 252);
		contentPane.add(scrollBar);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JButtonActionPerformed(arg0);

			}

			// 按钮事件处理方式
			private void JButtonActionPerformed(ActionEvent arg0) {
				showDir(textArea0);

			}

			private void showDir(JTextArea textArea0) {
				String dir = textField.getText();
				File dir_file = new File(dir);
				// 健壮性判断
				if (dir_file.exists() && dir_file.isDirectory()) {
					// 输入的路径正确就清文本域里面的内容
					textArea0.setText("");

					String[] dirs_file = dir_file.list();
					for (String name : dirs_file) {
						textArea0.append(name + LINE_SEPARATOR);
					}

				}
			}
		});
	}

}
