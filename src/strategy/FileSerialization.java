package strategy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.DrawingModel;
import shapes.Shape;

public class FileSerialization implements Strategy {
	
	private FileOutputStream outputStream;
	private FileInputStream inputStream;
	private DrawingModel model;
	
	public FileSerialization(DrawingModel model) {
		this.model = model;
	}
	
	@Override
	public void save(File file) {
		try {
			outputStream = new FileOutputStream(file + ".ser");
			ObjectOutputStream output = new ObjectOutputStream(outputStream);
			output.writeObject(model.getAll());
			output.close();
			outputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void open(File file) {
		try {
			inputStream = new FileInputStream(file);
			ObjectInputStream input = new ObjectInputStream(inputStream);
			model.addAll((ArrayList<Shape>) input.readObject());
	       
	        input.close();
	        inputStream.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
