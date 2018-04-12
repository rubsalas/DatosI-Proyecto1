package game;

import game.Player;
import Invaders.*;

/**
 * Tiene lógica del juego
 * @author Rubén Salas
 * @version 1.1
 * @since 25/03/18
 *
 */
public class InGame {
	
	Player player1;
	Hil hilActual ;
	Hil hilNext;
	
	public InGame(Player p1){
		this.player1 = p1;
	}
	
	public void setPlayer1(Player p1){
		player1 = p1;
	}
	
	public Player getPlayer1(){
		return player1;
	}
	
	public void setHils(){
		if (hilActual == null && hilNext == null){
//			hilActual = createHil("actual");
			hilActual = HilCreator.createHilBasic("actual");
			hilNext = createHil("next");
		} else {
			hilActual = hilNext;
			hilNext = createHil("next");
		}
	}
	
	public Hil getHilActual(){
		return this.hilActual;
	}
	
	public void showHils(){
		this.hilActual.show();
//		this.hilNext.show();
	}
	
	public Hil getHilNext(){
		return hilNext;
	}
	
	public Hil createHil(String need){
		int random = (int) Math.floor(Math.random()*(6-1+1)+1);
		if (random == 1){
			//Retorna una Hilera Basic
			return HilCreator.createHilBasic(need);
		} else if( random == 2) {
			//Retorna una Hilera Clase A
			return HilCreator.createHilClaseA(need);
		} else if( random == 3) {
			//Retorna una Hilera Clase B
			return HilCreator.createHilClaseB(need);
		} else if( random == 4) {
			//Retorna una Hilera Clase C
			return HilCreator.createHilClaseC(need);
		} else if( random == 5) {
			//Retorna una Hilera Clase D
			return HilCreator.createHilClaseD(need);
		} else {
			//Retorna una Hilera Clase E
			return HilCreator.createHilClaseE(need);
		}
	}
	
	public void endGame(){
		//Juego termina
		//Pasa al ultimo scene
	}

	public void startGame(){
		//Juego empieza
		//Pase al scene del juego
	}
}