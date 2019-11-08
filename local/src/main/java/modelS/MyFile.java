package modelS;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import exceptions.file.CreateFileException;
import exceptions.file.DeleteFileExeption;
import exceptions.file.DownloadFileExeption;
import exceptions.file.MoveFileExeption;
import exceptions.file.RenameFileExeption;
import exceptions.file.UploadFileExeption;
import exceptions.file.ZipFilesExeption;
import formatComponent.ExtensionList;
import model.MetaCreator;

public class MyFile implements model.MyFile {

	@Override
	public void create(String name, String path, ExtensionList extensiontList) throws CreateFileException {
		// TODO Auto-generated method stub

		if (name.equals("") || (name.indexOf('.') == -1)) {
			System.out.println("Ime fajla nije dobro!!!");
			return;
		}

		String extension = name.substring(name.indexOf('.') + 1);// ovo da se ukloni tacka

		System.out.println(extension);
		for (int i = 0; i < extensiontList.getExtensionList().size(); i++) {
			if (extensiontList.getExtensionList().get(i).equals(extension)) {
				System.out.println("Fajl sa ovom ekstenzijom se ne moze napraviti");
				return;
			}

		}
		if (Files.exists(Paths.get(path + File.separator + name))) {
			System.out.println("Ovakav file vec postoji");
			return;
		}
		try {
			Files.createFile(Paths.get(path + File.separator + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Fajl je dobro napravit");

	}

	@Override
	public void createWithMetadata(String name, String path, ExtensionList extensiontList) throws CreateFileException {
		// TODO Auto-generated method stub
		String nameForMeta = new String(name);
		if (name.equals("") || (name.indexOf('.') == -1)) {
			System.out.println("Ime fajla nije dobro!!!");
			return;
		}

		String extension = name.substring(name.indexOf('.') + 1);// ovo da se ukloni tacka

		System.out.println(extension);
		for (int i = 0; i < extensiontList.getExtensionList().size(); i++) {
			if (extensiontList.getExtensionList().get(i).equals(extension)) {
				System.out.println("Fajl sa ovom ekstenzijom se ne moze napraviti");
				return;
			}

		}
		if (Files.exists(Paths.get(path + File.separator + name))) {
			System.out.println("Ovakav file vec postoji");
			return;
		}
		try {
			Files.createFile(Paths.get(path + File.separator + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MetaCreator.createNewMetaDescription(path + File.separator + nameForMeta);
		System.out.println("Fajl je dobro napravit");

	}

	@Override
	public void delete(String path) throws DeleteFileExeption {
		// TODO Auto-generated method stub

		if (path.equals("") || (path.indexOf('.') == -1)) {
			System.out.println("Ime fajla nije dobro!!!");
			return;
		}
		//System.out.println(path);
		if (!Files.exists(Paths.get(path))) {
			System.out.println("Ovakav file ne postoji");
			return;
		}

		try {
			Files.deleteIfExists(Paths.get(path));
			System.out.println("fajl je uspjesno obrisan");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void download(String pathStorage, String pathDesktop) throws DownloadFileExeption {
		// TODO Auto-generated method stub
		
			try {
				move(pathStorage, pathDesktop);
			} catch (MoveFileExeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

	}

	@Override
	public void upload(String pathDesktop, String pathStorage, ExtensionList extensiontList) throws UploadFileExeption {
		// TODO Auto-generated method stub

	}

	

	@Override
	public void zip(String path) throws ZipFilesExeption {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(String pathFile, String destination) throws MoveFileExeption {
		// TODO Auto-generated method stub
		Path source;
		Path destFile;

		if (pathFile != null && !pathFile.equals("") ) {
			source = Paths.get(pathFile);
		} else {
			System.out.println("Nije dobra putanj fajla");
			return;
		}
		if (destination != null && !destination.equals("")) {
			destFile = Paths.get(destination);
		} else {
			System.out.println("Putanja destinacije nije dobra");
			return;
		}
		
		if(!(Files.exists(source) && Files.exists(destFile))) {
			System.out.println("Ne postoji destinacije");
			return;	
		}
		if (Files.exists(Paths.get(destination + File.separator + pathFile.substring(pathFile.lastIndexOf(File.separator) + 1)))) {
			System.out.println("Na ovoj putanji postoji isti fajl");
			return;
		}
		
		try {
			Files.move(source, Paths.get(destination + File.separator + pathFile.substring(pathFile.lastIndexOf(File.separator) + 1)), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Uspjesno je prebaceno");

	

	}

	@Override
	public void moveWithMetadata(String pathFile, String destination) throws MoveFileExeption {
		// TODO Auto-generated method stub
		move(pathFile, destination);
		String withoutExtension = pathFile.substring(0, pathFile.lastIndexOf("."));
		String tmp = withoutExtension+"-META.json";
		move(tmp,destination);
		System.out.print("i metapodaci");

	}

	@Override
	public void rename(String name, String path) throws RenameFileExeption {
		// TODO Auto-generated method stub

	}

	@Override
	public void uploadMultiple(List<String> files, String pathStorage, ExtensionList extensiontList)
			throws UploadFileExeption {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadMultipleZip(List<String> files, String destination) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
