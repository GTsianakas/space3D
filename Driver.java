import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.AmbientLight;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import java.util.ArrayList;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Cylinder;
import javafx.scene.transform.Rotate;
import javafx.scene.paint.PhongMaterial;
import javafx.application.Platform;
import javafx.animation.AnimationTimer;
import javafx.stage.WindowEvent;

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

    //choose demo and load it into scene
    sphereList = new DemoThree().getList();
    for (PhysicalObject sphere : sphereList){ root.getChildren().add(sphere.draw()); }

    this.addCoordLines(root);
    camera = new MovingCamera();

    root.getChildren().add(new AmbientLight(Color.WHITE)); //lighting make objects shinier (or however you spell it)
    scene.setCamera(camera);
    stage.setTitle("3d space testing");
    stage.setScene(scene);

    this.eventHandling(scene,stage);

    Physics physics = new Physics(sphereList);

    //main loop
    new AnimationTimer(){

      @Override
      public void handle(long currentTime) {
        physics.updatePhysics();
        Driver.this.handleInput();
      }
    }.start();
    stage.show();
  }

  //all movements relative to initial positions for now
  private void handleInput(){
    //rotation
    if (userInput.contains("A")){ camera.rotateLeft(); }
    if (userInput.contains("D")){ camera.rotateRight(); }
    if (userInput.contains("W")){ camera.rotateUp(); }
    if (userInput.contains("S")){ camera.rotateDown(); }
    if (userInput.contains("E")){ camera.rotateZdown(); }
    if (userInput.contains("Q")){ camera.rotateZup(); }

    //translation
    if (userInput.contains("I")){ camera.moveUp(); }
    if (userInput.contains("J")){ camera.moveLeft(); }
    if (userInput.contains("L")){ camera.moveRight(); }
    if (userInput.contains("K")){ camera.moveDown(); }

    //in-out
    if (userInput.contains("N")){ camera.moveIn(); }
    if (userInput.contains("H")){ camera.moveOut(); }
  }

  //xyz axis line meeting at (0,0,0)
  private void addCoordLines(Group root){
    Cylinder xCyl = new Cylinder(1.0,2000);
    Cylinder yCyl = new Cylinder(1.0,2000);
    Cylinder zCyl = new Cylinder(1.0,2000);

    root.getChildren().add(xCyl);
    root.getChildren().add(yCyl);
    root.getChildren().add(zCyl);

    xCyl.setTranslateX(0); xCyl.setTranslateY(0); xCyl.setTranslateZ(0);
    yCyl.setTranslateX(0); yCyl.setTranslateY(0); yCyl.setTranslateZ(0);
    zCyl.setTranslateX(0); zCyl.setTranslateY(0); zCyl.setTranslateZ(0);

    xCyl.getTransforms().addAll(new Rotate(90,Rotate.Z_AXIS));
    zCyl.getTransforms().addAll(new Rotate(90,Rotate.X_AXIS));

    xCyl.setMaterial(new PhongMaterial(Color.RED));
    yCyl.setMaterial(new PhongMaterial(Color.GREEN));
    zCyl.setMaterial(new PhongMaterial(Color.BLUE));
  }

  private void eventHandling(Scene scene, Stage stage){
    //WindowEvents
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              System.out.println("Exiting");
              Platform.exit();
          }
      });

    //getting key input
    userInput = new ArrayList<String>();

    scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
      public void handle(KeyEvent e){
        String code = e.getCode().toString();
        // only add once prevent duplicates
        if (!userInput.contains(code)){ userInput.add(code); }
      }
    });

    scene.setOnKeyReleased(new EventHandler<KeyEvent>(){
      public void handle(KeyEvent e){
        String code = e.getCode().toString();
        userInput.remove(code);
      }
    });
  }

}//class
