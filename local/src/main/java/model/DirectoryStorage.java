package model;

import java.util.List;

import exceptions.directory.CreateDirectoryExceptions;
import exceptions.directory.DeleteDirectoryExceptions;
import exceptions.directory.MoveDirectoryExceptions;
import exceptions.directory.RenameDirectoryExceptions;
import exceptions.directory.SearchDirectoryExceptions;
import exceptions.directory.ZipDirectoryExceptions;

public class DirectoryStorage implements Directory {

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

	public List<File> listAllinDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<File> listAllinDirectoryInDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<File> listAllFileinDirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<File> listAllinDirectoryAndSubdirectory(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<File> listAllinDirectoryWithExtension(String path, String extension) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<File> listAllinDirectoryWithMetadata(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

	public List<File> listAllinDirectoryWithoutMetadata(String path) throws SearchDirectoryExceptions {
		// TODO Auto-generated method stub
		return null;
	}

}
