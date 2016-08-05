import javafx.scene.shape.Sphere;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.Node;

public class PhysicalSphere extends PhysicalObject implements Drawable{


    private Sphere sphere;

    public PhysicalSphere(double radius, double x, double y, double z, double sx, double sy, double sz){
	sphere = new Sphere(radius);

	this.setPosX(x);
	this.setPosY(y);
	this.setPosZ(z);

	this.setSpeedX(sx);
	this.setSpeedY(sy);
	this.setSpeedZ(sz);
    }

    public Node draw(){
	
	return sphere;
    }

    public void update(){
	sphere.setTranslateX(this.getPosX());
	sphere.setTranslateY(this.getPosY());
	sphere.setTranslateZ(this.getPosZ());
    }

}
