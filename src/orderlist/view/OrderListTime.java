package orderlist.view;

import java.awt.Font;
import java.util.Calendar;

import javax.swing.JLabel;

public class OrderListTime extends JLabel implements Runnable {

	private Thread thread;
	private JLabel label;

	public OrderListTime() {
		super();

		label = new JLabel();
		label.setFont(new Font("Serif", Font.PLAIN, 20));

		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			Calendar cal = Calendar.getInstance();

			String now = cal.get(Calendar.YEAR) + "년" + (cal.get(Calendar.MONTH) + 1) + "월" + cal.get(Calendar.DATE)
					+ "일" + cal.get(Calendar.HOUR) + "시" + cal.get(Calendar.MINUTE) + "분" + cal.get(Calendar.SECOND)
					+ "초";

			label.setText(now);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}