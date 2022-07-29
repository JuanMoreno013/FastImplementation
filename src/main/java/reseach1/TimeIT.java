package reseach1;

import java.util.concurrent.Callable;

public class TimeIT {
    public static <T> T printTime(Callable<T> task) {
        T call = null;
        try {
            long startTime = System.currentTimeMillis();
            call = task.call();
            System.out.print((System.currentTimeMillis() - startTime) / 1000d + "s");
        } catch (Exception e) {
            //...
        }
        return call;
    }
}
