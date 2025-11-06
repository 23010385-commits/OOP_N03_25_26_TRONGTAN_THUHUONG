package review;

public class Caller {
    public void call(Callback callback) {
        for (int i = 0; i < 10; i++) {
            callback.go();
        }
    }
}
