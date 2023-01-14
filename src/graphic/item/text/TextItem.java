package graphic.item.text;

import graphic.item.Item;
import graphic.point.Point;

import java.awt.*;

public class TextItem extends Item {
    private final String text;
    private Point position;

    public TextItem(Point position, String text) {
        this.text = text;
        this.position = position;
    }

    public String getText() {
        return text;
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
        int count = 0;
        for(char ch : text.toCharArray()) {
            if(ch == 'm' || ch == 'w')
                count++;
            count++;
        }
        int diff = count / 20;
        return new Point[]{position,
                new Point(position.getX() + (6*count) - diff, position.getY()),
                new Point(position.getX() + (6*count) - diff, position.getY() + 12),
                new Point(position.getX(), position.getY() + 12)};
    }

    @Override
    public void draw(Graphics g) {
        g.drawString(text, position.getX(), position.getY() + 10);
    }
}
