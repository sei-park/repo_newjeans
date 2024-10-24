package com.ador.infra.hotel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ador.infra.code.CodeDto;

import jakarta.annotation.PostConstruct;

@Service
public class HotelService {
	
	@Autowired
	HotelDao hotelDao;
	
	// selectList
	public List<HotelDto> hotelList(HotelVo hotelVo) {
		return hotelDao.hotelList(hotelVo);
	}
	
	// insert 
	public int hotelInsert(HotelDto hotelDto) {
		return hotelDao.hotelInsert(hotelDto);
	}
	
	// selectOne
	public HotelDto hotelSelectOne(HotelDto hotelDto) {
		return hotelDao.hotelSelectOne(hotelDto);
	}
	
	// update
	public int hotelUpdate(HotelDto hotelDto) {
		return hotelDao.hotelUpdate(hotelDto);
	}
	
	// update delete 
	public int uelete(HotelDto hotelDto) {
		return hotelDao.uelete(hotelDto);
	}
	
	// delete
	public int delete(HotelDto hotelDto) {
		return hotelDao.delete(hotelDto);
	}
	
	// paging
	public int selectOneCount(HotelVo hotelVo) {
		return hotelDao.selectOneCount(hotelVo);
	}
	
	
	// 특정 함수를 구동시키는 어노테이션 
//    @PostConstruct 
//	public void hotelList() {
//		List<HotelDto> codeListFromDb = (ArrayList<HotelDto>) hotelDao.hotelList(); 
//		HotelDto.cachedHotelArrayList.clear(); 
//		HotelDto.cachedHotelArrayList.addAll(codeListFromDb); 
//		System.out.println("cachedCodeArrayList: " + HotelDto.cachedHotelArrayList.size() + " chached !");
//	}
//    
//    // 데이터 삭제
//    public static void clear() {
//    	HotelDto.cachedHotelArrayList.clear();
//	}
    
    // codegroup의 seq 번호를 받고 해당하는 code의 내용을 List로 출력 
//	public static List<HotelDto> selectListCachedCode(String htseq) {
//		List<CodeDto> rt = new ArrayList<CodeDto>();
//		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
//			if (codeRow.getCodegroup_ifcgSeq().equals(htseq)) {
//				rt.add(codeRow);
//			} else {
//				// by pass
//			}
//		}
//		return rt;
//	}
//	

	

	

	
	
}
