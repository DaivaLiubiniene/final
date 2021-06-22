package warehouse.exceptions;

public class ClientDoesNotExistsException extends RuntimeException {
    public ClientDoesNotExistsException(String message){
        super(message);
    }
}
