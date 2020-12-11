package order.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.component.btn.MenuBtnEnum;
import main.component.panel.ContentPanel;

public class OrderView {

	public static JPanel panel;

	private static DefaultTableModel dtm;

	static {
		panel = ContentPanel.getPanel(MenuBtnEnum.ORDER);
		/*
		 * 1. 기본 패널을 만든다 <- 기본 패널이다.
		 * 
		 * 2. 기본 패널 위에 카드 레이아웃으로 돌릴 메뉴 패널을 만든다. (사이즈 조절 및 위치조절? 방법) 2-1. 음료, 푸드, MD 패널을
		 * 각각 만들어서 각각 버튼을 넣어준다 2-2. 버튼을 넣어준 3개의 패널을 겹쳐서 메뉴 패널에 붙인다.
		 * 
		 * 3. 기본 패널 중간 부분에 주문 확인 패널을 넣는다(어떤 방식인지 아직 더 봐야함)
		 * 
		 * 4. 기본 패널 하단에 버튼을 단다.(5가지) 4-1 각 버튼을 누르면 액션리스너로 카드레이아웃에 담긴 패널을 보여준다 음료,푸드,MD
		 * <- 카드 레이아웃만 변하게 해주고 결제 및 이전으로는 <- 우측 메뉴 바 처럼 만들어도 가능하다
		 *
		 * -----------------------------------------------------------------------------
		 * -----↑완
		 * 
		 * ↓(목요일 이전까지 생각 및 구성을 해야함.) 5. 결제 페이지를 기본 패널 위의 새로운 패널로 전체 덮을것이 좋을지? 결제 페이지를 기본
		 * 패널 페이지 중앙에서 상단 부분 패널로 덮을것인지?
		 * 
		 * 6. 나머지는 이번주 안으로 더 구상 및 보완예정.
		 * 
		 * 7. 결제 페이지 구성
		 * 
		 * 8.메뉴 버튼 enum 화 (값이랑 가격 매겨줘야할듯.. )
		 */

		panel.setBackground(Color.red);// 중앙 색

		panel.setLayout(new BorderLayout());
		JPanel menu_panel = new JPanel(new CardLayout(10, 10));// 메인 패널 위에 메뉴패널?
		JPanel D_panel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel F_panel = new JPanel();// 메인 패널 위에 메뉴패널
		JPanel M_panel = new JPanel();// 메인 패널 위에 메뉴패널

		JPanel C_panel = new JPanel();// 센터 패널(공사중)

		JPanel B_panel = new JPanel();// 하단 패널 버튼

		JPanel P_panel = new JPanel(); // 결제 페이지

		// 상단부
		menu_panel.setBackground(Color.WHITE);
		panel.add(menu_panel, BorderLayout.NORTH);
		menu_panel.setPreferredSize(new Dimension(0, 580));

		menu_panel.add(D_panel, "Drink");
		menu_panel.add(F_panel, "Food");
		menu_panel.add(M_panel, "MD");
		menu_panel.add(P_panel, "Pay");

		// 중간부
		C_panel.setBackground(Color.WHITE);
		panel.add(C_panel, BorderLayout.CENTER);

		// 필드 생성

//		DefaultTableModel Dtm = new DefaultTableModel(new String[] {"번호", "메뉴", "가격", "개수"}, 0){
//			
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//			
//		};
//
		String title[] = { "번호", "메뉴", "가격", "개수" };
		String data[][] = new String[0][3];

		JTable table = new JTable(data, title);
		JScrollPane jsp = new JScrollPane(table);
		C_panel.add(jsp);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 고정
//		table.getTableHeader().setResizingAllowed(false); //사이즈 고정 
		jsp.setPreferredSize(new Dimension(870, 200));

		JSpinner spinner = new JSpinner();// 수량 화살표
		spinner.setPreferredSize(new Dimension(30,30));
		C_panel.add(spinner,BorderLayout.EAST);
		
//		JButton cancel = new JButton("취소"); // 취소버튼
//		cancel.setPreferredSize(new Dimension(50,50));
//		C_panel.add(cancel,BorderLayout.EAST);
		
		// 하단부
		B_panel.setBackground(Color.WHITE);
		panel.add(B_panel, BorderLayout.SOUTH);
		B_panel.setPreferredSize(new Dimension(0, 100));

		// panel에 작업하는게 왼쪽 영역에 표시됨.
//		BorderLayout Border = new BorderLayout();// 기본 레이아웃(임시 좌표용)

		
		
		for (int i = 0; i <= 14; i++) {

			Image C_D_Image = new ImageIcon("resources/img/drink/" + i + ".jpg").getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_D_Image = new ImageIcon(C_D_Image);

			D_panel.add(new JButton(USE_D_Image)).setPreferredSize(new Dimension(175, 175));
		}

		for (int i = 0; i <= 14; i++) {

			Image C_F_Image = new ImageIcon("resources/img/food/" + i + ".jpg").getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_F_Image = new ImageIcon(C_F_Image);

			F_panel.add(new JButton(USE_F_Image)).setPreferredSize(new Dimension(175, 175));
		}

		for (int i = 0; i <= 14; i++) {
			Image C_M_Image = new ImageIcon("resources/img/md/" + i + ".jpg").getImage().getScaledInstance(175, 175,
					Image.SCALE_REPLICATE);

			ImageIcon USE_M_Image = new ImageIcon(C_M_Image);

			M_panel.add(new JButton(USE_M_Image)).setPreferredSize(new Dimension(175, 175));
		}

		JButton btn_drink = new JButton("음료");
		btn_drink.setPreferredSize(new Dimension(90, 90));
		JButton btn_Food = new JButton("푸드");
		btn_Food.setPreferredSize(new Dimension(90, 90));
		JButton btn_M = new JButton("MD");
		btn_M.setPreferredSize(new Dimension(90, 90));
		JButton btn_first = new JButton("처음으로");
		btn_first.setPreferredSize(new Dimension(90, 90));
		JButton btn_pay = new JButton("결제");
		btn_pay.setPreferredSize(new Dimension(90, 90));

		btn_drink.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "Drink");
			}
		});

		btn_Food.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "Food");
			}
		});

		btn_M.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "MD");
			}
		});
		btn_first.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).first(menu_panel);
			}
		});
		btn_pay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardLayout) menu_panel.getLayout()).show(menu_panel, "Pay");
			}
		});

		JButton btn99 = new JButton("테스트");

		B_panel.add(btn_drink);
		B_panel.add(btn_Food);
		B_panel.add(btn_M);
		B_panel.add(btn_first);
		B_panel.add(btn_pay);

		P_panel.add(btn99);

	}

	public OrderView() {

	}

}
