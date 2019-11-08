package modelLocal;

import java.util.List;

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
		
	}

	public void delete(String path) throws DeleteDirectoryExceptions {
		// TODO Auto-generated method stub
		
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
