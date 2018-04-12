package game;


import javafx.animation.TranslateTransition;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;


/**
 * Main
 * @author Rubén Salas
 * @version 1.6
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
	Button btnStart;
	TextField txtPlayer;
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
	
	Label lblLives;
	Label lblScore;
	Label lblActualHil;
	Label lblNextHil;
	Label lblLevel;
	String font = "Arial";
	int fontSize = 16;
	
	Button btnSwitch2;
	
	static Circle bullet;
	
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
		
		txtPlayer = new TextField();
		txtPlayer.setMinWidth(200);
		txtPlayer.setMaxWidth(200);
		txtPlayer.setPromptText("Enter Player's Name");

		btnStart = new Button();
		btnStart.setText("Start");
		//btnStart.setDisable(true); //deshabilta el boton
		btnStart.setOnAction(
				e -> btnStart_Click() );

		//HACER UN EVENT HANDLER CUANDO SE PRESIONE ENTER SE INGRESE EL NOMBRE
		//QUITAR EL BOTON
		
		VBox panePrompt = new VBox(10);
		panePrompt.getChildren().addAll(txtPlayer, btnStart);
		
		Pane mainPane = new Pane();
		mainPane.getChildren().addAll(panePrompt);
		panePrompt.setLayoutX(325.0);
		panePrompt.setLayoutY(440.0);
		
		background = new BackgroundImage(new Image("/images/backgroundA.png"), //Fondo de estrellas
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
		        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		mainPane.setBackground(new Background(background));
		
		sceneRegistration = new Scene(mainPane, height, width); 
		
		
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

		imageBoss = new Image(getClass().getResourceAsStream("/images/boss.gif"));
		imageBoss1 = new ImageView(imageBoss);
				
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

		bullet = new Circle(-450, -450, 5);
		bullet.setStroke(Color.ORANGE);
		bullet.setFill(Color.YELLOW);
		
		//Boton Switch TEST
//		btnSwitch2 = new Button();
//		btnSwitch2.setText("Switch!");
//		btnSwitch2.setOnAction(
//				e -> btnSwitch2_Click() );
		
		//Botton Test 2 TEST 
//		Button btnTest2 = new Button();
//		btnTest2.setText("TEST");
//		btnTest2.setOnAction(
//				e -> btnTest2_Click() );
		
		//Layout Pane para Estadisticas arriba del juego
		Pane statsPane = new Pane();
		statsPane.getChildren().addAll(imageLives1, imageLives2, imageLives3, imageShip, 
				imageEnemy1, imageEnemy2, imageEnemy3, imageEnemy4, imageEnemy5,
				imageEnemy6, imageEnemy7, imageEnemy8, imageEnemy9, imageBoss1,
				bullet,
				lblLives, lblScore, lblActualHil, lblNextHil, lblLevel);
		
		Pane gamePane = new Pane();
		
		BorderPane pane2 = new BorderPane();
		pane2.setTop(statsPane);
		pane2.setCenter(gamePane);
//		pane2.setBottom(btnSwitch2);
//		pane2.setRight(btnTest2);
		
		//Fondo en gamePane
		background = new BackgroundImage(new Image("/images/backgroundB.png"), //Fondo de estrellas
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
		        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane2.setBackground(new Background(background));
		
		sceneGame = new Scene(pane2, height, width);
		
		Thread shipMovement = new Thread(new Runnable() {
			public void run() {
				 sceneGame.setOnKeyPressed(
						 e -> {
							 switch (e.getCode()) {
							 case RIGHT:
								 player1.getShip().move("right");
								 break;
							 case LEFT:
								 player1.getShip().move("left");
								 break;
							 case SPACE:
								 player1.getShip().shoot();
								 break;
							default:
								break;
							 }
						 }
					);
				 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			 }
		} );
		
		shipMovement.start();
		
		
		
//		sceneGame.setOnKeyPressed(new EventHandler<KeyEvent>() {
//			public void handle(KeyEvent arg0) {
//				// TODO Auto-generated method stub
//			}
//		});
		
		
		
		//3rd Scene
		
		lblStats = new Label();
		lblStats.setText("Show Stats");
				
		btnStats = new Button();
		btnStats.setText("Score");
		btnStats.setOnAction(
				e -> btnStats_Click() );
				
		btnSwitch3 = new Button();
		btnSwitch3.setText("Switch!");
		btnSwitch3.setOnAction(
				e -> btnSwitch3_Click() );
				
		VBox pane3 = new VBox(10);
		pane3.getChildren().addAll(lblStats, btnStats, btnSwitch3);
				
		sceneStats = new Scene(pane3, height, width);
		
		
		background = new BackgroundImage(new Image("/images/backgroundC.png"), //Fondo de estrellas
		        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, 
		        BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		pane3.setBackground(new Background(background));
		
		
	// Set the stage with scene 1 and show the stage
		stage.setScene(sceneRegistration);
		stage.setTitle("Space Invaders");
		stage.setHeight(height);
		stage.setWidth(width);
		stage.setResizable(false);
		stage.show();
		
	}
	
	// Event handlers for scene 1
	public void btnStart_Click(){
		
		//Agrega el nombre del prompt al Objeto
		
		player1.setName(txtPlayer.getText());
		System.out.println("Player1: " + player1.getName());
		
		//Crea las primeras dos hileras
		game.setHils();
		lblActualHil.setText("Hilera Actual: " + game.getHilActual().getName());
		lblNextHil.setText("Hilera Prox: " + game.getHilNext().getName());

		lblLevel.setText("Level: " + Integer.toString(player1.getActualLevel()));
		lblScore.setText("Score: " + Integer.toString(player1.getActualScore()));
		
		game.showHils();
		
		
		
		stage.setScene(sceneGame);
	}
	
	public static void makeBullet(){
		bullet = new Circle(player1.getShip().getPosX() + 50, 530, 5);
		bullet.setStroke(Color.ORANGE);
		bullet.setFill(Color.YELLOW);
	}
	
	
	// Event handlers for scene 2			
	private void btnSwitch2_Click() {
		stage.setScene(sceneStats);
		}
	
	private void btnTest2_Click() {
		lblActualHil.setText("Hilera Actual: Hilera Clase A");
		lblNextHil.setText("Hilera Prox: Hilera Clase B");
		
		imageLives2.setLayoutX(80.0);
		imageLives3.setLayoutX(110.0);
	}
	
	// Event handlers for scene 3
	public void btnStats_Click(){
		score = score * 5;
		lblStats.setText("Score: "
				+ score);
	}
				
	private void btnSwitch3_Click() {
		stage.setScene(sceneRegistration);
		}

}

//                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  