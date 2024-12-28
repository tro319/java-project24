package bentouSysModel;

public class BentouClass {
	
	// 各情報の取得をする、フィールドを定義。
	
	private int id;
	private String kind;
	private String bentouName;
	private int price;
	private String material;
	private String optionPlus;
	private String img;
	
	
	public BentouClass(int id, String kind, String bentouName, int price, String material, String optionPlus, String img) {
		
		this.id = id;
		this.kind = kind;
		this.bentouName = bentouName;
		this.price = price;
		this.material = material;
		this.optionPlus = optionPlus;
		this.img = img;
		
	}
	
	
	// 各情報の、ゲッターと、セッターのメソッドを作成。
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	public String getBentouName() {
		return bentouName;
	}
	
	public void setBentouName(String bentouName) {
		this.bentouName = bentouName;
	}
	
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	
	public String getOptionPlus() {
		return optionPlus;
	}
	
	public void setOptionPlus(String optionPlus) {
		this.optionPlus = optionPlus;
	}
	
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}

	
}

