package future;

public class IData implements Data {

    private String message;

    @Override
    public String fetch() {
        return message;
    }

    public IData(String message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.message = message;
    }
}
