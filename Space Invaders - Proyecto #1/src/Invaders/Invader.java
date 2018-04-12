package Invaders;

import javafx.scene.image.ImageView;

/**
 * Clase que representa un Invasor
 *
 * @author Rubsalas
 * @version 1.1
 * @since 14/03/18
 */
public class Invader extends Enemy{
	
	/**
	 * Constructor para crear un Invader con hits simple, igual a 1
	 * 
	 * @param name - Nombre del Enemy
	 * @param image - Localizacion de imagen
	 * @param x - Posicion en X
	 * @param y - Posicion en Y
	 */
	public Invader(String name, double x, double y, ImageView image){
		super(name, x, y, image);
	}

	/**
	 * Constructor para crear un Invader con hits diferente de 1
	 * 
	 * @param name - Nombre del Enemy
	 * @param image - Localizacion de imagen
	 * @param x - Posicion en X
	 * @param y - Posicion en Y
	 * @param h - Cantidad de hits necesarios para destruir
	 */
	public Invader(String name, double x, double y, int hits, ImageView image){
		super(name, x, y, hits, image);
	}
	
}
