import lombok.Data;

@Data
public class SimpleItem {
	private String region;
	private String type;
	private String name;
	
	public SimpleItem(String group, String type, String name) {
		super();
		this.region = group;
		this.type = type;
		this.name = name;
	}

	@Override
	public String toString() {
		return "SimpleItem [group=" + region + ", type=" + type + ", name=" + name + "]";
	}
	
	
}
