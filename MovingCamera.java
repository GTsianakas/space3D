import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

public class MovingCamera extends PerspectiveCamera{

    private double cameraSpeed = 10;

    public MovingCamera(){
	super(true);
	this.setVerticalFieldOfView(false);
	this.setNearClip(0.1);
	this.setFarClip(100000.0);
	this.getTransforms().addAll(new Translate(0,0,-3000));
    }


    public double getSpeed(){
	return cameraSpeed;
    }

    public void setSpeed(double s){
	this.cameraSpeed = s;
    }

    public void rotateLeft(){
	this.getTransforms().addAll(new Rotate(-0.3,Rotate.Y_AXIS));

    }
    public void rotateRight(){
	this.getTransforms().addAll(new Rotate(0.3,Rotate.Y_AXIS));

    }
    public void rotateUp(){
	this.getTransforms().addAll(new Rotate(0.3,Rotate.X_AXIS));

    }

    public void rotateDown(){
	this.getTransforms().addAll(new Rotate(-0.3,Rotate.X_AXIS));
				    
    }

    public void moveUp(){
	this.setTranslateY(this.getTranslateY()-cameraSpeed);
    }
    public void moveDown(){
	this.setTranslateY(this.getTranslateY()+cameraSpeed);
    }
    public void moveLeft(){
	this.setTranslateX(this.getTranslateX()-cameraSpeed);
    }
    public void moveRight(){
	this.setTranslateX(this.getTranslateX()+cameraSpeed);
    }
    public void moveIn(){
	this.setTranslateZ(this.getTranslateZ()-cameraSpeed);
    }
    public void moveOut(){
	this.setTranslateZ(this.getTranslateZ()+cameraSpeed);
    }

    //do rotations as well

}
