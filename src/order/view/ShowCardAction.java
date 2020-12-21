package order.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCardAction implements ActionListener{

	Container card_panel;
	String card_name;
	
	public ShowCardAction(Container card_panel, String card_name) {
		this.card_panel = card_panel;
		this.card_name = card_name;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((CardLayout) card_panel.getLayout()).show(card_panel, card_name);
	}
	
}
