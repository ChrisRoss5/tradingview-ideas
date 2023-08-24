package hr.algebra.dal.repository;

import java.util.List;
import java.util.Optional;
import hr.algebra.model.Symbol;

public interface SymbolRepository {

  int createSymbol(Symbol symbol) throws Exception;

  void createSymbols(List<Symbol> symbols) throws Exception;

  void updateSymbol(int id, Symbol symbol) throws Exception;

  void deleteSymbol(int id) throws Exception;

  Optional<Symbol> selectSymbol(int id) throws Exception;

  Optional<Symbol> selectSymbolByLink(String link) throws Exception;

  List<Symbol> selectSymbols() throws Exception;
}
