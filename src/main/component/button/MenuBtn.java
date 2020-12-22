package main.component.button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import main.controller.btn.MenuBtnClickListener;

public class MenuBtn extends JButton {

   public MenuBtn() {
      setBackground(Color.white);
      setBorder(BorderFactory.createEmptyBorder());
   }

   public MenuBtn(MenuBtnEnum mbe) {
      super(mbe.btnName);

      setBackground(new Color(0x2868b0));
      setFont(new Font("야놀자야체", Font.BOLD, 30));
      setForeground(new Color(0x663300));
//      setBorder(BorderFactory.createEmptyBorder());

      addActionListener(new MenuBtnClickListener(mbe));

      setContentAreaFilled(false);
   }

   static int round = 40;
   
   public void paint(Graphics g) {
       // Set background same as parent.
       setBackground(getParent().getBackground());
       setBorder(null);

       // I don't need this -- calls to above methods will 
       // invoke repaint as needed.
       super.paint(g);

       // Take advantage of Graphics2D to position string
       Graphics2D g2d = (Graphics2D)g;

       // Make it grey #DDDDDD, and make it round with 
       // 1px black border.
       // Use an HTML color guide to find a desired color.
       // Last color is alpha, with max 0xFF to make 
       // completely opaque.
       g2d.setColor(new Color(0x663300));

       // Draw rectangle with rounded corners on top of 
       // button
       g2d.fillRoundRect(0,0,getWidth(),getHeight(),round,round);

       // I'm just drawing a border
       g2d.setColor(getForeground());
       
       g2d.drawRoundRect(0,0,getWidth()-1,
          getHeight()-1,round,round);

       // Finding size of text so can position in center.
       FontRenderContext frc = 
          new FontRenderContext(null, false, false);
       Rectangle2D r = getFont().getStringBounds(getText(), frc);

       float xMargin = (float)(getWidth()-r.getWidth())/2;
       float yMargin = (float)(getHeight()-getFont().getSize())/2;

       // Draw the text in the center
       g2d.drawString(getText(), xMargin, 
          (float)getFont().getSize() + yMargin);
      }
   

}
