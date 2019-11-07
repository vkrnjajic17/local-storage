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
import formatComponent.ExtensionList;


public class FileStorage implements File {

	@Override
	public void create(String name, String path, ExtensionList extensiontList) throws CreateFileException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createWithMetadata(String name, String path, ExtensionList extensiontList) throws CreateFileException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String path) throws DeleteFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void download(String pathStorage, String pathDesktop) throws DownloadFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upload(String pathDesktop, String pathStorage, ExtensionList extensiontList) throws UploadFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectMutlipleFile(List<String> path) throws SelectFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadMultiple(List<File> files, String pathStorage, ExtensionList extensiontList)
			throws UploadFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadMultipleZip(List<File> files, String destination) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zip(String path) throws ZipFilesExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(String pathFile, String destination) throws MoveFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveWithMetadata(String pathFile, String destination) throws MoveFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rename(String name, String path) throws RenameFileExeption {
		// TODO Auto-generated method stub
		
	}



	

}
