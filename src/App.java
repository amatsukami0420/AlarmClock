import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "C:\\Users\\hp\\Downloads\\East Duo - Chubina (Live) - East Duo.wav";
        while (alarmTime == null) {
            try {
                System.out.print("Enter Alarm Time (HH:MM:SS):  ");

                String inputTime = scanner.nextLine();
                alarmTime = LocalTime.parse(inputTime, formatter);
            }
            catch (DateTimeParseException e) {
                System.out.println("Invalid Time Format");
                System.out.println("Please use HH:MM:SS");
                System.out.println("\nPress ENTER to continue >>>\n");
                scanner.nextLine();
            }
        }
        System.out.println("Alarm Set for: " + alarmTime);
        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmClockThread = new Thread(alarmClock);
        alarmClockThread.start();
    }
}
