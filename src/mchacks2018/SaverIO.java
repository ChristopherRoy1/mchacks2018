package mchacks2018;
import java.io.*;


// SaverIO Class will serialize(save) objects as binary files and deserialize(write) objects from their serialized binary files:
public class SaverIO {
	
	// Main Method:
	public static void main(String[] args) {
		AcademicRecording myRecording = new AcademicRecording("MATH-323", "First Probability Lecture", "010318", "08300");
		System.out.println(myRecording.getTitle());
		try {
			saveToFile(myRecording);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// saveToFile class will serialize an object
	public static void saveToFile(AcademicRecording r) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/mchacks2018/binaries/" + r.getFilename() + ".bin"));
			objectOutputStream.writeObject(r);
			objectOutputStream.close();
	}
	
	public static void getFromFile() {
		
	}
}


