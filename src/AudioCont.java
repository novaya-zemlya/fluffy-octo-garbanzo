


import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioCont {
    private static Clip clip; // the sound
    private static boolean go; // if the music should be playing

    public AudioCont() { // make a audiocont
        go = true;

    }

    public static void playSound(String soundFilePath) { // play a sound
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

    public static void playSoundLoop(String soundFilePath) { // play a sound and loop it
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
                    playSoundLoop(soundFilePath);
                }
            });

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void stopSound() { // stop the sound
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }


    public static void playMid1(){ // used to loop between 2 songs
        AudioCont.playSound("172561__djgriffin__video-game-7.wav");
        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                AudioCont.playMid2();
            }
        });
    }

    public static void playMid2(){ // used to loop between 2 songs
        AudioCont.playSound("568857__humanoide9000__military-march-music.wav");
        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                AudioCont.playMid1();
            }
        });


    }

    public static void playEnd(){ // This song does not work, never used
        AudioCont.playSound("803432__logicmoon__under-the-sky.wav");
    }

    public static void playAlarm(){ // play the alarm sound
        AudioCont.playSound("33732__jobro__1-alarm-short-e.wav");
    }

    public static void playMidGame() throws InterruptedException { // loop through many songs DOES NOT WORK YET
        while (go) {
            playMid1();
            while (clip.isRunning()) {
                Thread.sleep(0);
                if (!go){
                    break;
                }
            }
            if (!go){
                break;
            }
            AudioCont.stopSound();
            playMid2();
            while (clip.isRunning()) {
                Thread.sleep(0);
                if (!go){
                    break;
                }
            }
        }
    }

    public void stopMid(){ // stop the music
        go = false;
    }
}

