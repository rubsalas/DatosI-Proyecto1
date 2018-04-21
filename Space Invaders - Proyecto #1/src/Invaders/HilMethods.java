package Invaders;

/**
 * Interfaz con los m�todos de las Hileras.
 * 
 * @author Rub�n Salas
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
