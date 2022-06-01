package social.petting.pettingpersonservice.common.application;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public class Utils {

    public static final long MAX_FILE_SIZE = 10 * 1024 * 1024;

    public static LocalDateTime getUtc() {
        Instant instant = Instant.now();
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }

    public static String getRandomString(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static String getBaseUrl() {
        return "http://localhost:8080";
    }

}