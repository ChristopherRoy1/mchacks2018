package mchacks2018;
import javax.sound.sampled.*;
import java.io.File;


public class AudioPlayer {

	private File soundFile;
	private AudioInputStream audioStream;
	
	
	static void PlaySound(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));		
			System.out.println("Reach here");
			clip.start();
					
			
			long runtime = clip.getMicrosecondLength()/1000; //[seconds]	
			System.out.println(runtime);
			Thread.sleep(runtime);
		}
		catch (Exception e){
			System.out.println("error: " + e.getMessage());
			
		}
	}
	
	
	
}
