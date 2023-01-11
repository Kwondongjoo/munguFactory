package com.oracle.munguFactory.lwh.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.munguFactory.dto.FactoryDTO;
import com.oracle.munguFactory.dto.ItemDTO;
import com.oracle.munguFactory.dto.StockTakingDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class StockTakingDAOImpl implements StockTakingDAO {

	private final SqlSession session;
	
	@Override
	public List<FactoryDTO> selectFactoryList() {
		return session.selectList("stockTaking.selectFactoryList");
	}

	@Override
	public List<ItemDTO> selectItemList(StockTakingDTO stockTakingDTO) {
		return session.selectList("stockTaking.selectItemList", stockTakingDTO);
	}

	@Override
	public List<StockTakingDTO> selectStockTakingList(StockTakingDTO stockTakingDTO) {
		return session.selectList("stockTaking.selectStockTakingList", stockTakingDTO);
	}

	@Override
	public List<StockTakingDTO> selectSubulList() {
		return session.selectList("selectSubulList");
	}

	@Override
	public List<StockTakingDTO> selectItemInfo(StockTakingDTO stockTakingDTO) {
		return session.selectList("selectItemInfo", stockTakingDTO);
	}

	@Override
	public int insertStockTaking(StockTakingDTO stockTakingDTO) {
		return session.insert("insertStockTaking", stockTakingDTO);
	}

	@Override
	public int updateStockCnt(StockTakingDTO stockTakingDTO) {
		return session.update("updateStockCnt", stockTakingDTO);
	}

	@Override
	public int totalStockTakingCnt() {
		return session.selectOne("totalStockTakingCnt");
	}

	@Override
	public int insertTempSilsa(StockTakingDTO stockTakingDTO) {
		return session.insert("insertTempSilsa",stockTakingDTO);
	}

	@Override
	public int updateTempSilsaGubun(StockTakingDTO stockTakingDTO) {
		return session.update("updateTempSilsaGubun",stockTakingDTO);
	}

}
