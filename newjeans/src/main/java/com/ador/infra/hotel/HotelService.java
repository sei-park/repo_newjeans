package com.ador.infra.hotel;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ador.common.util.UtilDateTime;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class HotelService {
	
	@Autowired
	HotelDao hotelDao;
	
	@Autowired
	AmazonS3Client amazonS3Client; 
	
	// selectList
	public List<HotelDto> hotelList(HotelVo hotelVo) {
		return hotelDao.hotelList(hotelVo);
	}
	
	// insert 
	public int hotelInsert(HotelDto hotelDto, int type) throws Exception {
		
		for(int i=0; i < hotelDto.getUploadFiles().length; i++) { 
			
			if(!hotelDto.getUploadFiles()[i].isEmpty()) {
				
				// 파일 정보 설정
				String className = hotelDto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = hotelDto.getUploadFiles()[i].getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
				String pathModule = className;
				String nowString = UtilDateTime.nowString();
				String pathDate = nowString.substring(0,4) + "/" + nowString.substring(5,7) + "/" + nowString.substring(8,10); 
				String path = pathModule + "/" + type + "/" + pathDate + "/";
//				String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
				
				
				// S3에 업로드
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(hotelDto.getUploadFiles()[i].getSize());
		        metadata.setContentType(hotelDto.getUploadFiles()[i].getContentType());
		        amazonS3Client.putObject("newjeans", path + uuidFileName, hotelDto.getUploadFiles()[i].getInputStream(), metadata);
				
		        // S3 URL 생성
		        String objectUrl = amazonS3Client.getUrl("newjeans", path + uuidFileName).toString();
		        
		        // Dto에 정보 설정
		        hotelDto.setHtupath(objectUrl);
		        hotelDto.setHtuoriginalName(fileName);
		        hotelDto.setHtuuuidName(uuidFileName);
		        hotelDto.setHtuext(ext);
		        hotelDto.setHtusize(hotelDto.getUploadFiles()[i].getSize());

		        // hotelDto.setTableName(tableName);      
		        hotelDto.setHtutype(type);
		        // hotelDto.setHtusort(maxNumber + i);
		        hotelDto.setHtupseq(hotelDto.getHtupseq());
		        
		        hotelDao.insertUploaded(hotelDto);      
			}
		}
		
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
	
	// detailList
	public List<HotelDto> hotelDetailList(HotelDto hotelDto) {
		return hotelDao.hotelDetailList(hotelDto);
	}
	
	// hotel, hotelroom 연결
	public List<HotelDto> selectListHotelRoom() {
		return hotelDao.selectListHotelRoom();
	}
	
	// 예약 insert
	public int hotelBookingInsert(HotelDto hotelDto) {
		
		System.out.println("예약 insert, hotelBookingInsert");
		return hotelDao.hotelBookingInsert(hotelDto);
	}
	
	public int hotelBookingMenuInsert(HotelDto hotelDto) {
		
		System.out.println("예약 insert, hotelBookingMenuInsert");
		return hotelDao.hotelBookingMenuInsert(hotelDto);
	}
	
	
	// 결제 정보 출력
	// hotelbooking + hotelmember  정보 출력
	public HotelDto paymentSelectOne(HotelDto hotelDto) {
		return hotelDao.paymentSelectOne(hotelDto);
	}
	 
	// hotelbookingmenu + hotelmember  정보 출력 
	public List<HotelDto> paymentSelectList(HotelDto hotelDto) {
		return hotelDao.paymentSelectList(hotelDto);
	}
	
	// hotel 정보 출력 
    public HotelDto paymentHotelSelectOne(HotelDto hotelDto) {
    	return hotelDao.paymentHotelSelectOne(hotelDto);
    }
    
    // 결제 정보 업데이트
 	public int bookingUpdate(HotelDto hotelDto) {
 		return hotelDao.bookingUpdate(hotelDto);
 	}
	
 	// 예약 내역 리스트
 	public List<HotelDto> bookingHistorySelectList(HotelVo hotelVo) {
 		return hotelDao.bookingHistorySelectList(hotelVo);
 	}
	
 	// 예약 내역 paging
 	public int bookingHistorySelectOneCount(HotelVo hotelVo) {
 		return hotelDao.bookingHistorySelectOneCount(hotelVo);
 	}
 	
 	// 예약 내역 상세페이지
// 	public HotelDto bookingHistoryDetailsSelectOne(HotelDto hotelDto) {
// 		return hotelDao.bookingHistoryDetailsSelectOne(hotelDto);
// 	}
 	
 	// 예약 내역 상세페이지 selectList
 	public List<HotelDto> bookingHistoryDetailsSelectList(HotelDto hotelDto) {
 		return hotelDao.bookingHistoryDetailsSelectList(hotelDto);
 	}
	
	
	
	
	
	
	
}
