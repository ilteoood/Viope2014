package group5.viope2014;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import javax.swing.JPanel;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music extends JFrame implements Runnable {

    public static void PlaySound() {
        InputStream in;
        try {
            in = new FileInputStream(new File("sound.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void run() {

    }
}
