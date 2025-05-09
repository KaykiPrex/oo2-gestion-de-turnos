package datos;

public class Servicio {
	private long id;
	private String name;
	private String description;
	private String duration;
	private Double price;
	
	public Servicio(String name, String description, String duration, Double price) {
		this.name = name;
		this.description = description;
		this.duration = duration;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {

		return "{nombre=" + name + ", descripcion=" + description + ", duration=" + duration + ", price=" + price +'}';
	}
	
}
