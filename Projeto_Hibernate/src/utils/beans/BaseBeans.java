/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.beans;

import java.io.Serializable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Izidio
 */
//Serializable para transportar ele
public class BaseBeans implements Serializable {

    //UID
    private static final long serialVersionUID = -7015461569803621288L;
    //Override para todos os objetos 
    //para imprimir os atributos de qualquer classe e comparações  entre beans
    //sem programar pra cada beans os metodos 

    //comparação entre os objetos
    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    //ToStringBuilder pega os atribuitos dos beans por reflexao
    //e imprime no estilo de multiplas linhas
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
