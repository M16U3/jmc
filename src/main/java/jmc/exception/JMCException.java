/*
 * 
 * 
 * 
 */
package jmc.exception;

/**
 *
 * @author miguel
 */
public class JMCException extends Exception {

    public JMCException() {
    }

    public JMCException(Throwable cause) {
        super(cause);
    }

    public JMCException(String message) {
        super(message);
    }

    public JMCException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return super.initCause(cause); 
    }
    
    
}
