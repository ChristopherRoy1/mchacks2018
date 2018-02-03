package mchacks2018;
import javax.sound.sampled.*;
import java.io.File;


public class AudioPlayer {

	private File soundFile;
	private static Clip playingClip;
	private AudioInputStream audioStream;
	
	
	static void PlaySound(File sound) {
		try {
			playingClip = AudioSystem.getClip();
			playingClip.open(AudioSystem.getAudioInputStream(sound));		
			System.out.println("Reach here");
			playingClip.start();
					
			
			long runtime = playingClip.getMicrosecondLength()/1000; //[seconds]	
			System.out.println(runtime);
			Thread.sleep(runtime);
		}
		catch (Exception e){
			System.out.println("error: " + e.getMessage());			
		}
	}
	
	public static void pauseAudio() {
		playingClip.stop();
	}
	
	public static void stopAudio() {
		playingClip.stop();
		playingClip.close();		
	}
	
	public static void changeVolume(){
		FloatControl volumeControl = (FloatControl) playingClip.getControl(FloatControl.Type.MASTER_GAIN);
		
	}
	
	
	
}
