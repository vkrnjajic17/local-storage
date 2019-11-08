package modelS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FileUtils;

import exceptions.directory.CreateDirectoryExceptions;
import exceptions.directory.DeleteDirectoryExceptions;
import exceptions.directory.MoveDirectoryExceptions;
import exceptions.directory.RenameDirectoryExceptions;
import exceptions.directory.SearchDirectoryExceptions;
import exceptions.directory.ZipDirectoryExceptions;
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
		
	}

	public void move(String pathFile, String destination) throws MoveDirectoryExceptions {
		// TODO Auto-generated method stub
		
	}

	public void rename(String name, String path) throws RenameDirectoryExceptions {
		// TODO Auto-generated method stub
		
	}

	public List<MyFile> listAllinDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MyFile> listAllinDirectoryInDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<MyFile> listAllFileinDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
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
		
	}

	@Override
	public void upload(String src, String dest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadMultipleZip(List<String> directories, String dest, String name) {
		// TODO Auto-generated method stub
		
	}

	

	

}
