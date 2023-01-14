package graphic.item.primitive.shape;

import graphic.point.Point;

import java.awt.*;

public class Triangle extends Shape {
    private Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3, boolean filled) {
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
}
