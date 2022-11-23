package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dol.CircleAreaMeasurer;
import misc.RadiumValidator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CircleAreaWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CircleAreaWindow dialog = new CircleAreaWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CircleAreaWindow() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(168, 95, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		
		JLabel lblInput = new JLabel("Ingrese el radio:");
		lblInput.setBounds(32, 98, 104, 14);
		contentPanel.add(lblInput);
		
		JLabel lblTitle = new JLabel("Calculadora del area de un circulo");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(133, 11, 176, 45);
		contentPanel.add(lblTitle);
		
		JLabel lblResult = new JLabel("Resultado:");
		lblResult.setBounds(85, 168, 77, 14);
		contentPanel.add(lblResult);
		
		JLabel lblAnswer = new JLabel("");
		lblAnswer.setBounds(176, 159, 133, 35);
		contentPanel.add(lblAnswer);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double x, area;
				x = Double.parseDouble(textField.getText());
				
				CircleAreaMeasurer operator = new CircleAreaMeasurer(x);
				
				area = operator.calculateRadium();
				
				if(RadiumValidator.radiumValidator(x)) {
					
					lblAnswer.setText(String.valueOf(area));
				}else {
					lblAnswer.setText("Radio inválido");
					
				}
				
				
				
				
				
			}
		});
		btnNewButton.setBounds(335, 94, 89, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpiar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        textField.setText(null);
			    lblAnswer.setText(null);	
			}
		});
		btnNewButton_1.setBounds(335, 131, 89, 23);
		contentPanel.add(btnNewButton_1);
		{
			JPanel buttonPane = new JPanel(); 
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MainWindow previousWindow = new MainWindow();
						previousWindow.setVisible(true);
						dispose();
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						dispose();
						
					}
					
					
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
