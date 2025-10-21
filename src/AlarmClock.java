import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

@SuppressWarnings("ClassCanBeRecord")
public class AlarmClock implements Runnable{
    private final LocalTime alarmTime;
    private final String filePath;
    private final Scanner scanner;
    public AlarmClock(LocalTime alarmTime,  String filePath,  Scanner scanner) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
        this.scanner = scanner;
    }
    @Override
    public void run() {
        while(LocalTime.now().isBefore(alarmTime)){
            try {
                //noinspection BusyWait
                Thread.sleep(1000);
                System.out.printf("\r%02d:%02d:%02d",
                        LocalTime.now().getHour(),
                        LocalTime.now().getMinute(),
                        LocalTime.now().getSecond());
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
        System.out.println("\nWake Up!");
        playSound(filePath);
    }
    private void playSound(String filePath) {
        File audiofile = new File(filePath);
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(audiofile)) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("Press ENTER to dismiss");
            scanner.nextLine();
            scanner.close();

        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported Audio File");
        }
        catch (LineUnavailableException e) {
            System.out.println("Audio Unavailable");
        }
        catch (IOException e) {
            System.out.println("I/O Error");
        }
    }
}
