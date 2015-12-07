package presentation.courierui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import presentation.courierui.ordercreateui.OrderCreateDialog;
import presentation.courierui.ordersignui.OrderSignDialog;



/**
 * 这是快递员登录成功后的界面
 * @author lc
 * @version 1.4
 *
 */
public class OrderUI extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4720179693668770018L;
	
	private JButton orderCreateButton;
	private JButton orderSignButton;
	
	public OrderUI() {

		this.setSize(800, 540);
		this.setLayout(null);
		orderCreateButton = new JButton("创建订单");
		orderSignButton = new JButton("订单签收");
		orderCreateButton.setBounds(30, 380, 150, 40);
		orderSignButton.setBounds(30, 450, 150, 40);
		this.add(orderCreateButton);
		this.add(orderSignButton);
		this.setVisible(true);

		orderCreateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderCreateDialog();
			}
		});
		;

		orderSignButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderSignDialog();
			}
		});
	}

}
