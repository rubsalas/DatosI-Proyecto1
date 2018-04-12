package Invaders;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Representacion de la Hilera Basic:
 * "Todos los elementos de la hilera son iguales"
 * 
 * @author Rubén Salas
 * @version 1.3
 * @since 11/03/18
 *
 */
public class HilBasic extends Hil{

		String name = "Hilera Basic";
	
		/**
		 * Constructor para crear una Hilera Basic que hereda de Hilera
		 */
		public HilBasic(double sY){
			super(sY);
		}
		
		/**
		 * Retorna el nombre de la hilera.
		 * @return name - nombre
		 */
		public String getName(){
			return this.name;
		}
		
		/**
		 * Agrega un nuevo Enemy al final de la lista.
		 * @param newEnemy - nuevo Enemy por ingresar en lista
		 */
		@Override
		public void addEnemy(Enemy newEnemy){
			if (super.itsEmpty() == true) { //Verifica que la lista esté vacia
				super.setHead(newEnemy); //Agrega como head a newEnemy
			} 
			else { //Recorre la lista hasta llegar al último enemigo
				Enemy temp = super.getHead(); //Crea un Enemy temporal para referencia
				while(temp.getNext() != null){ //Recorre la lista hasta llegar al ultimo Enemy
					temp = temp.getNext();
				}
				temp.setNext(newEnemy); //Agrega a newEnemy al final de la lista
			}
			super.plusSize();
		}
		
		/**
		 * Destruye un Enemy.
		 * @param name - nombre del Enemy
		 */
		@Override
		public void destroyEnemy(String name) {
			
			if (super.getHead().getName() == name){
				super.setHead(super.getHead().getNext());
			} else {
				Enemy temp = super.getHead();
				while(temp.getNext().getName() != name){
					temp = temp.getNext();
				}
				temp.setNext( temp.getNext().getNext() );
			}
			super.minusSize();
			center();
		}

		/**
		 * Centra los Enemies de la lista.
		 */
		@Override
		public void center() {
			System.out.println("Se centran los Enemies");
		}
		
		public void print(){
			Enemy temp = super.getHead();
			while (temp != null){
				System.out.println(temp.getName());
				temp = temp.getNext();
			}
		}
		
		public void show(){
			Enemy temp = this.getHead();
			
			
			
			while(temp != null){ //Recorre la lista hasta llegar al ultimo Enemy
				temp.getImage().setFitHeight(90);
				temp.getImage().setFitWidth(90);
				temp.getImage().setLayoutX(temp.getPosX()-25);
				temp.getImage().setLayoutY(temp.getPosY());
				TranslateTransition trans = new TranslateTransition();
				trans.setDuration(Duration.millis(super.getSpeedY())); 
				trans.setNode(temp.getImage());
				trans.setToY(430);
				trans.play();
				
				TranslateTransition trans2 = new TranslateTransition();
				trans2.setDuration(Duration.millis(4000)); 
				trans2.setNode(temp.getImage());
				trans2.setToX(50);
				trans2.setAutoReverse(true);
				trans2.setCycleCount(TranslateTransition.INDEFINITE);
				trans2.play();
				
				temp = temp.getNext();
			}
			
			
			
		}
			
//			this.getHead().getImage().setFitHeight(90);
//			GameWindow.imageEnemy1.setFitWidth(90);
//			GameWindow.imageEnemy1.setLayoutX(posX+(90*0)); 
//			GameWindow.imageEnemy1.setLayoutY(posY);
//			
//			GameWindow.imageEnemy2.setFitHeight(90);
//			GameWindow.imageEnemy2.setFitWidth(90);
//			GameWindow.imageEnemy2.setLayoutX(posX+(90*1)); 
//			GameWindow.imageEnemy2.setLayoutY(posY);
//			
//			GameWindow.imageEnemy3.setFitHeight(90);
//			GameWindow.imageEnemy3.setFitWidth(90);
//			GameWindow.imageEnemy3.setLayoutX(posX+(90*2)); 
//			GameWindow.imageEnemy3.setLayoutY(posY);
//			
//			GameWindow.imageEnemy4.setFitHeight(90);
//			GameWindow.imageEnemy4.setFitWidth(90);
//			GameWindow.imageEnemy4.setLayoutX(posX+(90*3)); 
//			GameWindow.imageEnemy4.setLayoutY(posY);
//			
//			GameWindow.imageEnemy5.setFitHeight(90);
//			GameWindow.imageEnemy5.setFitWidth(90);
//			GameWindow.imageEnemy5.setLayoutX(posX+(90*4));
//			GameWindow.imageEnemy5.setLayoutY(posY);
//			
//			GameWindow.imageEnemy6.setFitHeight(90);
//			GameWindow.imageEnemy6.setFitWidth(90);
//			GameWindow.imageEnemy6.setLayoutX(posX+(90*5)); 
//			GameWindow.imageEnemy6.setLayoutY(posY);
//		
//			GameWindow.imageEnemy7.setFitHeight(90);
//			GameWindow.imageEnemy7.setFitWidth(90);
//			GameWindow.imageEnemy7.setLayoutX(posX+(90*6));
//			GameWindow.imageEnemy7.setLayoutY(posY);
//			
//			GameWindow.imageEnemy8.setFitHeight(90);
//			GameWindow.imageEnemy8.setFitWidth(90);
//			GameWindow.imageEnemy8.setLayoutX(posX+(90*7));
//			GameWindow.imageEnemy8.setLayoutY(posY);
//			
//			GameWindow.imageEnemy9.setFitHeight(90);
//			GameWindow.imageEnemy9.setFitWidth(90);
//			GameWindow.imageEnemy9.setLayoutX(posX+(90*8));
//			GameWindow.imageEnemy9.setLayoutY(posY);
//		}
		
		
}