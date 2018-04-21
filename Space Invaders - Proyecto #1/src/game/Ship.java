package game;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Representa a la nave que usará el jugador.
 * 
 * @author Rubén Salas
 * @version 1.6
 * @since 30/03/18
 */
public class Ship {
	
	double posX = 380.0;
	double posY = 525.0;
	int lives;
	boolean readyToFire, shot = false;

	/**
	 * Constructor
	 */
	public Ship(){
		
	}
	
	/**
	 * Retorna la posición en x de la nave.
	 * @return posX - coordenada x
	 */
	public double getPosX(){
		return this.posX;
	}
	
	/**
	 * Establece la posición en x de la nave.
	 * @param x - coordenada x
	 */
	public void setPosX(int x){
		this.posX = x;
	}
	
	/**
	 * Retorna la posición en y de la nave.
	 * @return posY - coordenada y
	 */
	public double getPosY(){
		return this.posY;
	}
	
	/**
	 * Establece la posición en y de la nave.
	 * @param y - coordenada y
	 */
	public void setPosY(int y){
		this.posY = y;
	}
	
	/**
	 * Retorna la cantidad de vidas restantes de la nave.
	 * @return lives - vidas
	 */
	public int getLives(){
		return this.lives;
	}
	
	/**
	 * Establece la cantidad de vidas restantes de la nave sin exceder a tres.
	 * @param lives
	 */
	public void addLives(int lives){
		if (this.lives < 3 && this.lives > 0){
			this.lives = this.lives + lives;
		}
	}
	
	/**
	 * Hace que la nave se mueva horizontalmete por la pantalla
	 * @param direction - izquierda o derecha
	 */
	public void move(String direction){
		if (direction == "right"){
			this.posX = this.posX + 10;
			if (this.posX >= 755)
				this.posX = 755;
			TranslateTransition trans = new TranslateTransition();
			trans.setDuration(Duration.millis(1)); //
			trans.setNode(GameWindow.imageShip);
			trans.setToX(this.posX - 380);
			trans.play();
			
		} else {
			this.posX = this.posX - 10;
			if (this.posX <= 0)
				this.posX = 0;
			TranslateTransition trans = new TranslateTransition();
			trans.setDuration(Duration.millis(1)); //
			trans.setNode(GameWindow.imageShip);
			trans.setToX(this.posX - 380);
			trans.play();
		//}
		}
		
	}	
	
	/**
	 * Verifica sus vidas cuando es destruido por enemigo.
	 */
	public void destroy(){
		
		//AMINACION DE DESTRUCCION
		
		this.lives--;
		if (this.lives == 0){
			GameWindow.game.endGame();
		} else {
			if (this.lives == 1){
				GameWindow.imageLives2.setLayoutX(-80.0); //80
				GameWindow.imageLives2.setLayoutY(0.0);
			} else { // this.lives == 2
				GameWindow.imageLives3.setLayoutX(-110.0); //110
				GameWindow.imageLives3.setLayoutY(0.0);
			}
		}
	}
	
}