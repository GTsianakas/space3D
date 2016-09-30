import java.util.ArrayList;

public class DemoThree{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoThree(){
    for (int i = 0; i < 500; i++){
            list.add(new PhysicalSphere(1,  //size
                    Math.random()*600.2-300.1+500,  //xpos
                    Math.random()*600.2-300.1,  //ypos
                    Math.random()*600.2-300.1,  //zpos
                                            0,    //xspeed
                                            0,    //yspeed
                                            0));  //zspeed
    }

    for (int i = 0; i < 500; i++){
            list.add(new PhysicalSphere(1,  //size
                    Math.random()*600.2-300.1-500,  //xpos
                    Math.random()*600.2-300.1,  //ypos
                    Math.random()*600.2-300.1,  //zpos
                                            0,  //xspeed
                                            0,    //yspeed
                                            0));  //zspeed
    }

  /*  list.add(new PhysicalSphere(2000,10,  //mass //size
                                200,  //xpos
                                -800,  //ypos
                                1,  //zpos
                                0,//Math.random()*2-1,    //xspeed
                                0,//Math.random()*2-1,    //yspeed
                                0));//Math.random()*2-1));  //zspeed */

  }

  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
