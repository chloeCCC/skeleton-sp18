import static java.lang.Math.*;
public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11; 	

	public Planet(double xP, double yP, double xV,
			double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;

	}

	public Planet(Planet p) {
		p.xxPos = this.xxPos;
		p.yyPos = this.yyPos;
		p.xxVel = this.xxVel;
		p.yyVel = this.yyVel;
		p.mass = this.mass;
		p.imgFileName = this.imgFileName;

	}
	
	public double calcDistance(Planet p) {
		double dx = (p.xxPos - this.xxPos);
		double dy = (p.yyPos - this.yyPos);
		double r = sqrt((dx*dx) + (dy*dy));
		return r;
	}
	
	public double calcForceExertedBy(Planet p) {
		double f = G * this.mass * p.mass / (calcDistance(p)*calcDistance(p));

		return f; 
	}

	public double calcForceExertedByX(Planet p) {
		double dx = (p.xxPos - this.xxPos);
		double fx = calcForceExertedBy(p)*dx/calcDistance(p);
		return fx;
	}

        public double calcForceExertedByY(Planet p) {
                double dy = (p.yyPos - this.yyPos);
                double fy = calcForceExertedBy(p)*dy/calcDistance(p);
                return fy;
        }
	
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double fx = 0.0;
		for (Planet p:allPlanets) {
			if (this.equals(p)) {
			} else {
			fx += calcForceExertedByX(p);
			}
		}
		return fx;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
                double fy = 0.0;
                for (Planet p:allPlanets) {
                        if (this.equals(p)) {
                        } else {
                        fy += calcForceExertedByY(p);
                        }
                }
                return fy;
	}

	public void update(double dt, double fx, double fy) {
		double ax = fx / this.mass;
		double ay = fy / this.mass;
		this.xxVel = xxVel + dt*ax;
		this.yyVel = yyVel + dt*ay;
		this.xxPos = xxPos + dt*xxVel;
		this.yyPos = yyPos + dt*yyVel; 
		
	}

	public double readRadius(String f) {
		In in = new In(f);
		int n = in.readInt();
		double r = in.readDouble();
		return r;
	}
	
	public void draw() {
		String filePath = "/images/" + imgFileName;
		StdDraw.picture(xxPos, yyPos, filePath);
	}	
}
