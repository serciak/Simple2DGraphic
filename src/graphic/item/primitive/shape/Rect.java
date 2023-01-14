package graphic.item.primitive.shape;

import graphic.point.Point;

import javax.swing.*;
import java.awt.*;

public class Rect extends Shape{
    private Point position;
    private int width, height;

    public Rect(Point position, int width, int height, boolean filled) {
        super(filled);
        this.position = position;
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void translate(Point p) {
        position.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        return new Point[]{position,
                new Point(position.getX() + width, position.getY()),
                new Point(position.getX() + width, position.getY() + height),
                new Point(position.getX(), position.getY() + height)};
    }

    @Override
    public void draw(Graphics g) {
        if(super.getFilled()) g.fillRect(position.getX(), position.getY(), width, height);
        else g.drawRect(position.getX(), position.getY(), width, height);
    }
}
