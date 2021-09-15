package tw.org.iii.cma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CSV")
@Data
public class Csv {
	@Id
	@Column(name = "uuid")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer uuid;
	@Column(name = "filename")
	private String filename;
	
	public Csv() {}
	
	public Csv(Integer uuid, String filename) {
		super();
		this.uuid = uuid;
		this.filename = filename;
	}
}
