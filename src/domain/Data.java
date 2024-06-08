package domain;

import java.util.Objects;

public class Data implements Comparable {
	
	private Long id;
	
	public Data(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		
		return "id : " + id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Data data = (Data) o;
		return Objects.equals(id, data.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
	@Override
	public int compareTo(Object o) {
		return (int) (this.id - ((Data) o).getId());
	}
}
