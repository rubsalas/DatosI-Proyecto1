package game;
import game.Ship;

/**
 * Objeto jugador que tiene las estadísticas y características del jugador
 * @author Rubén Salas
 * @version 1.3
 * @since 27/03/18
 */
public class Player {
	
	String name;
	Ship ship = new Ship();
	int topScore;
	int actualScore = 0;
	int topLevel;
	int actualLevel = 1;
	int totalEnemiesKilled;
	int actualEnemiesKilled = 0;
	
	/**
	 * Constructor Player
	 */
	public Player(){
	}
	
	/**
	 * Retorna el nombre del Player.
	 * @return name - nombre
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Establece el nombre del Player.
	 * @param name - nombre
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Retorna el Ship del jugador.
	 * @return ship - Objeto Ship
	 */
	public Ship getShip(){
		return this.ship;
	}
	
	/**
	 * Establece el Ship del jugador.
	 * @param ship - Objeto Ship
	 */
	public void setShip(Ship ship){
		this.ship = ship;
	}
	
	/**
	 * Retorna el puntaje máximo.
	 * @return topScore - puntaje máximo
	 */
	public int getTopScore(){
		return this.topScore;
	}
	
	/**
	 * Establece el puntaje máximo.
	 * @param tScore - puntaje máximo
	 */
	public void setTopScore(int tScore){
		this.topScore = tScore;
	}
	
	/**
	 * Retorna el puntaje actual.
	 * @return actualScore - puntaje actual
	 */
	public int getActualScore(){
		return this.actualScore;
	}
	
	/**
	 * Establece el puntaje actual.
	 * @param aScore - puntaje actual
	 */
	public void setActualScore(int aScore){
		this.actualScore = aScore;
	}
	
	/**
	 * Retorna el nivel máximo llegado por el jugador.
	 * @return topLevel - Máximo Nivel
	 */
	public int getTopLevel(){
		return this.topLevel;
	}
	
	/**
	 * Establece el nivel máximo llegado por el jugador.
	 * @param tLevel - Máximo Nivel
	 */
	public void setTopLevel(int tLevel){
		this.topLevel = tLevel;
	}
	
	/**
	 * Retorna el nivel actual del juego.
	 * @return actualLevel - nivel actual
	 */
	public int getActualLevel(){
		return this.actualLevel;
	}
	
	/**
	 * Establece el nivel actual del juego.
	 * @param aLevel - nivel actual
	 */
	public void setActualLevel(int aLevel){
		this.actualLevel = aLevel;
	}
	
	/**
	 * Retorna el total de Enemies destruidos.
	 * @return totalEnemiesKilled - Enemies destruidos
	 */
	public int getTotalEnemiesKilled(){
		return this.totalEnemiesKilled;
	}
	
	/**
	 * Establece el total de Enemies destruidos.
	 * @param tKilled - Enemies destruidos
	 */
	public void setTotalEnemiesKilled(int tKilled){
		this.totalEnemiesKilled = tKilled;
	}
	
	/**
	 * Retorna los enemigos destruidos actualmente.
	 * @return actualEnemiesKilled - Enemies destruidos actualmente
	 */
	public int getActualEnemiesKilled(){
		return this.actualEnemiesKilled;
	}
	
	/**
	 * Establece los enemigos destruidos actualmente.
	 * @param aKilled - Enemies destruidos actualmente
	 */
	public void setActualEnemiesKilled(int aKilled){
		this.actualEnemiesKilled = aKilled;
	}
	
	
			
}