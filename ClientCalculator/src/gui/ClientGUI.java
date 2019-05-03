package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel panel;
	private JLabel lblFirstNumber;
	private JLabel lblSecondNumber;
	private JLabel lblResult;
	static JPanel colorPanel;
	static JTextField jtfFirstNumber;
	static JTextField jtfSecondNumber;
	private JTextField jtfResult;
	static JButton btnCalculate;
	private JMenu mnFile;
	static JMenuItem itemConnect;
	static JMenuItem itemDisconnect;
	private JSeparator separator;
	private JPanel operationPanel;
	private JRadioButton rdbtnAddition;
	private JRadioButton rdbtnSubtraction;
	private JRadioButton rdbtnMultiplication;
	private JRadioButton rdbtnDivision;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public static RegistrationGUI registerWindow = null;
	public static LoginGUI loginWindow = null;

	static JMenuItem itemLogin;
	static JMenuItem itemRegister;
	static JMenuItem itemGuest;
	private JSeparator separator_1;
	private JMenuItem mntmHistory;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ClientGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIControler.exitApp(contentPane, jtfFirstNumber, jtfSecondNumber, jtfResult, colorPanel, itemConnect,
						itemDisconnect);
			}
		});
		setPreferredSize(new Dimension(300, 180));
		setMinimumSize(new Dimension(400, 190));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 190);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.CENTER);
		contentPane.add(getColorPanel(), BorderLayout.EAST);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
		}
		return menuBar;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addComponent(getBtnCalculate(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 366,
									Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
									.createParallelGroup(Alignment.LEADING, false)
									.addComponent(getLblSecondNumber(), GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addComponent(getLblFirstNumber(), GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getLblResult(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
											Short.MAX_VALUE))
									.addGap(14)
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
											.addComponent(getJtfFirstNumber(), GroupLayout.DEFAULT_SIZE, 262,
													Short.MAX_VALUE)
											.addComponent(getJtfResult(), GroupLayout.DEFAULT_SIZE, 262,
													Short.MAX_VALUE)
											.addComponent(getJtfSecondNumber(), Alignment.LEADING,
													GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED).addComponent(getOperationPanel(),
							GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap()));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblFirstNumber())
									.addComponent(getJtfFirstNumber(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(getJtfSecondNumber(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(getLblSecondNumber()))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(getLblResult())
									.addComponent(getJtfResult(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnCalculate())
							.addContainerGap())
					.addComponent(getOperationPanel(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE));
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	private JLabel getLblFirstNumber() {
		if (lblFirstNumber == null) {
			lblFirstNumber = new JLabel("First number:");
		}
		return lblFirstNumber;
	}

	private JLabel getLblSecondNumber() {
		if (lblSecondNumber == null) {
			lblSecondNumber = new JLabel("Second number:");
		}
		return lblSecondNumber;
	}

	private JLabel getLblResult() {
		if (lblResult == null) {
			lblResult = new JLabel("Result:");
		}
		return lblResult;
	}

	private JPanel getColorPanel() {
		if (colorPanel == null) {
			colorPanel = new JPanel();
			colorPanel.setBackground(Color.RED);
		}
		return colorPanel;
	}

	private JTextField getJtfFirstNumber() {
		if (jtfFirstNumber == null) {
			jtfFirstNumber = new JTextField();
			jtfFirstNumber.setEnabled(false);
			jtfFirstNumber.setColumns(10);
		}
		return jtfFirstNumber;
	}

	private JTextField getJtfSecondNumber() {
		if (jtfSecondNumber == null) {
			jtfSecondNumber = new JTextField();
			jtfSecondNumber.setEnabled(false);
			jtfSecondNumber.setColumns(10);
		}
		return jtfSecondNumber;
	}

	private JTextField getJtfResult() {
		if (jtfResult == null) {
			jtfResult = new JTextField();
			jtfResult.setEditable(false);
			jtfResult.setColumns(10);
		}
		return jtfResult;
	}

	private JButton getBtnCalculate() {
		if (btnCalculate == null) {
			btnCalculate = new JButton("Calculate");
			btnCalculate.setEnabled(false);
			btnCalculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.calculate(jtfFirstNumber, jtfSecondNumber, jtfResult, colorPanel, itemConnect,
							itemDisconnect, selectedOperation(), contentPane);
				}
			});
		}
		return btnCalculate;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getItemConnect());
			mnFile.add(getSeparator());
			mnFile.add(getItemLogin());
			mnFile.add(getItemRegister());
			mnFile.add(getItemGuest());
			mnFile.add(getSeparator_2());
			mnFile.add(getMntmHistory());
			mnFile.add(getSeparator_1());
			mnFile.add(getItemDisconnect());
		}
		return mnFile;
	}

	private JMenuItem getItemConnect() {
		if (itemConnect == null) {
			itemConnect = new JMenuItem("Connect ");
			itemConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.connectOnTheServer(contentPane, colorPanel, itemConnect, itemDisconnect);
				}
			});
		}
		return itemConnect;
	}

	private JMenuItem getItemDisconnect() {
		if (itemDisconnect == null) {
			itemDisconnect = new JMenuItem("Disconnect");
			itemDisconnect.setEnabled(false);
			itemDisconnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.disconnectFromServer(jtfFirstNumber, jtfSecondNumber, jtfResult, colorPanel,
							itemConnect, itemDisconnect, btnCalculate, itemLogin, itemRegister, itemGuest);
				}
			});
		}
		return itemDisconnect;
	}

	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	private JPanel getOperationPanel() {
		if (operationPanel == null) {
			operationPanel = new JPanel();
			GroupLayout gl_operationPanel = new GroupLayout(operationPanel);
			gl_operationPanel.setHorizontalGroup(gl_operationPanel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_operationPanel.createSequentialGroup().addContainerGap()
							.addGroup(gl_operationPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(getRadioButton_3(), GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addComponent(getRadioButton_2(), GroupLayout.DEFAULT_SIZE,
											GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(getRdbtnSubtraction(), GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
									.addComponent(getRdbtnAddition(), GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
							.addContainerGap()));
			gl_operationPanel.setVerticalGroup(gl_operationPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_operationPanel.createSequentialGroup().addGap(10).addComponent(getRdbtnAddition())
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getRdbtnSubtraction())
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getRadioButton_2())
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getRadioButton_3())
							.addContainerGap(21, Short.MAX_VALUE)));
			operationPanel.setLayout(gl_operationPanel);
		}
		return operationPanel;
	}

	private JRadioButton getRdbtnAddition() {
		if (rdbtnAddition == null) {
			rdbtnAddition = new JRadioButton("Addition");
			rdbtnAddition.setSelected(true);
			buttonGroup.add(rdbtnAddition);
		}
		return rdbtnAddition;
	}

	private JRadioButton getRdbtnSubtraction() {
		if (rdbtnSubtraction == null) {
			rdbtnSubtraction = new JRadioButton("Subtraction");
			buttonGroup.add(rdbtnSubtraction);
		}
		return rdbtnSubtraction;
	}

	private JRadioButton getRadioButton_2() {
		if (rdbtnMultiplication == null) {
			rdbtnMultiplication = new JRadioButton("Multiplication");
			buttonGroup.add(rdbtnMultiplication);
		}
		return rdbtnMultiplication;
	}

	private JRadioButton getRadioButton_3() {
		if (rdbtnDivision == null) {
			rdbtnDivision = new JRadioButton("Division");
			buttonGroup.add(rdbtnDivision);
		}
		return rdbtnDivision;
	}

	private String selectedOperation() {
		if (rdbtnAddition.isSelected())
			return "+";
		else if (rdbtnSubtraction.isSelected())
			return "-";
		else if (rdbtnMultiplication.isSelected())
			return "*";
		else
			return "/";
	}

	private JMenuItem getItemLogin() {
		if (itemLogin == null) {
			itemLogin = new JMenuItem("Login");
			itemLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.loginStart();
					loginWindow = new LoginGUI();
					loginWindow.setVisible(true);
					loginWindow.setLocationRelativeTo(null);
				}
			});
		}
		return itemLogin;
	}

	private JMenuItem getItemRegister() {
		if (itemRegister == null) {
			itemRegister = new JMenuItem("Register");
			itemRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.registerStart();
					registerWindow = new RegistrationGUI();
					registerWindow.setVisible(true);
					registerWindow.setLocationRelativeTo(null);
				}
			});
		}
		return itemRegister;
	}

	private JMenuItem getItemGuest() {
		if (itemGuest == null) {
			itemGuest = new JMenuItem("Guest");
			itemGuest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.guest();

					jtfFirstNumber.setEnabled(true);
					jtfSecondNumber.setEnabled(true);
					btnCalculate.setEnabled(true);
				}
			});
		}
		return itemGuest;
	}

	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
		}
		return separator_1;
	}
	private JMenuItem getMntmHistory() {
		if (mntmHistory == null) {
			mntmHistory = new JMenuItem("History");
			mntmHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.history();
				}
			});
		}
		return mntmHistory;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
		}
		return separator_2;
	}
}
