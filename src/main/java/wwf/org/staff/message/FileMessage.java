package wwf.org.staff.message;

import lombok.Data;

@Data
public class FileMessage {
    private String message;

    public FileMessage(String message) {
        this.message = message;
    }
}
