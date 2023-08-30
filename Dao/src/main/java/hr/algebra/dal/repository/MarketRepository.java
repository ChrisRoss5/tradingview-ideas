package hr.algebra.dal.repository;

import java.util.List;

import hr.algebra.model.Market;

public interface MarketRepository {

  void setSelected(int id, boolean isSelected) throws Exception;

  List<Market> selectMarkets() throws Exception;

}
