package game;

import java.util.ArrayList;
import Invaders.Enemy;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.*;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Main.
 * 
 * @author Rubén Salas
 * @version 2.1
 * @since 25/03/18
 */
public class GameWindow extends Application{
	
	public static void main(String[] args){
		
		launch(args);
		
	}
	
	//Se crea el objeto Player
	static Player player1 = new Player();
	//Se crea el objeto InGame
	static InGame game = new InGame(player1);
	
	int width = 860; //largo en pixeles
	int height = 650; //alto en pixeles

	Stage stage;
	
	//Primer Scene: Registration
	BackgroundImage background;
	Image spacebarImage;
	ImageView pressSpace;
	Scene sceneRegistration;
	
	//Segundo Scene: Game
	Image image;
	static ImageView imageLives1;
	static ImageView imageLives2;
	static ImageView imageLives3;
	
	static ImageView imageShip;
	
	public static Image imageEnemy;
	Image imageBoss;
	public static ImageView imageEnemy1;
	public static ImageView imageEnemy2;
	public static ImageView imageEnemy3;
	public static ImageView imageEnemy4;
	public static ImageView imageEnemy5;
	public static ImageView imageEnemy6;
	public static ImageView imageEnemy7;
	public static ImageView imageEnemy8;
	public static ImageView imageEnemy9;
	public static ImageView imageBoss1;
	
	
	public static ArrayList<Node> bullets = new ArrayList<Node>();
	public static Image imageBullet;
	boolean throwing, goRight, goLeft;
	int dWeapon = 10;
	
	Label lblLives;
	Label lblScore;
	static Label lblActualHil;
	static Label lblNextHil;
	static Label lblLevel;
	String font = "Arial";
	int fontSize = 16;
		
	Scene sceneGame;
	
	//Tercer Scene: Stats
	long score = 1;
	Label lblStats;
	Button btnStats;
	Button btnSwitch3;
	Scene sceneStats;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;
		
		//Primer Scene
		
		//Imagen de instrucción
		spacebarImage = new Image(getClass().getResourceAsStream("/images/spacebar.png"));
		pressSpace = new ImageView(spacebarImage);
		pressSpace.setFitHeight(53);
		pressSpace.setFitWidth(330);
		pressSpace.setLayoutX(265);
		pressSpace.setLayoutY(440);
		 
		//Movimiento Imagen de Instruccion
		TranslateTransition trans2 = new TranslateTransition();
		trans2.setDuration(Duration.millis(400)); 
		trans2.setNode(pressSpace);
		trans2.setToX(20);
		trans2.setAutoReverse(true);
		trans2.setCycleCount(TranslateTransition.INDEFINITE);
		trans2.play();
		
		Pane mainPane = new Pane();
		mainPane.getChildren().addAll(pressSpace);
		
		//Fondo con Título
		background = new BackgroundImage(new Image("/images/backgroundA.png"),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		mainPane.setBackground(new Background(background));
		
		//Primer Scene
		sceneRegistration = new Scene(mainPane, height, width); 
		
		//KeyHandler para iniciar el juego
		sceneRegistration.setOnKeyPressed(
				e -> {
					switch (e.getCode()) {
						case SPACE:
							start();
							break;
						default:
							break;
					}
				});
		
		
		//2nd Scene
		
		//Label Vidas
		lblLives = new Label("Lives: ");
		lblLives.setFont(new Font(font, fontSize));
		lblLives.setTextFill(Color.web("#EEEEEE"));
		lblLives.setLayoutX(5.0);
		lblLives.setLayoutY(3.0);
		
		//Imagen vidas
		image = new Image(getClass().getResourceAsStream("/images/ship.png"));
		//1
		imageLives1 = new ImageView(image);
		imageLives1.setFitHeight(25);
		imageLives1.setFitWidth(25);
		imageLives1.setLayoutX(50.0);
		imageLives1.setLayoutY(0.0);
		//2
		imageLives2 = new ImageView(image);
		imageLives2.setFitHeight(25);
		imageLives2.setFitWidth(25);
		imageLives2.setLayoutX(-80.0); //80
		imageLives2.setLayoutY(0.0);
		//3
		imageLives3 = new ImageView(image);
		imageLives3.setFitHeight(25);
		imageLives3.setFitWidth(25);
		imageLives3.setLayoutX(-110.0); //110
		imageLives3.setLayoutY(0.0);
		
		//Imagen de Nave
		imageShip = new ImageView(image);
		imageShip.setFitHeight(100);
		imageShip.setFitWidth(100);
		imageShip.setLayoutX(380.0); 
		imageShip.setLayoutY(525.0);
		
		//Imagenes de enemigos
		imageEnemy = new Image(getClass().getResourceAsStream("/images/enemy.gif"));
		imageEnemy1 = new ImageView(imageEnemy);
		imageEnemy2 = new ImageView(imageEnemy);
		imageEnemy3 = new ImageView(imageEnemy);
		imageEnemy4 = new ImageView(imageEnemy);
		imageEnemy5 = new ImageView(imageEnemy);
		imageEnemy6 = new ImageView(imageEnemy);
		imageEnemy7 = new ImageView(imageEnemy);
		imageEnemy8 = new ImageView(imageEnemy);
		imageEnemy9 = new ImageView(imageEnemy);

		//Imagen del Jefe
		imageBoss = new Image(getClass().getResourceAsStream("/images/boss.gif"));
		imageBoss1 = new ImageView(imageBoss);
		
		//Imagen del disparo
		imageBullet = new Image(getClass().getResourceAsStream("/images/bullet.png"));
		
		//Label Puntaje
		lblScore = new Label();
		lblScore.setText("Score: ");
		lblScore.setFont(new Font(font, fontSize));
		lblScore.setTextFill(Color.web("#EEEEEE"));
		lblScore.setLayoutX(150.0);
		lblScore.setLayoutY(3.0);
		
		//Label Hilera Actual
		lblActualHil = new Label();
		lblActualHil.setText("Hilera Actual: ");
		lblActualHil.setFont(new Font(font, fontSize));
		lblActualHil.setTextFill(Color.web("#EEEEEE"));
		lblActualHil.setLayoutX(330.0);
		lblActualHil.setLayoutY(3.0);
		
		//Label Hilera Proxima
		lblNextHil = new Label();
		lblNextHil.setText("Hilera Prox: ");
		lblNextHil.setFont(new Font(font, fontSize));
		lblNextHil.setTextFill(Color.web("#EEEEEE"));
		lblNextHil.setLayoutX(550.0);
		lblNextHil.setLayoutY(3.0);
		
		//Label Nivel
		lblLevel = new Label();
		lblLevel.setText("Level: ");
		lblLevel.setFont(new Font(font, fontSize));
		lblLevel.setTextFill(Color.web("#EEEEEE"));
		lblLevel.setLayoutX(760.0);
		lblLevel.setLayoutY(3.0);
		
		//Layout Pane para Estadisticas arriba del juego
		Pane statsPane = new Pane();
		
		statsPane.getChildren().addAll(imageLives1, imageLives2, imageLives3, imageShip, 
				imageEnemy1, imageEnemy2, imageEnemy3, imageEnemy4, imageEnemy5,
				imageEnemy6, imageEnemy7, imageEnemy8, imageEnemy9, imageBoss1,
				lblLives, lblScore, lblActualHil, lblNextHil, lblLevel);
		
		Pane gamePane = new Pane();
		
		BorderPane pane2 = new BorderPane();
		pane2.setTop(statsPane);
		pane2.setCenter(gamePane);
		
		//Fondo en gamePane
		background = new BackgroundImage(new Image("/images/backgroundB.png"), //Fondo de estrellas
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
		        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane2.setBackground(new Background(background));
		
		sceneGame = new Scene(pane2, height, width);

		//KeyHandlers para el movimiento y los disparos
		sceneGame.setOnKeyPressed(
				e -> {
					switch (e.getCode()) {
						case RIGHT:
							goRight = true;
							break;
						case LEFT:
							goLeft = true;
							break;
						case SPACE: 
							if (!throwing) {
								ImageView bullet = new ImageView(imageBullet);
								bullet.setFitHeight(20);
								bullet.setFitWidth(20);
								bullet.setLayoutX(player1.getShip().getPosX() + 40.5);
								bullet.setLayoutY(player1.getShip().getPosY() - 5);
									
								//Agrega la bala al ArrayList de balas
								bullets.add(bullet);
								//Agrega la bala al Pane
								statsPane.getChildren().add(bullet);
								//Sobre escribe la varible throwing
								throwing = true;
							}
							break;
						default:
							break;
					}
						
				}
		);
				 
		sceneGame.setOnKeyReleased(
				e -> {
				switch (e.getCode()){
					case RIGHT:
						goRight = false;
						break;
					case LEFT:
						goLeft = false;
						break;
					case SPACE:
						throwing = false;
						break;
					default:
						break;
				
				}
			}
		);
		
		//Timer esta activo, verifica varios metodos cada frame
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				
				if (goRight) player1.getShip().move("right");
				if (goLeft) player1.getShip().move("left");
				
				//Metodo para disparar
				shoot(dWeapon);
				//Verifica si golpea a un enemigo
				checkHit();
				
				//Verifica si las hileras estan activas
				if (game.getHilActual() != null)
					game.checkHils();
				
				//Verifica si el jugador queda sin vidas para terminar el juego
				if (player1.getShip().getLives() == 0) {
					game.endGame();
				}
			}
		};
		timer.start();
		
		
		//3rd Scene
		
		lblStats = new Label();
		lblStats.setText("Statistics:");
				
		VBox pane3 = new VBox(10);
		pane3.getChildren().addAll(lblStats);
				
		sceneStats = new Scene(pane3, height, width);
		
		background = new BackgroundImage(new Image("/images/backgroundC.png"), //Fondo de estrellas
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
		        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane3.setBackground(new Background(background));
		
		
	// Pone el primer Stage
		stage.getIcons().add(new Image(GameWindow.class.getResourceAsStream( "/images/ship.png" )));
		stage.setScene(sceneRegistration);
		stage.setTitle("Space Invaders");
		stage.setHeight(height);
		stage.setWidth(width);
		stage.setResizable(false);
		stage.show();
		
	}
	
	//Metodos
	
	/**
	 * Inicia varias variables del juego, pasa al segundo Stage
	 */
	public void start(){
		
		//Agrega el Objeto Jugador
		player1.setName("Player1");
		
		//Crea las primeras dos hileras
		game.setHils();
		lblActualHil.setText("Hilera Actual: " + game.getHilActual().getName());
		lblNextHil.setText("Hilera Prox: " + game.getHilNext().getName());

		lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
		lblScore.setText("Score: " + Integer.toString(player1.getActualScore()));
		
		game.showHils();
		
		stage.setScene(sceneGame);
	}
	

	/**
	 * Se encarga de los disparos de la nave
	 * @param vel - cantidad de pixeles por moverse
	 */
	public void shoot(int vel){
		for (int i=0; i< bullets.size(); i++) {
			if (bullets.get(i).getLayoutY() < height && bullets.get(i).getLayoutY() >= -10) {
				//Hace que constantemente se actualice la posicion de todas las bullets en la lista
				bullets.get(i).setLayoutY(bullets.get(i).getLayoutY() - vel);
			}
			else
				//Al llegar al tope se eliminan de la lista
				bullets.remove(i);
		}
	}	
		
	/**
	 * Verifica si el disparo ha impactado un Enemy
	 */
	public void checkHit() {
		if (bullets.size() != 0) {
			Enemy temp = game.getHilActual().getHead();			
			for (int i=0;i < bullets.size(); i++) {
				if (game.getHilActual().getTail() != null ) {
					while (temp != game.getHilActual().getTail()) {
						if (bullets.get(i).getBoundsInParent().intersects(temp.getImage().getBoundsInParent())) {
							System.out.println("Hit");
							game.getHilActual().destroyEnemy(temp.getName());
							player1.setActualScore(player1.getActualScore() + temp.getHits()*player1.getActualLevel());
							bullets.get(i).setLayoutY(-300);
							bullets.get(i).setLayoutX(-300);
							lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
							lblScore.setText("Score: " + Integer.toString(player1.getActualScore()));
		
							break;
							
						} else {
							temp = temp.getNext();
						}
					} 
					if (bullets.get(i).getBoundsInParent().intersects(game.getHilActual().getTail().getImage().getBoundsInParent())) {
						System.out.println("Hit");
						game.getHilActual().destroyEnemy(game.getHilActual().getTail().getName());
						player1.setActualScore(player1.getActualScore() + game.getHilActual().getTail().getHits()*player1.getActualLevel());
						bullets.get(i).setLayoutY(-300);
						bullets.get(i).setLayoutX(-300);
						lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
						lblScore.setText("Score: " + Integer.toString(player1.getActualScore()));
	
						break;
					}
				} else {
					
					while (temp != null) {
						if (bullets.get(i).getBoundsInParent().intersects(temp.getImage().getBoundsInParent())) {
							System.out.println("Hit");
							game.getHilActual().destroyEnemy(temp.getName());
							player1.setActualScore(player1.getActualScore() + temp.getHits()*player1.getActualLevel());
							bullets.get(i).setLayoutY(-300);
							bullets.get(i).setLayoutX(-300);
							lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
							lblScore.setText("Score: " + Integer.toString(player1.getActualScore()));
	
							break;
						} else {
							temp = temp.getNext();
						}	
					}
				}
			}
		}
	}
	
}