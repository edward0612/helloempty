package tw.org.iii.cma.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EMP")
@Data
public class Emp{ 
	
	@Id
	@Column(name = "pk")
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer pk;
	
	@Column(name = "empno")
	private String empno;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "cellphone")
	private String cellphone;
	
	@Column(name = "gender")
	private Integer gender;
	
	@Column(name = "groups")
	private String groups;
	
	@Column(name = "uuid")
	private Integer uuid;

	public Emp() {}
	
	public Emp(String empno, String name, String email, String cellphone, Integer gender, String groups, Integer uuid) {
		super();
		this.empno = empno;
		this.name = name;
		this.email = email;
		this.cellphone = cellphone;
		this.gender = gender;
		this.groups = groups;
		this.uuid = uuid;
	}
	
	
}
