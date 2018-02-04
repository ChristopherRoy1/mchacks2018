package mchacks2018;
import java.io.*;


// SaverIO Class will serialize(save) objects as binary files and deserialize(write) objects from their serialized binary files:
public class SaverIO {
	
	// Main Method:
	public static void main(String[] args) {
		AcademicRecording myRecording = new AcademicRecording("Prof Adam Wertheimer",
				"Adams Auditorium","McGill University","MATH-323", "First Probability Lecture", "010318", "08300");
		try {
			saveToFile(myRecording);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		try{
			getFromFile("src/mchacks2018/binaries/" + myRecording.getFilename() + ".bin");
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// saveToFile class will serialize an object
	public static void saveToFile(AcademicRecording r) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/mchacks2018/binaries/" + r.getFilename() + ".bin"));
			objectOutputStream.writeObject(r);
			objectOutputStream.close();
	}
	
	public static void getFromFile(String filename) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
		AcademicRecording ar = (AcademicRecording) objectInputStream.readObject();
		System.out.println(ar);
		objectInputStream.close();
	}

}


