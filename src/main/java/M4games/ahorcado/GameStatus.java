package M4games.ahorcado;

public class GameStatus {

	private boolean isPlaying = true;
	private int lives;
	private int intentos;
	private String wordToGuess;
	private String wordWriting;
	private String[] images = { "img1.png", "img0.png" };
	// Lista de palabras a adivinar
	final private String[] words = { "elefant", "criatura", "llapis", "maduixa", "rascacels", "papallona", "abecedari",
			"fong", "collaret", "trapezista" };

	public GameStatus() {

		//Elegimos con un random la palabra que tendremos que adivinar
		int num = (int) Math.floor(Math.random() * (words.length));
		intentos = 10;
		lives = 5;
		wordToGuess = words[num];
		wordWriting = "";
		//Y mostramos barra baja en lugar de las letras que contiene la palabra
		for (int i = 0; i < wordToGuess.length(); i++) {

			wordWriting += "_ ";

		}

	}

	//Creamos un método que vuelva a crear una palabra a voluntad como hicimos anteriormente
	public void setWordToGuess() {
		int num = (int) Math.floor(Math.random() * (words.length));
		wordToGuess = words[num];
		wordWriting = "";
		for (int i = 0; i < wordToGuess.length(); i++) {

			wordWriting += "_ ";

		}
	}

	//Distintos setters y getters
	
	public String[] getWords() {
		return words;
	}

	public boolean isPlaying() {

		return isPlaying;

	}

	public void setPlaying(boolean isPlaying) {

		this.isPlaying = isPlaying;

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

	//Método para reiniciar los intentos al iniciar palabra nueva.
	public void resetIntentos() {

		intentos = 10;

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

	public boolean isPalabraGuessed() {

		if (wordWriting.indexOf("") != -1) {

			return false;

		} else {

			return true;

		}

	}
}
