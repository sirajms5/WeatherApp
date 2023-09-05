/**
 * The {@code App} class is the starting point of the program
 * 
 * @author Siraj Mohammed Saleem
 * @version 1.0
 * @see Gui
 * @since 1.0
 */

public class App {

	/**
	 * 
	 * method main will create instance of Gui class when the program is launched
	 * 
	 * @param args command-line arguments passed to the program
	 */
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.setNorthPanel();
		gui.setSouthPanel();
		gui.generateGui();
	}

}
