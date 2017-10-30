package swing;

import java.awt.GraphicsEnvironment;

public class GetAllFonts {

	public static void main(String[] args) {
		GraphicsEnvironment eq = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = eq.getAvailableFontFamilyNames();
				for (int i = 0; i < fontNames.length; i++) {
					System.out.println(fontNames[i]);
					
				}

	}

}
