package modelS;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.NotFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

import exceptions.directory.CreateDirectoryExceptions;
import exceptions.directory.DeleteDirectoryExceptions;
import exceptions.directory.MoveDirectoryExceptions;
import exceptions.directory.RenameDirectoryExceptions;
import exceptions.directory.SearchDirectoryExceptions;
import exceptions.directory.ZipDirectoryExceptions;
import exceptions.file.MoveFileExeption;
import model.Archive;
import model.MyFile;



public class MyDirectory implements model.MyDirectory {

	public void create(String name, String path) throws CreateDirectoryExceptions {
		// TODO Auto-generated method stub
		if (name.equals("") ) {
			System.out.println("Ime dir-a nije dobro!!!");
			return;
		}

		if (Files.exists(Paths.get(path + File.separator + name))) {
			System.out.println("Ovakav dir vec postoji");
			return;
		}
		try {
			Files.createDirectory(Paths.get(path + File.separator + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Dir je dobro napravit");

	}

	public void delete(String path) throws DeleteDirectoryExceptions {
		// TODO Auto-generated method stub
		if (path.equals("") ) {
			System.out.println("Ime dir nije dobro!!!");
			return;
		}
		//System.out.println(path);
		if (!Files.exists(Paths.get(path))) {
			System.out.println("Ovakav dir ne postoji");
			return;
		}

		try {
			
			FileUtils.deleteDirectory(new File(path));
			System.out.println("dir je uspjesno obrisan");
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

	public void zip(String path) throws ZipDirectoryExceptions {
		// TODO Auto-generated method stub
		Path pathTmp = Paths.get(path);
		if (path.equals("") ) {
			System.out.println("Ime dir-a nije dobro!!!");
			return;
		}

		if (!Files.exists(Paths.get(path))) {
			System.out.println("Ovakav dir ne postoji");
			return;
		}
		Archive arhive = new Archive();
		File f= new File(path);
		/*
		System.out.println(path);
		System.out.println(path.substring(path.lastIndexOf(File.separator)+1)+"Z");
		System.out.println(path.substring(0,path.lastIndexOf(File.separator)));
		*/
		try {
			arhive.zipDirectory(f,path.substring(path.lastIndexOf(File.separator)+1)+"Z" , path.substring(0,path.lastIndexOf(File.separator)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("upjesno zipovan fajl");
		
	}

	public void move(String pathFile, String destination) throws MoveDirectoryExceptions {
		// TODO Auto-generated method stub
		Path source;
		Path destFile;

		if (pathFile != null && !pathFile.equals("") ) {
			source = Paths.get(pathFile);
		} else {
			System.out.println("Nije dobra putanj direktorija");
			return;
		}
		if (destination != null && !destination.equals("")) {
			destFile = Paths.get(destination);
		} else {
			System.out.println("Putanja destinacije nije dobra");
			return;
		}
		
		if(!(Files.exists(source) && Files.exists(destFile))) {
			System.out.println("Ne postoje destinacije");
			return;	
		}
		if (Files.exists(Paths.get(destination + File.separator + pathFile.substring(pathFile.lastIndexOf(File.separator) + 1)))) {
			System.out.println("Na ovoj putanji postoji isti fajl");
			return;
		}
		
		try {
			
			
			FileUtils.moveDirectory(new File(pathFile), new File(destination + File.separator + pathFile.substring(pathFile.lastIndexOf(File.separator) + 1)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Uspjesno je prebaceno");

		
		
	}

	public void rename(String name, String path) throws RenameDirectoryExceptions {
		// TODO Auto-generated method stub
		Path source;
		if (path != null && !path.equals("")) {
			source = Paths.get(path);
		} else {
			System.out.println("Putanja destinacije na storage nije dobra");
			return;
		}
		if(!(Files.exists(source))) {
			System.out.println("Ne postoji destinacije");
			return;	
		}
		if(name == null || name.equals("")) {
			System.out.println("Ime nije dobro");
			return;	
		}
		try {
			Files.move(source, source.resolveSibling(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ime je promjenjeno");
	}

	public List<MyFile> listAllinDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		Path dirPath;
		if (path != null && !path.equals("")) {
			dirPath = Paths.get(path);
		} else {
			System.out.println("Putanja nije dobra");
			return null;
		}
		
		

		if (Files.exists(dirPath)) {
			System.out.println("Lista u direktorjumu ");	
			ArrayList<File> found = new ArrayList<File>(Arrays.asList(new File(path).listFiles()));
			for (int i = 0; i < found.size(); i++) {
				System.out.println(found.get(i).getName() + ";");
			}
			
		} else {
//            System.out.println(new DirectoryListFilesException());
			System.out.println("Directory list files exception");
		}

	
		
		return null;
	}

	public List<MyFile> listAllinDirectoryInDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		Path dirPath;
		if (path != null && !path.equals("")) {
			dirPath = Paths.get(path);
		} else {
			System.out.println("Putanja nije dobra");
			return null;
		}
		
		

		if (Files.exists(dirPath)) {
			System.out.println("Lista u direktorjumu ");	
			ArrayList<File> found = new ArrayList<File>(Arrays.asList(new File(path).listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.isDirectory();
				}
			})));
			for (int i = 0; i < found.size(); i++) {
				System.out.println(found.get(i).getName() + ";");
			}
			
		} else {
//            System.out.println(new DirectoryListFilesException());
			System.out.println("Directory list files exception");
		}

	
		
		return null;
	}

	public List<MyFile> listAllFileinDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		Path dirPath;
		if (path != null && !path.equals("")) {
			dirPath = Paths.get(path);
		} else {
			System.out.println("Putanja nije dobra");
			return null;
		}
		
		

		if (Files.exists(dirPath)) {
			System.out.println("Lista u direktorjumu ");	
			ArrayList<File> found = new ArrayList<File>(Arrays.asList(new File(path).listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.isFile();
				}
			})));
			for (int i = 0; i < found.size(); i++) {
				System.out.println(found.get(i).getName() + ";");
			}
			
		} else {
//            System.out.println(new DirectoryListFilesException());
			System.out.println("Directory list files exception");
		}

	
		
		return null;
	}

	public List<MyFile> listAllinDirectoryAndSubdirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MyFile> listAllinDirectoryWithExtension(String path, String extension) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MyFile> listAllinDirectoryWithMetadata(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MyFile> listAllinDirectoryWithoutMetadata(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void download(String src, String dest) {
		// TODO Auto-generated method stub
		
			try {
				move(src, dest);
			} catch (MoveDirectoryExceptions e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	@Override
	public void upload(String src, String dest) {
		// TODO Auto-generated method stub
		Path source;
		Path destFile;

		if (src != null && !src.equals("") ) {
			source = Paths.get(src);
		} else {
			System.out.println("Nije dobra putanj fajla sa deskttopa");
			return;
		}
		if (dest != null && !dest.equals("")) {
			destFile = Paths.get(dest);
		} else {
			System.out.println("Putanja destinacije na storage nije dobra");
			return;
		}
		
		if(!(Files.exists(source) && Files.exists(destFile))) {
			System.out.println("Ne postoji destinacije");
			return;	
		}
		
		
		if (Files.exists(Paths.get(dest + File.separator + src.substring(src.lastIndexOf(File.separator) + 1)))) {
			System.out.println("Na ovoj putanji postoji isti fajl");
			return;
		}
		
		try {
			FileUtils.copyDirectory(new File(src), new File(dest + File.separator + src.substring(src.lastIndexOf(File.separator) + 1)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dir je prebacen");
		
	}

	@Override
	public void uploadMultipleZip(List<String> directories, String dest, String name) {
		// TODO Auto-generated method stub
		
	}

	

	

}
