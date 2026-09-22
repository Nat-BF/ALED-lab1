package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified period from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractPeriod implements Filter {
	private int min, max; //añadir tributos del objeto FilterExtractPeriod
	/**
	 * Builds the Filter from the [min, max] range defining the period that needs to
	 * be extracted. min and max are the indexes of the first and last measurements
	 * of the array obtained by calling the getMeasurements() method of EEGModel,
	 * and represent the starting and ending point of the period to be extracted.
	 * Both indexes are included and max-min must be less than the length of the
	 * Measurements array of the EGG Model.
	 * 
	 * @param min Start of the period to be extracted.
	 * @param max End of the period to be extracted.
	 */
	public FilterExtractPeriod(int min, int max) {
		this.min=min;
		this.max = max;
		
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		//1º Obtener lista de medidas del EEGMODEL
		Measurement[] medidasOriginales = eeg.getMeasurements();
		Measurement[] medidasFiltradas = new Measurement[max-min];
		//Cada measurement es un float[]	de canales. Recorrer Array de Measurement
		for(int i=0; i < medidasOriginales.length; i++) {
			int contador = 0;
			if(i < max && i >= min) { //indice se encuentra entre maximo y minimo
				medidasFiltradas[contador] = medidasOriginales[i];
				contador ++;
			}
		}
		EEGModel eegFiltrado = new EEGModel(medidasFiltradas);
		return eegFiltrado;
	}
}
