package graphic.item.complex;

import graphic.item.Item;
import graphic.point.Point;

import java.awt.*;
import java.util.List;

public class ComplexItem extends Item {
    private List<Item> children;

    public ComplexItem(List<Item> children) {
        this.children = children;
    }

    @Override
    public Point getPosition() {
        return getBoundingBox()[0];
    }

    @Override
    public void translate(Point p) {
        for(Item i : children)
            i.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for(Item i : children) {
            Point[] bb = i.getBoundingBox();
            if(maxX < bb[1].getX()) maxX = bb[1].getX();
            if(maxY < bb[2].getY()) maxY = bb[2].getY();
            if(minX > bb[0].getX()) minX = bb[0].getX();
            if(minY > bb[0].getY()) minY = bb[0].getY();
        }
        return new Point[]{new Point(minX, minY), new Point(maxX, minY), new Point(maxX, maxY), new Point(minX, maxY)};
    }

    @Override
    public void draw(Graphics g) {
        for(Item i : children)
            i.draw(g);
    }
}
