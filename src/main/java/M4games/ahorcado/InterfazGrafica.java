package M4games.ahorcado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;

public class InterfazGrafica extends JFrame {

	private JPanel contentPane;
	private GameStatus estadoJuego = new GameStatus();
	
	public InterfazGrafica() {


		//Image[] imagenAhorcado = new Image[10];
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Menú");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 76, 37);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Teclado");
		lblNewLabel_1.setBounds(10, 301, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Palabra secreta");
		lblNewLabel_2.setBounds(106, 213, 76, 13);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Iniciar juego");
		btnNewButton.setBounds(10, 57, 277, 36);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Resolver");
		btnNewButton_1.setBounds(10, 103, 277, 42);
		contentPane.add(btnNewButton_1);
		JTextArea txtrHola = new JTextArea();
		txtrHola.setEditable(false);
		txtrHola.setFont(txtrHola.getFont().deriveFont(txtrHola.getFont().getSize() + 12f));
		txtrHola.setText(estadoJuego.getWordWriting());
		txtrHola.setBackground(new Color(0, 0, 0));
		txtrHola.setForeground(new Color(255, 255, 255));
		txtrHola.setBounds(10, 236, 277, 38);
		contentPane.add(txtrHola);

		/*JLabel picLabel = new JLabel(new ImageIcon(imagenAhorcado[estadoJuego.getIntentos()]));
		picLabel.setBackground(new Color(255, 255, 255));
		picLabel.setBounds(305, 57, 263, 480);
		contentPane.add(picLabel);*/

		JLabel vida = new JLabel("X X X X X");
		vida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vida.setBounds(106, 167, 94, 25);
		contentPane.add(vida);
		
		JLabel botonIntentos = new JLabel("Intentos: 10");
		botonIntentos.setBounds(179, 550, 84, 13);
		contentPane.add(botonIntentos);
		
		//Evento que muestra las 5 vidas en forma de X's y muestra la palabra y nuestro progreso en ella.
		//Lo usamos para el botón "Iniciar juego".
		
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				estadoJuego = new GameStatus();
				vida.setText("X X X X X");
				txtrHola.setText(estadoJuego.getWordWriting());
			}
		});

		//For con el que crearemos todos los botones que contienen las letras y a partir de los cuales el código comenzará
		
		for (int i = 0; i < 27; i++) {

			int positionx = i % 5;
			int positiony = i / 5;

			JButton btn;

			if (i < 14) {

				char letra = (char) (i + 65);

				btn = new JButton("" + letra);
				
			} else if (i == 14) {

				//Usamos \u00d1 para la letra Ñ
				
				btn = new JButton("" + '\u00d1');

			} else {

				char letra = (char) (i + 64);
				btn = new JButton("" + letra);
			}

			//Introducimos la posición de todos los botones que introducen las letras
			
			btn.setBounds(20 + (positionx * 43), 324 + (positiony * 43), 46, 22);
			contentPane.add(btn);
			
			//Evento que nos comprueba si adivinamos las letras.
			
			btn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					int rejugar = 0;

					//Este if te comprueba la coincidencia entre la letra del botón pulsado y el contenido de la palabra
					
					if (estadoJuego.hayLetra(btn.getText())) {

						txtrHola.setText(estadoJuego.getWordWriting());

					//En caso de no estar dicha letra entra en el else y ocurren varias cosas:
						
					} else {

						//Bajamos en 1 el número de intentos disponibles.
						
						estadoJuego.setIntentos();
						botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());

						//Si los intentos de la palabra actual llegan a 0...
						
						if (estadoJuego.getIntentos() == 0) {
							
								int vidas = estadoJuego.getLives();
								
						//Bajamos la vida en 1.
								
								estadoJuego.setLives();
								System.out.println("Has perdido una vida, comienzas con una nueva palabra");
								
						//Nos genera una nueva palabra
								
								estadoJuego.setWordToGuess();
								
						//Y muestra las casillas de la palabra generada.
								
								txtrHola.setText(estadoJuego.getWordWriting());
								
						//Agarramos las vidas que nos quedan y volvemos a mostrar un número de X como de vidas tengamos.
								
								vidas = estadoJuego.getLives();
								
								String stringTexto = vida.getText();
								
								vida.setText(stringTexto.substring(0, vidas * 2));
								
						//Devolvemos los intentos a 10 y volvemos a mostrarlo por pantalla.
								
								estadoJuego.resetIntentos();
								botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());
								
						//Al perder todas las vidas perderemos la partida y se nos pedirá si queremos volver a jugar
								
							if (vidas==0) {
								
								JOptionPane.showMessageDialog(null, "Has perdido la partida", "Partida perdida",
										JOptionPane.ERROR_MESSAGE);
								rejugar = JOptionPane.showConfirmDialog(null,"¿Quieres volver a jugar?");
								
								//En caso de elegir Sí nos reinicia el juego poniendo nuestras vidas a 5.
								
									if(rejugar==JOptionPane.YES_OPTION) {
										estadoJuego = new GameStatus();
										vida.setText("X X X X X");
										
								//Al elegir No o Cancelar saldremos del juego.
										
									}else{
										System.exit(0);
									}
								
							}
						}

					}

				}

			});

		}

		/*
		 * JList list = new JList(estadoJuego.getWords()); list.setSelectedIndex(2);
		 * list.setToolTipText(""); list.setBounds(10, 379, 213, 69);
		 * contentPane.add(list);
		 */

	}
}
