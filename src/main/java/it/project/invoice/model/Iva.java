package it.project.invoice.model;

public enum Iva {
	ESENTE("esente",0),
//	RIDOTTA("ridotta 4%",4),
	RIDOTTA("ridotta 10%",10),
	ORDINARIA("ordinaria 22%",22);
	
	private String messaggio;
	private float percentuale;
	
	private Iva(String messaggio, float percentuale) {
		this.percentuale = percentuale;
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public float getPercentuale() {
		return percentuale;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public void setPercentuale(float percentuale) {
		this.percentuale = percentuale;
	}


}
