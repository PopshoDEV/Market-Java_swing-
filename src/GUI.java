import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

public class GUI{
	// constants
	int SCREEN_WIDTH = 1000;
	int SCREEN_HEIGHT = 600;
	int COLOR_GREENISH = 0x1BA466;
	int COLOR_SKY_BLUE = 0x195ABE;
	int FONT_HEADER1_SIZE = 30;
	int FONT_HEADER2_SIZE = 20;
	int FONT_DEFAULT_SIZE = 15;
	int POSITION_X_LOGIN = (SCREEN_WIDTH/2)-185;
	int POSITION_Y_LOGIN = (SCREEN_HEIGHT/2)-150;
	int POSITION_X_USER = 200;
	int POSITION_Y_USER = 100;
	int POSITION_X_CONTENT = 200;
	int POSITION_Y_CONTENT = 200;
	int arraySize = 100;
	int length;
	
	String FRAME_TITLE = "Sistema de manejo de supermercado V0.1";
	String ROOT_PASSWORD = "root001";
	String FONT_DEFAULT = "pala-proxima-nova-pal_guero";

	// objectos
	Users users;
	Items items;
	Orders orders;

	// Fecha
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");

	// frame
	JFrame frame;

	// panel
	JPanel userLoginPanel;
	JPanel userSignupPanel;
	JPanel userPanel;
	JPanel userProfilePanel;
	JPanel userOrdersPanel;

	JPanel adminLoginPanel;
	JPanel adminPanel;
	JPanel adminControlPanel;
	JPanel adminViewOrdersPanel;	

	// Titulos
	JLabel labelLogin;
	JLabel labelUsername;
	JLabel labelPassword;
	JLabel labelProfileHeader;
	JLabel labelUserMarketHeader;
	JLabel labelUserOrdersHeader;
	JLabel labelProfileUsername;
	JLabel labelProfileMobileNo;
	JLabel labelProfilePassword;
	JLabel labelUserSignup;
	JLabel labelSignupUsername;
	JLabel labelSignupMobileNumber;
	JLabel labelSignupPassword;
	JLabel labelUserMarketItemIDHeader;
	JLabel labelUserMarketItemNameHeader;
	JLabel labelUserMarketPricePerQuantityHeader;
	JLabel[] labelUserMarketItemID;
	JLabel[] labelUserMarketItemName;
	JLabel[] labelUserMarketPricePerQuantity;
	JLabel[] labelUserMarketPrice;
	JLabel labelUserMarketQuantityHeader;
	JLabel labelUserMarketPriceHeader;
	JLabel labelUserMarketTotalPriceHeader;
	JLabel labelUserMarketTotalPrice;
	JLabel labelUserOrderIDHeader;
	JLabel labelUserOrderDateHeader;
	JLabel labelUserOrderTotalPriceHeader;
	JLabel[] labelUserOrderID;
	JLabel[] labelUserOrderDate;
	JLabel[] labelUserOrderTotalPrice;

	JLabel labelAdminLogin;
	JLabel labelAdminPassword;
	JLabel labelAdminMarketHeader;
	JLabel labelAdminControlHeader;
	JLabel labelAdminViewOrdersHeader;
	JLabel labelAdminAddItemsHeader;
	JLabel labelAdminControlUserIDHeader;
	JLabel labelAdminControlUsernameHeader;
	JLabel labelAdminControlMobileNoHeader;
	JLabel[] labelAdminControlUserID;
	JLabel[] labelAdminControlUsername;
	JLabel[] labelAdminControlMobileNo;
	JLabel labelAdminMarketItemIDHeader;
	JLabel labelAdminMarketItemNameHeader;
	JLabel labelAdminMarketPriceHeader;
	JLabel[] labelAdminMarketItemID;
	JLabel[] labelAdminMarketItemName;
	JLabel[] labelAdminMarketPrice;
	JLabel labelAdminMarketAddItemName;
	JLabel labelAdminMarketAddPrice;
	JLabel labelAdminOrderIDHeader;
	JLabel labelAdminOrderDateHeader;
	JLabel labelAdminOrderUsernameHeader;
	JLabel labelAdminOrderTotalPriceHeader;
	JLabel[] labelAdminOrderID;
	JLabel[] labelAdminOrderDate;
	JLabel[] labelAdminOrderUsername;
	JLabel[] labelAdminOrderTotalPrice;


	// checkbox
	JCheckBox[] checkboxUserOrders;

	JCheckBox[] checkboxAdminControl;
	JCheckBox[] checkboxAdminMarket;
	JCheckBox[] checkboxAdminOrders;
	
	// Filas de textos
	JTextField textfieldUsername;
	JTextField textfieldEditUsername;
	JTextField textfieldEditMobileNo;
	JTextField textfieldSignupUsername;
	JTextField textfieldSignupMobileNumber;
	JTextField[] textfieldUserMarketItemQuantity;

	JTextField textfieldAdminMarketAddItemName;
	JTextField textfieldAdminMarketAddPrice;

	// filas de contraseña
	JPasswordField passwordFieldUser;
	JPasswordField passfieldEditPassword;
	JPasswordField passwordFieldSignupUser;
	JPasswordField passwordFieldAdmin;
	
	// butones
	JButton btnUserProfile;
	JButton btnUserLoginAttempt;
	JButton btnUserSignupPanel;
	JButton btnUserMarket;
	JButton btnUserOrders;
	JButton btnUserLogout;
	JButton btnUserDeleteAccount;
	JButton btnUserSaveChanges;
	JButton btnUserLoginPanel;
	JButton btnUserSignupAttempt;
	JButton btnUserMarketPlaceOrder;
	JButton btnUserMarketCalculate;
	JButton btnUserOrderView;
	
	JButton btnAdmin;
	JButton btnAdminLoginAtttempt;
	JButton btnAdminUser;
	JButton btnAdminLogout;
	JButton btnAdminControl;
	JButton btnAdminControlDelete;
	JButton btnAdminMarket;
	JButton btnAdminViewOrders;
	JButton btnAdminMarketAdditem;
	JButton btnAdminMarketDelete;
	JButton btnAdminOrderView;

	GUI() throws Exception{
		// objects
		users = new Users();
		items = new Items();
		orders = new Orders();

		// frame
		frame = new JFrame();

		// titulos de login
		labelLogin = new JLabel("SESION");
		labelLogin.setBounds(POSITION_X_LOGIN+125, POSITION_Y_LOGIN, 120, 60);
		labelLogin.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));
		
		labelUsername = new JLabel("USUARIO ");
		labelUsername.setBounds(POSITION_X_LOGIN, POSITION_Y_LOGIN+100, 120, 30);
		labelUsername.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

		labelPassword = new JLabel("CONTRASEÑA ");
		labelPassword.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
		labelPassword.setBounds(POSITION_X_LOGIN, POSITION_Y_LOGIN+140, 120, 30);

		// filas de login 
		textfieldUsername = new JTextField();
		textfieldUsername.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+100, 250, 30);
		textfieldUsername.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

		passwordFieldUser = new JPasswordField();
		passwordFieldUser.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+140, 250, 30);
		passwordFieldUser.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

		// Botones
		btnUserLoginAttempt = new JButton("Sesion");
		btnUserLoginAttempt.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+200, 100, 30);
		btnUserLoginAttempt.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
		btnUserLoginAttempt.setForeground(Color.WHITE);
		btnUserLoginAttempt.setBackground(Color.BLACK);
		btnUserLoginAttempt.setOpaque(true);
		btnUserLoginAttempt.setFocusable(false);
		btnUserLoginAttempt.setBorderPainted(false);
		btnUserLoginAttempt.setFocusPainted(false);

		btnUserSignupPanel = new JButton("Registrarse");
		btnUserSignupPanel.setBounds(POSITION_X_LOGIN+270, POSITION_Y_LOGIN+200, 100, 30);
		btnUserSignupPanel.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
		btnUserSignupPanel.setForeground(Color.WHITE);
		btnUserSignupPanel.setBackground(Color.BLACK);
		btnUserSignupPanel.setOpaque(true);
		btnUserSignupPanel.setFocusable(false);
		btnUserSignupPanel.setBorderPainted(false);
		btnUserSignupPanel.setFocusPainted(false);

		btnAdmin = new JButton("Admin");
		btnAdmin.setBounds(25, 25, 100, 30);
		btnAdmin.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
		btnAdmin.setForeground(Color.WHITE);
		btnAdmin.setBackground(Color.RED);
		btnAdmin.setOpaque(true);
		btnAdmin.setFocusable(false);
		btnAdmin.setBorderPainted(false);
		btnAdmin.setFocusPainted(false);

		// panel
		userLoginPanel = new JPanel();
		userLoginPanel.setLayout(null);
		userLoginPanel.add(labelLogin);
		userLoginPanel.add(labelUsername);
		userLoginPanel.add(textfieldUsername);
		userLoginPanel.add(labelPassword);
		userLoginPanel.add(passwordFieldUser);
		userLoginPanel.add(btnUserLoginAttempt);
		userLoginPanel.add(btnAdmin);
		userLoginPanel.add(btnUserSignupPanel);

		// entrada contenido
		frame.setContentPane(userLoginPanel);

		// actiones
		btnUserLoginAttempt.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Sesion de usuario: " + textfieldUsername.getText()+ " " + String.valueOf(passwordFieldUser.getPassword()) + " ");

				String[] userinfo = users.getUserinfo(textfieldUsername.getText());

				if(users.illegalUserTextInput(textfieldUsername.getText()) || users.illegalUserTextInput(String.valueOf(passwordFieldUser.getPassword()))){
					JOptionPane.showMessageDialog(null, "Please provide all the information", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(textfieldUsername.getText().equals(userinfo[1]) && String.valueOf(passwordFieldUser.getPassword()).equals(userinfo[3])){				
					int userID = Integer.valueOf(userinfo[0]);
					String username = userinfo[1];
					String mobileNo = userinfo[2];
					String password = userinfo[3];

					System.out.println(username + " Panel de usuario");

					// Elementos de usuario mercado
					labelUserMarketHeader = new JLabel("MERCADO");
					labelUserMarketHeader.setBounds(POSITION_X_USER, POSITION_Y_USER, 400, 30);
					labelUserMarketHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

					labelUserMarketItemIDHeader = new JLabel("Producto ID");
					labelUserMarketItemIDHeader.setBounds(200, 150, 100, 30);
					labelUserMarketItemIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserMarketItemNameHeader = new JLabel("Nombre Producto");
					labelUserMarketItemNameHeader.setBounds(300, 150, 300, 30);
					labelUserMarketItemNameHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserMarketPricePerQuantityHeader = new JLabel("Precio/Cantidad");
					labelUserMarketPricePerQuantityHeader.setBounds(550, 150, 100, 30);
					labelUserMarketPricePerQuantityHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserMarketQuantityHeader = new JLabel("Cantidad");
					labelUserMarketQuantityHeader.setBounds(650, 150, 100, 30);
					labelUserMarketQuantityHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserMarketPriceHeader = new JLabel("Precio");
					labelUserMarketPriceHeader.setBounds(750, 150, 100, 30);
					labelUserMarketPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserMarketTotalPriceHeader = new JLabel("Precio Total");
					labelUserMarketTotalPriceHeader.setBounds(650, SCREEN_HEIGHT-100, 100, 30);
					labelUserMarketTotalPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserMarketTotalPrice = new JLabel("0.0");
					labelUserMarketTotalPrice.setBounds(750, SCREEN_HEIGHT-100, 100, 30);
					labelUserMarketTotalPrice.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER2_SIZE));

					textfieldUserMarketItemQuantity = new JTextField[arraySize];

					labelUserMarketItemID = new JLabel[arraySize];
					labelUserMarketItemName = new JLabel[arraySize];
					labelUserMarketPricePerQuantity = new JLabel[arraySize];
					labelUserMarketPrice = new JLabel[arraySize];

					// Elementos de perfil, usuario
					labelProfileHeader = new JLabel("PERFIL");
					labelProfileHeader.setBounds(POSITION_X_USER, POSITION_Y_USER, 400, 30);
					labelProfileHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

					labelProfileUsername = new JLabel("Usuario");
					labelProfileUsername.setBounds(POSITION_X_USER, POSITION_Y_USER+100, 200, 30);
					labelProfileUsername.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelProfileMobileNo = new JLabel("Celular No");
					labelProfileMobileNo.setBounds(POSITION_X_USER, POSITION_Y_USER+150, 200, 30);
					labelProfileMobileNo.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelProfilePassword = new JLabel("Contraseña");
					labelProfilePassword.setBounds(POSITION_X_USER, POSITION_Y_USER+200, 200, 30);
					labelProfilePassword.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					textfieldEditUsername = new JTextField();
					textfieldEditUsername.setText(username);
					textfieldEditUsername.setBounds(POSITION_X_USER+100, POSITION_Y_USER+100, 250, 30);
					textfieldEditUsername.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
					
					textfieldEditMobileNo = new JTextField();
					textfieldEditMobileNo.setText(mobileNo);
					textfieldEditMobileNo.setBounds(POSITION_X_USER+100, POSITION_Y_USER+150, 250, 30);
					textfieldEditMobileNo.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
					
					passfieldEditPassword = new JPasswordField();
					passfieldEditPassword.setText(password);
					passfieldEditPassword.setBounds(POSITION_X_USER+100, POSITION_Y_USER+200, 250, 30);
					passfieldEditPassword.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

					// Elemento de pedido, usuario
					labelUserOrdersHeader = new JLabel("ORDENES");
					labelUserOrdersHeader.setBounds(POSITION_X_USER, POSITION_Y_USER, 400, 30);
					labelUserOrdersHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

					labelUserOrderIDHeader = new JLabel("Orden ID");
					labelUserOrderIDHeader.setBounds(200, 150, 100, 30);
					labelUserOrderIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserOrderDateHeader = new JLabel("Fecha Orden");
					labelUserOrderDateHeader.setBounds(300, 150, 300, 30);
					labelUserOrderDateHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					labelUserOrderTotalPriceHeader = new JLabel("Precio Total");
					labelUserOrderTotalPriceHeader.setBounds(600, 150, 100, 30);
					labelUserOrderTotalPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

					checkboxUserOrders = new JCheckBox[arraySize];
					labelUserOrderID = new JLabel[arraySize];
					labelUserOrderDate = new JLabel[arraySize];
					labelUserOrderTotalPrice = new JLabel[arraySize];

					// Botones de perfil, usuario
					btnUserProfile = new JButton("Perfil");
					btnUserProfile.setBounds(0, 100, 150, 50);
					btnUserProfile.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserProfile.setForeground(Color.WHITE);
					btnUserProfile.setBackground(Color.BLACK);
					btnUserProfile.setOpaque(true);
					btnUserProfile.setFocusable(false);
					btnUserProfile.setBorderPainted(false);
					btnUserProfile.setFocusPainted(false);
					btnUserProfile.setEnabled(true);
					
					btnUserDeleteAccount = new JButton("Eliminar Cuenta");
					btnUserDeleteAccount.setBounds(SCREEN_WIDTH-340, SCREEN_HEIGHT-100, 150, 50);
					btnUserDeleteAccount.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserDeleteAccount.setForeground(Color.WHITE);
					btnUserDeleteAccount.setBackground(Color.BLACK);
					btnUserDeleteAccount.setOpaque(true);
					btnUserDeleteAccount.setFocusable(false);
					btnUserDeleteAccount.setBorderPainted(false);
					btnUserDeleteAccount.setFocusPainted(false);

					btnUserSaveChanges = new JButton("Nuevo Cambios");
					btnUserSaveChanges.setBounds(SCREEN_WIDTH-170, SCREEN_HEIGHT-100, 150, 50);
					btnUserSaveChanges.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserSaveChanges.setForeground(Color.WHITE);
					btnUserSaveChanges.setBackground(Color.BLACK);
					btnUserSaveChanges.setOpaque(true);
					btnUserSaveChanges.setFocusable(false);
					btnUserSaveChanges.setBorderPainted(false);
					btnUserSaveChanges.setFocusPainted(false);

					// Botones de usuario, mercado
					btnUserMarket = new JButton("Mercado");
					btnUserMarket.setBounds(0, 150, 150, 50);
					btnUserMarket.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserMarket.setForeground(Color.WHITE);
					btnUserMarket.setBackground(Color.BLACK);
					btnUserMarket.setOpaque(true);
					btnUserMarket.setFocusable(false);
					btnUserMarket.setBorderPainted(false);
					btnUserMarket.setFocusPainted(false);
					btnUserMarket.setEnabled(false);

					btnUserMarketPlaceOrder = new JButton("Realizar pedido");
					btnUserMarketPlaceOrder.setBounds(SCREEN_WIDTH-170, SCREEN_HEIGHT-100, 150, 50);
					btnUserMarketPlaceOrder.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserMarketPlaceOrder.setForeground(Color.WHITE);
					btnUserMarketPlaceOrder.setBackground(Color.BLACK);
					btnUserMarketPlaceOrder.setOpaque(true);
					btnUserMarketPlaceOrder.setFocusable(false);
					btnUserMarketPlaceOrder.setBorderPainted(false);
					btnUserMarketPlaceOrder.setFocusPainted(false);
					btnUserMarketPlaceOrder.setEnabled(false);

					btnUserMarketCalculate = new JButton("Calcular");
					btnUserMarketCalculate.setBounds(170, SCREEN_HEIGHT-100, 150, 50);
					btnUserMarketCalculate.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserMarketCalculate.setForeground(Color.WHITE);
					btnUserMarketCalculate.setBackground(Color.BLACK);
					btnUserMarketCalculate.setOpaque(true);
					btnUserMarketCalculate.setFocusable(false);
					btnUserMarketCalculate.setBorderPainted(false);
					btnUserMarketCalculate.setFocusPainted(false);

					// user orders buttons
					btnUserOrders = new JButton("Ordenes");
					btnUserOrders.setBounds(0, 200, 150, 50);
					btnUserOrders.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserOrders.setForeground(Color.WHITE);
					btnUserOrders.setBackground(Color.BLACK);
					btnUserOrders.setOpaque(true);
					btnUserOrders.setFocusable(false);
					btnUserOrders.setBorderPainted(false);
					btnUserOrders.setFocusPainted(false);
					btnUserOrders.setEnabled(true);

					btnUserOrderView = new JButton("Vista");
					btnUserOrderView.setBounds(SCREEN_WIDTH-170, SCREEN_HEIGHT-100, 150, 50);
					btnUserOrderView.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserOrderView.setForeground(Color.WHITE);
					btnUserOrderView.setBackground(Color.BLACK);
					btnUserOrderView.setOpaque(true);
					btnUserOrderView.setFocusable(false);
					btnUserOrderView.setBorderPainted(false);
					btnUserOrderView.setFocusPainted(false);

					// user logout button
					btnUserLogout = new JButton("Opciones");
					btnUserLogout.setBounds(0, SCREEN_HEIGHT-100, 150, 50);
					btnUserLogout.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
					btnUserLogout.setForeground(Color.WHITE);
					btnUserLogout.setBackground(Color.BLACK);
					btnUserLogout.setOpaque(true);
					btnUserLogout.setFocusable(false);
					btnUserLogout.setBorderPainted(false);
					btnUserLogout.setFocusPainted(false);

					// user market panel
					userPanel = new JPanel();
					userPanel.setBackground(Color.WHITE);
					userPanel.setLayout(null);
					userPanel.add(btnUserProfile);
					userPanel.add(btnUserMarket);
					userPanel.add(btnUserOrders);
					userPanel.add(btnUserLogout);
					userPanel.add(labelUserMarketHeader);
					userPanel.add(labelUserMarketItemIDHeader);
					userPanel.add(labelUserMarketItemNameHeader);
					userPanel.add(labelUserMarketPricePerQuantityHeader);
					userPanel.add(btnUserMarketPlaceOrder);
					userPanel.add(labelUserMarketQuantityHeader);
					userPanel.add(labelUserMarketPriceHeader);
					userPanel.add(btnUserMarketCalculate);
					userPanel.add(labelUserMarketTotalPriceHeader);
					userPanel.add(labelUserMarketTotalPrice);
					
					for(int i=0; i<=items.newItemID; i++){
						labelUserMarketItemID[i] = new JLabel(String.valueOf(i));
						labelUserMarketItemID[i].setBounds(200, (150+30*(i+1)), 100, 30);
						labelUserMarketItemID[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

						labelUserMarketItemName[i] = new JLabel(items.itemName[i]);
						labelUserMarketItemName[i].setBounds(300, (150+30*(i+1)), 300, 30);
						labelUserMarketItemName[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

						labelUserMarketPricePerQuantity[i] = new JLabel(String.valueOf(items.price[i]));
						labelUserMarketPricePerQuantity[i].setBounds(550, (150+30*(i+1)), 100, 30);
						labelUserMarketPricePerQuantity[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

						textfieldUserMarketItemQuantity[i] = new JTextField();
						textfieldUserMarketItemQuantity[i].setText("0");
						textfieldUserMarketItemQuantity[i].setBounds(650, (150+30*(i+1)), 50, 30);
						textfieldUserMarketItemQuantity[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

						labelUserMarketPrice[i] = new JLabel();
						labelUserMarketPrice[i].setText("0.0");
						labelUserMarketPrice[i].setBounds(750, (150+30*(i+1)), 50, 30);
						labelUserMarketPrice[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));						

						userPanel.add(labelUserMarketItemID[i]);
						userPanel.add(labelUserMarketItemName[i]);
						userPanel.add(labelUserMarketPricePerQuantity[i]);
						userPanel.add(textfieldUserMarketItemQuantity[i]);
						userPanel.add(labelUserMarketPrice[i]);
					}

					// user profile panel
					userProfilePanel = new JPanel();
					userProfilePanel.setBackground(Color.WHITE);
					userProfilePanel.setLayout(null);

					// user order panel
					userOrdersPanel = new JPanel();
					userOrdersPanel.setBackground(Color.WHITE);
					userOrdersPanel.setLayout(null);
					userOrdersPanel.add(labelUserOrderIDHeader);
					userOrdersPanel.add(labelUserOrderDateHeader);
					userOrdersPanel.add(labelUserOrderTotalPriceHeader);
					userOrdersPanel.add(btnUserOrderView);

					for(int i=orders.newOrderID, j=0; i>=0; i--){
						if(orders.username[i].equals(username)){
							checkboxUserOrders[j] = new JCheckBox();
							checkboxUserOrders[j].setBounds(160, (150+30*(j+1)), 30, 30);
							checkboxUserOrders[j].setBackground(Color.WHITE);
							checkboxUserOrders[j].setFocusable(false);

							labelUserOrderID[j] = new JLabel(String.valueOf(i));
							labelUserOrderID[j].setBounds(200, (150+30*(j+1)), 100, 30);
							labelUserOrderID[j].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

							labelUserOrderDate[j] = new JLabel(orders.date[i]);
							labelUserOrderDate[j].setBounds(300, (150+30*(j+1)), 300, 30);
							labelUserOrderDate[j].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

							labelUserOrderTotalPrice[j] = new JLabel(String.valueOf(orders.totalPrice[i]));
							labelUserOrderTotalPrice[j].setBounds(600, (150+30*(j+1)), 100, 30);
							labelUserOrderTotalPrice[j].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

							userOrdersPanel.add(checkboxUserOrders[j]);
							userOrdersPanel.add(labelUserOrderID[j]);
							userOrdersPanel.add(labelUserOrderDate[j]);
							userOrdersPanel.add(labelUserOrderTotalPrice[j]);
							j++;
						}
					}

					// user temp panel
					JPanel tempPanel = new JPanel();
					tempPanel.setLayout(null);

					// action user profile
					btnUserProfile.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent arg0) {
							System.out.println(username + "Panel de usuario");
							btnUserMarket.setEnabled(true);
							btnUserProfile.setEnabled(false);
							btnUserOrders.setEnabled(true);

							userProfilePanel.add(labelProfileHeader);
							userProfilePanel.add(labelProfileUsername);
							userProfilePanel.add(textfieldEditUsername);
							userProfilePanel.add(labelProfileMobileNo);
							userProfilePanel.add(textfieldEditMobileNo);
							userProfilePanel.add(labelProfilePassword);
							userProfilePanel.add(passfieldEditPassword);
							userProfilePanel.add(btnUserProfile);
							userProfilePanel.add(btnUserMarket);
							userProfilePanel.add(btnUserOrders);
							userProfilePanel.add(btnUserLogout);
							userProfilePanel.add(btnUserSaveChanges);
							userProfilePanel.add(btnUserDeleteAccount);

							frame.setContentPane(userProfilePanel);
							frame.validate();
						}
					});

					btnUserDeleteAccount.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							int answer = JOptionPane.showConfirmDialog(null, "Realmente quieres eliminar tu cuenta?", "Confirmado", JOptionPane.YES_NO_OPTION);
							if(answer == 0){
								System.out.println("Cuenta de usuario eliminada: " + username);
								users.removeUser(userID);
								System.out.println(users);

								try {
									System.out.println("Guardando informacion de usuario....");
									users.saveUserinfo();
									users = new Users();
								} catch (Exception e) {
									e.printStackTrace();
								}

								frame.setContentPane(userLoginPanel);
								frame.validate();
							}
						}
						
					});

					btnUserSaveChanges.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							String username = textfieldEditUsername.getText();
							String mobileNo = textfieldEditMobileNo.getText();
							String password = String.valueOf(passfieldEditPassword.getPassword());

							System.out.println("Editando informacion de usuario: " + username + " " + mobileNo + " " + password);

							users.editUserinfo(userID, username, mobileNo, password);
							JOptionPane.showMessageDialog(null, "Los cambios se han aplicado correctamente!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
						}
						
					});

					// action user market
					btnUserMarket.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							System.out.println(username + " Panel de Usuario");

							btnUserMarket.setEnabled(false);
							btnUserProfile.setEnabled(true);
							btnUserOrders.setEnabled(true);
							
							userPanel.add(btnUserProfile);
							userPanel.add(btnUserMarket);
							userPanel.add(btnUserOrders);
							userPanel.add(btnUserLogout);
							userPanel.add(labelUserMarketHeader);

							frame.setContentPane(userPanel);
							frame.validate();
						}
						
					});

					btnUserMarketCalculate.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							try{
								System.out.println(username + " Precio a calcular");
								Double totalPrice = 0.0;

								for(int i=0; i<=items.newItemID; i++){
									Double price = Double.valueOf(labelUserMarketPricePerQuantity[i].getText()) * Double.valueOf(textfieldUserMarketItemQuantity[i].getText());
									labelUserMarketPrice[i].setText(String.valueOf(price));
									totalPrice += price;
								}

								System.out.println(username + " Precio Total: " + totalPrice);
								labelUserMarketTotalPrice.setText(String.valueOf(totalPrice));

								if(totalPrice == 0.0){
									btnUserMarketPlaceOrder.setEnabled(false);
								}else{
									btnUserMarketPlaceOrder.setEnabled(true);
								}
							}catch(Exception e){
								System.out.println(e);
							}
						}

					});
					
					btnUserMarketPlaceOrder.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							try{
								for(int i=0, j=0; i<=orders.newOrderID; i++){
									if(orders.username[i].equals(username)){
										tempPanel.add(checkboxUserOrders[j]);
										tempPanel.add(labelUserOrderID[j]);
										tempPanel.add(labelUserOrderDate[j]);
										tempPanel.add(labelUserOrderTotalPrice[j]);
										j++;
									}
								}

								LocalDateTime now = LocalDateTime.now();
								String date = String.valueOf(dtf.format(now));
								String itemsName = "";
								String itemsPricePerQuantity = "";
								String itemsQuantity = "";
								double totalPrice = Double.valueOf(labelUserMarketTotalPrice.getText());
								
								System.out.println(username + " Pedido Realizado: " + dtf.format(now) + " " + username + " " + totalPrice);

								for(int i=0; i<=items.newItemID; i++){
									itemsName += items.itemName[i];
									itemsPricePerQuantity += items.price[i];
									itemsQuantity += String.valueOf(Integer.valueOf(textfieldUserMarketItemQuantity[i].getText()));

									if(i != items.newItemID){
										itemsName += "-";
										itemsPricePerQuantity += "-";
										itemsQuantity += "-";
									}
								}

								orders.createOrder(date, username, itemsName, itemsPricePerQuantity, itemsQuantity, totalPrice);
								try {
									System.out.println("Guardando informacion del pedido....");
									orders.saveOrderInfo();
									orders = new Orders();
								} catch (Exception e) {
									e.printStackTrace();
								}

								JOptionPane.showMessageDialog(null, "Se ha realizado correctamente su pedido!", "Confirmado", JOptionPane.INFORMATION_MESSAGE);
								btnUserMarketPlaceOrder.setEnabled(false);

								for(int i=orders.newOrderID, j=0; i>=0; i--){
									if(orders.username[i].equals(username)){
										checkboxUserOrders[j] = new JCheckBox();
										checkboxUserOrders[j].setBounds(160, (150+30*(j+1)), 30, 30);
										checkboxUserOrders[j].setBackground(Color.WHITE);
										checkboxUserOrders[j].setFocusable(false);
			
										labelUserOrderID[j] = new JLabel(String.valueOf(i));
										labelUserOrderID[j].setBounds(200, (150+30*(j+1)), 100, 30);
										labelUserOrderID[j].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
			
										labelUserOrderDate[j] = new JLabel(orders.date[i]);
										labelUserOrderDate[j].setBounds(300, (150+30*(j+1)), 300, 30);
										labelUserOrderDate[j].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
			
										labelUserOrderTotalPrice[j] = new JLabel(String.valueOf(orders.totalPrice[i]));
										labelUserOrderTotalPrice[j].setBounds(600, (150+30*(j+1)), 100, 30);
										labelUserOrderTotalPrice[j].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
			
										userOrdersPanel.add(checkboxUserOrders[j]);
										userOrdersPanel.add(labelUserOrderID[j]);
										userOrdersPanel.add(labelUserOrderDate[j]);
										userOrdersPanel.add(labelUserOrderTotalPrice[j]);
										j++;
									}


								}
							}catch(Exception e){
								System.out.println(e);
							}

						}
						
					});

					// action user orders
					btnUserOrders.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							System.out.println(username + " Panel de ordenes");

							btnUserMarket.setEnabled(true);
							btnUserProfile.setEnabled(true);
							btnUserOrders.setEnabled(false);

							userOrdersPanel.add(btnUserProfile);
							userOrdersPanel.add(btnUserMarket);
							userOrdersPanel.add(btnUserOrders);
							userOrdersPanel.add(btnUserLogout);
							userOrdersPanel.add(labelUserOrdersHeader);

							frame.setContentPane(userOrdersPanel);
							frame.validate();
						}
						
					});
					
					btnUserOrderView.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							for(int i=0; i<=orders.newOrderID; i++){
								if(checkboxUserOrders[i].isSelected()){
									System.out.println(i);

									int checkedOrderID = Integer.valueOf(labelUserOrderID[i].getText());
									System.out.println(checkedOrderID);

									JFrame frameViewOrder = new JFrame();

									JLabel labelDate = new JLabel("Fecha: " + orders.date[checkedOrderID]);
									labelDate.setBounds(100, 50, 400, 50);
									labelDate.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER2_SIZE));
									
									JLabel labelUsername = new JLabel("Usuario: " + orders.username[checkedOrderID]);
									labelUsername.setBounds(100, 100, 400, 50);
									labelUsername.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER2_SIZE));

									JLabel labelItemIDHeader = new JLabel("ID Producto");
									labelItemIDHeader.setBounds(100, 150, 100, 30);
									labelItemIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

									JLabel labelItemNameHeader = new JLabel("Nombre de producto");
									labelItemNameHeader.setBounds(200, 150, 300, 30);
									labelItemNameHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

									JLabel labelPricePerQuantityHeader = new JLabel("Precio/Cantidad");
									labelPricePerQuantityHeader.setBounds(500, 150, 100, 30);
									labelPricePerQuantityHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

									JLabel labelQuantityHeader = new JLabel("Cantidad");
									labelQuantityHeader.setBounds(700, 150, 100, 30);
									labelQuantityHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

									JLabel labelPriceHeader = new JLabel("Precio");
									labelPriceHeader.setBounds(800, 150, 100, 30);
									labelPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

									JLabel[] labelItemID = new JLabel[arraySize];
									JLabel[] labelItemName = new JLabel[arraySize];
									JLabel[] labelItemPricePerQuantity = new JLabel[arraySize];
									JLabel[] labelItemQuantity = new JLabel[arraySize];
									JLabel[] labelItemPrice = new JLabel[arraySize];

									JLabel labelTotalPrice = new JLabel("Price Total: " + orders.totalPrice[checkedOrderID]);
									labelTotalPrice.setBounds(700, SCREEN_HEIGHT-100, 300, 30);
									labelTotalPrice.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

									String[] arrayItemsName = orders.itemsName[checkedOrderID].split("-");
									String[] arrayItemsPricePerQuantity = orders.itemsPricePerQuantity[checkedOrderID].split("-");
									String[] arrayItemsQuantity = orders.itemsQuantity[checkedOrderID].split("-");

									// panel
									JPanel viewOrderPanel = new JPanel();
									viewOrderPanel.setBackground(Color.WHITE);
									viewOrderPanel.setLayout(null);	
									viewOrderPanel.add(labelDate);
									viewOrderPanel.add(labelUsername);
									viewOrderPanel.add(labelTotalPrice);
									viewOrderPanel.add(labelPriceHeader);
									viewOrderPanel.add(labelQuantityHeader);
									viewOrderPanel.add(labelPricePerQuantityHeader);
									viewOrderPanel.add(labelItemNameHeader);
									viewOrderPanel.add(labelItemIDHeader);

									try{
										for(int k=0; k<arrayItemsName.length; k++){
											labelItemID[k] = new JLabel(String.valueOf(k));
											labelItemID[k].setBounds(100, 150+30*(k+1), 100, 30);
											labelItemID[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

											System.out.println(arrayItemsName[k] + " " + arrayItemsPricePerQuantity[k] + "-" + arrayItemsQuantity[k]);

											labelItemName[k] = new JLabel(arrayItemsName[k]);
											labelItemName[k].setBounds(200, 150+30*(k+1), 300, 30);
											labelItemName[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

											labelItemPricePerQuantity[k] = new JLabel(arrayItemsPricePerQuantity[k]);
											labelItemPricePerQuantity[k].setBounds(500, 150+30*(k+1), 100, 30);
											labelItemPricePerQuantity[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

											labelItemQuantity[k] = new JLabel(arrayItemsQuantity[k]);
											labelItemQuantity[k].setBounds(700, 150+30*(k+1), 100, 30);
											labelItemQuantity[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

											labelItemPrice[k] = new JLabel(String.valueOf(Double.valueOf(arrayItemsPricePerQuantity[k]) * Double.valueOf(arrayItemsQuantity[k])));
											labelItemPrice[k].setBounds(800, 150+30*(k+1), 100, 30);
											labelItemPrice[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

		
											viewOrderPanel.add(labelItemID[k]);
											viewOrderPanel.add(labelItemName[k]);
											viewOrderPanel.add(labelItemPricePerQuantity[k]);
											viewOrderPanel.add(labelItemQuantity[k]);
											viewOrderPanel.add(labelItemPrice[k]);
										}
									}catch(Exception e){
										System.out.println(e);
									}

									// frame
									frameViewOrder.setContentPane(viewOrderPanel);
									frameViewOrder.setTitle(orders.date[i] + " " + orders.username[i]);
									frameViewOrder.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
									frameViewOrder.setResizable(false);
									frameViewOrder.setLocationRelativeTo(null);
									frameViewOrder.setVisible(true);
									frameViewOrder.setLayout(null);
									break;
								}
							}
						}
						
					});
					
					
					btnUserLogout.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// set content
							int answer = JOptionPane.showConfirmDialog(null, "Realmente quieres salir de la session?", "Confirmado", JOptionPane.YES_NO_OPTION);
							if(answer == 0){
								System.out.println("Haz cerrado sesion: " + username);
								frame.setContentPane(userLoginPanel);
								frame.validate();
							}
						}
						
					});

					// set content
					frame.setContentPane(userPanel);
					frame.validate();				
				}else{
					JOptionPane.showMessageDialog(null, "Usuario o contraseña no esta correcto!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
		});

		btnUserSignupPanel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Panel de registro de usuario");
				// elements
				btnUserLoginPanel = new JButton("Login");
				btnUserLoginPanel.setBounds(25, 25, 100, 30);
				btnUserLoginPanel.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
				btnUserLoginPanel.setForeground(Color.WHITE);
				btnUserLoginPanel.setBackground(Color.BLACK);
				btnUserLoginPanel.setOpaque(true);
				btnUserLoginPanel.setFocusable(false);
				btnUserLoginPanel.setBorderPainted(false);
				btnUserLoginPanel.setFocusPainted(false);

				labelUserSignup = new JLabel("Registrar");
				labelUserSignup.setBounds(POSITION_X_LOGIN+125, POSITION_Y_LOGIN, 120, 60);
				labelUserSignup.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));
				
				labelSignupUsername = new JLabel("Usuario");
				labelSignupUsername.setBounds(POSITION_X_LOGIN, POSITION_Y_LOGIN+100, 120, 30);
				labelSignupUsername.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

				labelSignupMobileNumber = new JLabel("No Celular");
				labelSignupMobileNumber.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
				labelSignupMobileNumber.setBounds(POSITION_X_LOGIN, POSITION_Y_LOGIN+140, 120, 30);

				labelSignupPassword = new JLabel("Contraseña ");
				labelSignupPassword.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
				labelSignupPassword.setBounds(POSITION_X_LOGIN, POSITION_Y_LOGIN+180, 120, 30);

				// Campos Login
				textfieldSignupUsername = new JTextField();
				textfieldSignupUsername.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+100, 250, 30);
				textfieldSignupUsername.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

				textfieldSignupMobileNumber = new JTextField();
				textfieldSignupMobileNumber.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+140, 250, 30);
				textfieldSignupMobileNumber.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

				passwordFieldSignupUser = new JPasswordField();
				passwordFieldSignupUser.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+180, 250, 30);
				passwordFieldSignupUser.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

				btnUserSignupAttempt = new JButton("Registrarse");
				btnUserSignupAttempt.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+260, 100, 30);
				btnUserSignupAttempt.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
				btnUserSignupAttempt.setForeground(Color.WHITE);
				btnUserSignupAttempt.setBackground(Color.BLACK);
				btnUserSignupAttempt.setOpaque(true);
				btnUserSignupAttempt.setFocusable(false);
				btnUserSignupAttempt.setBorderPainted(false);
				btnUserSignupAttempt.setFocusPainted(false);

				// panel
				userSignupPanel = new JPanel();
				userSignupPanel.setBackground(Color.WHITE);
				userSignupPanel.setLayout(null);
				userSignupPanel.add(btnUserLoginPanel);
				userSignupPanel.add(labelUserSignup);
				userSignupPanel.add(labelSignupUsername);
				userSignupPanel.add(labelSignupPassword);
				userSignupPanel.add(labelSignupMobileNumber);
				userSignupPanel.add(textfieldSignupUsername);
				userSignupPanel.add(textfieldSignupMobileNumber);
				userSignupPanel.add(passwordFieldSignupUser);
				userSignupPanel.add(btnUserSignupAttempt);

				// actions
				btnUserLoginPanel.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// set content
						System.out.println("Sesion de panel de usuario");
						frame.setContentPane(userLoginPanel);
						frame.validate();
					}
					
				});

				btnUserSignupAttempt.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String signupUsername = textfieldSignupUsername.getText();
						String signupMobileNo = textfieldSignupMobileNumber.getText();
						String signupPassword = String.valueOf(passwordFieldSignupUser.getPassword());

						System.out.println("Signup attempt: "+signupUsername+" " +signupMobileNo+" "+signupPassword);

						// System.out.println(username + " " + mobileNo + " " + password);
						if(signupUsername.equals("") || signupMobileNo.equals("") || signupPassword.equals("")){
							// System.out.println("Please provide all information");
							JOptionPane.showMessageDialog(null, "Favor de proveer toda la información", "Error", JOptionPane.ERROR_MESSAGE);
						}else if(signupUsername.equals(users.getUserinfo(signupUsername)[1])){
							// System.out.println("User Already Exists");
							JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
						}else{
							users.createUser(signupUsername, signupMobileNo, signupPassword);
							// System.out.println("New User Created!");
							JOptionPane.showMessageDialog(null, "Se ha registrado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
							frame.setContentPane(userLoginPanel);
						}
					}
					
				});

				// set content
				frame.setContentPane(userSignupPanel);
				frame.validate();
			}
			
		});

		btnAdmin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Admin panel");
				// elements
				labelAdminLogin = new JLabel("Sesion admin");
				labelAdminLogin.setBounds(POSITION_X_LOGIN+100, POSITION_Y_LOGIN, 200, 60);
				labelAdminLogin.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));
				labelAdminLogin.setForeground(Color.RED);

				labelAdminPassword = new JLabel("Rooteo de contraseña ");
				labelAdminPassword.setBounds(POSITION_X_LOGIN, POSITION_Y_LOGIN+100, 120, 30);
				labelAdminPassword.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

				passwordFieldAdmin = new JPasswordField();
				passwordFieldAdmin.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+100, 250, 30);
				passwordFieldAdmin.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

				btnAdminLoginAtttempt = new JButton("Session");
				btnAdminLoginAtttempt.setBounds(POSITION_X_LOGIN+120, POSITION_Y_LOGIN+200, 100, 30);
				btnAdminLoginAtttempt.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
				btnAdminLoginAtttempt.setForeground(Color.WHITE);
				btnAdminLoginAtttempt.setBackground(Color.RED);
				btnAdminLoginAtttempt.setOpaque(true);
				btnAdminLoginAtttempt.setFocusable(false);
				btnAdminLoginAtttempt.setBorderPainted(false);
				btnAdminLoginAtttempt.setFocusPainted(false);

				btnAdminUser = new JButton("Usuario");
				btnAdminUser.setBounds(25, 25, 100, 30);
				btnAdminUser.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
				btnAdminUser.setForeground(Color.WHITE);
				btnAdminUser.setBackground(Color.BLACK);
				btnAdminUser.setOpaque(true);
				btnAdminUser.setFocusable(false);
				btnAdminUser.setBorderPainted(false);
				btnAdminUser.setFocusPainted(false);

				// actions
				btnAdminLoginAtttempt.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {	
						System.out.println("admin login attempt");
						if(!String.valueOf(passwordFieldAdmin.getPassword()).equals(ROOT_PASSWORD)){
							JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Error", JOptionPane.ERROR_MESSAGE);
						}else{
							System.out.println("Admin panel");

							// control labels
							labelAdminControlHeader = new JLabel("PANEL DE CONTROL");
							labelAdminControlHeader.setBounds(200, 100, 400, 30);
							labelAdminControlHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

							labelAdminControlUserIDHeader = new JLabel("ID USUARIO");
							labelAdminControlUserIDHeader.setBounds(200, 150, 100, 30);
							labelAdminControlUserIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminControlUsernameHeader = new JLabel("Nombre de Usuario");
							labelAdminControlUsernameHeader.setBounds(300, 150, 300, 30);
							labelAdminControlUsernameHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminControlMobileNoHeader = new JLabel("Celular No");
							labelAdminControlMobileNoHeader.setBounds(600, 150, 100, 30);
							labelAdminControlMobileNoHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							checkboxAdminControl = new JCheckBox[arraySize];
							labelAdminControlUserID = new JLabel[arraySize];
							labelAdminControlUsername = new JLabel[arraySize];
							labelAdminControlMobileNo = new JLabel[arraySize];

							// market labels
							labelAdminMarketHeader = new JLabel("MERCADO");
							labelAdminMarketHeader.setBounds(200, 100, 400, 30);
							labelAdminMarketHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

							// element add items
							labelAdminMarketAddItemName = new JLabel("Nombre de producto");
							labelAdminMarketAddItemName.setBounds(300, 150, 100, 30);
							labelAdminMarketAddItemName.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							textfieldAdminMarketAddItemName = new JTextField();
							textfieldAdminMarketAddItemName.setBounds(390, 150, 200, 30);
							textfieldAdminMarketAddItemName.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

							labelAdminMarketAddPrice = new JLabel("Precio");
							labelAdminMarketAddPrice.setBounds(600, 150, 100, 30);
							labelAdminMarketAddPrice.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							textfieldAdminMarketAddPrice = new JTextField();
							textfieldAdminMarketAddPrice.setBounds(650, 150, 100, 30);
							textfieldAdminMarketAddPrice.setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

							// label display items
							labelAdminMarketItemIDHeader = new JLabel("ID Producto");
							labelAdminMarketItemIDHeader.setBounds(200, 200, 100, 30);
							labelAdminMarketItemIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminMarketItemNameHeader = new JLabel("Nombre de producto");
							labelAdminMarketItemNameHeader.setBounds(300, 200, 300, 30);
							labelAdminMarketItemNameHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminMarketPriceHeader = new JLabel("Precio/Cantidad");
							labelAdminMarketPriceHeader.setBounds(600, 200, 100, 30);
							labelAdminMarketPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							checkboxAdminMarket = new JCheckBox[arraySize];
							labelAdminMarketItemID = new JLabel[arraySize];
							labelAdminMarketItemName = new JLabel[arraySize];
							labelAdminMarketPrice = new JLabel[arraySize];


							// view orders labels
							labelAdminViewOrdersHeader = new JLabel("VISTA DE PEDIDOS");
							labelAdminViewOrdersHeader.setBounds(200, 100, 400, 30);
							labelAdminViewOrdersHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

							labelAdminOrderIDHeader = new JLabel("ID Perdido");
							labelAdminOrderIDHeader.setBounds(200, 150, 100, 30);
							labelAdminOrderIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminOrderDateHeader = new JLabel("Dia de Pedido");
							labelAdminOrderDateHeader.setBounds(300, 150, 300, 30);
							labelAdminOrderDateHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminOrderUsernameHeader = new JLabel("Usuario");
							labelAdminOrderUsernameHeader.setBounds(600, 150, 100, 30);
							labelAdminOrderUsernameHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							labelAdminOrderTotalPriceHeader = new JLabel("Precio Total");
							labelAdminOrderTotalPriceHeader.setBounds(800, 150, 100, 30);
							labelAdminOrderTotalPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

							checkboxAdminOrders = new JCheckBox[arraySize];
							labelAdminOrderID = new JLabel[arraySize];
							labelAdminOrderDate = new JLabel[arraySize];
							labelAdminOrderUsername = new JLabel[arraySize];
							labelAdminOrderTotalPrice = new JLabel[arraySize];

							// add new items labels
							labelAdminAddItemsHeader = new JLabel("AÑADIR NUEVO PRODUCTO");
							labelAdminAddItemsHeader.setBounds(200, 100, 400, 30);
							labelAdminAddItemsHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER1_SIZE));

							// admin conrtol buttons
							btnAdminControl = new JButton("Panel de Control");
							btnAdminControl.setBounds(0, 100, 150, 50);
							btnAdminControl.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminControl.setForeground(Color.WHITE);
							btnAdminControl.setBackground(Color.RED);
							btnAdminControl.setOpaque(true);
							btnAdminControl.setFocusable(false);
							btnAdminControl.setBorderPainted(false);
							btnAdminControl.setFocusPainted(false);
							btnAdminControl.setEnabled(true);

							btnAdminControlDelete = new JButton("Remover");
							btnAdminControlDelete.setBounds(SCREEN_WIDTH-170, SCREEN_HEIGHT-100, 150, 50);
							btnAdminControlDelete.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminControlDelete.setForeground(Color.WHITE);
							btnAdminControlDelete.setBackground(Color.RED);
							btnAdminControlDelete.setOpaque(true);
							btnAdminControlDelete.setFocusable(false);
							btnAdminControlDelete.setBorderPainted(false);
							btnAdminControlDelete.setFocusPainted(false);
							
							// admin market buttons
							btnAdminMarket = new JButton("Mercado");
							btnAdminMarket.setBounds(0, 150, 150, 50);
							btnAdminMarket.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminMarket.setForeground(Color.WHITE);
							btnAdminMarket.setBackground(Color.RED);
							btnAdminMarket.setOpaque(true);
							btnAdminMarket.setFocusable(false);
							btnAdminMarket.setBorderPainted(false);
							btnAdminMarket.setFocusPainted(false);
							btnAdminMarket.setEnabled(false);

							btnAdminMarketAdditem = new JButton("Añadir");
							btnAdminMarketAdditem.setBounds(800, 150, 100, 30);
							btnAdminMarketAdditem.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminMarketAdditem.setForeground(Color.WHITE);
							btnAdminMarketAdditem.setBackground(Color.RED);
							btnAdminMarketAdditem.setOpaque(true);
							btnAdminMarketAdditem.setFocusable(false);
							btnAdminMarketAdditem.setBorderPainted(false);
							btnAdminMarketAdditem.setFocusPainted(false);

							btnAdminMarketDelete = new JButton("Eliminar");
							btnAdminMarketDelete.setBounds(SCREEN_WIDTH-170, SCREEN_HEIGHT-100, 150, 50);
							btnAdminMarketDelete.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminMarketDelete.setForeground(Color.WHITE);
							btnAdminMarketDelete.setBackground(Color.RED);
							btnAdminMarketDelete.setOpaque(true);
							btnAdminMarketDelete.setFocusable(false);
							btnAdminMarketDelete.setBorderPainted(false);
							btnAdminMarketDelete.setFocusPainted(false);
							
							// buttons admin view order 
							btnAdminViewOrders = new JButton("Vista de Pedido");
							btnAdminViewOrders.setBounds(0, 200, 150, 50);
							btnAdminViewOrders.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminViewOrders.setForeground(Color.WHITE);
							btnAdminViewOrders.setBackground(Color.RED);
							btnAdminViewOrders.setOpaque(true);
							btnAdminViewOrders.setFocusable(false);
							btnAdminViewOrders.setBorderPainted(false);
							btnAdminViewOrders.setFocusPainted(false);
							btnAdminViewOrders.setEnabled(true);

							btnAdminOrderView = new JButton("Vista");
							btnAdminOrderView.setBounds(SCREEN_WIDTH-170, SCREEN_HEIGHT-100, 150, 50);
							btnAdminOrderView.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminOrderView.setForeground(Color.WHITE);
							btnAdminOrderView.setBackground(Color.RED);
							btnAdminOrderView.setOpaque(true);
							btnAdminOrderView.setFocusable(false);
							btnAdminOrderView.setBorderPainted(false);
							btnAdminOrderView.setFocusPainted(false);

							// admin logout buttons
							btnAdminLogout = new JButton("Sesion");
							btnAdminLogout.setBounds(0, SCREEN_HEIGHT-100, 150, 50);
							btnAdminLogout.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));
							btnAdminLogout.setForeground(Color.WHITE);
							btnAdminLogout.setBackground(Color.RED);
							btnAdminLogout.setOpaque(true);
							btnAdminLogout.setFocusable(false);
							btnAdminLogout.setBorderPainted(false);
							btnAdminLogout.setFocusPainted(false);
							
							// admin panel
							adminPanel = new JPanel();
							adminPanel.setBackground(Color.WHITE);
							adminPanel.setLayout(null);
							adminPanel.add(labelAdminMarketHeader);
							adminPanel.add(btnAdminControl);
							adminPanel.add(btnAdminMarket);
							adminPanel.add(btnAdminViewOrders);
							adminPanel.add(btnAdminLogout);
							adminPanel.add(labelAdminMarketItemIDHeader);
							adminPanel.add(labelAdminMarketItemNameHeader);
							adminPanel.add(labelAdminMarketPriceHeader);
							adminPanel.add(labelAdminMarketAddItemName);
							adminPanel.add(labelAdminMarketAddPrice);
							adminPanel.add(textfieldAdminMarketAddItemName);
							adminPanel.add(textfieldAdminMarketAddPrice);
							adminPanel.add(btnAdminMarketAdditem);
							adminPanel.add(btnAdminMarketDelete);

							for(int i=0; i<=items.newItemID; i++){
								checkboxAdminMarket[i] = new JCheckBox();
								checkboxAdminMarket[i].setBounds(160, (200+30*(i+1)), 30, 30);
								checkboxAdminMarket[i].setBackground(Color.WHITE);
								checkboxAdminMarket[i].setFocusable(false);
								
								labelAdminMarketItemID[i] = new JLabel(String.valueOf(i));
								labelAdminMarketItemID[i].setBounds(200, (200+30*(i+1)), 100, 30);
								labelAdminMarketItemID[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

								labelAdminMarketItemName[i] = new JLabel(items.itemName[i]);
								labelAdminMarketItemName[i].setBounds(300, (200+30*(i+1)), 300, 30);
								labelAdminMarketItemName[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

								labelAdminMarketPrice[i] = new JLabel(String.valueOf(items.price[i]));
								labelAdminMarketPrice[i].setBounds(600, (200+30*(i+1)), 100, 30);
								labelAdminMarketPrice[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

								adminPanel.add(checkboxAdminMarket[i]);
								adminPanel.add(labelAdminMarketItemID[i]);
								adminPanel.add(labelAdminMarketItemName[i]);
								adminPanel.add(labelAdminMarketPrice[i]);
							}
							
							// admin control panel
							adminControlPanel = new JPanel();
							adminControlPanel.setBackground(Color.WHITE);
							adminControlPanel.setLayout(null);
							adminControlPanel.add(labelAdminControlHeader);
							adminControlPanel.add(labelAdminControlUserIDHeader);
							adminControlPanel.add(labelAdminControlUsernameHeader);
							adminControlPanel.add(labelAdminControlMobileNoHeader);
							adminControlPanel.add(btnAdminControlDelete);

							for(int i=0; i<=users.newUserID; i++){
								checkboxAdminControl[i] = new JCheckBox();
								checkboxAdminControl[i].setBounds(160, (150+30*(i+1)), 30, 30);
								checkboxAdminControl[i].setBackground(Color.WHITE);
								checkboxAdminControl[i].setFocusable(false);

								labelAdminControlUserID[i] = new JLabel(String.valueOf(i));
								labelAdminControlUserID[i].setBounds(200, (150+30*(i+1)), 100, 30);
								labelAdminControlUserID[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

								labelAdminControlUsername[i] = new JLabel(users.username[i]);
								labelAdminControlUsername[i].setBounds(300, (150+30*(i+1)), 300, 30);
								labelAdminControlUsername[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

								labelAdminControlMobileNo[i] = new JLabel(users.mobileNo[i]);
								labelAdminControlMobileNo[i].setBounds(600, (150+30*(i+1)), 300, 30);
								labelAdminControlMobileNo[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

								adminControlPanel.add(checkboxAdminControl[i]);
								adminControlPanel.add(labelAdminControlUserID[i]);
								adminControlPanel.add(labelAdminControlUsername[i]);
								adminControlPanel.add(labelAdminControlMobileNo[i]);

							}

							// admin order panel
							adminViewOrdersPanel = new JPanel();
							adminViewOrdersPanel.setBackground(Color.WHITE);
							adminViewOrdersPanel.setLayout(null);
							adminViewOrdersPanel.add(labelAdminOrderIDHeader);
							adminViewOrdersPanel.add(labelAdminOrderDateHeader);
							adminViewOrdersPanel.add(labelAdminOrderUsernameHeader);
							adminViewOrdersPanel.add(labelAdminOrderTotalPriceHeader);
							adminViewOrdersPanel.add(btnAdminOrderView);

							for(int i=0, j=orders.newOrderID; j>=0; j--){
								checkboxAdminOrders[i] = new JCheckBox();
								checkboxAdminOrders[i].setBounds(160, (150+30*(j+1)), 30, 30);
								checkboxAdminOrders[i].setBackground(Color.WHITE);
								checkboxAdminOrders[i].setFocusable(false);
	
								labelAdminOrderID[i] = new JLabel(String.valueOf(j));
								labelAdminOrderID[i].setBounds(200, (150+30*(i+1)), 100, 30);
								labelAdminOrderID[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
	
								labelAdminOrderDate[i] = new JLabel(orders.date[j]);
								labelAdminOrderDate[i].setBounds(300, (150+30*(i+1)), 300, 30);
								labelAdminOrderDate[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
	
								labelAdminOrderUsername[i] = new JLabel(orders.username[j]);
								labelAdminOrderUsername[i].setBounds(600, (150+30*(i+1)), 300, 30);
								labelAdminOrderUsername[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
	
								labelAdminOrderTotalPrice[i] = new JLabel(String.valueOf(orders.totalPrice[j]));
								labelAdminOrderTotalPrice[i].setBounds(800, (150+30*(i+1)), 100, 30);
								labelAdminOrderTotalPrice[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
	
								adminViewOrdersPanel.add(checkboxAdminOrders[i]);
								adminViewOrdersPanel.add(labelAdminOrderID[i]);
								adminViewOrdersPanel.add(labelAdminOrderDate[i]);
								adminViewOrdersPanel.add(labelAdminOrderUsername[i]);
								adminViewOrdersPanel.add(labelAdminOrderTotalPrice[i]);
								i++;
							}

							// refresh panel
							JPanel tempPanel = new JPanel();
							tempPanel.setLayout(null);

							// action admin control
							btnAdminControl.addActionListener(new ActionListener(){
								@Override
								public void actionPerformed(ActionEvent arg0) {
									System.out.println("Panel control, Admin");
									btnAdminControl.setEnabled(false);
									btnAdminMarket.setEnabled(true);
									btnAdminViewOrders.setEnabled(true);

									adminControlPanel.add(btnAdminControl);
									adminControlPanel.add(btnAdminMarket);
									adminControlPanel.add(btnAdminViewOrders);
									adminControlPanel.add(btnAdminLogout);
									
									
									frame.setContentPane(adminControlPanel);
									frame.validate();
								}
							});

							btnAdminControlDelete.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent arg0) {
									for(int i=0; i<=users.newUserID; i++){
										if(checkboxAdminControl[i].isSelected()){
											for(int k=0; k<=users.newUserID; k++){
												tempPanel.add(checkboxAdminControl[k]);
												tempPanel.add(labelAdminControlUserID[k]);
												tempPanel.add(labelAdminControlUsername[k]);
												tempPanel.add(labelAdminControlMobileNo[k]);
											}

											System.out.println("deleting item: " + i + " " + users.username[i] + " " + users.mobileNo[i]);
											users.removeUser(i);

											for(int k=0; k<=users.newUserID; k++){
												checkboxAdminControl[k] = new JCheckBox();
												checkboxAdminControl[k].setBounds(160, (150+30*(k+1)), 30, 30);
												checkboxAdminControl[k].setBackground(Color.WHITE);
												checkboxAdminControl[k].setFocusable(false);
		
												labelAdminControlUserID[k] = new JLabel(String.valueOf(k));
												labelAdminControlUserID[k].setBounds(200, (150+30*(k+1)), 100, 30);
												labelAdminControlUserID[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
				
												labelAdminControlUsername[k] = new JLabel(users.username[k]);
												labelAdminControlUsername[k].setBounds(300, (150+30*(k+1)), 300, 30);
												labelAdminControlUsername[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
				
												labelAdminControlMobileNo[k] = new JLabel(String.valueOf(users.mobileNo[k]));
												labelAdminControlMobileNo[k].setBounds(600, (150+30*(k+1)), 300, 30);
												labelAdminControlMobileNo[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
		
												adminControlPanel.add(checkboxAdminControl[k]);
												adminControlPanel.add(labelAdminControlUserID[k]);
												adminControlPanel.add(labelAdminControlUsername[k]);
												adminControlPanel.add(labelAdminControlMobileNo[k]);
											}

											break;
										}
									}
									
									try {
										System.out.println("Guardando información de usuario....");
										users.saveUserinfo();
										users = new Users();
									} catch (Exception e) {
										e.printStackTrace();
									}
									

									frame.setContentPane(adminControlPanel);
									frame.validate();
								}
								
							});

							// action admin market
							btnAdminMarket.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent arg0) {
									System.out.println("Panel Admin, mercado");

									btnAdminMarket.setEnabled(false);
									btnAdminControl.setEnabled(true);
									btnAdminViewOrders.setEnabled(true);

									adminPanel.add(btnAdminControl);
									adminPanel.add(btnAdminMarket);
									adminPanel.add(btnAdminViewOrders);
									adminPanel.add(btnAdminLogout);

									frame.setContentPane(adminPanel);
									frame.validate();
								}
								
							});

							btnAdminMarketAdditem.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent arg0) {
									try{
										String itemName = textfieldAdminMarketAddItemName.getText();
										double price = Double.valueOf(textfieldAdminMarketAddPrice.getText());

										String arrayItemName[] = itemName.split(" ");
										itemName = String.join("_", arrayItemName);
								
										for(int i=0; i<=items.newItemID; i++){
											tempPanel.add(checkboxAdminMarket[i]);
											tempPanel.add(labelAdminMarketItemID[i]);
											tempPanel.add(labelAdminMarketItemName[i]);
											tempPanel.add(labelAdminMarketPrice[i]);
										}

										items.createItem(itemName, price);
										System.out.println(items);

										for(int i=0; i<=items.newItemID; i++){
											checkboxAdminMarket[i] = new JCheckBox();
											checkboxAdminMarket[i].setBounds(160, (200+30*(i+1)), 30, 30);
											checkboxAdminMarket[i].setBackground(Color.WHITE);
											checkboxAdminMarket[i].setFocusable(false);

											labelAdminMarketItemID[i] = new JLabel(String.valueOf(i));
											labelAdminMarketItemID[i].setBounds(200, (200+30*(i+1)), 100, 30);
											labelAdminMarketItemID[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
			
											labelAdminMarketItemName[i] = new JLabel(items.itemName[i]);
											labelAdminMarketItemName[i].setBounds(300, (200+30*(i+1)), 300, 30);
											labelAdminMarketItemName[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
			
											labelAdminMarketPrice[i] = new JLabel(String.valueOf(items.price[i]));
											labelAdminMarketPrice[i].setBounds(600, (200+30*(i+1)), 100, 30);
											labelAdminMarketPrice[i].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

											textfieldAdminMarketAddItemName.setText("");
											textfieldAdminMarketAddPrice.setText("");
			
											adminPanel.add(checkboxAdminMarket[i]);
											adminPanel.add(labelAdminMarketItemID[i]);
											adminPanel.add(labelAdminMarketItemName[i]);
											adminPanel.add(labelAdminMarketPrice[i]);
										}

										try {
											System.out.println("Saving userinfo....");
											users.saveUserinfo();
											users = new Users();
										} catch (Exception e) {
											e.printStackTrace();
										}

										frame.setContentPane(adminPanel);
										frame.validate();
									}catch(Exception e){
										System.out.println(e);
									}
								}							
							});

							btnAdminMarketDelete.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent arg0) {
									for(int i=0; i<=items.newItemID; i++){
										if(checkboxAdminMarket[i].isSelected()){
											for(int k=0; k<=items.newItemID; k++){
												tempPanel.add(checkboxAdminMarket[k]);
												tempPanel.add(labelAdminMarketItemID[k]);
												tempPanel.add(labelAdminMarketItemName[k]);
												tempPanel.add(labelAdminMarketPrice[k]);
											}

											System.out.println("eliminando producto: " + i + " " + items.itemName[i] + " " + items.price[i]);
											items.removeItem(items.itemName[i]);

											try{
												items.saveIteminfo();
												items = new Items();
											}catch(Exception e){
												System.out.println(e);
											}

											for(int k=0; k<=items.newItemID; k++){
												checkboxAdminMarket[k] = new JCheckBox();
												checkboxAdminMarket[k].setBounds(160, (200+30*(k+1)), 30, 30);
												checkboxAdminMarket[k].setBackground(Color.WHITE);
												checkboxAdminMarket[k].setFocusable(false);
		
												labelAdminMarketItemID[k] = new JLabel(String.valueOf(k));
												labelAdminMarketItemID[k].setBounds(200, (200+30*(k+1)), 100, 30);
												labelAdminMarketItemID[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
				
												labelAdminMarketItemName[k] = new JLabel(items.itemName[k]);
												labelAdminMarketItemName[k].setBounds(300, (200+30*(k+1)), 300, 30);
												labelAdminMarketItemName[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
				
												labelAdminMarketPrice[k] = new JLabel(String.valueOf(items.price[k]));
												labelAdminMarketPrice[k].setBounds(600, (200+30*(k+1)), 100, 30);
												labelAdminMarketPrice[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));
		
												textfieldAdminMarketAddItemName.setText("");
												textfieldAdminMarketAddPrice.setText("");
				
												adminPanel.add(checkboxAdminMarket[k]);
												adminPanel.add(labelAdminMarketItemID[k]);
												adminPanel.add(labelAdminMarketItemName[k]);
												adminPanel.add(labelAdminMarketPrice[k]);
											}

											break;
										}
									}

									try {
										System.out.println("Guardando información del producto....");
										items.saveIteminfo();
										items = new Items();
									} catch (Exception e) {
										e.printStackTrace();
									}
									
									frame.setContentPane(adminPanel);
									frame.validate();
								}
								
							});

							// action admin orders
							btnAdminViewOrders.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent arg0) {
									System.out.println("Vista de pedido, Admin");

									btnAdminMarket.setEnabled(true);
									btnAdminControl.setEnabled(true);
									btnAdminViewOrders.setEnabled(false);

									adminViewOrdersPanel.add(labelAdminViewOrdersHeader);
									adminViewOrdersPanel.add(btnAdminControl);
									adminViewOrdersPanel.add(btnAdminMarket);
									adminViewOrdersPanel.add(btnAdminViewOrders);
									adminViewOrdersPanel.add(btnAdminLogout);

									frame.setContentPane(adminViewOrdersPanel);
									frame.validate();
								}
								
							});

							btnAdminOrderView.addActionListener(new ActionListener(){

								@Override
								public void actionPerformed(ActionEvent arg0) {
									for(int i=0; i<=orders.newOrderID; i++){
										if(checkboxAdminOrders[i].isSelected()){
											JFrame frameViewOrder = new JFrame();

											JLabel labelDate = new JLabel("Date: " + orders.date[i]);
											labelDate.setBounds(100, 50, 400, 50);
											labelDate.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER2_SIZE));
											
											JLabel labelUsername = new JLabel("Username: " + orders.username[i]);
											labelUsername.setBounds(100, 100, 400, 50);
											labelUsername.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_HEADER2_SIZE));

											JLabel labelItemIDHeader = new JLabel("Item ID");
											labelItemIDHeader.setBounds(100, 150, 100, 30);
											labelItemIDHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

											JLabel labelItemNameHeader = new JLabel("Item Name");
											labelItemNameHeader.setBounds(200, 150, 300, 30);
											labelItemNameHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

											JLabel labelPricePerQuantityHeader = new JLabel("Price/Quantity");
											labelPricePerQuantityHeader.setBounds(500, 150, 100, 30);
											labelPricePerQuantityHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

											JLabel labelQuantityHeader = new JLabel("Quantity");
											labelQuantityHeader.setBounds(700, 150, 100, 30);
											labelQuantityHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

											JLabel labelPriceHeader = new JLabel("Price");
											labelPriceHeader.setBounds(800, 150, 100, 30);
											labelPriceHeader.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

											JLabel[] labelItemID = new JLabel[arraySize];
											JLabel[] labelItemName = new JLabel[arraySize];
											JLabel[] labelItemPricePerQuantity = new JLabel[arraySize];
											JLabel[] labelItemQuantity = new JLabel[arraySize];
											JLabel[] labelItemPrice = new JLabel[arraySize];

											JLabel labelTotalPrice = new JLabel("Total Price: " + orders.totalPrice[i]);
											labelTotalPrice.setBounds(700, SCREEN_HEIGHT-100, 300, 30);
											labelTotalPrice.setFont(new Font(FONT_DEFAULT, Font.BOLD, FONT_DEFAULT_SIZE));

											String[] arrayItemsName = orders.itemsName[i].split("-");
											String[] arrayItemsPricePerQuantity = orders.itemsPricePerQuantity[i].split("-");
											String[] arrayItemsQuantity = orders.itemsQuantity[i].split("-");

											// panel
											JPanel viewOrderPanel = new JPanel();
											viewOrderPanel.setBackground(Color.WHITE);
											viewOrderPanel.setLayout(null);	
											viewOrderPanel.add(labelDate);
											viewOrderPanel.add(labelUsername);
											viewOrderPanel.add(labelTotalPrice);
											viewOrderPanel.add(labelPriceHeader);
											viewOrderPanel.add(labelQuantityHeader);
											viewOrderPanel.add(labelPricePerQuantityHeader);
											viewOrderPanel.add(labelItemNameHeader);
											viewOrderPanel.add(labelItemIDHeader);

											try{
												for(int k=0; k<arrayItemsName.length; k++){
													labelItemID[k] = new JLabel(String.valueOf(k));
													labelItemID[k].setBounds(100, 150+30*(k+1), 100, 30);
													labelItemID[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

													System.out.println(arrayItemsName[k] + " " + arrayItemsPricePerQuantity[k] + "-" + arrayItemsQuantity[k]);

													labelItemName[k] = new JLabel(arrayItemsName[k]);
													labelItemName[k].setBounds(200, 150+30*(k+1), 300, 30);
													labelItemName[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

													labelItemPricePerQuantity[k] = new JLabel(arrayItemsPricePerQuantity[k]);
													labelItemPricePerQuantity[k].setBounds(500, 150+30*(k+1), 100, 30);
													labelItemPricePerQuantity[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

													labelItemQuantity[k] = new JLabel(arrayItemsQuantity[k]);
													labelItemQuantity[k].setBounds(700, 150+30*(k+1), 100, 30);
													labelItemQuantity[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

													labelItemPrice[k] = new JLabel(String.valueOf(Double.valueOf(arrayItemsPricePerQuantity[k]) * Double.valueOf(arrayItemsQuantity[k])));
													labelItemPrice[k].setBounds(800, 150+30*(k+1), 100, 30);
													labelItemPrice[k].setFont(new Font(FONT_DEFAULT, Font.PLAIN, FONT_DEFAULT_SIZE));

				
													viewOrderPanel.add(labelItemID[k]);
													viewOrderPanel.add(labelItemName[k]);
													viewOrderPanel.add(labelItemPricePerQuantity[k]);
													viewOrderPanel.add(labelItemQuantity[k]);
													viewOrderPanel.add(labelItemPrice[k]);
												}
											}catch(Exception e){
												System.out.println(e);
											}

											// frame
											frameViewOrder.setContentPane(viewOrderPanel);
											frameViewOrder.setTitle(orders.date[i] + " " + orders.username[i]);
											frameViewOrder.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
											frameViewOrder.setResizable(false);
											frameViewOrder.setLocationRelativeTo(null);
											frameViewOrder.setVisible(true);
											frameViewOrder.setLayout(null);
											break;
										}
									}
								}
								
							});

							// action admin logout
							btnAdminLogout.addActionListener(new ActionListener(){
			
								@Override
								public void actionPerformed(ActionEvent arg0) {
									System.out.println("Admin Logout attempt");
									int answer = JOptionPane.showConfirmDialog(null, "Realmente quieres salir de esta sesion?", "Confirmado", JOptionPane.YES_NO_OPTION);
									if(answer == 0){
										System.out.println("Saliendo de la sesion, Admin ...");
										frame.setContentPane(adminLoginPanel);
									}
								}
								
							});							
							
							// set content
							frame.setContentPane(adminPanel);
							frame.validate();	
						}
			
					}
					
				});

				btnAdminUser.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// set content
						frame.setContentPane(userLoginPanel);
						frame.validate();
					}
					
				});

				// panel
				adminLoginPanel = new JPanel();
				adminLoginPanel.setBackground(Color.WHITE);
				adminLoginPanel.setLayout(null);
				adminLoginPanel.add(labelAdminLogin);
				adminLoginPanel.add(labelAdminPassword);
				adminLoginPanel.add(passwordFieldAdmin);
				adminLoginPanel.add(btnAdminLoginAtttempt);
				adminLoginPanel.add(btnAdminUser);

				// set content
				frame.setContentPane(adminLoginPanel);
				frame.validate();
			}
			
		});

		// saves everything to files
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				// System.out.println("Window closing listener");
				try {
					System.out.println("Guardando informacion de usuario....");
					users.saveUserinfo();
					System.out.println("Guardando informacion de Producto....");
					items.saveIteminfo();
					System.out.println("Guardando informacion de Pedido....");
					orders.saveOrderInfo();;
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		
		// frame
		frame.setTitle(FRAME_TITLE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(null);
	}
}
