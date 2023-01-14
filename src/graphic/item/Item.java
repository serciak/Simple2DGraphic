package graphic.item;

import graphic.point.Point;

import java.awt.*;

public abstract class Item {

    public Item() {}

    public abstract Point getPosition();

    public abstract void translate(Point p);

    public abstract Point[] getBoundingBox();
    public abstract void draw(Graphics g);

    public void drawBB(Graphics g) {
        Point[] bb = getBoundingBox();
        g.setColor(Color.RED);
        g.drawRect(bb[0].getX(), bb[0].getY(), bb[1].getX() - bb[0].getX(), bb[3].getY() - bb[0].getY());
        g.setColor(Color.BLACK);
    }
}
