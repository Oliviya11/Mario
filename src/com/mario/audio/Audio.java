package com.mario.audio;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio {
  private Clip clip;
  public Audio(String son) {
	  try {
		AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource(son));
		 clip = AudioSystem.getClip();
		  clip.open(audio);
	  } catch (UnsupportedAudioFileException | IOException e ) {}
	 catch (LineUnavailableException e) {}
  }
  
  public Clip getClip() {return clip;}
 
  public void play() {
	  clip.start();
  }
  public boolean playing() {
	  return clip.isRunning();
  }
  public void stop() {clip.stop();}
  
  public static void playSound(String s){
	  Audio a = new Audio(s);
	  a.play();
  }
  
}
