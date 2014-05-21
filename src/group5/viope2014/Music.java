package group5.viope2014;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Music extends JFrame implements Runnable {
    private static InputStream in;
    public static void playSound() {
        try {
            in = new FileInputStream(new File("sound//intro.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public static void playSoundDeath() {
        InputStream in;
        try {
            in = new FileInputStream(new File("sound//death.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    public static void playSoundEatGhost() {
        InputStream in;
        try {
            in = new FileInputStream(new File("sound//eatghost.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    public static void playSoundPill() {
        InputStream in;
        try {
            in = new FileInputStream(new File("sound//powerpill.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }}

    public static void PlaySound() {
    }
    public static void playSoundDots() {
        InputStream in;
        try {
            in = new FileInputStream(new File("sound//wakawaka.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {}}

    public static void playSoundIntermission() {
        InputStream in;
        try {
            in = new FileInputStream(new File("sound//intermission.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public static void playSoundBackground() {
        try {
            in = new FileInputStream(new File("sound//Pac-Man.WAV"));
            AudioStream audios = new AudioStream(in);
            AudioPlayer.player.start(audios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void run() {

    }}
