import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MortgageCalculator implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private String year;
	private JLabel housepay1 = new JLabel("");
	private JLabel housepay2 = new JLabel("");
	private JLabel max = new JLabel("");
	private JLabel mort = new JLabel("");
	private JComboBox comboBox1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MortgageCalculator window = new MortgageCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MortgageCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTotalGrossIncome = new JLabel("Total Gross Income");
		lblTotalGrossIncome.setBounds(10, 11, 150, 14);
		frame.getContentPane().add(lblTotalGrossIncome);
		
		textField = new JTextField();
		textField.setBounds(240, 8, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalMonthlyDebt = new JLabel("Total Monthly Debt");
		lblTotalMonthlyDebt.setBounds(10, 36, 150, 14);
		frame.getContentPane().add(lblTotalMonthlyDebt);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 33, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMortgageInterestRate = new JLabel("Mortgage Interest Rate");
		lblMortgageInterestRate.setBounds(10, 61, 178, 14);
		frame.getContentPane().add(lblMortgageInterestRate);
		
		textField_2 = new JTextField();
		textField_2.setBounds(240, 58, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("%");
		label.setBounds(330, 61, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblTerm = new JLabel("Term");
		lblTerm.setBounds(10, 86, 122, 14);
		frame.getContentPane().add(lblTerm);
		
		String[] years = {"10", "15", "30"};
		comboBox1 = new JComboBox(years);
		comboBox1.setBounds(240, 83, 86, 20);
		frame.getContentPane().add(comboBox1);
		
		JLabel lblDownPayment = new JLabel("Down Payment");
		lblDownPayment.setBounds(10, 111, 134, 14);
		frame.getContentPane().add(lblDownPayment);
		
		textField_3 = new JTextField();
		textField_3.setBounds(240, 108, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblHousingPayment = new JLabel("Housing Payment (18%):");
		lblHousingPayment.setBounds(10, 136, 178, 14);
		frame.getContentPane().add(lblHousingPayment);
		
		
		housepay1.setBounds(278, 136, 122, 14);
		frame.getContentPane().add(housepay1);
		
		JLabel lblHousingPayment_1 = new JLabel("Housing Payment + other obligations (36%):");
		lblHousingPayment_1.setBounds(10, 161, 268, 14);
		frame.getContentPane().add(lblHousingPayment_1);
		
		
		housepay2.setBounds(278, 161, 122, 14);
		frame.getContentPane().add(housepay2);
		
		JLabel lblMaxPaymentAllowed = new JLabel("Max Payment Allowed:");
		lblMaxPaymentAllowed.setBounds(10, 186, 208, 14);
		frame.getContentPane().add(lblMaxPaymentAllowed);
		
		
		max.setBounds(278, 186, 122, 14);
		frame.getContentPane().add(max);
		
		JLabel lblMortgage = new JLabel("Mortgage:");
		lblMortgage.setBounds(10, 211, 122, 14);
		frame.getContentPane().add(lblMortgage);
		
		
		mort.setBounds(278, 211, 122, 14);
		frame.getContentPane().add(mort);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(189, 238, 89, 23);
		frame.getContentPane().add(btnCalculate);
		btnCalculate.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		MortgageCalc m = new MortgageCalc();
		year = comboBox1.getSelectedItem().toString();
		double income = Double.parseDouble(textField.getText()), debt = Double.parseDouble(textField_1.getText()), IR = (Double.parseDouble(textField_2.getText()) / 1200);
		double maxpay = 0.0; 
		double month = (Integer.parseInt(year)) * 12;
		
		housepay1.setText("$" + m.HousePay1(income));
		housepay2.setText("$" + m.HousePay2(income, debt));
		maxpay = m.Max(m.HousePay1(income), m.HousePay2(income, debt));
		double mortgage = m.Mortgage(maxpay, IR, month);
		max.setText("$" + maxpay);
		mort.setText("$" + mortgage);
		
	}
}
