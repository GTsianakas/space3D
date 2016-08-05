import java.util.ArrayList;

public class Physics{

    ArrayList<PhysicalObject> list = null;

    private static final double GRAVITY_CONSTANT = 6.67408E-11; //m^3.kg^-1.s^-2

    public Physics(ArrayList<PhysicalObject> ps){
	this.list = ps;
    }

    public double gravityAcceleration(PhysicalObject s1, PhysicalObject s2){
    	return GRAVITY_CONSTANT *(s1.getMass() * s2.getMass())/Math.pow(getDistance(s1,s2),2);
    }

    public double getDistance(PhysicalObject s1, PhysicalObject s2){
    	return Math.pow(Math.pow(s1.getPosX()-s2.getPosX(),2)+Math.pow(s1.getPosY()-s2.getPosY(),2)+Math.pow(s1.getPosZ()-s2.getPosZ(),2),-2);
    }

    public void gravityPull(){
    	
    }

    //demo
    public void updatePhysics(){
		for (PhysicalObject obj : list){
	        if (obj.getPosX() > 500  || 
			    obj.getPosX() < -500 ||
			    obj.getPosY() > 500  || 
			    obj.getPosY() < -500 ||
			    obj.getPosZ() > 500  || 
			    obj.getPosZ() < -500 ){
			    
			    obj.setSpeed(obj.getSpeedX()*-1,obj.getSpeedY()*-1,obj.getSpeedZ()*-1);
			}
			
		//obj.move();
		
		obj.setPosX(obj.getPosX() + obj.getSpeedX());
		obj.setPosY(obj.getPosY() + obj.getSpeedY());
		obj.setPosZ(obj.getPosZ() + obj.getSpeedZ());

		obj.update();
		}
    }
    

}
