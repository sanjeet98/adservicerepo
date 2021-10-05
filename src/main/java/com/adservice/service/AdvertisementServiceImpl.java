/**
 * 
 */
package com.adservice.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adservice.entity.Advertisement;
import com.adservice.exception.AdvertisementAlreadyExistException;
import com.adservice.exception.AdvertisementNotFoundException;
import com.adservice.repository.AdvertisementRepository;

/**
 * @author Sanjeet
 *
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {
	
	@Autowired
	private AdvertisementRepository advertisementRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AdvertisementServiceImpl.class);
	
	@Override
	public Advertisement saveAdvertisement(Advertisement Advertisement) {
		logger.info("Inside advertisement service adding advertisement");
		if (Advertisement.getTitle() == null) {
			throw new NullPointerException("Please Enter All Values in the field");
		}
		
		if ((advertisementRepository.findBytitle(Advertisement.getTitle())) != null) {
			
			throw new AdvertisementAlreadyExistException("Advertisement already exists");
		} 
		return advertisementRepository.save(Advertisement);
		
	}
	
	@Override
	public Advertisement findBytitle(String title) {
		logger.info("Inside Advertisement service getAdvertisementBytitle");
		if (title == null) {
			
			throw new NullPointerException("Please Provide Title");
		}
		
		if ((advertisementRepository.findBytitle(title)) == null) {
			
			throw new AdvertisementNotFoundException("User with title : " + title + " does not exists");
		}
		return advertisementRepository.findBytitle(title);
		
	}

	@Override
	public Advertisement findByadvertiseIdentifier(String advertiseIdentifier) {
		logger.info("Inside Advertisement service find by Ad Id");
		if (advertiseIdentifier == null) {
			
			throw new NullPointerException("Please Provide Advertise Id");
		}
		
		if ((advertisementRepository.findByadvertiseIdentifier(advertiseIdentifier)) == null) {
			
			throw new AdvertisementNotFoundException("User with Advertise Id : " + advertiseIdentifier + " does not exists");
		}
		return advertisementRepository.findByadvertiseIdentifier(advertiseIdentifier);
		
	}

	@Override
	public Advertisement findByPostedBy(String PostedBy) {
		logger.info("Inside Advertisement service find by Posted Id");
		@SuppressWarnings("unused")
		Advertisement advertisement=null;
		if (PostedBy == null) {
			
			throw new NullPointerException("Please Provide Post");
		}
		
		if ((advertisement = advertisementRepository.findByPostedBy(PostedBy)) == null) {
			
			throw new AdvertisementNotFoundException("Advertisement with PostedBy : " + PostedBy + " does not exists");
		}
		return advertisementRepository.findByPostedBy(PostedBy);	
	}
	/**
	 * Updating or modifying advertisement details
	 */
	@Override
	public Advertisement updateAdvertisement(Advertisement advertisement) {
Advertisement oldAdvertisement =null;
		
		if (advertisement.getTitle() == null) {
			logger.info("Inside Advertisement service update Advertisement");
			throw new NullPointerException("Please Fill the Required Fields");
		}
		
		if ((oldAdvertisement=advertisementRepository.findBytitle(advertisement.getTitle())) == null) {
			logger.info("Inside Advertisement service update Advertisement");
			throw new AdvertisementNotFoundException("Advertisement with title: " + advertisement.getTitle() + " does not exists");
		}
		
		logger.info("Inside Advertisement service update Advertisement");
		advertisement.setAdvertiseId(oldAdvertisement.getAdvertiseId());
		oldAdvertisement = advertisement;
		return advertisementRepository.save(oldAdvertisement);
	}

	@Override
	public List<Advertisement> findAll() {
		try {
			
			return advertisementRepository.findAll();
		} catch (Exception e) {
			
			throw new AdvertisementNotFoundException("No Advertisement Found");
		}
	}
	/**
	 * Deleting advertisement
	 */
	@SuppressWarnings("unused")
	@Override
	public void deleteByadvertiseIdentifier(String advertiseIdentifier) {	
		Advertisement advertisement = null;
		
		if (advertiseIdentifier == null) {
			logger.info("Inside Advertisement service delete Advertisement");
			throw new NullPointerException("Please Provide Advertise Identifier");
		}
		
		if ((advertisement = advertisementRepository.findByadvertiseIdentifier(advertiseIdentifier)) == null) {
			logger.info("Inside Advertisement service delete Advertisement");
			throw new AdvertisementNotFoundException("Advertisement with task identifier: " + advertiseIdentifier + " does not exists");
		}
		logger.info("Inside Advertisement service delete Advertisement");
		advertisementRepository.deleteByadvertiseIdentifier(advertiseIdentifier);
	}

	@Override
	public void deleteAdvertisementById(Long advertiseIdentifier) {
		// TODO Auto-generated method stub
		
	}
}