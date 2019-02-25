package no.systema.tror.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

public class DaoConverter {

	/**
	 * 
	 * @return
	 */
	public Converter<String, BigDecimal> doBigDecimal(){
		Converter<String, BigDecimal> converter = new AbstractConverter<String, BigDecimal>() {
			protected BigDecimal convert(String source) {
				String tmp = source == null ? null : source.replaceFirst(",", ".");
				BigDecimal bd = new BigDecimal(0);
				if(tmp!=null && !"".equals(tmp)){
					 bd = new BigDecimal(Double.parseDouble(tmp));
					 bd = bd.setScale(2, RoundingMode.HALF_UP);
				}
				return bd;
			  }
		};
		
		return converter;
	}
	/**
	 * 
	 * @return
	 */
	public Converter<String, Integer> doInteger(){
		Converter<String, Integer> converter = new AbstractConverter<String, Integer>() {
			protected Integer convert(String source) {
				String tmp = source == null ? null : source;
				Integer _int = 0;
				if(tmp!=null && !"".equals(tmp)){
					_int = Integer.parseInt(tmp);
				}
				return _int;
			  }
		};
		
		return converter;
	}
}
