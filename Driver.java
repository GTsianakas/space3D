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

  //lines
  private Cylinder xCyl = new Cylinder(1.0,2000);
  private Cylinder yCyl = new Cylinder(1.0,2000);
  private Cylinder zCyl = new Cylinder(1.0,2000);

  @Override
  public void start(Stage stage){
    Scene scene = new Scene(root,WIDTH,HEIGHT,true, SceneAntialiasing.BALANCED);
    scene.setFill(Color.web("000000"));

    //massless particle to allow calculation for alone objects
    //PhysicalSphere massless = new PhysicalSphere(1,1,1,0,0,0,0);
    //massless.setMass(0); sphereList.add(massless);

    //demo
    for (int i = 0; i < 500; i++){
      sphereList.add(new PhysicalSphere(1,  //size
                    Math.random()*600-300-400,  //xpos
                    Math.random()*600-300,  //ypos
                    Math.random()*600-300,  //zpos
                    0,//Math.random()*0.4-0.2+0.2,    //xspeed
                    0,//Math.random()*0.4-0.2,    //yspeed
                    0));//Math.random()*0.4-0.2));  //zspeed
    }

    for (int i = 0; i < 500; i++){
      sphereList.add(new PhysicalSphere(1,  //size
                    Math.random()*600-300+400,  //xpos
                    Math.random()*600-300,  //ypos
                    Math.random()*600-300,  //zpos
                    0,//Math.random()*0.4-0.2+0.2,    //xspeed
                    0,//Math.random()*0.4-0.2,    //yspeed
                    0));//Math.random()*0.4-0.2));  //zspeed
    }

    //big one doesnt work with diferent masse yet
    /*PhysicalSphere blackHole  = new PhysicalSphere(10,1,1,1,0,0,0);
    blackHole.setMass(100000);
    sphereList.add(blackHole);

    PhysicalSphere blackHole1  = new PhysicalSphere(1,20,20,20,0,0,0);
    blackHole1.setMass(1);
    sphereList.add(blackHole1);*/


    //add the spheres to the roots children
    for (PhysicalObject sphere : sphereList){ root.getChildren().add(sphere.draw()); }

    //coord lines
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

    //camera
    camera = new MovingCamera();

    //lighting make objects shinier (or however you spell it)
    root.getChildren().add(new AmbientLight(Color.WHITE));

    scene.setCamera(camera);
    stage.setTitle("3d space testing");
    stage.setScene(scene);

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

  public void handleInput(){
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

}
