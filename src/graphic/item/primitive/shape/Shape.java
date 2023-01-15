package graphic.item.primitive.shape;

import graphic.item.primitive.Primitive;

public abstract class Shape extends Primitive {
    private boolean filled;

    public Shape(boolean filled) {
        this.filled = filled;
    }

    public boolean getFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {this.filled = filled;}
}
