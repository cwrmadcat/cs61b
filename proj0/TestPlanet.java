public class TestPlanet {
    public static void main(String[] args) {
        Planet p1 = new Planet(10, 9, 7, 6, 50, "Moo");
        Planet p2 = new Planet(5, 2, -7, -6, 25, "Bar");
        System.out.println(p1.calcDistance(p2));
        System.out.println(p2.calcDistance(p1));
        System.out.println(p1.calcForceExertedByX(p2));
        System.out.println(p1.calcForceExertedByY(p2));
        System.out.println(p2.calcForceExertedByX(p1));
        System.out.println(p2.calcForceExertedByY(p1));
    }
}
