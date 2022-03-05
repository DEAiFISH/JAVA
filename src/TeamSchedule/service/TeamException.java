package TeamSchedule.service;

/**
 * 自定义异常
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -338751621219948L;

    public TeamException() {
        super();
    }

    public TeamException(String msg) {
        super(msg);
    }
}
