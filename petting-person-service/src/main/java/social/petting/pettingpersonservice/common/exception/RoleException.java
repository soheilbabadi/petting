package social.petting.pettingpersonservice.common.exception;

import java.io.Serial;

public class RoleException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2071123707280696589L;

    public RoleException(String errorMessage) {
        super(errorMessage);
    }
}

