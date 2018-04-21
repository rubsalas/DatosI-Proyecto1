package Invaders;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase A:
 * "Uno de los enemigos de la hilera es jefe. Aleatoriamente se elige a un jefe. 
 *  Cuando el jefe se destruye, el resto de naves desaparece. Para destruir el
 *  jefe, se requieren entre 2 a 5 disparos"
 * 
 * @author Rubén Salas
 * @version 1.4
 * @since 17/03/18
 *  
 */
public class HilClaseA extends Hil{
	
	String name = "Hilera Clase A";
	
	/**
	 * Constructor Hilera Clasic A que hereda de Hilera
	 */
	public HilClaseA(double sY){
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
//		if (name == "boss"){
//			destroyAll();
//			print();
//		} else {
			if (super.getHead().getName() == name){
				//Interfaz
				super.getHead().getImage().setLayoutX(-200);
				super.getHead().getImage().setLayoutY(-200);
				//Cambia la referencia
				super.setHead(super.getHead().getNext());
			} else {
				Enemy temp = super.getHead();
				while(temp.getNext().getName() != name){
					temp = temp.getNext();
				}
				//Interfaz
				temp.getNext().getImage().setLayoutX(-200);
				temp.getNext().getImage().setLayoutY(-200);
				//Cambia de referencia la lista
				temp.setNext( temp.getNext().getNext() );
			}
			super.minusSize();
			center();
//		}
	}
	
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
	 * Destruye todos los Enemies de la lista restantes.
	 */
	public void destroyAll(){
//		Enemy temp = super.getHead();
//		while (temp != null){
//			Enemy aux = temp.getNext();
//			this.destroyEnemy(temp.getName());
//			temp = aux;
//		}
	
		super.setHead(null);
		super.zeroSize();
		System.out.println("Se eliminan todos los Enemies");
	
	}
	
	/**
	 * Imprime la Hilera
	 */
	public void print(){
		Enemy temp = super.getHead();
		while (temp != null){
			System.out.println(temp.getName());
			temp = temp.getNext();
		}
	}
	
	/**
	 * Muestra la hilera en pantalla
	 */
	public void show(){
		Enemy temp = this.getHead();
		
		this.setYs();
		
		System.out.println("Showing " + this.getName());

		while(temp != null){ //Recorre la lista hasta llegar al ultimo Enemy
			temp.getImage().setFitHeight(80);
			temp.getImage().setFitWidth(80);
			temp.getImage().setLayoutX(temp.getPosX());
			temp.getImage().setLayoutY(temp.getPosY());
			
			System.out.println(temp.getImage().getLayoutX());
			System.out.println(temp.getImage().getLayoutY());
			
			TranslateTransition trans = new TranslateTransition();
			
			//Animacion
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
	
	/**
	 * Al entrar la hilera a la pantalla sus coordenadas en y son redefinidas
	 */
	public void setYs(){
		Enemy temp = this.getHead();
		
		while(temp != null){ //Recorre la lista hasta llegar al ultimo Enemy
			temp.setPosY(40);
			temp = temp.getNext();
		}
		
	}
	
}
