import java.util.ArrayList;

public class DemoTest{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoTest(){
    for (int i = 0; i < 500; i++){
            list.add(new PhysicalSphere(100,1,  //mass,size
                    Math.random()*600-300+500,  //xpos
                    Math.random()*600-300,  //ypos
                    Math.random()*600-300,  //zpos
                    0,//Math.random()*2-1,    //xspeed
                    0,//Math.random()*2-1,    //yspeed
                    0));//Math.random()*2-1));  //zspeed
    }

    for (int i = 0; i < 500; i++){
            list.add(new PhysicalSphere(100,1,  //mass,size
                    Math.random()*600-300-500,  //xpos
                    Math.random()*600-300,  //ypos
                    Math.random()*600-300,  //zpos
                    0,//Math.random()*2-1,    //xspeed
                    0,//Math.random()*2-1,    //yspeed
                    0));//Math.random()*2-1));  //zspeed
}

  }

  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
