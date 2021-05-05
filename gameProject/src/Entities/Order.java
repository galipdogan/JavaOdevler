package Entities;

import Abstract.Entity;

public class Order implements Entity{
	
	private int orderId;
	private int gamerId;
	private int gameId;
	private int campaignId;
	private int quantity;
	private double discountAmount;
	private double totalAmount;
	
	public Order(){
		
	}

	public Order(int orderId, int gamerId, int gameId, int campaignId,int quantity,double discountAmount, double totalAmount) {
		this.orderId = orderId;
		this.gamerId = gamerId;
		this.gameId = gameId;
		this.campaignId = campaignId;
		this.quantity=quantity;
		this.discountAmount=discountAmount;
		this.totalAmount=totalAmount;
	}

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getGamerId() {
		return gamerId;
	}

	public void setGamerId(int gamerId) {
		this.gamerId = gamerId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(int campaignId) {
		this.campaignId = campaignId;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
