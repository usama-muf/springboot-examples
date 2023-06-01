public class InvalidTypeExceptoin extends RuntimeException{
    private String message;
    InvalidTypeExceptoin(String message) {
        super(message);
    }
}
