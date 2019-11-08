package storage;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import formatComponent.ExtensionHandler;
import formatComponent.ExtensionList;
import handle.ExtensionHandleStorage;
import handle.UsersHandleStorage;
import model.MyPath;
import usersComponent.HandleUsers;
import usersComponent.User;
import usersComponent.UserDatabase;

public class Connection implements connectionComponent.Connection {

	private MyPath myPath;
	private UserDatabase userDatabase;
	private ExtensionList extension;
	private User userLoggedin;
	private final String disk = "storageDisk";
	private HandleUsers handleUsers;
	private ExtensionHandler extensionHandler;

	public Connection() {
		this.extensionHandler = new ExtensionHandleStorage();
		this.handleUsers = new UsersHandleStorage();
		this.myPath = new MyPath();
		this.userDatabase = new UserDatabase();
		this.extension = new ExtensionList();

	}

	@Override
	public void createNewStorage(String path) {
		// TODO Auto-generated method stub
		try {
			Files.createDirectory(Paths.get(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		handleUsers.createNewUserDatabase(path); //pravi json korisnici
		extensionHandler.createNewExtensionsList(path);//pravi json ekstenzije
		Scanner scr = new Scanner(System.in);
		System.out.println("Unesi username korisnika storage:");
		String username = scr.nextLine();
		System.out.println("Unesi password korisnika storage:");
		String password = scr.nextLine();

		User user = new User(username, password, true, true, true, true);
		this.userDatabase.getUsers().add(user);
		this.userLoggedin = user;

		this.myPath.setPath(path);

	}

	@Override
	public void connectToStorage() {
		// TODO Auto-generated method stub

		// ArrayList<File> found = new ArrayList<File>(
		// FileUtils.listFilesAndDirs(new File(disk), new
		// NotFileFilter(TrueFileFilter.INSTANCE), DirectoryFileFilter.DIRECTORY));

		/*
		 * File[] filesd = new File(disk).listFiles(new FileFilter() {
		 * 
		 * @Override public boolean accept(File file) { return file.isDirectory(); } });
		 */

		ArrayList<File> found = new ArrayList<File>(Arrays.asList(new File(disk).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		})

		));
		/*
		 * for (File f : found) { f.getAbsoluteFile(); System.out.println("Found file: "
		 * + f +"--"+f.getName()); }
		 */
		
		Scanner scr = new Scanner(System.in);
		System.out.println("Trenutni storage in disk:");
		for (int i = 0; i < found.size(); i++) {
			System.out.println(found.get(i).getName() + ";");
		}
		System.out.println();
		System.out.println("Upise ime storage koji zelis ili drugo ime ako zelis novi:");
		String storageName = scr.nextLine();
		
		boolean nijeNadjenDirektorijum = true; 
		for (int i = 0; i < found.size(); i++) {
			if (found.get(i).getName().equalsIgnoreCase(storageName)) {
				nijeNadjenDirektorijum = false;
				break;
			}
		}
		if (nijeNadjenDirektorijum) {
			createNewStorage(disk + File.separator + storageName);
			return;
		}
		myPath.setPath(disk + File.separator + storageName);
		this.userDatabase.setUsers(this.handleUsers.readFromUserDatabase(this.myPath.getPath()).getUsers());
		//System.out.println(userDatabase.getUsers().toString());
		
		this.userLoggedin = null;
		//if(scr.hasNext())
			//scr.next();
		System.out.print("Unsei korisnike storage");
		while(true) {
			System.out.print("Unesi username:");
			String username = scr.nextLine();
			
			System.out.print("Unesi password :");
			String password = scr.nextLine();
			
			for (int j = 0; j < this.userDatabase.getUsers().size(); j++) {
				if (this.userDatabase.getUsers().get(j).getUsername().equals(username)) {
					if (this.userDatabase.getUsers().get(j).getPassword().equals(password)) {
						this.userLoggedin = this.userDatabase.getUsers().get(j);
					}
					
				}
			}
			//System.out.println(username);
			if(this.userLoggedin == null) {
				System.out.println("Korisnik nije pronadjen, pokujate ponovo");
			}else {
				System.out.println("Korisnik"+ this.userLoggedin.getUsername() +"je nadjen. NAastavite dalje sa radom");
				break;
			}
		}
		
		//dodavanje ekstenzija
		this.extension.setExtensionList(this.extensionHandler.readExtensions(this.myPath.getPath()).getExtensionList());
		

	}

	@Override
	public void disconnectFromStorage() {
		// TODO Auto-generated method stub
		handleUsers.saveUserDatabase(this.myPath.getPath(), this.userDatabase);
		extensionHandler.saveExtensions(this.myPath.getPath(), extension);

	}

	@Override
	public MyPath getMyPath() {
		return myPath;
	}

	@Override
	public ExtensionList getExtension() {
		return extension;
	}

	@Override
	public UserDatabase getUsers() {
		// TODO Auto-generated method stub
		return this.userDatabase;
	}

	@Override
	public User getLogin() {
		// TODO Auto-generated method stub
		return userLoggedin;
	}

}
