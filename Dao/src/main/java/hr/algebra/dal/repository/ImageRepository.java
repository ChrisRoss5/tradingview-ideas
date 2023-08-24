package hr.algebra.dal.repository;

public interface ImageRepository {
  String saveImage(String imageLink) throws Exception;

  void deleteImage(String imageLink) throws Exception;

  void deleteAllImages() throws Exception;
}
