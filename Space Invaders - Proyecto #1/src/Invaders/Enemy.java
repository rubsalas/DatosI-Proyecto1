package Invaders;

import javafx.scene.image.ImageView;

//import game.InGame;

/**
 * Representa a los Enemigos que saldrán a destruir a la nave del jugador.
 * 
 * @author Rubsalas
 * @version 1.1
 * @since 11/03/18
 */
public class Enemy {
	
	private String name; //nombre del Enemy
	private ImageView image; //String de localizacion de imagen
	private double posX; //posicion en X
	private double posY; //posicion en Y
	private int hits; //cantidad de disparos necesarios para que se destruya
	private Enemy next; //proximo Enemy en lista
	private Enemy prev; //anterior Enemy en lista
	
	/**
	 * Constructor para crear Enemigo con hits simple, igual a 1
	 * 
	 * @param name - nombre del Enemy
	 * @param image - Localizacion de imagen
	 * @param x - Posicion en X
	 * @param y - Posicion en Y
	 */
	public Enemy(String name, double x, double y, ImageView image){
		this.name = name;
		this.image = image;
		this.posX = x;
		this.posY = y;
		this.hits = 1;
	}
	
	/**
	 * Constructor para crear Enemigo con hits diferente de 1
	 * 
	 * @param name - nombre del Enemy
	 * @param image - Localizacion de imagen
	 * @param x - Posicion en X
	 * @param y - Posicion en Y
	 * @param h - Cantidad de hits necesarios para destruir
	 */
	public Enemy(String name, double x, double y, int hits, ImageView image){
		this.name = name;
		this.image = image;
		this.posX = x;
		this.posY = y;
		this.hits = hits;
	}

	
	/**
	 * Retorna el nombre del Enemy.
	 * @return name - nombre
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Establecen el nombre del Enemy.
	 * @param image - nombre 
	 */
	public void setName(String name){
		this.name = name;		
	}
	
	/**
	 * Retorna el nombre de la imagen del Enemy.
	 * @return image - nombre de imagen
	 */
	public ImageView getImage(){
		return this.image;
	}
	
	/**
	 * Establece el nombre de la imagen del Enemy.
	 * @param image - nombre de la imagen
	 */
	public void setImage(ImageView image){
		this.image = image;		
	}
	
	/**
	 * Retorna la posición en x del Enemy.
	 * @return posX - coordenada x
	 */
	public double getPosX(){
		return this.posX;
	}
	
	/**
	 * Establece la posición en y del Enemy.
	 * @param x - coordenada x
	 */
	public void setPosX(double x){
		this.posX = x;		
	}
	
	/**
	 * Retorna la posición en y del Enemy.
	 * @return posY - coordenada y
	 */
	public double getPosY(){
		return this.posY;
	}
	
	/**
	 * Establece la posición en y del Enemy.
	 * @param y - coordenada y
	 */
	public void setPosY(double y){
		this.posY = y;
	}
	
	/**
	 * Retorna la cantidad de hits necesaria para destruir al Enemy.
	 * @return hits - cantidad de hits
	 */
	public int getHits(){
		return this.hits;
	}
	
	/**
	 * Establece la cantidad de hits necesaria para destruir al Enemy.
	 * @param hits - cantidad de hits
	 */
	public void setHits(int hits){
		this.hits = hits;
	}
	
	/**
	 * Retorna el Enemy siguiente.
	 * @return next - Enemy siguiente
	 */
	public Enemy getNext(){
		return this.next;
	}
	
	/**
	 * Establece al Enemy siguiente.
	 * @param nxt - Enemy siguiente.
	 */
	public void setNext(Enemy nxt){
		this.next = nxt;
	}
	
	/**
	 * Retorna el Enemy previo.
	 * @return prev - Enemy previo
	 */
	public Enemy getPrev(){
		return this.prev;
	}
	
	/**
	 * Establece al Enemy previo.
	 * @param prv - Enemy previo.
	 */
	public void setPrev(Enemy prv){
		this.prev = prv;
	}
	
	public void move(){
		//switch con cases de momvimientos de diferentes clases de hileras
	}
	
	public void shoot(){
//		if ( SHIP WAS HIT){
//			InGame.getPlayer1().getShip().destroy();
//		} else {
//			
//		}
	}
}