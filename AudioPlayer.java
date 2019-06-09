import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

public class AudioPlayer extends JFrame {

	private Clip clip;
	private File backgroundSound;
	private AudioInputStream audioIn;
	private Clip clip1;
	private File coinSound;
	private AudioInputStream audioIn1;
	private Clip clip2;
	private File sadGameOverSound;
	private AudioInputStream audioIn2;
	private Clip clip3;
	private File happyGameOverSound;
	private AudioInputStream audioIn3;
   public AudioPlayer() {    
      try {
         // Open an audio input stream.           
          backgroundSound = new File("C:\\\\Users\\\\varun\\\\Downloads\\Tricky_Maze_...for_Lost_World_-_Sonic_Adventure_Music_Extended-JcRsqVM3l5k.wav"); //you could also get the sound file with an URL
          audioIn = AudioSystem.getAudioInputStream(backgroundSound);   
          coinSound = new File("C:\\\\Users\\\\varun\\\\Downloads\\PING_-_Sound_effect-UfumsRKSpeo.wav"); //you could also get the sound file with an URL
          audioIn1 = AudioSystem.getAudioInputStream(coinSound); 
          sadGameOverSound = new File("C:\\\\Users\\\\varun\\\\Downloads\\MarioSoundGameOver.wav"); //you could also get the sound file with an URL
          audioIn2 = AudioSystem.getAudioInputStream(sadGameOverSound); 
          happyGameOverSound = new File("C:\\\\Users\\\\varun\\\\Downloads\\MarioWinSound.wav"); //you could also get the sound file with an URL
          audioIn3 = AudioSystem.getAudioInputStream(happyGameOverSound);
         // Get a sound clip resource.
         clip = AudioSystem.getClip();
         clip1 = AudioSystem.getClip();
         clip2 = AudioSystem.getClip();
         clip3 = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip1.open(audioIn1);
         clip2.open(audioIn2);
         clip3.open(audioIn3);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
   }

   public void startBackgroundAudio() 
   {
      clip.start();
   }
   public void stopBackgroundAudio()
   {
	   clip.stop();
   }
   public void startCoinAudio()
   {
	   clip1.start();
   }
   public void stopCoinAudio()
   {
	   clip1.stop();
   }
   public void startSadGameOverAudio()
   {
	   clip2.start();
   }
   public void stopSadGameOverAudio()
   {
	   clip2.stop();
   }
   public void startHappyGameOverAudio()
   {
	   clip3.start();
   }
   public void stopHappyGameOverAudio()
   {
	   clip3.stop();
   }
 
   
}