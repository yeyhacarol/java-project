package br.senai.sp.jandira.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Viagem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTotalKm;
	private JTextField txtAutonomiaCarro;
	private JTextField txtPrecoCombustivel;

	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTotalKm = new JLabel("Qual a quilometragem total da viagem?");
		lblTotalKm.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTotalKm.setBounds(10, 11, 278, 30);
		contentPane.add(lblTotalKm);

		txtTotalKm = new JTextField();
		txtTotalKm.setToolTipText("");
		txtTotalKm.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalKm.setFont(new Font("Arial", Font.PLAIN, 16));
		txtTotalKm.setBounds(10, 48, 105, 30);
		contentPane.add(txtTotalKm);
		txtTotalKm.setColumns(10);

		JLabel lblAutonomiaCarro = new JLabel("Quantos km/l o carro percorre?");
		lblAutonomiaCarro.setFont(new Font("Arial", Font.PLAIN, 16));
		lblAutonomiaCarro.setBounds(10, 85, 278, 30);
		contentPane.add(lblAutonomiaCarro);

		txtAutonomiaCarro = new JTextField();
		txtAutonomiaCarro.setToolTipText("");
		txtAutonomiaCarro.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAutonomiaCarro.setFont(new Font("Arial", Font.PLAIN, 16));
		txtAutonomiaCarro.setColumns(10);
		txtAutonomiaCarro.setBounds(10, 122, 105, 30);
		contentPane.add(txtAutonomiaCarro);

		JLabel lblPrecoCombustivel = new JLabel("Qual o pre\u00E7o da gasolina?");
		lblPrecoCombustivel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPrecoCombustivel.setBounds(10, 159, 278, 30);
		contentPane.add(lblPrecoCombustivel);

		txtPrecoCombustivel = new JTextField();
		txtPrecoCombustivel.setToolTipText("");
		txtPrecoCombustivel.setHorizontalAlignment(SwingConstants.RIGHT);
		txtPrecoCombustivel.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPrecoCombustivel.setColumns(10);
		txtPrecoCombustivel.setBounds(10, 196, 105, 30);
		contentPane.add(txtPrecoCombustivel);

		JLabel lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 16));
		lblResultado.setBounds(153, 289, 135, 30);
		contentPane.add(lblResultado);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Viagem custoViagem = new Viagem();
				DecimalFormat decimalFormat = new DecimalFormat("00.00");

				custoViagem.setQuilometragemTotal(txtTotalKm.getText());
				custoViagem.setAutonomiaCarro(txtAutonomiaCarro.getText());
				custoViagem.setPrecoCombustivel(txtPrecoCombustivel.getText());

				custoViagem.calcularCusto();

				lblResultado.setText(String.valueOf(decimalFormat.format(custoViagem.getCusto())));
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 16));
		btnCalcular.setBounds(30, 248, 105, 30);
		contentPane.add(btnCalcular);

		JLabel lblCustoViagem = new JLabel("A viagem custou R$");
		lblCustoViagem.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCustoViagem.setBounds(10, 289, 139, 30);
		contentPane.add(lblCustoViagem);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTotalKm.setText("");
				txtAutonomiaCarro.setText("");
				txtPrecoCombustivel.setText("");
				
				lblResultado.setText("");
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 16));
		btnLimpar.setBounds(163, 248, 105, 30);
		contentPane.add(btnLimpar);
	}
}