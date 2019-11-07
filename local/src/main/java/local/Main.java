package local;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import connectionComponent.Connection;
import model.MyPath;
import local.ConectionsStorage;


public class Main  {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = new ConectionsStorage();
		connection.connectToStorage();
		MyPath myPath= connection.getMyPath();
		
		System.out.println();
		try {
			Files.createDirectory(Paths.get(myPath.getPath()+File.separator+"aaaaa"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		ArrayList<File> found = new ArrayList<File>(
				FileUtils.listFilesAndDirs(new File("storageDisk"), new NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.DIRECTORY));

		
		/*System.out.println("Trenutni storage in disk:");
		for (int i = 1; i < found.size(); i++) {
			System.out.println(found.get(i).getName() + ";");
		}*/
		
		connection.disconnectFromStorage();
		
		/*UserDatabase users = connection.getUsers();
	    ExtensionHandler extension = connection.getExtension(); 
		int loginUserNuber = connection.getLogin();*/
		
		
		
		
		
		
		
		
	}

	

	

}
