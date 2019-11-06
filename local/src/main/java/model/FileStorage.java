package model;

import java.util.List;

import exceptions.file.CreateFileException;
import exceptions.file.DeleteFileExeption;
import exceptions.file.DownloadFileExeption;
import exceptions.file.MoveFileExeption;
import exceptions.file.RenameFileExeption;
import exceptions.file.SelectFileExeption;
import exceptions.file.UploadFileExeption;
import exceptions.file.ZipFilesExeption;

public class FileStorage implements model.File {

	public void create(String name, String path) throws CreateFileException {
		// TODO Auto-generated method stub
		
	}

	public void createWithMetadata(String name, String path) throws CreateFileException {
		// TODO Auto-generated method stub
		
	}

	public void delete(String path) throws DeleteFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void download(String pathStorage, String pathDesktop) throws DownloadFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void upload(String pathDesktop, String pathStorage) throws UploadFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void selectMutlipleFile(List<String> path) throws SelectFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void uploadMultiple(List<File> files, String pathStorage) throws UploadFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void uploadMultipleZip(List<File> files, String destination) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void zip(String path) throws ZipFilesExeption {
		// TODO Auto-generated method stub
		
	}

	public void move(String pathFile, String destination) throws MoveFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void moveWithMetadata(String pathFile, String destination) throws MoveFileExeption {
		// TODO Auto-generated method stub
		
	}

	public void rename(String name, String path) throws RenameFileExeption {
		// TODO Auto-generated method stub
		
	}

}
