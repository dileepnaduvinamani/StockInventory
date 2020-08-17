package dileep.inventory.stockmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

	private int slNO;
	private long stockNumber;
	private String stockName;
	private String stockDesc;
	private Double quantity;
	private Double purchasePrice;
	private Date purchaseDate;
	private Double sellingPrice;
	private Date sellingDate;
	private Double quantityAvailable;
	private Long itemNo;

	public Stock() {

	}

	public Stock(long stockNumber, String stockName, String stockDesc, Double quantity, Double purchasePrice,
			Date purchaseDate, Double sellingPrice, Date sellingDate, Double quantityAvailable) {
		super();
		this.stockNumber = stockNumber;
		this.stockName = stockName;
		this.stockDesc = stockDesc;
		this.quantity = quantity;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
		this.sellingPrice = sellingPrice;
		this.sellingDate = sellingDate;
		this.quantityAvailable = quantityAvailable;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getSlNO() {
		return slNO;
	}

	public void setSlNO(int slNO) {
		this.slNO = slNO;
	}

	public long getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(long stockNumber) {
		this.stockNumber = stockNumber;
	}

	@Column(name = "stock_name", nullable = false)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Column(name = "stock_desc", nullable = false)
	public String getStockDesc() {
		return stockDesc;
	}

	public void setStockDesc(String stockDesc) {
		this.stockDesc = stockDesc;
	}

	@Column(name = "quntity", nullable = false)
	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Column(name = "purchase_price", nullable = false)
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Column(name = "purchase_date", nullable = false)
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Column(name = "selling_price", nullable = false)
	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	@Column(name = "selling_date", nullable = false)
	public Date getSellingDate() {
		return sellingDate;
	}

	public void setSellingDate(Date sellingDate) {
		this.sellingDate = sellingDate;
	}

	@Column(name = "quantity_available", nullable = false)
	public Double getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(Double quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public Long getItemNo() {
		return itemNo;
	}

	public void setItemNo(Long itemNo) {
		this.itemNo = itemNo;
	}

}
