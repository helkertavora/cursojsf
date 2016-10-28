package br.com.cursojsf.validators;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.cursojsf.model.Cep;
import br.com.cursojsf.util.ValidacaoHelper;

@FacesValidator("validators.CepValidator")
public class CepValidator implements Validator {
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {		
		if(value != null && value instanceof Cep){
			      Cep cep = (Cep)value; 
			      ValidacaoHelper.validatorRegiao(cep.getRegiao());
			      ValidacaoHelper.validatorSufixo(cep.getSufixo());
			    }
			  }
			
			  
			  
			 
			
}