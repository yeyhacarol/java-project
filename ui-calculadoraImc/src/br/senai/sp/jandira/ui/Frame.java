package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Person;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private final JLabel lblTitle = new JLabel("Calcule seu IMC");
	private JLabel lblHeight;
	private JTextField txtWeight;
	private JTextField txtHeight;
	private JButton btnCalculate;
	private JLabel txtBmi;
	private JLabel lblStatus;
	private JLabel lblBmiResult;
	private JLabel lblStatusResult;

	public Frame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Frame.class.getResource("/br/senai/sp/jandira/img/balanca.png")));
		setTitle("Calcule seu IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTitle.setBounds(70, 11, 131, 31);
		contentPane.add(lblTitle);
		
		JLabel lblWeight = new JLabel("Insira aqui seu peso:");
		lblWeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWeight.setFont(new Font("Arial", Font.PLAIN, 16));
		lblWeight.setBounds(10, 62, 152, 14);
		contentPane.add(lblWeight);
		
		lblHeight = new JLabel("Insira aqui sua altura:");
		lblHeight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeight.setFont(new Font("Arial", Font.PLAIN, 16));
		lblHeight.setBounds(10, 116, 152, 14);
		contentPane.add(lblHeight);
		
		txtWeight = new JTextField();
		txtWeight.setBounds(172, 56, 86, 30);
		contentPane.add(txtWeight);
		txtWeight.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setColumns(10);
		txtHeight.setBounds(172, 110, 86, 30);
		contentPane.add(txtHeight);
		
		Color btnColor = new Color(51, 153, 51);
		btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Person person = new Person();
				DecimalFormat decimalFormat = new DecimalFormat("0.00");
				
				double weight = Double.valueOf(txtWeight.getText());
				double height = Double.valueOf(txtHeight.getText());
				
				person.calculateBmi(weight, height);
				lblBmiResult.setText(String.valueOf(decimalFormat.format(person.getBmi())));
				
				person.setStatus();
				lblStatusResult.setText(person.getStatus());					
			}
		});
		btnCalculate.setBackground(btnColor);
		btnCalculate.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCalculate.setBounds(95, 172, 106, 40);
		contentPane.add(btnCalculate);
		
		txtBmi = new JLabel("Seu IMC:");
		txtBmi.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBmi.setFont(new Font("Arial", Font.PLAIN, 16));
		txtBmi.setBounds(20, 243, 76, 14);
		contentPane.add(txtBmi);
		
		lblStatus = new JLabel("Seu estado:");
		lblStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 16));
		lblStatus.setBounds(10, 291, 86, 14);
		contentPane.add(lblStatus);
		
		lblBmiResult = new JLabel("");
		lblBmiResult.setFont(new Font("Arial", Font.PLAIN, 16));
		lblBmiResult.setBounds(107, 235, 151, 30);
		contentPane.add(lblBmiResult);
		
		lblStatusResult = new JLabel("");
		lblStatusResult.setFont(new Font("Arial", Font.PLAIN, 16));
		lblStatusResult.setBounds(107, 284, 151, 30);
		contentPane.add(lblStatusResult);
	}
}