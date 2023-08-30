package hr.algebra.dal.repository;

import java.util.List;
import hr.algebra.model.Symbol;

public interface SymbolRepository {

  int createSymbol(Symbol symbol) throws Exception;

  void createSymbols(List<Symbol> symbols) throws Exception;

  void updateSymbol(int id, Symbol symbol) throws Exception;

  void deleteSymbol(int id) throws Exception;

  List<Symbol> selectSymbols() throws Exception;

}
