package graphic.item.primitive.shape;

import graphic.point.Point;

import java.awt.*;

public class StarPolygon extends Shape {
    private final int radius;
    private Point center;
    private Point[] border;
    private int n;

    public StarPolygon(Point center, int radius, int n, boolean filled) {
        super(filled);
        this.center = center;
        this.radius = radius;
        this.n = n;
        calculateBorder();
    }

    private void calculateBorder() {
        int points = n * 2;
        border = new Point[points];

        for(int i = 0; i < points; i++) {
            double r = (i % 2 == 0) ? radius : radius * 0.5;
            double angle = (i * 360.0) / (2 * n);

            border[i] = new Point((int) (center.getX() + r * Math.cos(Math.toRadians(angle - 90))),
                    (int) (center.getY() + r * Math.sin(Math.toRadians(angle - 90))));
        }
    }

    @Override
    public Point getPosition() {
        return getBoundingBox()[0];
    }

    @Override
    public void translate(Point p) {
        center.translate(p);
        for(Point point : border)
            point.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(Point p : border) {
            if(maxX < p.getX()) maxX = p.getX();
            if(maxY < p.getY()) maxY = p.getY();
            if(minX > p.getX()) minX = p.getX();
            if(minY > p.getY()) minY = p.getY();
        }

        return new Point[]{new Point(minX, minY), new Point(maxX, minY), new Point(maxX, maxY), new Point(minX, maxY)};
    }

    @Override
    public void draw(Graphics g) {
        int points = n*2;
        int[] xs = new int[points];
        int[] ys = new int[points];

        for(int i = 0; i < points; i++) {
            xs[i] = border[i].getX();
            ys[i] = border[i].getY();
        }

        if(super.getFilled()) g.fillPolygon(xs, ys, points);
        else g.drawPolygon(xs, ys, points);
    }
}
