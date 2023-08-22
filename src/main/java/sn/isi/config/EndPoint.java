package sn.isi.config;

public abstract class EndPoint {
	//	DECLARANT
	public static final String DECLARANT = "/declarant";
	public static final String ADD_DECLARANT = "/addDeclarant";
	public static final String GET_DECLARANT_BY_ID = "/getDeclarantById/{id}";
	public static final String GET_DECLARANT_LIST = "/listDeclarant";
	public static final String DELETE_DECLARANT = "/deleteDeclarant/{id}";
	public static final String UPDATE_DECLARANT = "/updateDeclarant/{id}";
	
//	DECLARATION
	public static final String DECLARATION = "/declaration";
	public static final String ADD_DECLARATION = "/addDeclaration";
	public static final String GET_DECLARATION_BY_ID = "/getDeclarationById/{id}";
	public static final String GET_DECLARATION_LIST = "/listDeclaration";
	public static final String DELETE_DECLARATION = "/deleteDeclaration/{id}";
	public static final String UPDATE_DECLARATION = "/updateDeclaration/{id}";
	
//	PAIEMENT
	public static final String PAIEMENT = "/paiement";
	public static final String ADD_PAIEMENT = "/addPaiement";
	public static final String GET_PAIEMENT_BY_ID = "/getPaiementById/{id}";
	public static final String GET_PAIEMENT_LIST = "/listPaiement";
	public static final String DELETE_PAIEMENT = "/deletePaiement/{id}";
	public static final String UPDATE_PAIEMENT = "/updatePaiement/{id}";
}
