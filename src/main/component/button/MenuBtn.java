package main.component.button;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.component.panel.menu.side.MainMenuSideCenterPanel;
import main.component.panel.menu.side.MainMenuSideDownPanel;
import main.controller.btn.MenuBtnClickListener;

public class MenuBtn extends JButton {

	public static final Color FONT_COLOR = new Color(0xFFFFFF);
	public static final Color BG_COLOR = new Color(0x663300);

	public MenuBtn(String name) {
		super(name);
		setFont(new Font("맑은 고딕", Font.BOLD, 30));

		setContentAreaFilled(false);
		
		setForeground(new Color(0xFFFFFF)); // 버튼 폰트
		setBackground(new Color(0x663300)); // 버튼 배경
		setBorder(BorderFactory.createLineBorder(new Color(0x663300)));
	
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new BorderLayout(0, 10));
				
				panel.add(MainMenuSideCenterPanel.getInstance(), BorderLayout.CENTER);
				
				JOptionPane.showMessageDialog(null, panel, "매장 정보", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
	}


   public MenuBtn(MenuBtnEnum mbe) {
      super(mbe.btnName);

      setFont(new Font("맑은 고딕", Font.BOLD, 30));

      addActionListener(new MenuBtnClickListener(mbe));

      setContentAreaFilled(false);

      setForeground(FONT_COLOR);// 버튼 폰트
      setBackground(BG_COLOR);// 버튼 배경
      setBorder(BorderFactory.createLineBorder(BG_COLOR));

   }

   static int round = 40;

   public void paint(Graphics g) {
      setBackground(getParent().getBackground());
      setBorder(null);

      Graphics2D g2d = (Graphics2D)g;

      g2d.setColor(BG_COLOR); // BG Color

      g2d.fillRoundRect(0,0,getWidth(),getHeight(),round,round);

      g2d.setColor(FONT_COLOR);

      g2d.drawRoundRect(0,0,getWidth()-1, getHeight()-1,round, round);

      FontRenderContext frc = new FontRenderContext(null, false, false);
      Rectangle2D r = getFont().getStringBounds(getText(), frc);

      float xMargin = (float)(getWidth()-r.getWidth())/2;
      float yMargin = (float)(getHeight()-getFont().getSize())/2;

      g2d.drawString(getText(), xMargin, (float)getFont().getSize() + yMargin);
   }


}