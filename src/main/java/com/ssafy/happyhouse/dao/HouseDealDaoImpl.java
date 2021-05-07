package com.ssafy.happyhouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;

public class HouseDealDaoImpl implements HouseDealDao {

	private static HouseDealDaoImpl houseDealDao;
	public static HouseDealDao getHouseDealDao() {
		if(houseDealDao==null) {
			houseDealDao=new HouseDealDaoImpl();
		}
		return houseDealDao;
	};
	
	private HouseDealDaoImpl() {
		
	}
	
	/**
	 * no에 따른 집 거래 정보 가져오기
	 */
	@Override
	public HouseDealDto getHouseDeal(long no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/**
	 * 거래 정보에 담긴 총 개수 
	 */
	@Override
	public int totalCount(Connection conn, PageBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/**
	 * 검색 조건에 맞는 HouseDealDto 리스트
	 */
	@Override
	public List<HouseDealDto> searchAll(Connection conn, PageBean bean) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HouseDealDto> list = new ArrayList<HouseDealDto>();
		try {
			String key = bean.getKey();
			String word= bean.getWord();
			int startNo= bean.getStartNo();
			int interval=bean.getInterval();
			
			System.out.println("searchAll>> key: "+key+" word: "+word);
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select no, AptName, dealAmount, area, dealYear, dealMonth, dealDay from housedeal  \n");
			//검색 조건에 맞는 쿼리 작성 => 동적 쿼리 
			if(key != null && !key.equals("all") && word !=null && !word.trim().equals("")) {
				if(key.equals("dong")) {
					sql.append(" where dong like ? \n");
				}else if(key.equals("dealAmount")) {
					sql.append(" where dealAmount <= ?  \n");
				}else if(key.equals("AptName")) {
					sql.append("where AptName like ? \n");
				}
			}
			sql.append(" order by no ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			System.out.println("searchAll sql>>>"+sql.toString()+" "+word);

			//데이타 설정 
			int idx = 1;  //? 번호를 위한 변수   => 조건에 따라서 ?의 번호가 달라지므로 변수를 사용한다. 
			
			if(key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if(key.equals("dong")) {
					pstmt.setString(idx++, "%"+word+"%");
				}else if(key.equals("dealAmount")) {
					pstmt.setLong(idx++, Long.parseLong(word.trim()));
				}else if(key.equals("AptName")) {
					pstmt.setString(idx++, "%"+ word +"%");
				}
			}
			
			System.out.println("startNo>>> "+startNo+" interval>>> "+interval);
			/*pstmt.setInt(idx++, startNo);
			pstmt.setInt(idx++, interval);*/
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HouseDealDto houseDealDto = new HouseDealDto();
				houseDealDto.setNo(rs.getInt("no"));
				houseDealDto.setAptName(rs.getString("AptName"));
				houseDealDto.setDealAmount(Long.parseLong(rs.getString("dealAmount").trim().replaceAll(",", "")));
				houseDealDto.setArea(Double.parseDouble(rs.getString("area")));;
				houseDealDto.setDealYear(Integer.parseInt(rs.getString("dealYear")));
				houseDealDto.setDealMonth(Integer.parseInt(rs.getString("dealMonth")));
				houseDealDto.setDealDay(Integer.parseInt(rs.getString("dealMonth")));
				
				//System.out.println("HouseDealDto>>> no"+houseDealDto.getNo()+" AptName: "+houseDealDto.getAptName());
				list.add(houseDealDto);
			}
		} finally {
			DBUtil.close(rs, pstmt);
		}
		return list;
	}
}
