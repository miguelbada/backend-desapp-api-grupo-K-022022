package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.model.exception;

public class PublishedPriceNotAllowed extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PublishedPriceNotAllowed(String message) {
        super(message);
    }

}
