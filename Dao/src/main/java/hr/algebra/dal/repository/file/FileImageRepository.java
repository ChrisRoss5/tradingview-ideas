package hr.algebra.dal.repository.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.factory.UrlConnectionFactory;

public class FileImageRepository implements ImageRepository {
  private static final String DIR = "assets";
  private static final String EXT = ".png";

  @Override
  public String saveImageFromLink(String imageLink) throws MalformedURLException, IOException {
    String localPicturePath = createPicturePath(imageLink);
    createDirHierarchy(localPicturePath);
    HttpURLConnection con = UrlConnectionFactory.getHttpUrlConnection(imageLink);
    try (InputStream is = con.getInputStream()) {
      Files.copy(is, Paths.get(localPicturePath));
    }
    return localPicturePath;
  }

  @Override
  public String saveImageFromPath(String imagePath) throws IOException {
    String localPicturePath = createPicturePath(imagePath);
    createDirHierarchy(localPicturePath);
    Files.copy(Paths.get(imagePath), Paths.get(localPicturePath));
    return localPicturePath;
  }

  @Override
  public void deleteImage(String imagePath) {
    File file = new File(imagePath);
    if (file.exists()) {
      file.delete();
    }
  }

  @Override
  public void deleteAllImages() throws Exception {
    File dir = new File(DIR);
    if (dir.exists()) {
      for (File file : dir.listFiles()) {
        file.delete();
      }
    }
  }

  private String createPicturePath(String imageLinkOrPath) {
    String ext = imageLinkOrPath.substring(imageLinkOrPath.lastIndexOf("."));
    if (ext.length() > 4) {
      ext = EXT;
    }
    String pictureName = UUID.randomUUID() + ext;
    return DIR + File.separator + pictureName;
  }

  private static void createDirHierarchy(String destination) throws IOException {
    String dir = destination.substring(0, destination.lastIndexOf(File.separator));
    if (!Files.exists(Paths.get(dir))) {
      Files.createDirectories(Paths.get(dir));
    }
  }
}
