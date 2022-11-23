package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dol.MathOperator;
import misc.DivisorValidator;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MathOperationsWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNumber1;
	private JTextField textFieldNumber2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MathOperationsWindow dialog = new MathOperationsWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MathOperationsWindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblAnswer = new JLabel("");
		lblAnswer.setForeground(Color.BLACK);
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setBounds(114, 160, 104, 28);
		contentPanel.add(lblAnswer);
		
		JButton btnNewButton_2 = new JButton("Limpiar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNumber1.setText(null);
				textFieldNumber2.setText(null);
				lblAnswer.setText(null);
				
				
			}
		});
		
	
		btnNewButton_2.setBounds(25, 227, 89, 23);
		contentPanel.add(btnNewButton_2);
		{
			
			JRadioButton rdbtnSum = new JRadioButton("Suma");
			rdbtnSum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UIUtil.opcion = 0;
				}
			});
			buttonGroup.add(rdbtnSum);
			rdbtnSum.setBounds(282, 79, 109, 23);
			contentPanel.add(rdbtnSum);
			
			JRadioButton rdbtnDifference = new JRadioButton("Resta");
			rdbtnDifference.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					UIUtil.opcion = 1;
				}
			});
			buttonGroup.add(rdbtnDifference);
			rdbtnDifference.setBounds(282, 105, 109, 23);
			contentPanel.add(rdbtnDifference);
			
			JRadioButton rdbtnMultiplication = new JRadioButton("Multiplicación");
			rdbtnMultiplication.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UIUtil.opcion = 2;
					
				}
			});
			buttonGroup.add(rdbtnMultiplication);
			rdbtnMultiplication.setBounds(282, 131, 109, 23);
			contentPanel.add(rdbtnMultiplication);
			
			JRadioButton rdbtnDIvision = new JRadioButton("División");
			rdbtnDIvision.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					UIUtil.opcion = 3;
				}
			});
			buttonGroup.add(rdbtnDIvision);
			rdbtnDIvision.setBounds(282, 157, 109, 23);
			contentPanel.add(rdbtnDIvision);
			

			
			
			JButton btnNewButton = new JButton("Calcular");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MathOperator operator;
					String result;
					double x, y;
					
					x = Integer.parseInt(textFieldNumber1.getText());
					y = Integer.parseInt(textFieldNumber2.getText());
					
					operator = new MathOperator(x,y);
					
					switch(UIUtil.opcion) {
					
					case 0:
						result = String.valueOf(operator.sum());
						
 						lblAnswer.setText(result);
						
						break;
					case 1:
						result = String.valueOf(operator.substraction());
						lblAnswer.setText(result);
						
						break;
					case 2:
						result = String.valueOf(operator.multiplication());
						lblAnswer.setText(result);
						
						break;
					case 3:
						
						if(DivisorValidator.divisorValidator(y)) {
							result = String.valueOf(operator.division());
							lblAnswer.setText(result);
							
							
						}else {
							lblAnswer.setText("Ingrese un divisor válido.");
						}
						
						
						
						break;
					
					}
					
				
					
					
					
					
				}
			});
			
			btnNewButton.setBounds(238, 227, 89, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Volver");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					MainWindow previousWindow = new MainWindow();
					previousWindow.setVisible(true);
					dispose();
					
				}
				
				
			});
			btnNewButton_1.setBounds(337, 227, 89, 23);
			contentPanel.add(btnNewButton_1);
		}
		
		textFieldNumber1 = new JTextField();
		textFieldNumber1.setBounds(132, 80, 86, 20);
		contentPanel.add(textFieldNumber1);
		textFieldNumber1.setColumns(10);
		
		textFieldNumber2 = new JTextField();
		textFieldNumber2.setBounds(132, 119, 86, 20);
		contentPanel.add(textFieldNumber2);
		textFieldNumber2.setColumns(10);
		
		JLabel lblTitle = new JLabel("Operaciones matematicas");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(156, 11, 149, 23);
		contentPanel.add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("Primer numero:");
		lblNewLabel.setBounds(25, 83, 97, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Segundo numero:");
		lblNewLabel_1.setBounds(25, 122, 97, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblResult = new JLabel("Resultado:");
		lblResult.setBounds(25, 167, 79, 14);
		contentPanel.add(lblResult);
		
		
	}

	
}
