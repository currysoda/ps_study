package domain;

/**
 * @field Long id
 * @field String name
 */
public class Data {
	
	private Long id;
	
	public Data(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("id : " + id + "\n");
		
		return sb.toString();
	}
}
