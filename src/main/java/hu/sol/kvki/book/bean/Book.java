package hu.sol.kvki.book.bean;

public class Book {
	private Integer id;
	private String name;
	private String desc;
	private String author;
	private int pubYear;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", author=" + author + ", pubYear=" + pubYear + "]";
	}

}
