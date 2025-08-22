package projects;

public class BoxObj<T,E,D> extends Box<T,E> implements Material<D> {

    public BoxObj(T content , E secondaryContent) {
        super(content,secondaryContent);
    }

    @Override
    public D getMaterial() {

    }
}
