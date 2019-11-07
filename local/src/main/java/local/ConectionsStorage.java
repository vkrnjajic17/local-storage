package local;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import connectionComponent.Connection;
import formatComponent.ExtensionHandler;
import formatComponent.ExtensionList;
import model.MyPath;
import users.UsersStorage;
import usersComponent.HandleUsers;
import usersComponent.User;
import usersComponent.UserDatabase;

public class ConectionsStorage implements Connection {

	private MyPath myPath;
	private UserDatabase userDatabase;
	private ExtensionList extension;
	private int loginUserNuber;
	private final String disk = "storageDisk";
	private HandleUsers handleUsers;

	public ConectionsStorage() {
		handleUsers = new UsersStorage();
		this.myPath = new MyPath();
		this.userDatabase = new UserDatabase();
		// this.extension = null;

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
		handleUsers.createNewUserDatabase(path);
		Scanner scr = new Scanner(System.in);
		System.out.println("Unesi username korisnika storage:");
		String username = scr.nextLine();
		System.out.println("Unesi password korisnika storage:");
		String password = scr.nextLine();

		User user = new User(username, password, true, true, true, true);
		this.userDatabase.getUsers().add(user);

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
		String storageName = scr.next();
		int i = 0;
		for (i = 0; i < found.size(); i++) {
			if (found.get(i).getName().equalsIgnoreCase(storageName)) {
				break;
			}
		}
		if (i == found.size()) {
			createNewStorage(disk + File.separator + storageName);
			return;
		}
		myPath.setPath(disk + File.separator + storageName);
		this.userDatabase.setUsers(this.handleUsers.readFromUserDatabase(this.myPath.getPath()).getUsers());
		System.out.println(userDatabase.getUsers().toString());

	}

	@Override
	public void disconnectFromStorage() {
		// TODO Auto-generated method stub
		handleUsers.saveUserDatabase(this.myPath.getPath(), this.userDatabase);

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
		return null;
	}

	@Override
	public int getLogin() {
		// TODO Auto-generated method stub
		return 0;
	}

}
