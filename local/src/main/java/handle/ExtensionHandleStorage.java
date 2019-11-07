package handle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import formatComponent.ExtensionList;

public class ExtensionHandleStorage implements formatComponent.ExtensionHandler {

	@Override
	public void createNewExtensionsList(String path) {
		// TODO Auto-generated method stub
		File f = new File(path+File.separator+"formats.json");
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ExtensionList readExtensions(String path) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		ExtensionList extensionList = null;
		final String extensionString = "formats.json";
		path=path+File.separator+ extensionString;
		try {
			extensionList = gson.fromJson(new FileReader(path), ExtensionList.class);
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
		
		return extensionList;
	}

	@Override
	public void saveExtensions(String path, ExtensionList fl) {
		// TODO Auto-generated method stub
		File extension =new  File(path+ File.separatorChar+"formats.json");
		Gson gson = new Gson();
		String t = gson.toJson(fl);
		
		try {
			FileWriter fw =  new FileWriter(extension);
			fw.write(t);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
