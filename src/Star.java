import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Star {
    public ArrayList<Planet> planets = new ArrayList<>();
    public double mass = 0;
    public double x = 0;
    public double y = 0;
    public Random r = new Random();
    public ArrayList<Planet> removePlanets = new ArrayList<>();

    public Star(double mass){
        this.mass = mass;
        this.x = 0;
        this.y = 0;


        for(int i = 0; i<50;i++){
            Planet p = new Planet(0,randinRange(-500,500),
                    randinRange(-1,1),0
                    ,randinRange(0,5));
            UniverseSim.planets.add(p);
            this.planets.add(p);
        }


        /*// MOOOON  N PLANET
        Planet p = new Planet(300,0,0,-1,20);
        Planet p2 = new Planet(305,-5,-0.05,-1.1,0.1);
        UniverseSim.planets.add(p);
        UniverseSim.planets.add(p2);
        this.planets.add(p);
        this.planets.add(p2);*/

        /*Planet p3 = new Planet(315,0,0,1.45,0.000001);
        Planet p4 = new Planet(300,0,0,1.3,1000);
        //Planet inner = new Planet(100,0,0,1,0.0000001);
        UniverseSim.planets.add(p3);
        this.planets.add(p3);
        UniverseSim.planets.add(p4);
        this.planets.add(p4);*/
        //UniverseSim.planets.add(inner);
        //this.planets.add(inner);
    }

    public void update(){
        for(Planet p:planets){
            p.update(this);
        }
    }

    public double randinRange(double min, double max){
        double rand = r.nextDouble();
        double scaled = rand*(max-min);
        return scaled + min;
    }
}
