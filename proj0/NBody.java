
public class NBody{
    public static double readRadius(String file){
        In in = new In(file);
		in.readInt();
		double radius = in.readDouble();
		return radius;
    }
    public static Body[] readBodies(String file){
        In in = new In(file);
        int numberOfmyBodies = in.readInt();
        Body[] myBodies = new Body[numberOfmyBodies];
        double radius = in.readDouble();
        for(int i=0; i<myBodies.length; i++){
          myBodies[i] = createBodyFromData(in);
        }
        return myBodies;
    }
     private static Body createBodyFromData(In n){
        double xxPosition = n.readDouble();
        double yyPosition = n.readDouble();
        double xxVelocity = n.readDouble();
        double yyVelocity = n.readDouble();
        double mass = n.readDouble();
        String img = n.readString();
        return new Body(xxPosition,yyPosition,xxVelocity,yyVelocity,mass,img);
    } 

    public static void main(String[] args){
        if(args.length!=3){
            System.out.println("Please specify all 3 required arguments to run the program.");
            return;
        }
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Body[] myBodies = readBodies(filename);
        int bodiesNumber = myBodies.length;
        StdDraw.enableDoubleBuffering();
        double time = 0;
        while(time<T){
        StdDraw.setScale(-radius, radius);

        StdDraw.clear();
        
        StdDraw.picture(0,0, "images/starfield.jpg");
        double[] xForces = new double[bodiesNumber];
        double[] yForces = new double[bodiesNumber];

        for(int i=0; i<bodiesNumber; i++){
            xForces[i] = myBodies[i].calcNetForceExertedByX(myBodies);
            yForces[i] = myBodies[i].calcNetForceExertedByY(myBodies);
        }
        for(int i =0; i<bodiesNumber; i++){
            myBodies[i].update(dt, xForces[i], yForces[i]);
            myBodies[i].draw();
        }
        StdDraw.show();
        StdDraw.pause(10);
        time += dt;
    }
    StdOut.printf("%d\n", myBodies.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < myBodies.length; i++) {
    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  myBodies[i].xxPos, myBodies[i].yyPos, myBodies[i].xxVel,
                  myBodies[i].yyVel, myBodies[i].mass, myBodies[i].imgFileName);   
}

}
}