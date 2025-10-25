# AlarmClock

A simple console-based Java alarm clock. You enter a target time in HH:MM:SS (24‑hour) format; the app counts down by printing the current time every second and plays a WAV sound when the alarm time is reached. Press ENTER to dismiss the alarm.

## Tech Stack
- Language: Java (no additional frameworks)
- Standard library: `java.time`, `javax.sound.sampled`
- Build system/package manager: none (plain `javac`/`java` or run from an IDE, e.g., IntelliJ IDEA)

## Project Structure
```
AlarmClock/                # Project root
├─ src/
│  ├─ App.java            # Entry point (contains main method)
│  └─ AlarmClock.java     # Runnable that waits until the alarm time and plays sound
├─ out/                   # Compiled classes (if built via IDE or javac -d)
│  └─ production/AlarmClock/ (created by IDE; may vary)
├─ AlarmClock.iml         # IntelliJ IDEA module file
└─ README.md              # This file
```

## Entry Point
- Main class: `App`
- File: `src/App.java`

## Requirements
- Java Development Kit (JDK) 8 or newer
  - The code uses `java.time` (available since Java 8) and `javax.sound.sampled`.
- A WAV audio file accessible on your machine.
  - Note: The current code uses a hardcoded file path to a WAV file.

## Setup and Run
You can run the project either with the JDK tools (javac/java) or an IDE.

### Option A: Run with JDK (Windows PowerShell)
1. Navigate to the project root (adjust the path to your environment):
   ```powershell
   cd "C:\Users\hp\OneDrive\Documents\Java Programs\AlarmClock"
   ```
2. Compile the sources to the `out` directory:
   ```powershell
   javac -d out src\App.java src\AlarmClock.java
   ```
   Alternatively:
   ```powershell
   javac -d out src\*.java
   ```
3. Run the program:
   ```powershell
   java -cp out App
   ```

### Option B: Run in IntelliJ IDEA
1. Open the project folder (`AlarmClock`) in IntelliJ IDEA.
2. Ensure the SDK is set to a valid JDK (File → Project Structure → SDKs).
3. Open `src/App.java`, right‑click the `main` method in class `App`, and choose Run.

## Usage
- When prompted, enter the alarm time in 24‑hour format `HH:MM:SS` (e.g., `07:30:00`).
- The console will update every second with the current time until the alarm time is reached.
- When the alarm triggers, a WAV file is played in a loop. Press ENTER to dismiss.

## Audio File Configuration
- The path to the WAV file is currently hardcoded in `src/App.java` as the `filePath` variable:
  ```java
  String filePath = "C:\\Users\\hp\\Downloads\\East Duo - Chubina (Live) - East Duo.wav";
  ```
- You must change this value to point to a valid WAV file on your machine before running, otherwise the app will print an error like "I/O Error" or "Unsupported Audio File" when it tries to play the sound.

TODO:
- Make the sound file path configurable via command‑line argument or environment variable instead of hardcoding.

## Scripts
- No custom scripts are defined for this project.

## Environment Variables
- None are currently used by the application.

TODO:
- Introduce an environment variable (e.g., `ALARM_SOUND_PATH`) or CLI flag to set the WAV path at runtime.

## Tests
- There are currently no automated tests for this project.

TODO:
- Add unit tests (for time parsing/validation) and possibly integration tests for audio playback where possible.

## Known Limitations
- Only supports WAV files via `javax.sound.sampled`.
- The alarm time must be on the same day and in the future at the moment you start the app.
- The sound path is hardcoded and must be edited in the source.

TODO:
- Add support for other audio formats (e.g., MP3, OGG, etc.).
- Add support for alarm times on different days.
- Add support for alarm times in different time zones.
- Add a calendar UI to allow setting alarm times.
- Use Java Swing for a GUI instead of the console.

## License
- Not Yet Added

TODO:
- Add a LICENSE file to clarify usage rights.

## Troubleshooting
- "Invalid Time Format" messages: Ensure you are using the `HH:MM:SS` 24‑hour format.
- Audio errors (Unsupported/Unavailable/I/O): Ensure the WAV file exists at the configured path and that your system audio is available.
- If nothing prints in the console: Make sure the app is running in a console that supports carriage returns (the app updates the same line with the current time).
