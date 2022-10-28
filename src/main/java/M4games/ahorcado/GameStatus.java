package M4games.ahorcado;

public class GameStatus {
	
	private boolean isPlaying = true;
    private int lives;
    private int intentos;
    private String wordToGuess;
    private String wordWriting;
    private String[] images = {"img1.png", "img0.png"};
    final private String[] words = {"elefant", "criatura", "llapis", "maduixa", "rascacels", "papallona", "abecedari", "fong", "collaret", "trapezista"};

    public GameStatus () {

    	intentos=10;
        int num = (int)Math.floor(Math.random() * (words.length));

        lives = 5;
        wordToGuess = words[num];
        wordWriting="";
        for (int i = 0; i < wordToGuess.length(); i++) {

            wordWriting += "_ ";

        }

    }

    
    
    public void setWordToGuess() {
    	int num = (int)Math.floor(Math.random() * (words.length));
    	wordToGuess = words[num];
    	wordWriting="";
        for (int i = 0; i < wordToGuess.length(); i++) {

            wordWriting += "_ ";

        }
	}



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

    public void resetIntentos() {
    	
		intentos=10;
		
	}

	public String getWordWriting() {

        return wordWriting;

    }

	public void setWordWriting(char letra) {

        String wordWritingSave = this.getWordWriting();
        wordWriting = "";

        for (int i = 0; i < wordToGuess.length(); i++) {

            if (wordToGuess.toUpperCase().charAt(i) == letra) {

                wordWriting += letra + " ";

            } else {

                wordWriting += wordWritingSave.charAt(i*2) + " ";

            }

        }

    }

    public String getWordToGuess() {

        return wordToGuess;

    }

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
