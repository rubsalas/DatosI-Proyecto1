package Invaders;

/**
 * Representacion de una Hilera:
 *  
 * @author Rubén Salas
 * @version 1.6
 * @since 14/03/18
 *
 */
public class Hil implements HilMethods{

		private Enemy head;
		private Enemy tail;
		private int size;
		private double speedY;
		
		/**
		 * Constructor Hilera Basic.
		 */
		public Hil(double sY){ //double sY
			this.head = null;
			this.tail = null;
			this.size = 0;
			this.speedY = sY;
		}
		
		/**
		 * Retorna el primer Enemy de la lista.
		 * @return head - primer Enemy
		 */
		public Enemy getHead(){
			return this.head;
		}
		
		/**
		 * Establece al primer Enemy de la lista.
		 * @param h - Enemy
		 */
		public void setHead(Enemy h){
			this.head = h;
		}
		
		/**
		 * Retorna al último Enemy de la lista.
		 * @return tail - último Enemy
		 */
		public Enemy getTail(){
			return this.tail;
		}
		
		/**
		 * Establece al último enemigo de la lista.
		 * @param t - Enemy
		 */
		public void setTail(Enemy t){
			this.tail = t;
		}
		
		/**
		 * Retorna la cantidad de Enemies que están en la lista.
		 * @return size - cantidad de Enemies
		 */
		public int getSize(){
			return this.size;
		}
		
		/**
		 * Agrega 1 al size de la lista.
		 */
		public void plusSize(){
			this.size++;
		}
		
		/**
		 * Elimina 1 al size de la lista.
		 */
		public void minusSize(){
			this.size--;
		}
		
		/**
		 * Establece al size como O.
		 */
		public void zeroSize(){
			this.size = 0;
		}
		
		/**
		 * Retorna el primer Enemy de la lista.
		 * @return head - primer Enemy
		 */
		public double getSpeedY(){
			return this.speedY;
		}
		
		/**
		 * Establece al primer Enemy de la lista.
		 * @param h - Enemy
		 */
		public void setSpeedY(double sY){
			this.speedY = sY;
		}
		
		/**
		 * Retorna el nombre de la hilera.
		 * @return name - nombre
		 */
		public String getName(){return"";}
		
		/**
		 * Consulta si la lista está vacía.
		 * 
		 * @return true si el primer Enemy (head), no apunta a otro Enemy.
		 */
		public boolean itsEmpty(){
			return this.head == null;
		}
		
		/**
		 * Agrega un Enemy.
		 * @param enemy - Enemy por agregar
		 */
		@Override
		public void addEnemy(Enemy enemy) {
			
		}
		
		/**
		 * Destruye un Enemy.
		 * @param enemy - Enemy por destruir
		 */
		@Override
		public void destroyEnemy(String name) {
			
		}

		/**
		 * Centra los Enemies de la lista.
		 */
		@Override
		public void center() {
			
		}
		
		/**
		 * Muestra la Hilera en pantalla
		 */
		public void show(){
			
		}
		
		/**
		 * Al entrar la hilera a la pantalla sus coordenadas en y son redefinidas
		 */
		public void setYs() {
			
		}

}
