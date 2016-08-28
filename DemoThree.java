import java.util.ArrayList;

public class DemoThree{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoThree(){
    for (int i = 0; i < 500; i++){
            list.add(new PhysicalSphere(1,  //size
                    Math.random()*0.2-0.1+500,  //xpos
                    Math.random()*0.2-0.1,  //ypos
                    Math.random()*0.2-0.1,  //zpos
                    Math.random()*2-1,    //xspeed
                    Math.random()*2-1,    //yspeed
                    Math.random()*2-1));  //zspeed
    }

    for (int i = 0; i < 500; i++){
            list.add(new PhysicalSphere(1,  //size
                    Math.random()*0.2-0.1-500,  //xpos
                    Math.random()*0.2-0.1,  //ypos
                    Math.random()*0.2-0.1,  //zpos
                    Math.random()*2-1,    //xspeed
                    Math.random()*2-1,    //yspeed
                    Math.random()*2-1));  //zspeed
    }

  }

  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
