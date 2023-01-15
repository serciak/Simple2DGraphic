import graphic.Scene;
import graphic.item.Item;
import graphic.item.complex.ComplexItem;
import graphic.item.primitive.Segment;
import graphic.item.primitive.shape.Circle;
import graphic.item.primitive.shape.Rect;
import graphic.item.primitive.shape.StarPolygon;
import graphic.item.primitive.shape.Triangle;
import graphic.item.text.TextItem;
import graphic.point.Point;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene(800, 600, false);
        scene.addItem(new Rect(new Point(50, 50), 100, 50, true));
        scene.addItem(new Circle(new Point(300, 300), 50, true));
        scene.addItem(new StarPolygon(new Point(200, 100), 50, 5, false));
        scene.addItem(Triangle.getInstance(new Point(400, 300), new Point(600, 200), new Point(700, 550), true));
        scene.addItem(Triangle.getInstance(new Point(20, 40), new Point(100, 200), new Point(40, 120), true));
        scene.addItem(new Segment(new Point(100, 100), new Point(700, 500)));
        scene.addItem(new TextItem(new Point(190, 90), "star"));
        List<Item> items = new ArrayList<>();
        items.add(new Rect(new Point(50, 400), 100, 50, false));
        items.add(new Circle(new Point(60, 300), 30, true));
        scene.addItem(new ComplexItem(items));
        scene.draw();
    }
}
