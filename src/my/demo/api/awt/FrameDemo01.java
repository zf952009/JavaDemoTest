package my.demo.api.awt;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameDemo01 {

	public static void main(String[] args) {
		// 创建窗体演示，
		// 默认创建一个不可见的窗体
		Frame frame = new Frame("我是窗体");
		// 窗体设置
		frame.setLayout(new FlowLayout());
		// 窗体位置
		frame.setLocation(300, 200);
		// 窗体大小
		frame.setSize(500, 500);

		Button button = new Button("提交按钮");
		frame.add(button);

		// 窗体显示

		frame.setVisible(true);

	}

}
