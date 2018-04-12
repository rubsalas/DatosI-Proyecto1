package Invaders;

import game.GameWindow;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase A:
 * "Uno de los enemigos de la hilera es jefe. Aleatoriamente se elige a un jefe. 
 *  Cuando el jefe se destruye, el resto de naves desaparece. Para destruir el
 *  jefe, se requieren entre 2 a 5 disparos"
 * 
 * @author Rubén Salas
 * @version 1.2
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
		if (name == "boss"){
			destroyAll();
		} else {
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
	}
	
	/**
	 * Centra los Enemies de la lista.
	 */
	@Override
	public void center() {
		System.out.println("Se centran los Enemies");
	}
	
	/**
	 * Destruye todos los Enemies de la lista restantes.
	 */
	public void destroyAll(){
		super.setHead(null);
		super.zeroSize();
		System.out.println("Se eliminan todos los Enemies");
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
			temp.getImage().setLayoutX(temp.getPosX());
			temp.getImage().setLayoutY(temp.getPosY());
			TranslateTransition trans = new TranslateTransition();
			
			//Animacion
			trans.setDuration(Duration.millis(super.getSpeedY()));
			trans.setNode(temp.getImage());
			trans.setNode(temp.getImage());
			trans.setToY(430);
			trans.play();
			
			temp = temp.getNext();
		}
			
	}
	
}
