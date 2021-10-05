/**
 * 
 */
package com.adservice.service;

import java.util.List;

import com.adservice.entity.Advertisement;
// import com.cloud.farmappapi.exception.AdvertisementNotFoundException;

/**
 * @author Sanjeet
 *
 */
public interface AdvertisementService {

	public Advertisement saveAdvertisement(Advertisement Advertisement);
	public Advertisement findBytitle(String title);
	public Advertisement findByadvertiseIdentifier(String advertiseIdentifier);
	public Advertisement findByPostedBy(String PostedBy);
    
	public Advertisement updateAdvertisement(Advertisement advertisement);
	
	public List<Advertisement> findAll();
	public void deleteByadvertiseIdentifier(String advertiseIdentifier);
	public void deleteAdvertisementById(Long advertiseIdentifier);
}