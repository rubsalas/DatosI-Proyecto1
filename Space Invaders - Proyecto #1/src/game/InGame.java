package game;

import game.Player;
import Invaders.*;

/**
 * Tiene lógica del juego
 * @author Rubén Salas
 * @version 1.5
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
			hilActual = createHil("actual");
		//	hilActual = HilCreator.createHilClaseE("actual");
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
	}
	
	public Hil getHilNext(){
		return hilNext;
	}
	
	/**
	 * Crea las hileras para mostrarlas en pantalla
	 * @param need - la actual o la de despues
	 * @return Hil
	 */
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
		} else //if( random == 5) {
			//Retorna una Hilera Clase D
			return HilCreator.createHilClaseD(need);
//		} else {
//			//Retorna una Hilera Clase E
//			return HilCreator.createHilClaseE(need);
//		}
	}
	
	/**
	 * Verifica el estado de las hileras
	 */
	public void checkHils() {
		int count = 1;
		if (this.getHilActual().getSize() == 0) {
			this.setHils();
			this.getHilActual().setSpeedY(HilCreator.setSpeedY());
			this.showHils();
			GameWindow.lblActualHil.setText("Hilera Actual: " + GameWindow.game.getHilActual().getName());
			GameWindow.lblNextHil.setText("Hilera Prox: " + GameWindow.game.getHilNext().getName());
			
			if (count % 3 == 1) {
				player1.setActualLevel(player1.getActualLevel() + 1);
				GameWindow.lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
			}
			count++;
		}
		if (count % 3 == 0) {
			player1.setActualLevel(player1.getActualLevel() + 1);
			GameWindow.lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
			this.getHilActual().setSpeedY(HilCreator.setSpeedY());
		}
		
	}
	
	
	public void endGame(){
		//Juego termina
		//Pasa al ultimo scene
	}

}