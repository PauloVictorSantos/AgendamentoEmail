package br.com.alura.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class AgendamentoEmailBusiness {
	public List<String> listarAgendamentoEmail(){
		List<String>  emails  = new ArrayList<>();
		emails.add("paulovictor494@gmail.com");
		emails.add("paulovictor494@gmail.com");
		return emails;
	}
}
