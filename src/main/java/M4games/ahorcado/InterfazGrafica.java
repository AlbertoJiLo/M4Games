package M4games.ahorcado;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class InterfazGrafica extends JFrame {

	private JPanel contentPane;
	private GameStatus estadoJuego = new GameStatus();
	
	public InterfazGrafica() {
		
		setTitle("Ahorcado");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 640);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem botonMenuNuevojuego = new JMenuItem("Nuevo juego");
		mnNewMenu.add(botonMenuNuevojuego);
		
		JMenuItem botonMenuSalir = new JMenuItem("Salir");
		mnNewMenu.add(botonMenuSalir);
		
		JMenu mnNewMenu_1 = new JMenu("Como jugar");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem botonInstrucciones = new JMenuItem("Instrucciones");
		mnNewMenu_1.add(botonInstrucciones);
		
		JMenu mnNewMenu_2 = new JMenu("Acerca de");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem botonAcercade = new JMenuItem("Acerca de");
		mnNewMenu_2.add(botonAcercade);
		
		JMenu mnNewMenu_3 = new JMenu("Diccionario");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem botonAddWord = new JMenuItem("Añadir palabra");
		mnNewMenu_3.add(botonAddWord);
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

		JButton botonResolver = new JButton("Resolver");
		botonResolver.setBackground(new Color(128, 255, 128));
		botonResolver.setBounds(10, 103, 277, 42);
		contentPane.add(botonResolver);
		

		JTextArea txtrHola = new JTextArea();
		txtrHola.setEditable(false);
		txtrHola.setFont(txtrHola.getFont().deriveFont(txtrHola.getFont().getSize() + 12f));
		txtrHola.setText(estadoJuego.getWordWriting());
		txtrHola.setBackground(new Color(0, 0, 0));
		txtrHola.setForeground(new Color(255, 255, 255));
		txtrHola.setBounds(10, 236, 277, 38);
		contentPane.add(txtrHola);



		JLabel vida = new JLabel(estadoJuego.textVidas());
		vida.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vida.setBounds(106, 167, 94, 25);
		contentPane.add(vida);
		
		JLabel botonIntentos = new JLabel("Intentos: 10");
		botonIntentos.setBounds(179, 550, 84, 13);
		contentPane.add(botonIntentos);
		
		JLabel labelVictorias = new JLabel("Victorias: 0");
		labelVictorias.setBounds(203, 26, 84, 13);
		contentPane.add(labelVictorias);
		
		URL img = this.getClass().getResource("images/10.png");
		
		ImageIcon imagen = new ImageIcon (img);
		
		JLabel picLabel = new JLabel(imagen);
		picLabel.setBackground(new Color(255, 255, 255));
		picLabel.setBounds(305, 57, 263, 480);
		contentPane.add(picLabel);
		
		//Menú Archivo
		//Evento para juego nuevo del menú Archivo
		
		botonMenuNuevojuego.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int rejugar=0;
				rejugar = JOptionPane.showConfirmDialog(null,"¿Estás seguro de que quieres comenzar una partida nueva?");
				
					if(rejugar==JOptionPane.YES_OPTION) {
						estadoJuego = new GameStatus(estadoJuego.getWords());
						vida.setText(estadoJuego.textVidas());
						txtrHola.setText(estadoJuego.getWordWriting());
						labelVictorias.setText("Victorias: "+estadoJuego.getVictorias());
						imagenReload(picLabel);
						botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());
						botonResolver.setBackground(new Color(128, 255, 128));
					}
			}
		});
		
		//Evento para salir desde el menú Archivo
		
		botonMenuSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Evento para mostrar las instrucciones del juego.
		
		botonInstrucciones.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Instrucciones para el ahorcado.\n"
						+ "El jugador decidirá la dificultad. Dependiendo de la que elija tendrás más o menos intentos.\n"
						+ "El jugador clicará en una letra para comprobar si está incluida en la palabra.\n"
						+ "En caso de fallar el ahorcado estará más cerca de morir y tus intentos bajarán.\n"
						+ "Cada vez que el ahorcado muera perderás una vida. Si pierdes 5 pierdes la partida.\n"
						+ "EXTRA: A cambio de gastar una vida puedes auto-adivinar una palabra.");
			}
		});
		
		//Evento para mostrar la información de los alumnos.
		
		botonAcercade.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Este juego ha sido creado por el equipo 5 conformado por:\n"
						+ "Carlos Lafuente\n"
						+ "Alberto Jiménez\n"
						+ "Facundo Silva");
			}
		});
		
		//Evento para añadir palabras al diccionario desde el menú Archivo
		
		botonAddWord.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					String palabraElegida = JOptionPane.showInputDialog("Escribe la palabra que quieres añadir");
					String caracteresPermitidos = "abcdefghijklmn\u00f1opqrstuvwxyz";
					for(int i=0;i<palabraElegida.length();i++) {
						char letra = palabraElegida.toLowerCase().charAt(i);
						if(caracteresPermitidos.indexOf(letra) ==-1){
							throw (new Exception("La palabra que has introducido contiene algun caracter no valido"));
						}
					}
					estadoJuego.addWord(palabraElegida);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
												
			}
		});
				
		
		
		
		//Evento que muestra las 5 vidas en forma de X's y muestra la palabra y nuestro progreso en ella.
		//Lo usamos para el botón "Iniciar juego".
		
		
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int rejugar=0;
				rejugar = JOptionPane.showConfirmDialog(null,"¿Estás seguro de que quieres comenzar una partida nueva?");
				
				//Si decidimos jugar otra partida y pulsamos sí.
				
					if(rejugar==JOptionPane.YES_OPTION) {
						
						//Reseteamos a los valores del constructor por defecto devolviendo las vidas, intentos, victorias y el
						//estado del comodín a su estado original.
						
						estadoJuego = new GameStatus(estadoJuego.getWords());
						
						//Y actualizamos el apartado visual para el jugador. Esto incluye botones, labels, 
						//imagenes y el fondo del comodín
						
						vida.setText(estadoJuego.textVidas());
						txtrHola.setText(estadoJuego.getWordWriting());
						labelVictorias.setText("Victorias: "+estadoJuego.getVictorias());
						imagenReload(picLabel);
						botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());
						botonResolver.setBackground(new Color(128, 255, 128));
					}
			}
		});

		botonResolver.addActionListener(new ActionListener() {
			
			//Evento que maneja el uso del boton Resolver. 
			//Nos informa de lo ocurrido y "apaga" el botón para que no pueda volver a usarse
			
			public void actionPerformed(ActionEvent e) {
				
				//Si el comodín no ha sido usado en esa partida ocurren varias cosas.
				
				if(estadoJuego.isResolver()) {
					
					//Indicamos que el botón resolver ha sido usado.
					
					estadoJuego.setResolver();
					
					//Bajamos la vida en 1.
					
					estadoJuego.setLives();
					
					//Añadimos una victoria.
					
					estadoJuego.setVictorias();
					labelVictorias.setText("Victorias: "+estadoJuego.getVictorias());
					
					//Actualizamos el apartado visual del número de vidas.
					
					vida.setText(estadoJuego.textVidas());
					
					//Informamos al jugador de lo que ha ocurrido.
					
					JOptionPane.showMessageDialog(null, "Has gastado tu comodín y has perdido una vida, la palabra era "+estadoJuego.getWordToGuess());
					
					//Reseteamos tanto la palabra a adivinar como el número de intentos.
					
					estadoJuego.setWordToGuess();
					estadoJuego.resetIntentos();
					
					//Actualizamos el apartado visual de la palabra a adivinar y el número de intentos.
					
					botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());
					txtrHola.setText(estadoJuego.getWordWriting());
					
					//Ponemos el fondo del botón en rojo para indicar que ya ha sido usado
					
					botonResolver.setBackground(new Color(255, 0, 0));
					
					//Reseteamos la imagen del ahorcado.
					
					imagenReload(picLabel);
					
					if(estadoJuego.getVictorias() == 5) {
						JOptionPane.showMessageDialog(null, "Enhorabuena, has ganado el juego");
						int rejugar = JOptionPane.showConfirmDialog(null,"¿Quieres volver a jugar?");
						
						//En caso de elegir Sí nos reinicia el juego poniendo nuestras vidas a 5 y las victorias a 0.
						
							if(rejugar==JOptionPane.YES_OPTION) {
								estadoJuego = new GameStatus(estadoJuego.getWords());
								vida.setText(estadoJuego.textVidas());
								labelVictorias.setText("Victorias: "+estadoJuego.getVictorias());
								
							}else {
								System.exit(0);
							}
					}
					
				//En caso de haber usado el comodín nos lo indica.
					
				}else {
					JOptionPane.showMessageDialog(null, "Ya usaste el comodin, no seas pillin");
				}
				
			}
			
		});
		
		//For con el que crearemos todos los botones que contienen las letras y a partir de los cuales el juego comenzará
		
		
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

			//Introducimos la posición de todos los botones de las letras
			
			btn.setBounds(20 + (positionx * 43), 324 + (positiony * 43), 46, 22);
			contentPane.add(btn);
			
			
			//Evento que nos comprueba si adivinamos las letras.
			
			btn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					int rejugar = 0;

					//Este if te comprueba la coincidencia entre la letra del botón pulsado y el contenido de la palabra
					
					if (estadoJuego.hayLetra(btn.getText())) {

						txtrHola.setText(estadoJuego.getWordWriting());
						
						if(estadoJuego.isPalabraGuessed()) {
							
							/*Al acertar la palabra reseteamos los valores necesarios como los intentos 
							o la palabra a adivinar y añadimos una victoria.*/
							
							//Además actualizamos el apartado visual
							
							estadoJuego.setVictorias();
							labelVictorias.setText("Victorias: "+estadoJuego.getVictorias());
							JOptionPane.showMessageDialog(null, "Has acertado la palabra");
							estadoJuego.setWordToGuess();
							estadoJuego.resetIntentos();
							botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());
							txtrHola.setText(estadoJuego.getWordWriting());
							imagenReload(picLabel);
							
							//En caso de que llevemos 5 victorias indicamos al jugador que ha ganado la partida.
							
							if(estadoJuego.getVictorias() == 5) {
								JOptionPane.showMessageDialog(null, "Enhorabuena, has ganado el juego");
								rejugar = JOptionPane.showConfirmDialog(null,"¿Quieres volver a jugar?");
								
								//En caso de elegir Sí nos reinicia el juego poniendo nuestras vidas a 5 y las victorias a 0.
								
									if(rejugar==JOptionPane.YES_OPTION) {
										estadoJuego = new GameStatus(estadoJuego.getWords());
										vida.setText(estadoJuego.textVidas());
										labelVictorias.setText("Victorias: "+estadoJuego.getVictorias());
										
									}else {
										System.exit(0);
									}
							}
						}
						

					//Suponiendo que la letra elegida no está entra en el else y ocurren varias cosas:
						
					} else {

						//Bajamos en 1 el número de intentos disponibles, lo mostramos por pantalla y cambiamos la imagen.
						
						estadoJuego.setIntentos();
						botonIntentos.setText("Intentos: "+estadoJuego.getIntentos());
						imagenReload(picLabel);
						

						//Si los intentos de la palabra actual llegan a 0...
						
						if (estadoJuego.getIntentos() == 0) {
							
								int vidas = estadoJuego.getLives();
								
						//Bajamos la vida en 1.
								
								estadoJuego.setLives();
								JOptionPane.showMessageDialog(null, "Has perdido una vida, comienzas con una nueva palabra");
								
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
								imagenReload(picLabel);
								
						//Al perder todas las vidas perderemos la partida y se nos pedirá si queremos volver a jugar
								
							if (vidas==0) {
								
								JOptionPane.showMessageDialog(null, "Has perdido la partida", "Partida perdida",
										JOptionPane.ERROR_MESSAGE);
								rejugar = JOptionPane.showConfirmDialog(null,"¿Quieres volver a jugar?");
								
								//En caso de elegir Sí nos reinicia el juego poniendo nuestras vidas a 5.
								
									if(rejugar==JOptionPane.YES_OPTION) {
										estadoJuego = new GameStatus(estadoJuego.getWords());
										vida.setText(estadoJuego.textVidas());
										
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
	}
	
	//Método para cambiar la imagen en el que indicamos el directorio, el nombre de la imagen que depende de los intentos
	//y el formato de la imagen guardado en el propio objeto.
	
	public void imagenReload(JLabel picLabel) {
		
		URL img = this.getClass().getResource("images/"+estadoJuego.getIntentos()+estadoJuego.getImagesFormat());
		ImageIcon imagen = new ImageIcon (img);
		picLabel.setIcon(imagen);
	}
}
