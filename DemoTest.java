import java.util.ArrayList;

public class DemoTest{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoTest(){

    list.add(new PhysicalSphere(5.972E24,10,  //mass //size
            1,  //xpos
            1,  //ypos
            1,  //zpos
            0,//Math.random()*2-1,    //xspeed
            0,//Math.random()*2-1,    //yspeed
            0));//Math.random()*2-1));  //zspeed



    list.add(new PhysicalSphere(7.347E22,2,  //size
            384400000,  //xpos
            0,  //ypos
            0,  //zpos
            0,//Math.random()*2-1,    //xspeed
            0,//Math.random()*2-1,    //yspeed
            0));//Math.random()*2-1));  //zspeed

  }



  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
