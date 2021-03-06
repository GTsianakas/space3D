import java.util.ArrayList;

public class Physics{

  private ArrayList<PhysicalObject> list = null;
  private static double interval = 0.03;
  private static final double GRAVITY_CONSTANT = 6.67408E-11; //m^3.kg^-1.s^-2

  public Physics(ArrayList<PhysicalObject> po){
    this.list = po;
  }

  public Physics(ArrayList<PhysicalObject> po, double interval){
    this.list = po;
    this.interval = interval;
  }

  public double gravityAcceleration(PhysicalObject s1, PhysicalObject s2){
    double distance = getDistance(s1,s2);
    return GRAVITY_CONSTANT *(s1.getMass() * s2.getMass())/(distance * distance);
  }

  public double getForceX(PhysicalObject o1, PhysicalObject o2){
    double d = getDistance(o1,o2);
    return ((GRAVITY_CONSTANT * o1.getMass() * o2.getMass() * getDistanceX(o1,o2))/d*d*d);
  }

  public double getForceY(PhysicalObject o1, PhysicalObject o2){
    double d = getDistance(o1,o2);
    return ((GRAVITY_CONSTANT * o1.getMass() * o2.getMass() * getDistanceY(o1,o2))/d*d*d);
  }

  public double getForceZ(PhysicalObject o1, PhysicalObject o2){
    double d = getDistance(o1,o2);
    return ((GRAVITY_CONSTANT * o1.getMass() * o2.getMass() * getDistanceZ(o1,o2))/d*d*d);
  }

  public double getDistance(PhysicalObject o1, PhysicalObject o2){

    //working with old positions so we the values wont change between calculations
    double a = o1.getPosX() - o2.getPosXOld();
    double b = o1.getPosY() - o2.getPosYOld();
    double c = o1.getPosZ() - o2.getPosZOld();

    return Math.sqrt(a*a + b*b + c*c);
  }

  public double getDistanceX(PhysicalObject o1, PhysicalObject o2){
    return o1.getPosX() - o2.getPosXOld();
  }

  public double getDistanceY(PhysicalObject o1, PhysicalObject o2){
    return o1.getPosY() - o2.getPosYOld();
  }

  public double getDistanceZ(PhysicalObject o1, PhysicalObject o2){
    return o1.getPosZ() - o2.getPosZOld();
  }

  //energy loss due to solar particles, meteorites, lights, and atoms throuout space
  //more drag at the fastest direction of travel
  private void energyLoss(PhysicalObject po){
    double Xspeed = po.getSpeedX();
    double Yspeed = po.getSpeedY();
    double Zspeed = po.getSpeedZ();
    double drag = 0.000001;

    if (Xspeed > 0){
      po.setSpeedX(Xspeed-(drag * (Xspeed*Xspeed/2)));
    }else{
      po.setSpeedX(Xspeed+(drag * (Xspeed*Xspeed/2)));
    }

    if (Yspeed > 0){
      po.setSpeedY(Yspeed-(drag * (Yspeed*Yspeed/2)));
    }else{
      po.setSpeedY(Yspeed+(drag * (Yspeed*Yspeed/2)));
    }

    if (Zspeed > 0){
      po.setSpeedZ(Zspeed-(drag * (Zspeed*Zspeed/2)));
    }else{
      po.setSpeedZ(Zspeed+(drag * (Zspeed*Zspeed/2)));
    }
  }

  public void updatePhysics(){
    for (PhysicalObject obj1 : list){
      for (PhysicalObject obj2 : list){
        if (obj1 != obj2){

          //opposite force
          obj1.setAccX(-getForceX(obj1,obj2) / obj1.getMass());
          obj1.setAccY(-getForceY(obj1,obj2) / obj1.getMass());
          obj1.setAccZ(-getForceZ(obj1,obj2) / obj1.getMass());

          //x speed
          obj1.setSpeedX(obj1.getAccX() * interval + obj1.getSpeedX());
          //y speed
          obj1.setSpeedY(obj1.getAccY() * interval + obj1.getSpeedY());
          //z speed
          obj1.setSpeedZ(obj1.getAccZ() * interval + obj1.getSpeedZ());

          //adding drag
          this.energyLoss(obj1);

          double forceX = (-obj1.getAccX()) * interval;
          double forceY = (-obj1.getAccY()) * interval;
          double forceZ = (-obj1.getAccZ()) * interval;

          //set displacement
          obj1.setPosX(obj1.getPosX()+obj1.getSpeedX()*interval - 0.5*forceX* interval * obj1.getAccX());
          obj1.setPosY(obj1.getPosY()+obj1.getSpeedY()*interval - 0.5*forceY* interval * obj1.getAccY());
          obj1.setPosZ(obj1.getPosZ()+obj1.getSpeedZ()*interval - 0.5*forceZ* interval * obj1.getAccZ());
          //System.out.println(obj1.getPosX());



        }
      }
    }
    //to update pos together for correct calculations
    for (PhysicalObject obj : list){
      obj.update();
      obj.updateOldPositions();
    }

  }

}//class
