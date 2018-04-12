package game;

import Invaders.*;
import javafx.scene.image.ImageView;

/**
 * Creador de las Hileras
 * @author Rubén Salas
 * @version 1.2
 * @since 25/03/18
 */
public class HilCreator {
	int icount = 1;
	
	/**
	 * Crea una hilera Basic.
	 */
	public static Hil createHilBasic(String need){
		System.out.println("Creating HilBasic"); //TEST
		double sY = setSpeedY();
		HilBasic actualHil = new HilBasic(sY);
		double posX;
		double posY;
		if (need == "actual") {
			posY = 40;
		} else {
			posY = 1000;
			}
		//Crea 9 Enemies
		for (int i = 1; i <= 9; i++){
			String eName = "enemy" + Integer.toString(i); //Crea el nombre con su número
			posX = 25 + (90 * (i-1)); //aumenta 90 pixeles su posición
			Invader newEnemy = new Invader(eName,posX,posY, setImageEnemy(Integer.toString(i)));
			actualHil.addEnemy(newEnemy);
		}
		actualHil.print(); //TEST
		GameWindow.imageBoss1.setLayoutY(1000.0);
		
		return actualHil;
	}
	
	/**
	 * Crea una hilera Clase A.
	 */
	public static Hil createHilClaseA(String need){
		System.out.println("Creating HilClaseA"); //TEST
		double sY = setSpeedY();
		HilClaseA actualHil = new HilClaseA(sY);
		double posX;
		double posY;
		if (need == "actual") {
			posY = 40;
		} else {
			posY = 1000; }
		int hits = (int) Math.floor(Math.random()*(5-2+1)+2);
		int random = (int) Math.floor(Math.random()*(9-1+1)+1);
		//Se escoje un numero entre 1 y 9 aleatorio y esa posición se convierte en el jefe.
		for (int i = 1; i <= 9; i++){
			posX = 25 + (90 * (i-1)); //aumenta 90 pixeles su posición
			if (i == random){
				Boss bss = new Boss(posX, posY, hits, setImageEnemy("boss")); 
				actualHil.addEnemy(bss);
				setImageEnemy(Integer.toString(i)).setLayoutY(1000);
			} else {
				String eName = "enemy" + Integer.toString(i); //Crea el nombre con su número
				Invader newEnemy = new Invader(eName,posX,posY, setImageEnemy(Integer.toString(i)));
				actualHil.addEnemy(newEnemy);
			}
		}
		actualHil.print(); //TEST
		
		
		return actualHil;
	}
	
	
	/**
	 * Crea una hilera Clase B.
	 */
	public static Hil createHilClaseB(String need){
		System.out.println("Creating HilClaseB"); //TEST
		double sY = setSpeedY();
		HilClaseB actualHil = new HilClaseB(sY);
		double posX;
		double posY;
		if (need == "actual") {
			posY = 40;
		} else {
			posY = 1000; }
		int hits = (int) Math.floor(Math.random()*(5-2+1)+2);
		int random = (int) Math.floor(Math.random()*(9-1+1)+1);
		//Se escoje un numero entre 1 y 9 aleatorio y esa posición se convierte en el jefe.
		for (int i = 9; i >= 1; i--){ //Ingresa los enemies de atras para adelante
			posX = 25 + (90 * (i-1)); //aumenta 90 pixeles su posición
			if (i == random){
				Boss bss = new Boss(posX, posY, hits, setImageEnemy("boss")); 
				actualHil.addEnemy(bss);
				setImageEnemy(Integer.toString(i)).setLayoutY(1000);
			} else {
				String eName = "enemy" + Integer.toString(i); //Crea el nombre con su número
				Invader newEnemy = new Invader(eName,posX,posY, setImageEnemy(Integer.toString(i)));
				actualHil.addEnemy(newEnemy);
			}
		}
		actualHil.print(); //TEST
		
		return actualHil;
	}
	
	/**
	 * Crea una hilera Clase C.
	 */
	public static Hil createHilClaseC(String need){
		System.out.println("Creating HilClaseC"); //TEST
		double sY = setSpeedY();
		HilClaseC actualHil = new HilClaseC(sY);
		double posX;
		double posY;
		if (need == "actual") {
			posY = 40;
		} else {
			posY = 1000; }
		int hits = (int) Math.floor(Math.random()*(5-2+1)+2);
		int random = (int) Math.floor(Math.random()*(9-1+1)+1);
		//Se escoje un numero entre 1 y 9 aleatorio y esa posición se convierte en el jefe.
		for (int i = 9; i >= 1; i--){ //Ingresa los enemies de atras para adelante
			posX = 25 + (90 * (i-1)); //aumenta 90 pixeles su posición
			if (i == random){
				Boss bss = new Boss(posX, posY, hits, setImageEnemy("boss")); 
				actualHil.addEnemy(bss);
				setImageEnemy(Integer.toString(i)).setLayoutY(1000);
			} else {
				String eName = "enemy" + Integer.toString(i); //Crea el nombre con su número
				Invader newEnemy = new Invader(eName,posX,posY, setImageEnemy(Integer.toString(i)));
				actualHil.addEnemy(newEnemy);
			}
		}
		actualHil.print(); //TEST
		
		return actualHil;
	}

	
	/**
	 * Crea una hilera Clase D.
	 */
	public static Hil createHilClaseD(String need){
		System.out.println("Creating HilClaseD"); //TEST
		double sY = setSpeedY();
		HilClaseD actualHil = new HilClaseD(sY);
		double posX;
		double posY;
		if (need == "actual") {
			posY = 40;
		} else {
			posY = 1000; }
		int hitsInvader;
		int hitsBoss = (int) Math.floor(Math.random()*(5-2+1)+2);
		int random = (int) Math.floor(Math.random()*(9-1+1)+1);
		//Se escoje un numero entre 1 y 9 aleatorio y esa posición se convierte en el jefe.
		for (int i = 9; i >= 1; i--){ //Ingresa los enemies de atras para adelante
			posX = 25 + (90 * (i-1)); //aumenta 90 pixeles su posición
			if (i == random){
				Boss bss = new Boss(posX, posY, hitsBoss, setImageEnemy("boss")); 
				actualHil.addEnemy(bss);
				setImageEnemy(Integer.toString(i)).setLayoutY(1000);
			} else {
				hitsInvader = (int) Math.floor(Math.random()*(5-1+1)+1); //Pone un valor entre 1 y 4 hits 
				String eName = "enemy" + Integer.toString(i); //Crea el nombre con su número
				Invader newEnemy = new Invader(eName,posX,posY,hitsInvader, setImageEnemy(Integer.toString(i)));
				actualHil.addEnemy(newEnemy);
			}
		}
		actualHil.print(); //TEST
		actualHil.order();
		
		return actualHil;
	}
	
	/**
	 * Crea una hilera Clase E.
	 */
	public static Hil createHilClaseE(String need){
		System.out.println("Creating HilClaseE"); //TEST
		double sY = setSpeedY();
		HilClaseE actualHil = new HilClaseE(sY);
		double posX;
		double posY;
		if (need == "actual") {
			posY = 40;
		} else {
			posY = 1000; }
		int hits = (int) Math.floor(Math.random()*(5-2+1)+2);
		int random = (int) Math.floor(Math.random()*(9-1+1)+1);
		//Se escoje un numero entre 1 y 9 aleatorio y esa posición se convierte en el jefe.
		for (int i = 1; i <= 9; i++){
			posX = 25 + (90 * (i-1)); //aumenta 90 pixeles su posición
			if (i == random){
				Boss bss = new Boss(posX, posY, hits, setImageEnemy("boss")); 
				actualHil.addEnemy(bss);
				setImageEnemy(Integer.toString(i)).setLayoutY(1000);
			} else {
				String eName = "enemy" + Integer.toString(i); //Crea el nombre con su número
				Invader newEnemy = new Invader(eName,posX,posY, setImageEnemy(Integer.toString(i)));
				actualHil.addEnemy(newEnemy);
			}
		}
		actualHil.print(); //TEST
		
		return actualHil;
	}
	
	public static ImageView setImageEnemy(String enemy){
		switch (enemy){
			case "1":
				return GameWindow.imageEnemy1;
			case "2":
				return GameWindow.imageEnemy2;
			case "3":
				return GameWindow.imageEnemy3;
			case "4":
				return GameWindow.imageEnemy4;
			case "5":
				return GameWindow.imageEnemy5;
			case "6":
				return GameWindow.imageEnemy6;
			case "7":
				return GameWindow.imageEnemy7;
			case "8":
				return GameWindow.imageEnemy8;
			case "9":
				return GameWindow.imageEnemy9;
			case "boss":
				return GameWindow.imageBoss1;
			default:
				return null;
		}
	}
	
	public static double setSpeedY(){
		int lvl = GameWindow.player1.getActualLevel();
		if (lvl <= 10){
			return 40000 - (1000*lvl);
		} else if (lvl > 10 && lvl <= 30) {
			return 30000 - (750*lvl);
		} else {
			return 15000;
		}
	}
}
	