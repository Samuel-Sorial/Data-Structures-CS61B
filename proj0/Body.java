public class Body{
   public double xxPos;
   public double yyPos;
   public double xxVel;
   public double yyVel;
   public double mass;
   public String imgFileName;
   public static double G = 6.67e-11;

   public Body(double xP, double yP, double xV, double yV, double m, String img){
       xxPos = xP;
       yyPos = yP;
       xxVel = xV;
       yyVel = yV;
       mass = m;
       imgFileName = img;
   }
   public Body(Body b){
    this.xxPos = b.xxPos;
    this.yyPos = b.yyPos;
    this.xxVel = b.xxVel;
    this.yyVel = b.yyVel;
    this.mass = b.mass;
    this.imgFileName = b.imgFileName;
   }
   public double calcDistance(Body b){
        double distance;
        double deltaX = this.xxPos - b.xxPos; 
        double deltaY = this.yyPos - b.yyPos;
        distance = Math.sqrt(deltaX*deltaX  + deltaY*deltaY);
        return distance;
   }
   public double calcForceExertedBy(Body b){
       double distance = this.calcDistance(b);
       double force = G*this.mass*b.mass / (distance*distance);
       return force;
   }
   public double calcForceExertedByX(Body b){
        double totalDistance = this.calcDistance(b);
        double totalForce = this.calcForceExertedBy(b);
        double deltaX = b.xxPos - this.xxPos;
        return totalForce*deltaX / totalDistance;
   }
   public double calcForceExertedByY(Body b){
         double totalDistance = this.calcDistance(b);
         double totalForce = this.calcForceExertedBy(b);
         double deltaY = b.yyPos - this.yyPos;
         return totalForce*deltaY / totalDistance;
   }
   public double calcNetForceExertedByX(Body[] bodies){
         double netForce = 0;
         for(Body b : bodies){
             if(b.equals(this))
                continue;
             netForce += this.calcForceExertedByX(b);
         }
         return netForce;
   }
   public double calcNetForceExertedByY(Body[] bodies){
        double netForce = 0;
        for(Body b : bodies){
            if(b.equals(this))
                continue;
            netForce += this.calcForceExertedByY(b);
        }
        return netForce;
   }
}