public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xLength = this.xxPos - p.xxPos;
        double yLength = this.yyPos - p.yyPos;
        double distance = Math.sqrt(xLength * xLength + yLength * yLength);
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        final double gravConst = 6.67e-11;
        return (gravConst * this.mass * p.mass) / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        return this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double totalXForce = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.equals(p[i])) {
                continue;
            }
            totalXForce = totalXForce + this.calcForceExertedByX(p[i]);
        }
        return totalXForce;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double totalYForce = 0;
        for (int i = 0; i < p.length; i++) {
            if (this.equals(p[i])) {
                continue;
            }
            totalYForce = totalYForce + this.calcForceExertedByY(p[i]);
        }
        return totalYForce;
    }

    public void update(double time, double fX, double fY) {
        double xAccel = fX / this.mass;
        double yAccel = fY / this.mass;
        this.xxVel = this.xxVel + xAccel * time;
        this.yyVel = this.yyVel + yAccel * time;
        this.xxPos = this.xxPos + this.xxVel * time;
        this.yyPos = this.yyPos + this.yyVel * time;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
