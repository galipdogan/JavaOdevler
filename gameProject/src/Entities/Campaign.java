package Entities;

public class Campaign {
	private int campaingId;
	private String name;
	private int discount;
	
	public Campaign() {
		
	}

	public Campaign(int campaingId, String name, int discount) {
		super();
		this.campaingId = campaingId;
		this.name = name;
		this.discount = discount;
	}

	public int getCampaingId() {
		return campaingId;
	}

	public void setCampaingId(int campaingId) {
		this.campaingId = campaingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}
