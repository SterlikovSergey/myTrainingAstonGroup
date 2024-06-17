package by.st.Exeptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyExceptions extends RuntimeException{
    public MyExceptions(String message) {
        super((message + " at " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
    }
}
