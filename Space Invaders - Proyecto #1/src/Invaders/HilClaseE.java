package Invaders;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;

/**
 * Representación de la Hilera Clase E:
 * "Igual que la C con algunas variaciones. La hilera no es horizontal,
 * constantemente rota según las manecillas del reloj. El jefe siempre
 * está en el centro. Es una lista doble y circular."
 * 
 * @author Rubén Salas
 * @version 1.3
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
//		//Si es el Boss
//		if (name == "boss"){
//			changeBoss();
//		} 
//		//Para cualquier Enemy
//		else {
			if (super.getHead() != null) {
				Enemy aux = super.getHead();
				Enemy prev = null;
				//Mientras el siguiente sea diferente del Head
				while (aux.getNext() != super.getHead()) {
					if (aux.getName() == name) {
						//Si es el primero
						if (prev == null) {
							if (aux.getNext() == super.getHead()) {
								
								//Interfaz
								aux.getImage().setLayoutX(-200);
								aux.getImage().setLayoutY(-200);
								
								super.setHead(null);
							}
							else {
								prev = aux.getPrev();
								
								//Interfaz
								aux.getImage().setLayoutX(-200);
								aux.getImage().setLayoutY(-200);
								
								prev.setNext(aux.getNext());
								aux = aux.getNext();
								aux.setPrev(prev);
								super.setHead(aux);
								prev = null;
							}
							
						}
						else {
							aux.setPrev(null);
							
							//Interfaz
							aux.getImage().setLayoutX(-200);
							aux.getImage().setLayoutY(-200);
							
							prev.setNext(aux.getNext());
							aux = aux.getNext();
							aux.setPrev(prev);
						}
						if (super.getTail().getName() == name){
							
							//Interfaz
							super.getTail().getImage().setLayoutX(-200);
							super.getTail().getImage().setLayoutY(-200);
							
							super.setTail(super.getTail().getPrev());
							super.getTail().setNext(super.getHead());
						}
					}
					else{
						prev = aux;
						aux = aux.getNext();
					}
				}
			}
		}
//	}

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
	
	/**
	 * Imprime la Hilera
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
	 * Muestra la Hilera en pantalla
	 */
	public void show(){		
		Enemy temp = super.getHead();
		
		System.out.println("Showing " + this.getName());

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
		super.getTail().getImage().setFitHeight(90);
		super.getTail().getImage().setFitWidth(90);
		super.getTail().getImage().setLayoutX(temp.getPosX()); 
		super.getTail().getImage().setLayoutY(40);
		
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
	
}
