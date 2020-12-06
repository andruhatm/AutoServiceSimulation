package enums;

public enum BrandEnum {
	Audi(1),
	BMW(2),
	Mercedes(3),
	Lada(4);

	private final Integer title;

	BrandEnum(Integer title) {
		this.title = title;
	}

	public Integer getTitle() {
		return title;
	}
}
