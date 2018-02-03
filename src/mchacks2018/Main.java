package mchacks2018;

import java.io.File;

public class Main {

	public static void main(String [] args) {
		File sound = new File("src/mchacks2018/sounds/test.wav");
		System.out.println("I run");
		AudioPlayer.PlaySound(sound);		
	}
}








