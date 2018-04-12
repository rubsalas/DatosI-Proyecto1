package Invaders;

import game.GameWindow;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase E:
 * "Igual que la C con algunas variaciones. La hilera no es horizontal,
 * constantemente rota según las manecillas del reloj. El jefe siempre
 * está en el centro. Es una lista doble y circular."
 * @author Rubén Salas
 * @version 1.2
 * @since 18/03/18
 */
public class HilClaseE extends Hil{

	String name = "Hilera Clase E";
	
	/**
	 * Constructor de Hilera Clase E que hereda de Hilera
	 */
	public HilClaseE(double sY){
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
	 * @param newEnemy - Enemy por agregar
	 */
	@Override
	public void addEnemy(Enemy newEnemy) {
		
		if (super.getHead() == null) {
			newEnemy.setNext(newEnemy);
			newEnemy.setPrev(newEnemy);
			super.setHead(newEnemy);
			super.setTail(newEnemy);
		} else {
			newEnemy.setPrev(super.getTail());
			super.getTail().setNext(newEnemy);
			super.getHead().setPrev(newEnemy);
			newEnemy.setNext(super.getHead());
			super.setTail(newEnemy);
		}
		super.plusSize();
	}
	
	/**
	 * Destruye un Enemy.
	 * @param name - Nombre del Enemy por destruir
	 */
	@Override
	public void destroyEnemy(String name) {
		//Si es el Boss
		if (name == "boss"){
			changeBoss();
		} 
		//Para cualquier Enemy
		else {
			if (super.getHead() != null) {
				Enemy aux = super.getHead();
				Enemy prev = null;
				//Mientras el siguiente sea diferente del Head
				while (aux.getNext() != super.getHead()) {
					if (aux.getName() == name) {
						//Si es el primero
						if (prev == null) {
							if (aux.getNext() == super.getHead()) {
								super.setHead(null);
							}
							else {
								prev = aux.getPrev();
								prev.setNext(aux.getNext());
								aux = aux.getNext();
								aux.setPrev(prev);
								super.setHead(aux);
								prev = null;
							}
						}
						else {
							aux.setPrev(null);
							prev.setNext(aux.getNext());
							aux = aux.getNext();
							aux.setPrev(prev);
						}
					}
					else{
						prev = aux;
						aux = aux.getNext();
					}
				}
			}
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
		centerBoss();
	}
	
	/**
	 * Hace que el boss esté en una posición central
	 */
	public void centerBoss(){
		System.out.println("Se centra el jefe (interfaz)");
	}
	
	/**
	 * Rota la Hilera de Enemies (Interfaz)
	 */
	public void rotate(){
		System.out.println("Se rota constantemente la hilera");
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
