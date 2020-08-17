package dileep.inventory.stockmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

	private Long itemNo;
	private String itemName;
	private String itemDesc;

	public Item() {

	}

	public Item(String itemName, String itemDesc) {
		super();
		this.itemName = itemName;
		this.itemDesc = itemDesc;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getItemNo() {
		return itemNo;
	}

	public void setItemNo(Long itemNo) {
		this.itemNo = itemNo;
	}

	@Column(name = "item_name", nullable = false)
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "item_desc", nullable = false)
	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	@Override
	public String toString() {
		return "Item [itemNo=" + itemNo + ", itemName=" + itemName + ", itemDesc=" + itemDesc + "]";
	}

}
