package Invaders;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase C:
 * "Igual que la A pero si el jefe se destruye, otro toma 
 *  su lugar aleatoriamente. Es una lista circular."
 *  
 * @author Rubén Salas
 * @version 1.5
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
//			//Si se elimina al Boss
//			if (name == "boss"){
//				changeBoss();
//			}
//			//Si es cualquier otro Enemy
//			else {
				//Si se elimina al primero
				if (super.getHead().getName() == name){
					
					//Interfaz
					super.getHead().getImage().setLayoutX(-200);
					super.getHead().getImage().setLayoutY(-200);
					
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
						
						//Interfaz
						super.getTail().getImage().setLayoutX(-200);
						super.getTail().getImage().setLayoutY(-200);
						
						aux.setNext(super.getHead());
						super.setTail(aux);
					}
					else {

						Enemy next = aux.getNext();
						
						//Interfaz
						next.getImage().setLayoutX(-200);
						next.getImage().setLayoutY(-200);
						
						aux.setNext(next.getNext());
					}
				}
				super.minusSize();
				center();
			}
//		}
		
		/**
		 * Centra los Enemies de la lista.
		 */
		@Override
		public void center() {
			System.out.println("Se centran los Enemies");
			
			int n = 1;
			Enemy temp = this.getHead();
			
			for (int i = 1; i <= this.getSize(); i++){
				int posX = 25 + (45*(9 - this.getSize())) + (90 * (i-1)); //aumenta 90 pixeles su posición
				
				while (i == n){
				
				temp.setPosX(posX);
				temp.getImage().setLayoutX(posX);
				temp = temp.getNext();
				n++;
				
				}
			}
			this.print(); //TEST
		}
		
		/**
		 * Escoge aleatoriamente un Enemy para que sea un nuevo boss
		 */
		public void changeBoss(){
			//Intercambiar imagen y nombre
			//Usar destroy enemy con el nombre del enemy
			System.out.println("Cambio de Boss");
		}
		
		/**
		 * Imprime la lista
		 */
		public void print(){
			Enemy temp = super.getHead();
			while (temp != super.getTail()){
				System.out.println(temp.getName());
				temp = temp.getNext();
			}
			System.out.println(super.getTail().getName());
		}		
	
		/**
		 * Muestra la hilera en pantalla
		 */
		public void show(){
			Enemy temp = super.getHead();
			
			this.setYs();
			
			while(temp != super.getTail()){ //Recorre la lista hasta llegar al ultimo Enemy
				temp.getImage().setFitHeight(80);
				temp.getImage().setFitWidth(80);
				temp.getImage().setLayoutX(temp.getPosX());
				temp.getImage().setLayoutY(temp.getPosY());
				
				System.out.println(temp.getImage().getLayoutX());
				System.out.println(temp.getImage().getLayoutY());
				
				//Animacion
				TranslateTransition trans = new TranslateTransition();
				trans.setDuration(Duration.millis(super.getSpeedY()));
				trans.setNode(temp.getImage());
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
			super.getTail().getImage().setFitHeight(80);
			super.getTail().getImage().setFitWidth(80);
			super.getTail().getImage().setLayoutX(temp.getPosX()); 
			super.getTail().getImage().setLayoutY(temp.getPosY());
			
			//Animacion
			TranslateTransition trans = new TranslateTransition();
			trans.setDuration(Duration.millis(super.getSpeedY()));
			trans.setNode(super.getTail().getImage());
			trans.setNode(super.getTail().getImage());
			trans.setToY(430);
			trans.play();
			
			TranslateTransition trans2 = new TranslateTransition();
			trans2.setDuration(Duration.millis(4000)); 
			trans2.setNode(temp.getImage());
			trans2.setToX(50);
			trans2.setAutoReverse(true);
			trans2.setCycleCount(TranslateTransition.INDEFINITE);
			trans2.play();
				
		}
		
		/**
		 * Redefine las coordenadas Y al entrar en pantalla
		 */
		public void setYs(){
			Enemy temp = this.getHead();
			
			while (temp != super.getTail()){
				temp.setPosY(40);
				temp = temp.getNext();
			}
			super.getTail().setPosY(40);
		}
		
}
