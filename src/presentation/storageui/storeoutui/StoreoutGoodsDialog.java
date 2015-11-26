package presentation.storageui.storeoutui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StoreoutGoodsDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7103785931098225175L;
	
	private JLabel goodsIdLabel;
	private JTextField goodsIdTextField;
	
	private JButton confirmButton;
	private JButton cancleButton;
	
	private DefaultTableModel tableModel;

	public StoreoutGoodsDialog(DefaultTableModel tableModel){
		this.tableModel = tableModel;
		init();
		buttonFunction();
	}
	
	public void init(){
		this.setTitle("�������");	
		this.setSize(380, 160);
		this.setLayout(null);
		
		goodsIdLabel = new JLabel("������");
		goodsIdLabel.setBounds(10, 40, 60, 22);
		goodsIdTextField = new JTextField();
		goodsIdTextField.setBounds(80, 40, 180, 22);
		confirmButton = new JButton("ȷ��");
		confirmButton.setBounds(290, 80, 70, 30);
		cancleButton = new JButton("ȡ��");
		cancleButton.setBounds(200, 80, 70, 30);
		
		this.add(goodsIdLabel);
		this.add(goodsIdTextField);
		this.add(confirmButton);
		this.add(cancleButton);
		
		this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);	
		
	}
	
	public void buttonFunction(){
		
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] data = {goodsIdTextField.getText()};
				tableModel.addRow(data);
				
			}
		});
		
		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}