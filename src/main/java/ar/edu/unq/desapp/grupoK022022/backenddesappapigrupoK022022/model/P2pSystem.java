package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model;


public class P2pSystem {
	
	private IdGenerator idGenerator;
	
	public P2pSystem (IdGenerator idGenerator) {
		super();
		this.idGenerator = idGenerator;
		
	};
	
	public User register(String name, String lastName, String email, String address, String password, String cvuMercadoPago, String criptoWallet) {
		User newUser = new User(idGenerator.nextUserId(), name, lastName, email, address, password, cvuMercadoPago, criptoWallet);
		return newUser;
	}


}
