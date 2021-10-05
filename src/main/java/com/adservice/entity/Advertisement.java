package com.adservice.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Sanjeet
 *
 */
@Entity
@Table(name="advertisements")
public class Advertisement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long advertiseId;
	
	@Size(min=5, max=10,message = "title can be 5 to 10 characters")
	@NotBlank(message = "Please Provide a Advertisement title, Don't be lazy")
	@Column(name="ad_titles",unique=true,updatable=false)
	private String title;
	
	@Size(min=2, max=4,message = "identifier can be 5 to 10 characters")
	@NotBlank(message = "Please Provide a Identifier")
	@Column(name="ad_identifiers",unique = true, updatable = false)
	private String advertiseIdentifier;
	
	@Size(min=5, max=100,message = "Offer Description can be Big till 100 characters")
	@NotBlank(message = "Please Provide a Offer Description Give something exciting")
	@Column(name="offers")
	private String offerDescription;
	
	@Size(min=0,message = "Hello! Available stock should be more than 0 ")
	@NotBlank(message = "Please Provide available Stock")
	@Column(name="stock")
	private String availableStock;
	
	
	/**
	 * @param title
	 * @param advertiseIdentifier
	 * @param offerDescription
	 * @param availableStock
	 * @param postedBy
	 */
	public Advertisement(String title, String advertiseIdentifier, String offerDescription, String availableStock,
			String postedBy) {
		super();
		this.title = title;
		this.advertiseIdentifier = advertiseIdentifier;
		this.offerDescription = offerDescription;
		this.availableStock = availableStock;
		this.postedBy = postedBy;
	}

	/**
	 * postedBy field will contain name of Dealer retrieved through session
	 */
	@Column(name="postedby")
	private String postedBy;
	/**
	 * @param advertiseId
	 * @param title
	 * @param advertiseIdentifier
	 * @param offerDescription
	 * @param availableStock
	 */
	
	/**
	 * Default Constructor for Advertisement class
	 */
	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the advertiseId
	 */
	public Long getAdvertiseId() {
		return advertiseId;
	}

	/**
	 * @param advertiseId the advertiseId to set
	 */
	public void setAdvertiseId(Long advertiseId) {
		this.advertiseId = advertiseId;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the advertiseIdentifier
	 */
	public String getAdvertiseIdentifier() {
		return advertiseIdentifier;
	}

	/**
	 * @param advertiseIdentifier the advertiseIdentifier to set
	 */
	public void setAdvertiseIdentifier(String advertiseIdentifier) {
		this.advertiseIdentifier = advertiseIdentifier;
	}

	/**
	 * @return the offerDescription
	 */
	public String getOfferDescription() {
		return offerDescription;
	}

	/**
	 * @param offerDescription the offerDescription to set
	 */
	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	/**
	 * @return the availableStock
	 */
	public String getAvailableStock() {
		return availableStock;
	}

	/**
	 * @param availableStock the availableStock to set
	 */
	public void setAvailableStock(String availableStock) {
		this.availableStock = availableStock;
	}

	/**
	 * @return the postedBy
	 */
	public String getPostedBy() {
		return postedBy;
	}

	/**
	 * @param postedBy the postedBy to set
	 */
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
}