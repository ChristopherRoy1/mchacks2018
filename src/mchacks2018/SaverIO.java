package mchacks2018;
import java.io.*;


// Class will serialize(save) objects as binary files.
public class SaverIO {
	
	// Main Method:
	public static void main(String[] args) {
		System.out.println("asdf");
	}
}

class Student implements Serializable{
	String subject, room, professor, semester;
	int date, lectureNumber;
}
