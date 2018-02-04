package mchacks2018;

import javax.sound.sampled.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class AudioRecorder {
		
	public static void main(String [] args) {
		for( Mixer.Info e : AudioSystem.getMixerInfo()) {
			System.out.println("Mixer name: " + e.getName());
			System.out.println("Description: " + e.getDescription());
		}
	}
	
}
