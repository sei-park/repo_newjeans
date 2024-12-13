package com.ador.infra.hotelRoom;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ador.common.util.UtilDateTime;
import com.ador.infra.hotel.HotelDao;
import com.ador.infra.hotel.HotelDto;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class HotelRoomService {
	
	@Autowired
	HotelRoomDao hotelRoomDao;
	
	@Autowired
	AmazonS3Client amazonS3Client; 
	
	// selectList
	public List<HotelRoomDto> selectRoomList(HotelRoomVo hotelRoomVo) {
		return hotelRoomDao.selectRoomList(hotelRoomVo);
	}
	
	// insert
	public int selectRoomInsert(HotelRoomDto hotelRoomDto) {
		return hotelRoomDao.selectRoomInsert(hotelRoomDto);
	}
	
	// selectOne
	public HotelRoomDto selectRoomSelectOne(HotelRoomDto hotelRoomDto) {
		return hotelRoomDao.selectRoomSelectOne(hotelRoomDto);
	}
	
//	// update
//	public int selectRoomUpdate(HotelRoomDto hotelRoomDto) {
//		return hotelRoomDao.selectRoomUpdate(hotelRoomDto);
//	}
	
	
	// update
	public int selectRoomUpdate(HotelRoomDto hotelRoomDto, int type) throws Exception {
		
		for(int i=0; i < hotelRoomDto.getUploadFiles().length; i++) { 
			
			if(!hotelRoomDto.getUploadFiles()[i].isEmpty()) {
				
				// 파일 정보 설정
				String className = hotelRoomDto.getClass().getSimpleName().toString().toLowerCase();		
				String fileName = hotelRoomDto.getUploadFiles()[i].getOriginalFilename();
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
		        metadata.setContentLength(hotelRoomDto.getUploadFiles()[i].getSize());
		        metadata.setContentType(hotelRoomDto.getUploadFiles()[i].getContentType());
		        amazonS3Client.putObject("newjeans", path + uuidFileName, hotelRoomDto.getUploadFiles()[i].getInputStream(), metadata);
				
		        // S3 URL 생성
		        String objectUrl = amazonS3Client.getUrl("newjeans", path + uuidFileName).toString();
		        
		        // Dto에 정보 설정
		        hotelRoomDto.setHtupath(objectUrl);
		        hotelRoomDto.setHtuoriginalName(fileName);
		        hotelRoomDto.setHtuuuidName(uuidFileName);
		        hotelRoomDto.setHtuext(ext);
		        hotelRoomDto.setHtusize(hotelRoomDto.getUploadFiles()[i].getSize());

		        // hotelDto.setTableName(tableName);      
		        hotelRoomDto.setHtutype(type);
		        // hotelDto.setHtusort(maxNumber + i);
		        //hotelRoomDto.setHtupseq(hotelRoomDto.getHtseq());
		        hotelRoomDto.setHturegSeq(hotelRoomDto.getHtrseq());
		        
		        hotelRoomDao.insertUploaded(hotelRoomDto);      
			}
		}
		
		return hotelRoomDao.selectRoomUpdate(hotelRoomDto);
	}
	
	public int insertUploaded(HotelRoomDto hotelRoomDto) {
		return hotelRoomDao.insertUploaded(hotelRoomDto);
	}
	
	
	// paging
	public int selectOneCount(HotelRoomVo hotelRoomVo) {
		return hotelRoomDao.selectOneCount(hotelRoomVo);
	}

}
