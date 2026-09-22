package es.upm.aled.lab1.measurements;

import java.util.List;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	private int[] validChannels;
	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {
		this.validChannels = validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] medidasOriginales = eeg.getMeasurements();
		Measurement[] medidasFiltradas = new Measurement[medidasOriginales.length];
		
		 //de cada measurement del array de Masurement hay que extraer los canales para escoger los validos
		for(int i=0; i < medidasOriginales.length; i++) {
			Measurement medidaOriginal = medidasOriginales[i];
			float[] canalesNuevos = new float[validChannels.length];
			for(int j=0; i < validChannels.length; j++) { //comprobar con canales validos
				int canalValido = validChannels[j];
				canalesNuevos[j] = medidaOriginal.getChannel(canalValido); //nuevo array de canales extraidos- inserta el canal en la posicion valida de cada medida
			}
			medidasFiltradas[i] = new Measurement(canalesNuevos);
		}
		
		EEGModel eegFiltrado = new EEGModel(medidasFiltradas);
		return eegFiltrado;
	}

}
