import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoundPlayerApp {

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Sound Player");
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());

        // Create a button
        JButton button = new JButton("Play Sound");

        JButton button4 = new JButton("play another sound");

        // Add action listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("107330__chimerical__countdown-news-intro.wav");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("107330__chimerical__countdown-news-intro.wav");
            }
        });


        // Set up GridBagConstraints to control the placement and resizing of buttons
        GridBagConstraints gbc = new GridBagConstraints();

        // Allow buttons to resize both horizontally and vertically
        gbc.fill = GridBagConstraints.BOTH;  // Resizes both horizontally and vertically
        gbc.weightx = 1.0; // Allow horizontal resizing
        gbc.weighty = 1.0; // Allow vertical resizing
        gbc.insets = new Insets(5, 5, 5, 5); // Add some spacing around the buttons

        // Add buttons to the frame using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(button, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        frame.add(button4, gbc);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void playSound(String soundFilePath) {
        try {
            // Get the sound file
            File soundFile = new File(soundFilePath);

            // Get the audio input stream from the file
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // Get a clip to play the sound
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);

            // Play the sound
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
