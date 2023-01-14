package graphic.item.primitive;

import graphic.item.Item;
import graphic.point.Point;

import java.awt.*;

public class Segment extends Primitive {
    private Point start, end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Point getPosition() {
        return new Point(Math.min(start.getX(), end.getX()), Math.min(start.getY(), end.getY()));
    }

    @Override
    public void translate(Point p) {
        start.translate(p);
        end.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        return new Point[]{getPosition(),
                new Point(Math.max(start.getX(), end.getX()), Math.min(start.getY(), end.getY())),
                new Point(Math.max(start.getX(), end.getX()), Math.max(start.getY(), end.getY())),
                new Point(Math.min(start.getX(), end.getX()), Math.max(start.getY(), end.getY()))};
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
