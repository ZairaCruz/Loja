package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = " pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	@Column(name = "cpf", length = 14, nullable = true)
	private String cpf;
	
	@Column(name= "rg", length = 10, nullable = true)
	private String rg;
	
	@Column(name = "data_nasc")
	private Date data_nasc;
	
	@Column(name = "rua", length = 60, nullable = true)
	private String rua;
	
	@Column(name = "bairro", length = 30, nullable = true)
	private String bairro;
	
	@Column(name = "cidade", length = 30, nullable = true)
	private String cidade;
	
	@Column(name = "uf", length = 2, nullable = true)
	private String uf;
	
	@Column(name = "cep")
	private int cep;
	
	@Column (name = "email", length = 40, nullable = true)
	private String email;
	
	@Column (name = "senha", length = 32, nullable = true)
	private String senha;
	
	@Column (name = "tipo", length = 30, nullable = true)
	private String tipo;
	
	//Relacionamento de 1 para vários
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Fone> fones = new ArrayList<Fone>();
	
	public List<Fone> getFones() {
		return fones;
	}

	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
