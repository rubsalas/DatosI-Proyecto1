package Invaders;

import game.GameWindow;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase B:
 * "Clase A con una variación. El jefe se intercambia rápidamente con el 
 *  resto de los miembros de la hilera. Es una lista doblemente enlazada."
 * 
 * @author Rubén Salas
 * @version 1.3
 * @since 17/03/18
 */
public class HilClaseB extends Hil{
	
	String name = "Hilera Clase B";
	
	/**
	 * Constructor de Hilera Clase B que hereda de Hilera
	 */
	public HilClaseB(double sY){
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
		if (super.itsEmpty() == true) { //Verifica que la lista esté vacia
			super.setHead(newEnemy); //Agrega como head a newEnemy
			super.setTail(newEnemy); //Agrega como tail a newEnemy
		} else {
			//Agrega al nuevo enemy al inicio
			super.getHead().setPrev(newEnemy); //Establece al previo del head como el nuevo Enemy
			newEnemy.setNext(super.getHead()); //Establece al next del nuevo Enemy al head
			super.setHead(newEnemy); //Establece al nuevo Enemy como el head
		}
		super.plusSize();
	}
	
	/**
	 * Destruye un Enemy.
	 * @param enemy - Enemy por destruir
	 */
	@Override
	public void destroyEnemy(String name) {
		Enemy temp = super.getHead();
		Enemy prev = null;
		//Recorre la lista hasta llegar al último
		while(temp!=super.getTail()){
			//Si se encuentra
			if(temp.getName() == name){
				//Si está de primero
				if(prev == null){
					super.setHead(temp.getNext());
					super.getHead().setPrev(null);
				}
				//Si está en el medio de otros enemigos
				else {
					prev.setNext(temp.getNext());
					Enemy aux = temp.getNext();
					aux.setPrev(prev);
				}
				break;
			}
			//Si no se encuntra, se pasa a la siguiente posición.
			prev = temp;
			temp = temp.getNext();
		}
		//Si el que hay que eliminar es el último
		if(super.getTail().getName() == name){
			super.setTail(temp.getPrev());
			super.getTail().setNext(null);
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
	
	/**
	 * Hace que el jefe se intercambie con el resto de los miembros de la hilera.
	 */
	public void swap(){
		System.out.println("Swap Boss");
		
		Enemy boss;
		Enemy swapee;
		int i = 1;
		Enemy temp = super.getHead();
		int random = (int) Math.floor(Math.random()*(9-1+1)+1);
		while (temp != null){
			if (temp.getName() == "boss"){
				break;
			} else {
				i++;
				temp = temp.getNext();
			}
			
		}
		boss = temp;
		System.out.println(boss.getName());
		System.out.println(i);
		while (random == i){
			random = (int) Math.floor(Math.random()*(9-1+1)+1);
		}
		System.out.println(random);
		Enemy aux = super.getHead();
		String name = "enemy" + Integer.toString(random);
		System.out.println("-> enemy" + Integer.toString(random));	
		while (aux != null){
			if (aux.getName() == name){
				break;
				
			} else {
				aux = aux.getNext();
			}
			break;
		}
		swapee = aux;
		System.out.println(swapee.getName());
//		double swpX = boss.getPosX();
//		double bssX = swapee.getPosX();
//		boss.setPosX(bssX);
//		swapee.setPosX(swpX);
			
//			boss.getImage().setLayoutX(temp.getPosX());
//			swapee.getImage().setLayoutX(temp.getPosX());
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
			
			//Animacion
			TranslateTransition trans = new TranslateTransition();
			trans.setDuration(Duration.millis(super.getSpeedY()));
			trans.setNode(temp.getImage());
			trans.setToY(430);
			trans.play();
			
			temp = temp.getNext();
			
			
		}
		
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				
				swap();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		//thread.start();
		
		swap();
			
	}
	
}
