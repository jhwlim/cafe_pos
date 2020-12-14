package store.controller.mouse.add;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

public class StoreAddTextClickActionListener extends MouseAdapter {

	JTextField text;
	
	public StoreAddTextClickActionListener(JTextField text) {
		this.text = text;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
			text.setText("");
			text.setForeground(Color.black);
		}
	}

	
}
