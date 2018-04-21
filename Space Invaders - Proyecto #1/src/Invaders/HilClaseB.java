package Invaders;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase B:
 * "Clase A con una variación. El jefe se intercambia rápidamente con el 
 *  resto de los miembros de la hilera. Es una lista doblemente enlazada."
 * 
 * @author Rubén Salas
 * @version 1.4
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
					
					//Interfaz
					temp.getImage().setLayoutX(-200);
					temp.getImage().setLayoutY(-200);
					
					super.getHead().setPrev(null);
					
				}
				//Si está en el medio de otros enemigos
				else {
					
					//Interfaz
					prev.getNext().getImage().setLayoutX(-200);
					prev.getNext().getImage().setLayoutY(-200);
					
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
		if(super.getTail().getName() == name && super.getTail() != super.getHead()){
			
			//Interfaz
			super.getTail().getImage().setLayoutX(-200);
			super.getTail().getImage().setLayoutY(-200);
			
			
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
	 * Muestra la Hilera en pantalla
	 */
	public void show(){
		Enemy temp = this.getHead();
		
		this.setYs();
		
		while(temp != null){ //Recorre la lista hasta llegar al ultimo Enemy
			temp.getImage().setFitHeight(80);
			temp.getImage().setFitWidth(80);
			temp.getImage().setLayoutX(temp.getPosX());
			temp.getImage().setLayoutY(40);
			
			System.out.println(temp.getImage().getLayoutX());
			System.out.println(temp.getImage().getLayoutY());
			
			//Animacion
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
		thread.start();
		
		swap();
	}
	
	/**
	 * Redefine las coordenadas Y al entrar en pantalla
	 */
	public void setYs(){
		Enemy temp = this.getHead();
		
		while(temp != null){ //Recorre la lista hasta llegar al ultimo Enemy
			temp.setPosY(40);
			temp = temp.getNext();
		}
		
	}
	
}
