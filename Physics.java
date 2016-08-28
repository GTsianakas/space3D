import java.util.ArrayList;

public class Physics{

  private ArrayList<PhysicalObject> list = null;
  private static double interval = 0.01;
  private static final double GRAVITY_CONSTANT = 6.67408E-11; //m^3.kg^-1.s^-2

  public Physics(ArrayList<PhysicalObject> po){
    this.list = po;
  }

  public double gravityAcceleration(PhysicalObject s1, PhysicalObject s2){
    double distance = getDistance(s1,s2);
    return GRAVITY_CONSTANT *(s1.getMass() * s2.getMass())/(distance * distance);
  }

  //assumes all objects same mass
  public double getForceX(PhysicalObject o1, PhysicalObject o2){
    double d = getDistance(o1,o2);
    return ((GRAVITY_CONSTANT * o1.getMass() * o2.getMass() *getDistanceX(o1,o2))/d*d*d)/2;
  }

  //assumes all objects same mass
  public double getForceY(PhysicalObject o1, PhysicalObject o2){
    double d = getDistance(o1,o2);
    return ((GRAVITY_CONSTANT * o1.getMass() * o2.getMass() *getDistanceY(o1,o2))/d*d*d)/2;
  }

  //assumes all objects same mass
  public double getForceZ(PhysicalObject o1, PhysicalObject o2){
    double d = getDistance(o1,o2);
    return ((GRAVITY_CONSTANT * o1.getMass() * o2.getMass() * getDistanceZ(o1,o2))/d*d*d)/2;
  }

  public double getDistance(PhysicalObject o1, PhysicalObject o2){
    double a = o1.getPosX() - o2.getPosX();
    double b = o1.getPosY() - o2.getPosY();
    double c = o1.getPosZ() - o2.getPosZ();
    return Math.sqrt(a*a + b*b + c*c);
  }

  public double getDistanceX(PhysicalObject o1, PhysicalObject o2){
    return o1.getPosX() - o2.getPosX();
  }

  public double getDistanceY(PhysicalObject o1, PhysicalObject o2){
    return o1.getPosY() - o2.getPosY();
  }

  public double getDistanceZ(PhysicalObject o1, PhysicalObject o2){
    return o1.getPosZ() - o2.getPosZ();
  }

  public void updatePhysics(){
  //assumes same mass for all particles
    for (PhysicalObject obj1 : list){
      for (PhysicalObject obj2 : list){
        if (obj1 != obj2){

          //in order to work with negative coords, thats why getForce doesn't absolute the value
          obj1.setAccX(-getForceX(obj1,obj2));
          obj1.setAccY(-getForceY(obj1,obj2));
          obj1.setAccZ(-getForceZ(obj1,obj2));

          //x speed
          obj1.setSpeedX(obj1.getAccX() + obj1.getSpeedX());
          //y speed
          obj1.setSpeedY(obj1.getAccY() + obj1.getSpeedY());
          //z speed
          obj1.setSpeedZ(obj1.getAccZ() + obj1.getSpeedZ());

          double forceX = (-obj1.getAccX()) * interval;
          double forceY = (-obj1.getAccY()) * interval;
          double forceZ = (-obj1.getAccZ()) * interval;

          //set displacement
          obj1.setPosX(obj1.getPosX()+obj1.getSpeedX()*interval - 0.5*forceX*obj1.getAccX());
          obj1.setPosY(obj1.getPosY()+obj1.getSpeedY()*interval - 0.5*forceY*obj1.getAccY());
          obj1.setPosZ(obj1.getPosZ()+obj1.getSpeedZ()*interval - 0.5*forceZ*obj1.getAccZ());
        }
        obj1.update();
      }
    }
  }

}
