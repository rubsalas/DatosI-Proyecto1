package Invaders;

import game.GameWindow;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase C:
 * "Igual que la A pero si el jefe se destruye, otro toma 
 *  su lugar aleatoriamente. Es una lista circular."
 * @author Rubén Salas
 * @version 1.3
 * @since 18/03/18
 */
public class HilClaseC extends Hil{
	
		String name = "Hilera Clase C";

		/**
		 * Constructor de Hilera Clase C que hereda de Hilera
		 */
		public HilClaseC(double sY){
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
		 * Agrega un Enemy.
		 * @param enemy - Enemy por agregar
		 */
		@Override
		public void addEnemy(Enemy newEnemy) {
			//Si la lista está vacia
			if (super.itsEmpty() == true) {
				super.setHead(newEnemy);
				super.setTail(newEnemy);
				super.getTail().setNext(super.getHead());
			}
			//Si ya hay Enemies
			else {
				newEnemy.setNext(super.getHead());
				super.setHead(newEnemy);
				super.getTail().setNext(super.getHead());
			}
			super.plusSize();
		}
	
		/**
		 * Destruyre un Enemy por su nombre, si es el Boss, se destruyen todos
		 */
		@Override
		public void destroyEnemy(String name) {
			//Si se elimina al Boss
			if (name == "boss"){
				changeBoss();
			}
			//Si es cualquier otro Enemy
			else {
				//Si se elimina al primero
				if (super.getHead().getName() == name){
					super.setHead(super.getHead().getNext());
					super.getTail().setNext(super.getHead());
				}
				//Si no es el primero
				else {
					Enemy aux = super.getHead();
					//Recorre la lista hasta llegar al Enemy anterior
					while (aux.getNext().getName() != name){
						aux = aux.getNext();
					}
					//Si es el último
					if (aux.getNext() == super.getTail()){
						aux.setNext(super.getHead());
						super.setTail(aux);
					}
					else {
						Enemy next = aux.getNext();
						aux.setNext(next.getNext());
					}
				}
				super.minusSize();
				center();
			}
		}
		
		/**
		 * Centra los Enemies de la lista.
		 */
		@Override
		public void center() {
			System.out.println("Se centran los Enemies");
		}
		
		/**
		 * Escoge aleatoriamente un Enemy para que sea un nuevo boss
		 */
		public void changeBoss(){
			//Intercambiar imagen y nombre
			//Usar destroy enemy con el nombre del enemy
			System.out.println("Cambio de Boss");
		}
		
		public void print(){
			Enemy temp = super.getHead();
			while (temp != super.getTail()){
				System.out.println(temp.getName());
				temp = temp.getNext();
			}
			System.out.println(super.getTail().getName());
		}
		
		public void show(){
			Enemy temp = super.getHead();
			
			while(temp != super.getTail()){ //Recorre la lista hasta llegar al ultimo Enemy
				temp.getImage().setFitHeight(90);
				temp.getImage().setFitWidth(90);
				temp.getImage().setLayoutX(temp.getPosX());
				temp.getImage().setLayoutY(temp.getPosY());
				
				//Animacion
				TranslateTransition trans = new TranslateTransition();
				trans.setDuration(Duration.millis(super.getSpeedY()));
				trans.setNode(temp.getImage());
				trans.setNode(temp.getImage());
				trans.setToY(430);
				trans.play();
				
				temp = temp.getNext();
			}
			super.getTail().getImage().setFitHeight(90);
			super.getTail().getImage().setFitWidth(90);
			super.getTail().getImage().setLayoutX(temp.getPosX()); 
			super.getTail().getImage().setLayoutY(temp.getPosY());
			
			//Animacion
			TranslateTransition trans = new TranslateTransition();
			trans.setDuration(Duration.millis(super.getSpeedY()));
			trans.setNode(super.getTail().getImage());
			trans.setNode(super.getTail().getImage());
			trans.setToY(430);
			trans.play();
				
		}
		
}
