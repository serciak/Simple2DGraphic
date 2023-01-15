package graphic.item.primitive.shape;

import graphic.point.Point;

import java.awt.*;

public class Triangle extends Shape implements SingletonTriangle {
    private Point p1, p2, p3;
    private static Triangle instance;

    private Triangle(Point p1, Point p2, Point p3, boolean filled) {
        super(filled);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public Point getPosition() {
        return new Point(Math.min(Math.min(p1.getX(), p2.getX()), p3.getX()),
                Math.min(Math.min(p1.getY(), p2.getY()), p3.getY()));
    }

    @Override
    public void translate(Point p) {
        p1.translate(p);
        p2.translate(p);
        p3.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        return new Point[]{getPosition(),
                new Point(Math.max(Math.max(p1.getX(), p2.getX()), p3.getX()),
                        Math.min(Math.min(p1.getY(), p2.getY()), p3.getY())),
                new Point(Math.max(Math.max(p1.getX(), p2.getX()), p3.getX()),
                        Math.max(Math.max(p1.getY(), p2.getY()), p3.getY())),
                new Point(Math.min(Math.min(p1.getX(), p2.getX()), p3.getX()),
                        Math.max(Math.max(p1.getY(), p2.getY()), p3.getY()))};
    }

    @Override
    public void draw(Graphics g) {
        if(super.getFilled())
            g.fillPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()},
                    new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
        else g.drawPolygon(new int[]{p1.getX(), p2.getX(), p3.getX()},
                new int[]{p1.getY(), p2.getY(), p3.getY()}, 3);
    }

    public static Triangle getInstance(Point p1, Point p2, Point p3, boolean filled) {
        if(instance == null) {
            instance = new Triangle(p1, p2, p3, filled);
        }
        else {
            instance.setP1(p1);
            instance.setP2(p2);
            instance.setP3(p3);
            instance.setFilled(filled);
        }

        return instance;
    }

    private void setP1(Point p1) {
        this.p1 = p1;
    }

    private void setP2(Point p2) {
        this.p2 = p2;
    }

    private void setP3(Point p3) {
        this.p3 = p3;
    }
}
