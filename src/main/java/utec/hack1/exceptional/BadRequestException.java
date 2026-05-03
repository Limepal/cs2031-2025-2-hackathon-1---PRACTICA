package utec.hack1.exceptional;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
