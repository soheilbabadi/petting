package social.petting.pettingpersonservice.common.exception;


import java.io.Serial;

public class UserException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5158038740488561520L;

    public UserException(String errorMessage) {
        super(errorMessage);
    }
}