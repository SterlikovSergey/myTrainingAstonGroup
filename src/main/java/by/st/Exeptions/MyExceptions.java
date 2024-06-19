package by.st.Exeptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyExceptions extends Exception{
    public MyExceptions(String message, Throwable throwable) {
        super(message +  " at " + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), throwable);
    }
}
