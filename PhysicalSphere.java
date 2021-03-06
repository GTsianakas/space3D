import javafx.scene.shape.Sphere;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.Node;

public class PhysicalSphere extends PhysicalObject implements Drawable{

    private Sphere sphere;

    public PhysicalSphere(double radius, double x, double y, double z, double sx, double sy, double sz){
    	sphere = new Sphere(radius);
    	sphere.setMaterial(new PhongMaterial(Color.WHITE));

    	this.setPosX(x);
    	this.setPosY(y);
    	this.setPosZ(z);
      
      this.setPosXOld(x);
    	this.setPosYOld(y);
    	this.setPosZOld(z);

    	this.setSpeedX(sx);
    	this.setSpeedY(sy);
    	this.setSpeedZ(sz);

    	//this.setMass(5.972E24); //earth mass
      this.setMass(1);
    }

    public PhysicalSphere(double mass,double radius, double x, double y, double z, double sx, double sy, double sz){
      this(radius, x,  y, z, sx, sy, sz);
      this.setMass(mass);
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
