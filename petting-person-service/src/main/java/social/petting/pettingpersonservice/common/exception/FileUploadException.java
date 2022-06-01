package social.petting.pettingpersonservice.common.exception;

import java.io.Serial;

public class FileUploadException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -6765072845677910295L;

    public FileUploadException(String message) {
        super(message);
    }
}
