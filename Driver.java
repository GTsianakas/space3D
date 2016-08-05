import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.AmbientLight;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import java.util.ArrayList;
import javafx.scene.input.KeyEvent;

public class Driver extends Application{

    private final Group root = new Group();
    private final double HEIGHT = 1080;
    private final double WIDTH = 1920;
    
    private MovingCamera camera;

    private ArrayList<String> userInput = null;

    private ArrayList<PhysicalObject> sphereList = new ArrayList<>();

    @Override
    public void start(Stage stage){
	Scene scene = new Scene(root,WIDTH,HEIGHT,true, SceneAntialiasing.BALANCED);
	scene.setFill(Color.web("000000"));
	

	//objects/////////////////////////////////////////////
	//demo
	for (int i = 0; i < 50000; i++){
	    sphereList.add(new PhysicalSphere(1,Math.random()*500-250,Math.random()*500-250,Math.random()*500-250,Math.random()*40-20,Math.random()*40-20,Math.random()*40-20));
	}

	for (PhysicalObject sphere : sphereList){
	    root.getChildren().add(sphere.draw());
	}

	/////////////////////////////////////////////////////

	//camera
	camera = new MovingCamera();

	//lighting
	root.getChildren().add(new AmbientLight(Color.WHITE));

	scene.setCamera(camera);
	stage.setTitle("3d space testing");
	stage.setScene(scene);

	
	
	//getting key input
	userInput = new ArrayList<String>();
	
        scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
		public void handle(KeyEvent e){
		    String code = e.getCode().toString();
		    // only add once... prevent duplicates
		    if (!userInput.contains(code)){ userInput.add(code); }
		}
	    });
	
        scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
		public void handle(KeyEvent e){
		    String code = e.getCode().toString();
		    userInput.remove( code );
		}
	    });

	//Physics
	Physics physics = new Physics(sphereList);

	//simulation loop starts
	Timeline loop = new Timeline();
	loop.setCycleCount(Timeline.INDEFINITE);
	
	KeyFrame kf = new KeyFrame(Duration.seconds(0.017)/*60fps*/,
				   new EventHandler<ActionEvent>(){
				       public void handle(ActionEvent ae){
					   //looping stuff here

					   physics.updatePhysics();
					 					   
					   Driver.this.handleInput();
				       }
				   });
	
	loop.getKeyFrames().add(kf);
	loop.play();

	stage.show();
    }

    

    
    public void handleInput(){
	
	//rotation
	if (userInput.contains("A")){ camera.rotateLeft(); }
	if (userInput.contains("D")){ camera.rotateRight(); }
	if (userInput.contains("W")){ camera.rotateUp(); }
	if (userInput.contains("S")){ camera.rotateDown(); }

	//translation
	if (userInput.contains("I")){ camera.moveUp(); }
	if (userInput.contains("J")){ camera.moveLeft(); }
	if (userInput.contains("L")){ camera.moveRight(); }
	if (userInput.contains("K")){ camera.moveDown(); }

	//in-out
	if (userInput.contains("N")){ camera.moveIn(); }
	if (userInput.contains("H")){ camera.moveOut(); }

    }
}
