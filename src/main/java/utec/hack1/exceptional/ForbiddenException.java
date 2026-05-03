package utec.hack1.exceptional;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException (String message){
        super(message);
    }
}
