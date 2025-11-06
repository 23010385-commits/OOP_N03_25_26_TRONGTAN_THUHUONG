package review;

public class InnerPrivate {
    private class PrivateInner {
        public void display() {
            System.out.println("Day la private inner class");
        }
    }

    public void accessPrivateInner() {
        PrivateInner inner = new PrivateInner();
        inner.display();
    }
}
