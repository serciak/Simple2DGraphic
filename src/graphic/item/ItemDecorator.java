package graphic.item;

import graphic.point.Point;

import java.awt.*;

public class ItemDecorator extends Item {

    private Item item;

    ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public Point getPosition() {
        return item.getPosition();
    }

    @Override
    public void translate(Point p) {
        item.translate(p);
    }

    @Override
    public Point[] getBoundingBox() {
        return item.getBoundingBox();
    }

    @Override
    public void draw(Graphics g) {
        item.draw(g);
    }
}
