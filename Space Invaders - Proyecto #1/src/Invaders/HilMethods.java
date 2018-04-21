package Invaders;

/**
 * Interfaz con los métodos de las Hileras.
 * 
 * @author Rubén Salas
 * @version 1.2
 * @since 13/03/18
 *
 */
public interface HilMethods {
	public void addEnemy(Enemy enemy);
	public void destroyEnemy(String name);
	public void center();
	public void show();
}
