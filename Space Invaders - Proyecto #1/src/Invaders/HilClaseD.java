package Invaders;

import game.GameWindow;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Representación de la Hilera clase D:
 * "Igual que la C pero los miembros de la hilera tienen diferentes
 *  resistencias. La Hilera se mantiene ordenada de mayor a menor 
 *  resistencia, utilizando bubble sort."
 * @author Rubén Salas
 * @version 1.2
 * @since 18/03/18
 */
public class HilClaseD extends HilClaseC{
	
	String name = "Hilera Clase D";
	
	/**
	 * Constructor de Hilera Clase D que hereda de Hilera Clase C
	 */
	public HilClaseD(double sY){
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
	 * Ordena los Enemies 
	 */
	public void order(){
		//Llamar cada vez que se impacte cada Enemy
		//Bubble sort por numero de hits
		System.out.println("Ordenado de Mayor a Menor");
	}
	
	public void print(){
		Enemy temp = super.getHead();
		while (temp != super.getTail()){
			System.out.println(temp.getName() + " -> Hits: " + Integer.toString(temp.getHits()) + ".");
			temp = temp.getNext();
		}
		System.out.println(super.getTail().getName() + " -> Hits: " + Integer.toString(super.getTail().getHits()) + ".");
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
