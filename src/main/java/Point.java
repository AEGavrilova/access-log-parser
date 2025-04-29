public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point other = (Point) obj;
        return Double.compare(other.x, x) == 0 &&
                Double.compare(other.y, y) == 0;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 3);
        Point p2 = new Point(1, 3);
        Point p3 = new Point(5, 8);

        System.out.println("Точка 1: " + p1);
        System.out.println("Точка 2: " + p2);
        System.out.println("Точка 3: " + p3);

        System.out.println("Сравнение p1 и p2: " + p1.equals(p3));
        System.out.println("Сравнение p1 и p3: " + p2.equals(p3));
    }
}
