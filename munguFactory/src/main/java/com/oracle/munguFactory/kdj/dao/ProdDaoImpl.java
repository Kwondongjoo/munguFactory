package com.oracle.munguFactory.kdj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oracle.munguFactory.dto.ProdDTO;

import lombok.RequiredArgsConstructor;
@Repository
@RequiredArgsConstructor
public class ProdDaoImpl implements ProdDao {
	
	private final SqlSession session;

	/* 생산지시조회 전체카운트 */
	@Override
	public int totalProdCnt() {
		int totalProdCnt = 0;
		System.out.println("ProdDaoImpl totalProdCnt start~!");
		try {
			//totalProdCnt = session.selectOne("totalProdCnt");
			Integer objTotalProdCnt = session.selectOne("totalProdCnt");
			totalProdCnt = objTotalProdCnt.intValue();
			System.out.println("ProdDaoImpl totalProdCnt -> "+ totalProdCnt);
		} catch (Exception e) {
			System.out.println("ProdDaoImpl totalProdCnt "+ e.getMessage());
		}
		return totalProdCnt;
	}
	/* 생산지시목록 */
	@Override
	public List<ProdDTO> listProd(ProdDTO prodDto) {
		List<ProdDTO> prodList = null;
		try {
			prodList = session.selectList("prodList", prodDto);
		} catch (Exception e) {
			System.out.println("ProdDaoImpl prodList "+ e.getMessage());
		}
		return prodList;
	}
	@Override
	public ProdDTO ContentModProd(int sujuNo) {
		System.out.println("ProdDaoImpl ContentModProd start~!");
		ProdDTO prod = new ProdDTO();
		try {
			prod = session.selectOne("ModContent", sujuNo);
		} catch (Exception e) {
			System.out.println("ProdDaoImpl prodList "+ e.getMessage());
		}
		return prod;
	}

	/*
	 * @Override public ProdDTO ContentProd(ProdDTO prodDto) {
	 * System.out.println("ProdDaoImpl ContentProd start~!"); ProdDTO prod1 = new
	 * ProdDTO(); try { prod1 = session.selectOne("ModContent", prodDto); } catch
	 * (Exception e) { System.out.println("ProdDaoImpl ContentProd "+
	 * e.getMessage());
	 * 
	 * } return prod1; }
	 */
	

}
