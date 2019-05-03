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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegistrationGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField jtfUsername;
	private JTextField jtfPassword;
	private JButton btnRegister;

	/**
	 * Create the frame.
	 */
	public RegistrationGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIControler.stopRegOrLog();
			}
		});
		setTitle("Registration");
		setMinimumSize(new Dimension(300, 145));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(getPanel(),
				GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(getPanel(),
				GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(getBtnRegister(), GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
									.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
													.addComponent(getLblPassword(), GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(getLblUsername(), GroupLayout.DEFAULT_SIZE, 74,
															Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
													.addComponent(getJtfPassword(), GroupLayout.DEFAULT_SIZE, 326,
															Short.MAX_VALUE)
													.addComponent(getJtfUsername(), GroupLayout.DEFAULT_SIZE, 326,
															Short.MAX_VALUE))))
							.addContainerGap()));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup().addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblUsername())
									.addComponent(getJtfUsername(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(getLblPassword())
									.addComponent(getJtfPassword(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnRegister())
							.addContainerGap(26, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);
		}
		return panel;
	}

	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
		}
		return lblUsername;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
		}
		return lblPassword;
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

	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("Create account");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIControler.register(jtfUsername, jtfPassword, ClientGUI.registerWindow, ClientGUI.jtfFirstNumber,
							ClientGUI.jtfSecondNumber, ClientGUI.btnCalculate, ClientGUI.itemLogin);
				}
			});
		}
		return btnRegister;
	}
}
