import java.util.ArrayList;

public class DemoOne{

  ArrayList<PhysicalObject> sphereList = new ArrayList<>();

  public DemoOne(){

    for (int i = 0; i < 1000; i++){
      sphereList.add(new PhysicalSphere(1,  //size
                    Math.random()*0.2-0.1,  //xpos
                    Math.random()*0.2-0.1,  //ypos
                    Math.random()*0.2-0.1,  //zpos
                    Math.random()*20-10,    //xspeed
                    Math.random()*20-10,    //yspeed
                    Math.random()*20-10));  //zspeed
    }

  }

  public ArrayList<PhysicalObject> getList(){
    return this.sphereList;
  }

}