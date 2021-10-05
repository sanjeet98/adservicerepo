/**
 * 
 */
package com.adservice.serviceimpltest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.adservice.entity.Advertisement;
import com.adservice.exception.AdvertisementAlreadyExistException;
import com.adservice.exception.AdvertisementNotFoundException;
import com.adservice.repository.AdvertisementRepository;
import com.adservice.service.AdvertisementServiceImpl;

/**
 * @author Sanjeet
 *
 */
public class AdServiceImplTest {

	@InjectMocks
	AdvertisementServiceImpl advertisementServiceImpl;

	private Advertisement testad;
	private Advertisement ad1;
	private Advertisement ad2;
	private Advertisement ad3;
	private List<Advertisement> adList;

	@Mock
	AdvertisementRepository advertisementRepository;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this); // invoke mocks

		/**
		 * advertiseId, title, advertiseIdentifier, offerDescription, availableStock,
		 * postedBy
		 */
		testad = new Advertisement("test", "test", "test", "admin", "admin");
		ad1 = new Advertisement("ad1", "ad1", "ad1", "admin", "admin");
		ad2 = new Advertisement("ad2", "ad2", "ad2", "dealer", "dealer");
		ad3 = new Advertisement("ad3", "ad3", "ad3", "farmer", "farmer");

		adList = new ArrayList<>();
		adList.add(ad1);
		adList.add(ad2);
		adList.add(ad3);
	}

	// FIND TEST CASE: By designated values like advertiseId, title,
	// advertiseIdentifier, offerDescription, availableStock, postedBy

	@Test
	void test_SaveAdvertisement_Given_AdvertisementnameNull_Should_Return_Nullpointer_Exception() {

		when(advertisementServiceImpl.saveAdvertisement(testad))
				.thenThrow(new NullPointerException("Please Enter All Values in the field"));
		Exception ex = assertThrows(NullPointerException.class,
				() -> advertisementServiceImpl.saveAdvertisement(testad));
		assertEquals("Please Enter All Values in the field", ex.getMessage());

	}

	// FIND TEST CASE: By title of AD
	@Test
	void test_SaveAdvertisement_Given_Title_Should_Return_SavedAdvertisement() {
		when(advertisementRepository.save(ad1)).thenReturn(ad1);
		Advertisement savedAdvertisement = advertisementServiceImpl.saveAdvertisement(ad1);
		assertEquals(ad1.getAdvertiseId(), savedAdvertisement.getAdvertiseId());
		assertEquals(ad1.getTitle(), savedAdvertisement.getTitle());
		assertEquals(ad1.getAdvertiseIdentifier(), savedAdvertisement.getAdvertiseIdentifier());
	}

	// FIND TEST CASE: By Available stocks
	@Test
	void test_SaveAdvertisement_Given_availableStock_Should_Return_SavedAdvertisement() {
		when(advertisementRepository.save(ad1)).thenReturn(ad1);
		Advertisement savedAdvertisement = advertisementServiceImpl.saveAdvertisement(ad1);
		assertEquals(ad1.getAdvertiseId(), savedAdvertisement.getAdvertiseId());
		assertEquals(ad1.getTitle(), savedAdvertisement.getTitle());
		assertEquals(ad1.getAdvertiseIdentifier(), savedAdvertisement.getAdvertiseIdentifier());
	}

	// FIND TEST CASE: By the person who has posted the AD
	@Test
	void test_SaveAdvertisement_Given_postedBy_Should_Return_SavedAdvertisement() {
		when(advertisementRepository.save(ad1)).thenReturn(ad1);
		Advertisement savedAdvertisement = advertisementServiceImpl.saveAdvertisement(ad1);
		assertEquals(ad1.getAdvertiseId(), savedAdvertisement.getAdvertiseId());
		assertEquals(ad1.getTitle(), savedAdvertisement.getTitle());
		assertEquals(ad1.getAdvertiseIdentifier(), savedAdvertisement.getAdvertiseIdentifier());
	}

	// FIND TEST CASE: By Offer Description
	@Test
	void test_SaveAdvertisement_Given_offerDescription_Should_Return_SavedAdvertisement() {
		when(advertisementRepository.save(ad1)).thenReturn(ad1);
		Advertisement savedAdvertisement = advertisementServiceImpl.saveAdvertisement(ad1);
		assertEquals(ad1.getAdvertiseId(), savedAdvertisement.getAdvertiseId());
		assertEquals(ad1.getTitle(), savedAdvertisement.getTitle());
		assertEquals(ad1.getAdvertiseIdentifier(), savedAdvertisement.getAdvertiseIdentifier());
	}

	// FIND TEST CASE: Existing Advertisement
	@Test
	void test_SaveAdvertisement_Given_ExistingAdvertisement_Should_Return_Exception_AdvertisementAlreadyExist() {
		when(advertisementRepository.save(ad1)).thenReturn(ad1);
		Advertisement savedAdvertisement = advertisementServiceImpl.saveAdvertisement(ad1);
		assertEquals(ad1.getAdvertiseId(), savedAdvertisement.getAdvertiseId());
		assertEquals(ad1.getTitle(), savedAdvertisement.getTitle());
		assertEquals(ad1.getAdvertiseIdentifier(), savedAdvertisement.getAdvertiseIdentifier());
	}

	// FIND TEST CASE: Not found AD by title
	@Test
	void test_findByTitle_Given_String_NotFoundTitle_AdvertisementNotFoundException() {
		String title = "sanj123";
		when(advertisementRepository.findBytitle(title)).thenThrow(
				new AdvertisementNotFoundException("Advertisement with title : " + title + " does not exists"));
		Exception ex = assertThrows(AdvertisementNotFoundException.class,
				() -> advertisementServiceImpl.findBytitle(title));
		assertEquals("Advertisement with title : " + title + " does not exists", ex.getMessage());
	}

	// FIND TEST CASE: By not finding the person who posted the AD
	@Test
	void test_findByTitle_Given_String_NotFoundPostedBy_AdvertisementNotFoundException() {
		String PostedBy = "dealer12";
		when(advertisementRepository.findByPostedBy(PostedBy)).thenThrow(
				new AdvertisementNotFoundException("Advertisement with PostedBy : " + PostedBy + " does not exists"));
		Exception ex = assertThrows(AdvertisementNotFoundException.class,
				() -> advertisementServiceImpl.findByPostedBy(PostedBy));
		assertEquals("Advertisement with PostedBy : " + PostedBy + " does not exists", ex.getMessage());
	}

	// FIND TEST CASE: Already exist AD by title
	@Test
	void test_findByTitle_Given_String_AlreadyExistAdvertisement_AdvertisementAlreadyExistException() {
		String Title = "sup123";
		when(advertisementRepository.findBytitle(Title))
				.thenThrow(new AdvertisementAlreadyExistException("Advertisement already exists"));
		Exception ex = assertThrows(AdvertisementAlreadyExistException.class,
				() -> advertisementServiceImpl.findBytitle(Title));
		assertEquals("Advertisement already exists", ex.getMessage());
	}

	@AfterEach
	public void cleanUp() {

		ad3 = ad1 = ad2 = null;
		adList = null;
	}
}