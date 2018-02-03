package mchacks2018;
import javax.sound.sampled.*;
import java.io.File;


public class AudioPlayer {

	private File soundFile;
	private long runtime;
	private Clip playingClip;
	
	
	public AudioPlayer(String filename) {
		try {			
			soundFile = new File(filename);			
			playingClip = AudioSystem.getClip();
			playingClip.open(AudioSystem.getAudioInputStream(soundFile));
						
			runtime = playingClip.getMicrosecondLength()/1000;
			Thread.sleep(runtime);
		} catch (Exception e) {
			
		}
		
		
	}
	public void playAudio() {
		playingClip.start();
	}
	
	
	public void pauseAudio() {
		playingClip.stop();
	}
	
	public void resumeAudio() {
		if(playingClip.isOpen() && !playingClip.isActive()) {
			playingClip.start();
		}
	}
	
	public void stopAudio() {
		playingClip.stop();
		playingClip.close();		
	}
	
	public void changeVolume(int sliderValue){
		FloatControl volumeControl = (FloatControl) playingClip.getControl(FloatControl.Type.MASTER_GAIN);
		volumeControl.setValue(sliderValue);
	}
	
	public void changePosition(long slidervalue) {
		playingClip.setMicrosecondPosition(slidervalue);
		
	}
	
	
	
	
	
}
