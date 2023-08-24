package hr.algebra.dal.repository;

import hr.algebra.model.Market;
import java.util.List;
import java.util.Optional;

public interface MarketRepository {

  int createMarket(Market market) throws Exception;

  void updateMarket(int id, Market market) throws Exception;

  void deleteMarket(int id) throws Exception;

  Optional<Market> selectMarket(int id) throws Exception;

  List<Market> selectMarkets() throws Exception;
}
