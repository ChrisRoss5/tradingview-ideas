package hr.algebra.dal.repository.file;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.utilities.FileUtils;

public class FileImageRepository implements ImageRepository {
  private static final String DIR = "assets";
  private static final String EXT = ".png";

  @Override
  public String saveImage(String imageUrl) throws Exception {
    String ext = imageUrl.substring(imageUrl.lastIndexOf("."));
    if (ext.length() > 4) {
      ext = EXT;
    }
    String pictureName = UUID.randomUUID() + ext;
    String localPicturePath = DIR + File.separator + pictureName;
    FileUtils.copyFromUrl(imageUrl, localPicturePath);
    return localPicturePath;
  }

  @Override
  public void deleteImage(String imageUrl) throws Exception {
    File file = new File(imageUrl);
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
}
