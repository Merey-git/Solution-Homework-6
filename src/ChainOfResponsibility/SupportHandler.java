package ChainOfResponsibility;
import java.util.logging.Logger;


abstract class SupportHandler {
    protected SupportHandler nextHandler;
    protected static final Logger logger = Logger.getLogger(SupportHandler.class.getName());

    public void setNext(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public abstract void handle(String issue) throws Exception;
}
