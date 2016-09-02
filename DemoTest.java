import java.util.ArrayList;

public class DemoTest{

  ArrayList<PhysicalObject> list = new ArrayList<>();

  public DemoTest(){
    list.add(new PhysicalSphere(5.972E24,100,  //mass,size
            0.1,  //xpos
            0.1,  //ypos
            0.1,  //zpos
            0,//Math.random()*2-1,    //xspeed
            0,//Math.random()*2-1,    //yspeed
            0));//Math.random()*2-1));  //zspeed

      list.add(new PhysicalSphere(7.34767309E22,10,  //mass,size
              100,  //xpos
              0.1,  //ypos
              0.1,  //zpos
              0,//Math.random()*2-1,    //xspeed
              0,//Math.random()*2-1,    //yspeed
              0));//Math.random()*2-1));  //zspeed
  }



  public ArrayList<PhysicalObject> getList(){
    return this.list;
  }

}
