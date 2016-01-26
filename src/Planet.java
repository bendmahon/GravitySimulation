import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Planet {
    public double mass;
    public double x = 0;
    public double y = 0;
    public double xv = 0;
    public double yv = 0;
    public Color color = Color.black;
    public List<Double> xs = new ArrayList<Double>();
    public List<Double> ys = new ArrayList<Double>();

    public Planet(double x, double y, double xv, double yv, double mass){
        this.x = x;
        this.y = y;
        this.xv = xv;
        this.yv = yv;
        this.mass = mass;
        this.color = new Color(UniverseSim.r.nextFloat(),UniverseSim.r.nextFloat(),UniverseSim.r.nextFloat());
    }

    public void update(Star s){
        for(int i=0;i<UniverseSim.steps;i++) {
            double rDiffx = this.x-s.x;
            double rDiffy = this.y-s.y;
            double rLen = Math.sqrt(Math.pow(rDiffx, 2)+Math.pow(rDiffy,2));
            double rDiv = UniverseSim.dt / Math.pow(rLen, 3);
            xv -= rDiffx * UniverseSim.G * s.mass * rDiv;
            yv -= rDiffy * UniverseSim.G * s.mass * rDiv;
            x += xv * UniverseSim.dt;
            y += yv * UniverseSim.dt;

        }

        for(Planet p:s.planets){
            if(p!=this) {
                for(int i=0;i<UniverseSim.steps;i++) {
                    double rDiffx = this.x - p.x;
                    double rDiffy = this.y - p.y;
                    double rLen = Math.sqrt(Math.pow(rDiffx, 2) + Math.pow(rDiffy, 2));
                    double rDiv = UniverseSim.dt / Math.pow(rLen, 3);
                    xv -= rDiffx * UniverseSim.G * p.mass * rDiv;
                    yv -= rDiffy * UniverseSim.G * p.mass * rDiv;
                    x += xv * UniverseSim.dt;
                    y += yv * UniverseSim.dt;
                }
            }else{}
        }
        xs.add(x);
        ys.add(y);
        //System.out.println("X: " + x + " Y:" + y + " xv: "+xv + " yv: "+yv);
    }

    public double distance(double x1, double x2, double y1, double y2){
        return Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
    }
}
