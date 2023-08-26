package hr.algebra.dal.repository.file;

import java.io.File;
import java.util.UUID;

import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.utilities.FileUtils;

public class FileImageRepository implements ImageRepository {
  private static final String DIR = "assets";
  private static final String EXT = ".png";

  @Override
  public String saveImageFromLink(String imageLink) throws Exception {
    String localPicturePath = createPicturePath(imageLink);
    FileUtils.copyFromUrl(imageLink, localPicturePath);
    return localPicturePath;
  }

  @Override
  public String saveImageFromPath(String imagePath) throws Exception {
    String localPicturePath = createPicturePath(imagePath);
    FileUtils.copy(imagePath, localPicturePath);
    return localPicturePath;
  }

  @Override
  public void deleteImage(String imageLink) throws Exception {
    File file = new File(imageLink);
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
}
