package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JTextField jtfUsername;
	private JTextField jtfPassword;
	private JButton btnLogin;

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setMaximumSize(new Dimension(2147483647, 145));
		setPreferredSize(new Dimension(300, 145));
		setMinimumSize(new Dimension(300, 145));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 145);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(300, 145));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(getPanel(),
				GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(getPanel(),
				GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(getBtnLogin(), GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
							.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
											.addComponent(getLabel_1(), GroupLayout.DEFAULT_SIZE,
													GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(getLabel(), GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(getJtfPassword(), GroupLayout.DEFAULT_SIZE, 330,
													Short.MAX_VALUE)
											.addComponent(getJtfUsername(), GroupLayout.DEFAULT_SIZE, 330,
													Short.MAX_VALUE))))
					.addContainerGap()));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
					.createSequentialGroup().addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLabel()).addComponent(
							getJtfUsername(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLabel_1()).addComponent(
							getJtfPassword(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnLogin())
					.addContainerGap(162, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Username:");
		}
		return label;
	}

	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Password:");
		}
		return label_1;
	}

	private JTextField getJtfUsername() {
		if (jtfUsername == null) {
			jtfUsername = new JTextField();
			jtfUsername.setColumns(10);
		}
		return jtfUsername;
	}

	private JTextField getJtfPassword() {
		if (jtfPassword == null) {
			jtfPassword = new JTextField();
			jtfPassword.setColumns(10);
		}
		return jtfPassword;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.login(jtfUsername, jtfPassword, ClientGUI.loginWindow, ClientGUI.jtfFirstNumber,
							ClientGUI.jtfSecondNumber, ClientGUI.btnCalculate, ClientGUI.itemLogin, ClientGUI.itemRegister, ClientGUI.itemGuest);
				}
			});
		}
		return btnLogin;
	}
}
