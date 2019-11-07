package users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import usersComponent.HandleUsers;
import usersComponent.UserDatabase;

public class UsersStorage implements HandleUsers{

	@Override
	public void createNewUserDatabase(String path) {
		// TODO Auto-generated method stub
		File f = new File(path+File.separator+"users1.json");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public UserDatabase readFromUserDatabase(String path) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		UserDatabase users = null;
		final String usersString = "users1.json";
		path=path+File.separator+ usersString;
		try {
			users = gson.fromJson(new FileReader(path), UserDatabase.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(users.getUsers());
		return users; 
	}

	@Override
	public void saveUserDatabase(String path, UserDatabase ub) {
		// TODO Auto-generated method stub
		
		File korisnici =new  File(path+ File.separatorChar+"users1.json");
		Gson gson = new Gson();
		String t = gson.toJson(ub);
		
		try {
			FileWriter fw =  new FileWriter(korisnici);
			fw.write(t);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
