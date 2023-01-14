package graphic.item.primitive.shape;

import graphic.point.Point;

import java.awt.*;

public class Circle extends Shape {
    private Point center;
    private int radius;

    public Circle(Point center, int radius, boolean filled) {
        super(filled);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point getPosition() {
        return new Point(center.getX() - radius, center.getY() - radius);
    }

    @Override
    public void translate(Point p) {
        center.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        return new Point[]{getPosition(),
                new Point(center.getX() + radius, center.getY() - radius),
                new Point(center.getX() + radius, center.getY() + radius),
                new Point(center.getX() - radius, center.getY() + radius)};
    }

    @Override
    public void draw(Graphics g) {
        if(super.getFilled()) g.fillOval(getPosition().getX(), getPosition().getY(), 2*radius, 2*radius);
        else g.drawOval(getPosition().getX(), getPosition().getY(), 2*radius, 2*radius);
    }
}
