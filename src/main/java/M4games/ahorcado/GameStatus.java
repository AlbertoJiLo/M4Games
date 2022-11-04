package M4games.ahorcado;

import java.util.ArrayList;
import java.util.Arrays;

public class GameStatus {

	private boolean resolver;
	private int victorias;
	private int lives;
	private int intentos;
	private String wordToGuess;
	private String wordWriting;
	private String imagesFormat = ".png";
	// Lista de palabras a adivinar
	private ArrayList <String> words = new ArrayList<String>(Arrays.asList("elefante", "criatura", "lapiz", "fresa", "rascacielos", "mariposa", "abecedario",
			"hongo", "collarin", "trapecista", "ara\u00d1a"));

	//Constructor por defecto.
	
	public GameStatus() {

		victorias=0;
		intentos = 10;
		lives = 5;
		resolver = true;
		setWordToGuess();

	}
	
	//Constructor para mantener el diccionario que hemos añadido a través del menú.
	
	public GameStatus(ArrayList<String> arrayActual) {

		words=arrayActual;
		victorias=0;
		intentos = 10;
		lives = 5;
		resolver = true;
		setWordToGuess();
		
	}

	
	//Creamos un método que vuelva a crear una palabra a voluntad como hicimos anteriormente
	public void setWordToGuess() {
		int num = (int) Math.floor(Math.random() * (words.size()));
		wordToGuess = words.get(num);
		wordWriting = "";
		for (int i = 0; i < wordToGuess.length(); i++) {

			wordWriting += "_ ";

		}
	}

	//Distintos setters y getters
	
	public ArrayList<String> getWords() {
		return words;
	}

	//Método para añadir palabras a las posibilidades.
	
	public void addWord(String palabra) {
		words.add(palabra);
	}

	public int getLives() {

		return lives;

	}

	public int getIntentos() {

		return intentos;

	}

	public void setLives() {

		this.lives--;

	}

	public void setIntentos() {

		this.intentos--;

	}

	public void setVictorias() {
		this.victorias++;
	}



	public int getVictorias() {
		return victorias;
	}

	
	
	//Método para reiniciar los intentos.
	public void resetIntentos() {

		intentos = 10;

	}
	
	public String getImagesFormat() {
		return imagesFormat;
	}

	public boolean isResolver() {
		return resolver;
	}

	public void setResolver() {
		this.resolver = false;
	}

	public String getWordWriting() {

		return wordWriting;

	}

	// Método para mostrar la letra adivinada.
	
	public void setWordWriting(char letra) {

		//En wordWrittingSave tendremos el progreso de la palabra actual.
		
		String wordWritingSave = this.getWordWriting();
		wordWriting = "";

		//For que comprobará cada caracter para en caso de coincidir dicha letra mostrarla.
		
		for (int i = 0; i < wordToGuess.length(); i++) {

			if (wordToGuess.toUpperCase().charAt(i) == letra) {

				wordWriting += letra + " ";

			} else {

				wordWriting += wordWritingSave.charAt(i * 2) + " ";

			}

		}

	}

	public String getWordToGuess() {

		return wordToGuess;

	}

	//Método que comprueba si la letra está en la palabra que además accede al método que cambia la _ por la letra pertinente.
	
	public boolean hayLetra(String string) {

		char letra = string.charAt(0);

		if (wordToGuess.toUpperCase().indexOf(letra) != -1) {

			setWordWriting(letra);

			return true;

		} else {

			return false;

		}

	}

	
	//Método que cuenta como solucionada la palabra al no quedar "_", es decir, está adivinada.
	
	public boolean isPalabraGuessed() {

		if (wordWriting.indexOf("_") != -1) {

			return false;

		} else {

			return true;

		}

	}
	
	//Método para crear la cadena de texto que representa las vidas.
	
	public String textVidas() {

        String text = "";

        for (int i = 0; i < lives; i++) {

            text += "X ";

        }

        return text;

    }
}
