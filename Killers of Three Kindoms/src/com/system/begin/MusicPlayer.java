package com.system.begin;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MusicPlayer extends Thread {
    private ArrayList<String> fileNameList;
    private ArrayList<File> fileList;
    private String srcPath;
    private boolean theEnd;

    /**
     * construct Music Player
     *
     * @param srcPath
     * @param theEnd
     */
    public MusicPlayer(String srcPath, boolean theEnd) {
        this.srcPath = srcPath;
        this.theEnd = theEnd;
        this.fileNameList = new ArrayList<String>();
        this.fileList = new ArrayList<File>();
        this.fileNameList.add("bgm.wav");
        // Initialize fileList.
        for (int i = 0; i < this.fileNameList.size(); i++) {
            File file = new File(this.srcPath + this.fileNameList.get(i));
//            System.out.println(this.srcPath + this.fileNameList.get(i));
            this.fileList.add(file);
        }
    }

    @Override
    public void run() {
        File currentFile;
        if (!this.theEnd) {
            int musicNum = (int) (Math.random() * this.fileList.size());
            currentFile = this.fileList.get(musicNum);
        } else {
            currentFile = new File(this.srcPath + "musicOver.wav");
        }
        AudioInputStream audioIn = null;
        try {
            audioIn = AudioSystem.getAudioInputStream(currentFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Clip clip = null;

        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        assert clip != null;
        try {
            clip.open(audioIn);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if (!this.theEnd) {
            clip.loop(1000);
        } else {
            clip.start();
        }
        while (true) {
            if (this.isInterrupted()) {
                clip.stop();
            }
        }
    }

}
