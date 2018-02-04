package mchacks2018;

import javax.sound.sampled.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class AudioRecorder {
		
	public static void main(String [] args) {
		
		//Find all mixers
		Mixer microphone;
		microphone = AudioRecorder.getMic();
		
		Port sourceLine = null;
		TargetDataLine targetLine = null;
		
		
		//FIX LATER, not guaranteed to work
		Line.Info targetLineInfo = microphone.getTargetLineInfo()[0];
		
		AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
	      float rate = 44100.0f;
	      int channels = 2;
	      int frameSize = 4;
	      int sampleSize = 16;
	      boolean bigEndian = true;

	      AudioFormat format = new AudioFormat(encoding, rate, sampleSize, channels, (sampleSize / 8)
	          * channels, rate, bigEndian);
		
	      DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
		
	      if (!AudioSystem.isLineSupported(info)) {
	    	  //Print error
	      }
		
		
		try {
			 sourceLine = (Port) microphone.getLine(Port.Info.MICROPHONE);
			 targetLine = (TargetDataLine) AudioSystem.getLine(info);
			 
			 sourceLine.open();
			 targetLine.open();
		} 
		catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
			System.exit(1);
		}
		boolean stopped = false;
		// Assume that the TargetDataLine, line, has already
		// been obtained and opened.
		int t = 0;
		
		ByteArrayOutputStream out  = new ByteArrayOutputStream();
		int numBytesRead;
		byte[] data = new byte[targetLine.getBufferSize() / 5];
		
		
		

		// Begin audio capture.

		while(t < 1000000) {
		// Here, stopped is a global boolean set by another thread.
		// Read the next chunk of data from the TargetDataLine.
		   numBytesRead =  targetLine.read(data, 0, data.length);
		   // Save this chunk of data.
		   out.write(data, 0, numBytesRead);
		   System.out.println("Ratata");
		   t++;
		}
		
		try (OutputStream outputStream = new FileOutputStream("src/mchacks2018/sounds/recording.wav")) {
		    out.writeTo(outputStream);
		}
		catch(Exception e) {
			
		}
	/*	
		
		FileOutputStream fos;
		try{
		    fos = new FileOutputStream (new File("src/mchacks2018/sounds/record.wav")); 
		    // Put data in your baos
		    out.writeTo(fos);
		    fos.close();
		} catch(IOException ioe) {
		    // Handle exception here
		    ioe.printStackTrace();
		} 
	*/
	
		
		
		
		
		
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
