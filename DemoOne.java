import java.util.ArrayList;

public class DemoOne{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoOne(){

    for (int i = 0; i < 1000; i++){
            list.add(new PhysicalSphere(1,  //size
                    Math.random()*0.2-0.1,  //xpos
                    Math.random()*0.2-0.1,  //ypos
                    Math.random()*0.2-0.1,  //zpos
                    Math.random()*1-0.5,    //xspeed
                    Math.random()*1-0.5,    //yspeed
                    Math.random()*1-0.5));  //zspeed
    }

  }

  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
