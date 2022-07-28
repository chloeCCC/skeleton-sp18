public class NBody {        
	public static double readRadius(String f) {
                @Deprecated
		In in = new In(f);
                int n = in.readInt();
                double r = in.readDouble();
                return r;
        }

	public static Planet[] readPlanets(String f) {
		Planet[] pArray = new Planet[5];
		In in = new In(f);
		int n = in.readInt();
		double r = in.readDouble();
		int i = 0;
		while (i < 5) {
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();			
			double yyVel = in.readDouble();
			double m = in.readDouble();
			String s = in.readString();
			Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, m, s);
			pArray[i] = p;
			i++;
		}
		return pArray;
	
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String fileName = args[2];
		double r = readRadius(fileName);
		Planet[] pArray = readPlanets(fileName);
		StdDraw.setScale(-r, r);
		StdDraw.clear();
		StdDraw.picture(0, 0,"/images/starfield.jpg");
		for(Planet p: pArray) {
			p.draw();
		}
		StdDraw.show();
		StdDraw.pause(10);
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time < T) {
			double[] xForces = new double[pArray.length];
			double[] yForces = new double[pArray.length];
			int i = 0;
			for (Planet p: pArray) {
				xForces[i] = p.calcNetForceExertedByX(pArray);
				yForces[i] = p.calcNetForceExertedByY(pArray);
				p.update(dt, xForces[i], yForces[i]);
				i++;
			}
			StdDraw.picture(0, 0,"/images/starfield.jpg");
			for(Planet p: pArray) {
                	        p.draw();
               		 }
                	StdDraw.show();
                	StdDraw.pause(10);
			time += dt;
		}		
		StdOut.printf("%d\n", pArray.length);
		StdOut.printf("%.2e\n", r);
		for (int i = 0; i < pArray.length; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  	pArray[i].xxPos, pArray[i].yyPos, pArray[i].xxVel,
                  	pArray[i].yyVel, pArray[i].mass, pArray[i].imgFileName);   
		}		

	}

}
