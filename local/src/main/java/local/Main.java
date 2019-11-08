package local;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import exceptions.file.CreateFileException;
import formatComponent.ExtensionList;
import model.MyPath;
import modelLocal.MyFile;
import modelLocal.MyDirectory;
import usersComponent.User;
import usersComponent.UserDatabase;
import local.Connection;


public class Main  {
	
	
	
	
	public static void main(String[] args) throws Exception   {
		// TODO Auto-generated method stub
		
		connectionComponent.Connection connection = new Connection();
		connection.connectToStorage();
		
		MyPath myPath= connection.getMyPath();
		ExtensionList extensionList=connection.getExtension();
		UserDatabase userDatabase=connection.getUsers();
		User userLoggedin = connection.getLogin();
		model.MyFile myfile= new MyFile();
		model.MyDirectory myDirectory = new MyDirectory();
		
		myPath.setTmpPath(myPath.getPath());
		
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Unesi ime file ");
		String name =scanner.nextLine();
		
		
		
		System.out.println("Unesi ime destinacije ");
		String destination =scanner.nextLine();
		
		myfile.download(name, destination);
		
		//myfile.create(name, myPath.getTmpPath(), extensionList);
		
		//myfile.createWithMetadata(name, myPath.getTmpPath(), extensionList);
		//System.out.println(myPath.getPath());
		//myfile.delete(myPath.getPath()+File.separator+name);
		/*System.out.println("Unesi ime file ");
		name =scanner.nextLine();
		
		System.out.println(name);*/
		
		//System.out.println(extensionList.getExtensionList());
		/*
		while(true) {
			String extension = scanner.nextLine();
			extensionList.getExtensionList().add(extension);
			System.out.println("Da li zelite da unesete jos extension?");
			Boolean daNe = scanner.nextBoolean();
			
			if(!daNe) {
				break;
			}
			if(scanner.hasNext()) {
				scanner.nextLine();
				//System.out.println("A"+scanner.nextLine()+"B");
			}
			
		}*/
		
		//System.out.println(userLoggedin);
		//System.out.println(userDatabase.getUsers());
		/*
		while(true) {
			String noviUsername = scanner.nextLine();
			
			String novaSifra = scanner.nextLine();
			Boolean snimanje,brisanje,preuzimanje;
			
			snimanje = scanner.nextBoolean();
			brisanje = scanner.nextBoolean();
			preuzimanje = scanner.nextBoolean();
			
			User noviKorisnik = new User(noviUsername,novaSifra,false,snimanje,brisanje,preuzimanje);
			userDatabase.getUsers().add(noviKorisnik);
			
			
			System.out.println("Da li zelite da unesete jos korisnika?");
			Boolean daNe = scanner.nextBoolean();
			if(!daNe) {
				break;
			}
			if(scanner.hasNext()) {
				
				System.out.println("A"+scanner.nextLine()+"B");
			}
		}
		*/
		
		
		System.out.println(myPath.getPath());
		System.out.println(userLoggedin);
		/*try {
			Files.createDirectory(Paths.get(myPath.getPath()+File.separator+"aadd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//ArrayList<File> found = new ArrayList<File>(
			//	FileUtils.listFilesAndDirs(new File("storageDisk"), new NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.DIRECTORY));

		
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
