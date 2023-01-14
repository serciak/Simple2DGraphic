package graphic.item;

import java.awt.*;

public class ItemBBDecorator extends ItemDecorator {

    public ItemBBDecorator(Item item) {
        super(item);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawBB(g);
    }
}
