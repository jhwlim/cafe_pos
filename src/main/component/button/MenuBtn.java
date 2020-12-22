package main.component.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import common.font.MenuBtnFont;
import main.controller.btn.MenuBtnClickListener;

public class MenuBtn extends JButton {
   
   public MenuBtn() {
      setBackground(new Color(0x663300));
      setBorder(BorderFactory.createEmptyBorder());
   }
   
   public MenuBtn(MenuBtnEnum mbe) {
      super(mbe.btnName);
      
      setBackground(new Color(0x2868b0));
      setFont(new Font("맑은 고딕", Font.BOLD, 30));
      setForeground(new Color(0x663300));
      setBorder(BorderFactory.createEmptyBorder());
      
      addActionListener(new MenuBtnClickListener(mbe));
   }
   
   protected void decorate() { 
      setBorderPainted(false); 
      setOpaque(false); 
   }

   public static int round = 50;
   
   @Override
   protected void paintComponent(Graphics g) {
      int width = getWidth(); 
      int height = getHeight(); 
      Graphics2D graphics = (Graphics2D) g; 
      graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
      if (getModel().isArmed()) { 
         graphics.setColor(getBackground().darker()); 
      } else if (getModel().isRollover()) { 
         graphics.setColor(getBackground().brighter()); 
      } else { 
         graphics.setColor(getBackground()); 
      } 
      graphics.fillRoundRect(0, 0, width, height, round, round); 
      FontMetrics fontMetrics = graphics.getFontMetrics(); 
      Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
      int textX = (width - stringBounds.width) / 2; 
      int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
      graphics.setColor(getForeground()); 
      graphics.setFont(getFont()); 
      graphics.drawString(getText(), textX, textY); 
      graphics.dispose(); 
      super.paintComponent(g);

   }
   
}