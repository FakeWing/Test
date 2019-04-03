package hotel.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import hotel.controlador.CRUD;
import hotel.modelo.Cliente;

public class RegistroCliente extends JFrame {
	public static JTextField txtRut;
	public static JTextField txtNombre;
	public static JTextField txtApellidoP;
	public static JTextField txtApellidoM;
	public static JTextField txtSexo;
	public static JTextField txtNacionalidad;
	public static JTextField txtFecha;
	public static JDateChooser dateChooser;

	private JPanel contentPane;
	// static Cliente cliente=Cliente.getInstance();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					RegistroCliente frame = new RegistroCliente();
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
	public RegistroCliente() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRegistrar.setBounds(80, 580, 121, 44);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRegistrarActionPerformed(evt);
			}
		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVolver.setBounds(336, 580, 121, 44);
		contentPane.add(btnVolver);
		btnVolver.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnVolverActionPerformed(evt);
			}
		});

		JLabel lblRut = new JLabel("Rut:");
		lblRut.setBounds(100, 139, 46, 14);
		contentPane.add(lblRut);

		txtRut = new JTextField();
		txtRut.setBounds(247, 139, 167, 20);
		contentPane.add(txtRut);
		txtRut.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(247, 178, 167, 20);
		contentPane.add(txtNombre);

		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(100, 178, 64, 14);
		contentPane.add(lblNombres);

		txtApellidoP = new JTextField();
		txtApellidoP.setColumns(10);
		txtApellidoP.setBounds(247, 213, 167, 20);
		contentPane.add(txtApellidoP);

		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno:");
		lblApellidoPaterno.setBounds(100, 213, 101, 14);
		contentPane.add(lblApellidoPaterno);

		txtApellidoM = new JTextField();
		txtApellidoM.setColumns(10);
		txtApellidoM.setBounds(247, 248, 167, 20);
		contentPane.add(txtApellidoM);

		JLabel lblApellidoMaterno = new JLabel("Apellido Materno:");
		lblApellidoMaterno.setBounds(98, 248, 103, 14);
		contentPane.add(lblApellidoMaterno);

		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(247, 283, 167, 20);
		contentPane.add(txtSexo);

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(100, 286, 46, 14);
		contentPane.add(lblSexo);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(98, 322, 121, 14);
		contentPane.add(lblFechaDeNacimiento);

		txtNacionalidad = new JTextField();
		txtNacionalidad.setColumns(10);
		txtNacionalidad.setBounds(247, 357, 167, 20);
		contentPane.add(txtNacionalidad);

		JLabel lblNacionalidad = new JLabel("Nacionalidad:");
		lblNacionalidad.setBounds(100, 357, 82, 14);
		contentPane.add(lblNacionalidad);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(392, 322, 22, 20);
		contentPane.add(dateChooser);

		JButton btnConfirmarFecha = new JButton("Confirmar");
		btnConfirmarFecha.setBounds(424, 318, 103, 23);
		contentPane.add(btnConfirmarFecha);
		btnConfirmarFecha.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConfirmarFechaActionPerformed(evt);
			}
		});

		JButton btnVerificarRut = new JButton("Verificar Rut");
		btnVerificarRut.setBounds(424, 138, 121, 23);
		contentPane.add(btnVerificarRut);

		txtFecha = new JTextField();
		txtFecha.setBounds(247, 319, 135, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		btnVerificarRut.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnVerificarRutActionPerformed(evt);
			}
		});

	}

	protected void btnConfirmarFechaActionPerformed(ActionEvent evt) {
		CRUD.ConfirmarFecha();

	}

	protected void btnVerificarRutActionPerformed(ActionEvent evt) {
		CRUD.VerificarRut();
		CRUD.LlenarDatos(Cliente.getInstance());

	}

	protected void btnRegistrarActionPerformed(ActionEvent evt) {

		CRUD.crearCliente();

	}

	protected void btnVolverActionPerformed(ActionEvent evt) {
		new Menu().setVisible(true);
		dispose();

	}
}
