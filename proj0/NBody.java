public class NBody {
    public static double readRadius(String filename) {
        In parseData = new In(filename);
        int totalPlanets = parseData.readInt();
        double galaxyRadius = parseData.readDouble();
        return galaxyRadius;
    }

    public static Planet[] readPlanets(String filename) {
        In parseData = new In(filename);
        int totalPlanets = parseData.readInt();
        double galaxyRadius = parseData.readDouble();
        Planet[] planetArray = new Planet[totalPlanets];
        for (int i = 0; i < totalPlanets; i++) {
            planetArray[i] = new Planet(
                parseData.readDouble(),
                parseData.readDouble(),
                parseData.readDouble(),
                parseData.readDouble(),
                parseData.readDouble(),
                parseData.readString()
            );
        }
        return planetArray;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double galaxyRadius = NBody.readRadius(filename);
        Planet[] planetList = NBody.readPlanets(filename);

        StdDraw.enableDoubleBuffering();

        double time = 0.0;

        while (time < T) {
            double[] xForces = new double[planetList.length];
            double[] yForces = new double[planetList.length];

            for (int i = 0; i < planetList.length; i++) {
                xForces[i] = planetList[i].calcNetForceExertedByX(planetList);
                yForces[i] = planetList[i].calcNetForceExertedByY(planetList);
            }
            for (int i = 0; i < planetList.length; i++) {
                planetList[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.setXscale(-2 * galaxyRadius, 2 * galaxyRadius);
            StdDraw.setYscale(-2 * galaxyRadius, 2 * galaxyRadius);
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < planetList.length; i++) {
                planetList[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time = time + dt;
        }

        StdOut.printf("%d\n", planetList.length);
        StdOut.printf("%.2e\n", galaxyRadius);
        for (int i = 0; i < planetList.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planetList[i].xxPos, planetList[i].yyPos, planetList[i].xxVel,
            planetList[i].yyVel, planetList[i].mass, planetList[i].imgFileName);   
        }
    }
}
