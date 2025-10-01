package Doctrine;

import java.util.concurrent.TimeUnit;

public class GameTime {
    private long syncTime;
    private static final int FPS_TARGET = 60;
    private static int currentFps;
    private static long fpsDeltaTime;
    private static long gameStartTime;
    private static int fpsCount;


    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static int getCurrentFps() {
        return (currentFps > 0) ? currentFps : fpsCount;
    }

    public static long getElapsedTime() {
        return (System.currentTimeMillis() - gameStartTime);
    }

    public static String getElapsedFormattedTime() {
        long time = getElapsedTime();
        long hours = TimeUnit.MILLISECONDS.toHours(time);
        time -= TimeUnit.HOURS.toHours(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time);
        time -= TimeUnit.MINUTES.toMinutes(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public GameTime() {
        syncTime = System.currentTimeMillis();
        gameStartTime = System.currentTimeMillis();
        fpsCount = 0;
        fpsDeltaTime = 0;
        currentFps = 0;
    }

    void synchronize() {
        update();
        try {
            Thread.sleep(getSleepTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        syncTime = System.currentTimeMillis();
    }

    private void update() {
        fpsCount++;
        long currentSecond = TimeUnit.MILLISECONDS.toSeconds(getCurrentTime());
        if (fpsCount != currentSecond) {
            currentFps = fpsCount;
            fpsCount = 0;
        }
        fpsDeltaTime = currentSecond;
    }

    private long getSleepTime() {
        long targetTime = 1000L / FPS_TARGET;//16.6ms environ
        long sleep = targetTime - (System.currentTimeMillis() - syncTime);

        if (sleep < 0) {
            sleep = 4;
        }
        return sleep;
    }

}
