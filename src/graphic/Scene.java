package graphic;

import graphic.item.Item;
import graphic.item.primitive.shape.Rect;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel {
    private int width, height;
    private boolean bb;
    private List<Item> items;

    public Scene(int width, int height, boolean bb) {
        this.height = height;
        this.width = width;
        this.bb = bb;
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void draw() {
        JFrame frame = new JFrame("LISTA 8");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.add(this);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(Item i : items) {
            if(bb)
                i.drawBB(g);
            i.draw(g);
        }
    }
}
