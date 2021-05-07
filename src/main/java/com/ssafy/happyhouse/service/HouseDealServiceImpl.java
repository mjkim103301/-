package com.ssafy.happyhouse.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dao.HouseDealDao;
import com.ssafy.model.dao.HouseDealDaoImpl;
import com.ssafy.model.dto.HouseDealDto;
import com.ssafy.model.dto.PageBean;
import com.ssafy.model.dto.ProductException;
import com.ssafy.util.DBUtil;
import com.ssafy.util.PageUtility;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	@Autowired
	private HouseDealDao dao;
	
	@Transactional
	@Override
	public List<HouseDealDto> searchAll(PageBean bean) {
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			//페이지 처리를 위해 전체 데이타 개수 조회
			int total=dao.totalCount(conn, bean);
			PageUtility util=new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");// 나중에 이미지 다운받고 경로 넣기!!!
			bean.setPageLink(util.getPageBar());
			
			List<HouseDealDto> result=dao.searchAll(conn, bean);
			
			/*for(HouseDealDto item:result) {
				System.out.println("HouseDealDto AptName>> "+ item.AptName);
			}*/
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			throw new ProductException("제품 목록 조회 중 오류 발생");
		}finally {
			DBUtil.close(conn);
		}
	}
	
	
	@Transactional
	@Override
	public HouseDealDto getHouseDeal(long no) {
		// TODO Auto-generated method stub
		return null;
	}
}
