package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;

public class IdGenerator {
	
	private Integer userId = 3;
	
	public Integer nextUserId() {
		return userId++;
	}

}
