package orderlist.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;

public class OrderListTime extends JLabel implements Runnable {

	private Thread thread;

	public OrderListTime() {
		super();

		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		setForeground(Color.white);
		setFont(new Font("야놀자야체", Font.BOLD, 25));
		}
	}

	@Override
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();

			String now = cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH) + 1) + "월 " + cal.get(Calendar.DATE) + "일 "
					+ cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초";

			this.setText(now);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	
}