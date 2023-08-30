package hr.algebra.dal.repository;

public interface ImageRepository {

  String saveImageFromLink(String imageLink) throws Exception;

  String saveImageFromPath(String imagePath) throws Exception;

  void deleteImage(String imageLink) throws Exception;

  void deleteAllImages() throws Exception;

}
