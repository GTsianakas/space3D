import javafx.scene.transform.Rotate;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Translate;

public class MovingCamera extends PerspectiveCamera{

  private double cameraMovementSpeed = 10;
  private double cameraRotationSpeed = 0.8;

  public MovingCamera(){
    super(true);
    this.setVerticalFieldOfView(false);
    this.setNearClip(0.1);
    this.setFarClip(100000.0);
    this.getTransforms().addAll(new Translate(0,0,-3000));
  }

  public double getMovementSpeed(){
    return cameraMovementSpeed;
  }

  public void setMovementSpeed(double s){
    this.cameraMovementSpeed = s;
  }

  public double getRotationSpeed(){
    return cameraRotationSpeed;
  }

  public void setRotationSpeed(double s){
    this.cameraRotationSpeed = s;
  }

  public void rotateLeft(){
    this.getTransforms().addAll(new Rotate(-cameraRotationSpeed,Rotate.Y_AXIS));
  }

  public void rotateRight(){
    this.getTransforms().addAll(new Rotate(cameraRotationSpeed,Rotate.Y_AXIS));
  }

  public void rotateUp(){
    this.getTransforms().addAll(new Rotate(cameraRotationSpeed,Rotate.X_AXIS));
  }

  public void rotateDown(){
    this.getTransforms().addAll(new Rotate(-cameraRotationSpeed,Rotate.X_AXIS));
  }

  public void rotateZup(){
    this.getTransforms().addAll(new Rotate(cameraRotationSpeed,Rotate.Z_AXIS));
  }

  public void rotateZdown(){
    this.getTransforms().addAll(new Rotate(-cameraRotationSpeed,Rotate.Z_AXIS));
  }

  public void moveUp(){
    this.setTranslateY(this.getTranslateY()-cameraMovementSpeed);
  }
  public void moveDown(){
    this.setTranslateY(this.getTranslateY()+cameraMovementSpeed);
  }
  public void moveLeft(){
    this.setTranslateX(this.getTranslateX()-cameraMovementSpeed);
  }
  public void moveRight(){
    this.setTranslateX(this.getTranslateX()+cameraMovementSpeed);
  }
  public void moveIn(){
    this.setTranslateZ(this.getTranslateZ()-cameraMovementSpeed);
  }
  public void moveOut(){
    this.setTranslateZ(this.getTranslateZ()+cameraMovementSpeed);
  }

}
