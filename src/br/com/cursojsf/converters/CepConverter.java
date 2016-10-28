package br.com.cursojsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.cursojsf.model.Cep;

@FacesConverter("converters.CepConverter")
public class CepConverter implements Converter {
	
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
    	if(value != null ) {
    		      String[] split = value.split("-");
    		      if(split.length == 2){
    		       return new Cep( split[0] , split[1] );
    		      }
    		      if(split.length == 1){
    		        return new Cep( split[0] , "" );
    		      }
    		    }
        return null;
    }
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
    	 if(value != null){
    		       return ((Cep)value).toString();
    		     }
        return null;
    }
}