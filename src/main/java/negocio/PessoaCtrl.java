package negocio;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistencia.HibernateUtil;
import persistencia.PessoaDAO;
import beans.Fone;
import beans.Pessoa;


@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setProduto(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> getListagem(){
		return PessoaDAO.listagem("");
	}
	
	public String actionGravar(){
		if(pessoa.getId() == 0){
			PessoaDAO.inserir(pessoa);
			return actionInserir();
		}else{
			PessoaDAO.alterar(pessoa);
			return "lista_pessoas";
		}
	}
	
	public String actionInserir(){
		pessoa = new Pessoa();
		return "form_pessoa";
	}
	
	public String actionExcluir(Pessoa p){
		PessoaDAO.excluir(p);
		return "lista_pessoas";
	}
	
	public String actionAlterar(Pessoa p){
		pessoa = p;
		return "form_pessoa";
	}
	
	public String voltar(){
		return "lista_pessoas";
	}
	public String actionInserirFone(){
		Fone fone = new Fone();
		fone.setPessoa(pessoa);
		pessoa.getFones().add(fone);
		return "form_pessoa";
	}
	public String actionExcluirFone(Fone f){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(f);
		t.commit();
		sessao.close();
		return "form_pessoa";
	}
}
