package bj.formation.demoprojet.exception;

// ValidationErrorResponse.java

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {
    private List<ValidationError> errors = new ArrayList<>();
    private String timestamp;
    private int status;

    @Getter
    @Setter
    public static class ValidationError {
        private String field;
        private String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
