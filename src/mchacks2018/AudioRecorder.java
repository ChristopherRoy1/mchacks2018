package mchacks2018;

import javax.sound.sampled.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AudioRecorder {
		
	public static void main(String [] args) {
		
		//Find all mixers
		Mixer microphone;
		microphone = AudioRecorder.getMic();
		
		Port sourceLine;
		TargetDataLine targetLine;
		
		
		//FIX LATER, not guaranteed to work
		Line.Info targetLineInfo = microphone.getTargetLineInfo()[0];
		
		
		try {
			 sourceLine = (Port) microphone.getLine(Port.Info.MICROPHONE);
			 targetLine = (TargetDataLine) microphone.getLine(targetLineInfo);
		} 
		catch(Exception e) {
			
		}
		
		
		
	}
	
	private static Mixer getMic() {
		Mixer microphone = null;
		for( Mixer.Info e : AudioSystem.getMixerInfo()) {
			microphone = AudioSystem.getMixer(e);
			if(microphone.isLineSupported(Port.Info.MICROPHONE)) {
				System.out.println("Mic is supported!");
				break;
			}
		}
		return microphone; 
	}
	
	
}
