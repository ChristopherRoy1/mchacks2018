package mchacks2018;
import javax.sound.sampled.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AudioPlayer implements LineListener {

	private File soundFile;
	private long runtime;
	private boolean playing = false;
	private Clip playingClip;
	
	public static void main(String [] args) {
		String filename = "src/mchacks2018/sounds/test.wav";
		AudioPlayer player = new AudioPlayer(filename);
		player.playAudio();
		player.wait(5);
		player.pauseAudio();	
		player.wait(2);
		player.resumeAudio();
		player.wait(2);
		player.pauseAudio();
		player.wait(1);
		player.resumeAudio();
		player.wait(10);
		
	}
	public AudioPlayer(String filename) {
		try {			
			soundFile = new File(filename);			
			playingClip = AudioSystem.getClip();
			playingClip.open(AudioSystem.getAudioInputStream(soundFile));
			playingClip.addLineListener(this);			
			runtime = playingClip.getMicrosecondLength()/1000;
			
		} catch (Exception e) {
			
		}
		
		
	}
	public void playAudio() {
		playingClip.addLineListener(this);
		playingClip.start();
		playing = true;
	}
	
	
	public void pauseAudio() {
		playingClip.stop();
		playing = false;
	}
	
	public void resumeAudio() {	
			playingClip.addLineListener(this);
			playingClip.start();
			playing = true;
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
	
	private void wait(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
			
			}
			catch(Exception e) {
				
			}
	}
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		
		if(type == LineEvent.Type.START) {
			System.out.println("Playback Started");
		} else if(type == LineEvent.Type.STOP) {
			playing = false;
			System.out.println("Playback Paused");
		}
		
	}
	
	
	
	
	
}
