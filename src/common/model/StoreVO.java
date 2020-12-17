package common.model;

public class StoreVO {
	
	private int storeId;
	private String storeName;
	private String storeAddr;
	private int storeSize;
	private int storeType;
	
	public StoreVO() {
	}

	public StoreVO(int storeId, String storeName, String storeAddr, int storeSize, int storeType) {
		super();
		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddr = storeAddr;
		this.storeSize = storeSize;
		this.storeType = storeType;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddr() {
		return storeAddr;
	}

	public void setStoreAddr(String storeAddr) {
		this.storeAddr = storeAddr;
	}

	public int getStoreSize() {
		return storeSize;
	}

	public void setStoreSize(int storeSize) {
		this.storeSize = storeSize;
	}

	public int getStoreType() {
		return storeType;
	}

	public void setStoreType(int storeType) {
		this.storeType = storeType;
	}

	@Override
	public String toString() {
		return "StoreVO [storeId=" + storeId + ", storeName=" + storeName + ", storeAddr=" + storeAddr + ", storeSize="
				+ storeSize + ", storeType=" + storeType + "]";
	}
	
	
	
}
