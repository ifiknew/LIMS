package presentation.financeui.paymentui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;



import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import businesslogic.paymentbl.Payment;
import businesslogicservice.PaymentblService;
import systemenum.Entry;
import vo.PaymentVO;


public class PaymentDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -165240080512733546L;

	private JTextField paymentIdField;
 	private JComboBox yearBox;
 	private JComboBox monthBox;
 	private JComboBox dayBox;
 	private JTextField moneyField;
 	private JTextField nameField;
 	private JTextField payeeAccountField;
 	private JComboBox payerAccountBox;
 	private JComboBox entryBox;
 	private JTextArea remarksArea;
 	
	public PaymentDialog(){
		int dialogx=380;
		int dialogy=500;
		this.setSize(dialogx+10, dialogy+30);
		this.setLocationRelativeTo(null);
  
		JLabel paymentLabel=new JLabel("���");
		paymentLabel.setSize(61,24);
		paymentLabel.setLocation(dialogx/2-20, dialogy/30);
		paymentLabel.setVisible(true);
		
		int labelWidth=80;
		int labelHeight=25;
		int labelx=20;
		int labely=60;
		int interval=15;
		JLabel paymentIdLabel=new JLabel("������");
		paymentIdLabel.setSize(labelWidth,labelHeight);
		paymentIdLabel.setLocation(labelx, labely);
		JLabel dateLabel=new JLabel("��������");
		dateLabel.setSize(labelWidth,labelHeight);
		dateLabel.setLocation(labelx, labely+(interval+labelHeight)*1);
		JLabel moneyLabel=new JLabel("������");
		moneyLabel.setSize(labelWidth,labelHeight);
		moneyLabel.setLocation(labelx, labely+(interval+labelHeight)*2);
		JLabel nameLabel=new JLabel("�տ�������");
		nameLabel.setSize(labelWidth,labelHeight);
		nameLabel.setLocation(labelx, labely+(interval+labelHeight)*3);
		JLabel payeeAccountLabel=new JLabel("�տ�˻�");
		payeeAccountLabel.setSize(labelWidth,labelHeight);
		payeeAccountLabel.setLocation(labelx, labely+(interval+labelHeight)*4);
		JLabel payerAccountLabel=new JLabel("����˻�");
		payerAccountLabel.setSize(labelWidth,labelHeight);
		payerAccountLabel.setLocation(labelx, labely+(interval+labelHeight)*5);
		JLabel entryLabel=new JLabel("��Ŀ");
		entryLabel.setSize(labelWidth,labelHeight);
		entryLabel.setLocation(labelx, labely+(interval+labelHeight)*6);
		JLabel remarksLabel=new JLabel("��ע");
		remarksLabel.setSize(labelWidth,labelHeight);
		remarksLabel.setLocation(labelx, labely+(interval+labelHeight)*7);
		
		int longWidth=180;
		int shortWidth=60;
		int textFieldHeight=25;
		int textFieldx=105;
		int textFieldy=60;
		int interval2=15;
		paymentIdField=new JTextField();
		paymentIdField.setSize(longWidth,textFieldHeight);
		paymentIdField.setLocation(textFieldx, textFieldy);
		paymentIdField.setEditable(false);
		paymentIdField.setText("1010100000000000000");
		String[] year=new String[]{"2015","2016"};
		JLabel yearLabel =new JLabel("��");
		yearLabel.setBounds(textFieldx+shortWidth+5,textFieldy+(interval2+textFieldHeight)*1,20,20);		
		JLabel monthLabel =new JLabel("��");
		monthLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*1,textFieldy+(interval2+textFieldHeight)*1,20,20);	
		JLabel dayLabel =new JLabel("��");
		dayLabel.setBounds(textFieldx+shortWidth+(20+shortWidth)*2,textFieldy+(interval2+textFieldHeight)*1,20,20);	
		yearBox=new JComboBox(year);
		yearBox.setSize(shortWidth+5, textFieldHeight);
		yearBox.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*1);
		String[] month=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
		monthBox=new JComboBox(month);
		monthBox.setSize(shortWidth, textFieldHeight);
		monthBox.setLocation(textFieldx+shortWidth+20, textFieldy+(interval2+textFieldHeight)*1);
		String[] day=new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		dayBox=new JComboBox(day);
		dayBox.setSize(shortWidth, textFieldHeight);
		dayBox.setLocation(textFieldx+(shortWidth+20)*2, textFieldy+(interval2+textFieldHeight)*1);
		moneyField=new JTextField();
		moneyField.setSize(shortWidth,textFieldHeight);
		moneyField.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*2);
		nameField=new JTextField();
		nameField.setSize(shortWidth,textFieldHeight);
		nameField.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*3);
		payeeAccountField=new JTextField();
		payeeAccountField.setSize(longWidth,textFieldHeight);
		payeeAccountField.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*4);
		String[] payerAccount=new String[]{"6222110000000000000","6222110000000000001"};
		payerAccountBox=new JComboBox(payerAccount);
		payerAccountBox.setSize(longWidth, textFieldHeight);
		payerAccountBox.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*5);
		String[] entry=new String[]{"���","�˷�","��Ա����","����"};
		entryBox=new JComboBox(entry);
		entryBox.setSize(shortWidth+40, textFieldHeight);
		entryBox.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*6);
		remarksArea=new JTextArea();
		remarksArea.setSize(longWidth,85);
		remarksArea.setLocation(textFieldx, textFieldy+(interval2+textFieldHeight)*7);
		
		JButton confirmButton=new JButton("ȷ��");
		confirmButton.setBounds(280,450, 70, 30);
		confirmButton.addActionListener(new ConfirmButtonListener());
		JButton cancelButton=new JButton("ȡ��");
		cancelButton.setBounds(190,450, 70, 30);
		cancelButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				PaymentDialog.this.dispose();
			}
		});
		
		this.setLayout(null);
		this.add(paymentLabel);
		this.add(paymentIdLabel);
		this.add(dateLabel);
		this.add(moneyLabel);
		this.add(nameLabel);
		this.add(payeeAccountLabel);
		this.add(payerAccountLabel);
		this.add(entryLabel);
		this.add(remarksLabel);
		
		this.add(paymentIdField);
		this.add(yearLabel);
		this.add(monthLabel);
		this.add(dayLabel);
		this.add(yearBox);
		this.add(monthBox);
		this.add(dayBox);
		this.add(moneyField);
		this.add(nameField);
		this.add(payeeAccountField);
		this.add(payerAccountBox);
		this.add(entryBox);
		this.add(remarksArea);
		
		this.add(confirmButton);
		this.add(cancelButton);
	
		
        this.setVisible(true);
	}
	
	class ConfirmButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {			
			double money = Double.parseDouble(moneyField.getText());
			new java.text.DecimalFormat("#.00").format(money);
			PaymentVO vo = new PaymentVO( paymentIdField.getText(),new Date(Integer.parseInt(yearBox.getSelectedItem().toString())-1900,Integer.parseInt(monthBox.getSelectedItem().toString())-1,Integer.parseInt(dayBox.getSelectedItem().toString())), money ,nameField.getText() , payeeAccountField.getText(), payerAccountBox.getSelectedItem().toString() , 	Entry.values()[entryBox.getSelectedIndex()] , remarksArea.getText());
			PaymentblService pbl = new Payment();
			pbl.createPaymentPO(vo);
			PaymentDialog.this.dispose();
		}		
	}
}