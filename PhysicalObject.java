
import javafx.scene.Node;

public abstract class PhysicalObject implements Drawable{

  private double speedX;
  private double speedY;
  private double speedZ;

  private double accelerationX;
  private double accelerationY;
  private double accelerationZ;

  private double mass;

  private double posX;
  private double posY;
  private double posZ;

  public void setMass(double m){
    this.mass = m;
  }

  public double getMass(){
    return mass;
  }

  public void setAccX(double acc){
    this.accelerationX = acc;
  }

  public void setAccY(double acc){
    this.accelerationY = acc;
  }

  public void setAccZ(double acc){
    this.accelerationZ = acc;
  }

  public double getAccX(){
    return this.accelerationX;
  }

  public double getAccY(){
    return this.accelerationY;
  }

  public double getAccZ(){
    return this.accelerationZ;
  }

  public void setSpeed(double x, double y,double z){
    this.speedX = x;
    this.speedY = y;
    this.speedZ = z;
  }

  public void setSpeedX(double s){
    this.speedX = s;
  }

  public void setSpeedY(double s){
    this.speedY = s;
  }

  public void setSpeedZ(double s){
    this.speedZ = s;
  }

  public double getSpeedX(){
    return speedX;
  }

  public double getSpeedY(){
    return speedY;
  }

  public double getSpeedZ(){
    return speedZ;
  }

  public double[] getSpeedVector(){
    return new double[] {this.speedX,this.speedY,this.speedZ};
  }

  public Point3D getPos(){
    return new Point3D(this.posX,this.posY,this.posZ);
  }

  public void setPos(double x, double y, double z){
    this.posX = x;
    this.posY = y;
    this.posZ = z;
  }

  public void setPosX(double p){
    this.posX = p;
  }

  public void setPosY(double p){
    this.posY = p;
  }

  public void setPosZ(double p){
    this.posZ = p;
  }

  public double getPosX(){
    return posX;
  }

  public double getPosY(){
    return posY;
  }

  public double getPosZ(){
    return posZ;
  }

  public Node draw(){
    return null;
  }

  public void update(){}

}
