package Invaders;

import javafx.scene.image.ImageView;

/**
 * Clase que representa un Jefe
 *
 * @author Rubsalas
 * @version 1.1
 * @since 14/03/18
 */
public class Boss extends Enemy{
	
	/**
	 * Constructor para crear Jefe con hits diferente de 1
	 * 
	 * @param image - Localizacion de imagen
	 * @param x - Posicion en X
	 * @param y - Posicion en Y
	 * @param h - Cantidad de hits necesarios para destruir
	 */
	public Boss(double x, double y, int hits, ImageView image){
		//Agrega como name = "boss"
		super("boss", x, y, hits, image);
	}
	
}
