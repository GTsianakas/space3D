import java.util.ArrayList;

public class DemoTwo{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoTwo(){
    PhysicalSphere earth = new PhysicalSphere(10,0,0,0,0,0,0);
    earth.setMass(100);
    list.add(earth);

    PhysicalSphere moon = new PhysicalSphere(2,-100,0,0,0,10,10);
    list.add(moon);

    PhysicalSphere moon2 = new PhysicalSphere(2,100,50,0,0,0,10);
    list.add(moon2);

  }

  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
