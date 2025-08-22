package projects;

public abstract class Box <T,E>{

    private T primaryContent;
    private E secondaryContent;

    private Double price;
    private String color;

    public Box(T primaryContent, E secondaryContent) {
        this.primaryContent = primaryContent;
        this.secondaryContent = secondaryContent;
    }

    public T getPrimaryContent() {
        return primaryContent;
    }

    public void setPrimaryContent(T primaryContent) {
        this.primaryContent = primaryContent;
    }

    public E getSecondaryContent() {
        return secondaryContent;
    }

    public void setSecondaryContent(E secondaryContent) {
        this.secondaryContent = secondaryContent;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    abstract void sayHello();

    @Override
    public String toString() {
        return "Box{" +
                "primaryContent=" + primaryContent +
                ", secondaryContent=" + secondaryContent +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
