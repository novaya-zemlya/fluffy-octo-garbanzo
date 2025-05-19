import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioCont {
    private static Clip clip;

    public AudioCont() {

    }

    public static void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            if (!soundFile.exists()) {
                System.err.println("Sound file not found: " + soundFilePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
