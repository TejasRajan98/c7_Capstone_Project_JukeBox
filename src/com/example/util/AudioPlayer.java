package com.example.util;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    long currentFrame;
    Clip clip;
    static public String status;
    AudioInputStream audioInputStream;
    String filePath;
    public AudioPlayer(String filePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public String play() {
        clip.start();
        status = "play";
        return  status;
    }

    private void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public String pause() {
        this.currentFrame = this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
        return status;
    }

    public void resume() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (status.equals("play"))
        {
            System.out.println("Audio is already being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }
}
