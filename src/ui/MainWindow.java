package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
			UIUtil.listIndex = list.getSelectedIndex();
				
				
			}
		});
		list.setToolTipText("\r\n\r\n");
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setVisibleRowCount(2);
		
		
		
		
		list.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		list.setForeground(Color.RED);
		list.setBackground(UIManager.getColor("CheckBox.darkShadow"));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"1. Calcular Area", "2. Operaciones matematicas"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(123, 113, 156, 59);
		contentPane.add(list);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Programa multifuncional");
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(123, 11, 202, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione su función\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(146, 82, 127, 19);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Entrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch(UIUtil.listIndex) {
				
				case 0:
					CircleAreaWindow subWindow = new CircleAreaWindow();
					subWindow.setVisible(true);
					dispose();
					
					break;
				case 1:
					MathOperationsWindow subWindow1 = new MathOperationsWindow();
					subWindow1.setVisible(true);
					dispose();
					
					break;
				
				default:
					
					System.out.print("\nOpción inválida.");
					break;
					
				}
				
			}
		});
		btnNewButton_1.setBounds(172, 199, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
