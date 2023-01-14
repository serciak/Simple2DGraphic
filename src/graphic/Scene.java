package graphic;

import graphic.item.Item;
import graphic.item.ItemBBDecorator;
import graphic.item.primitive.shape.Rect;
import graphic.point.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class Scene extends JPanel implements MouseListener {
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
        frame.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        Point p = new Point(e.getX(), e.getY());

        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).contains(p)) {
                items.set(i, new ItemBBDecorator(items.get(i)));
            }
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
