package br.com.codecode.workix.tests.reflection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder @AllArgsConstructor @NoArgsConstructor
class NovaClasse {   

    @Setter @Getter
    private int idade;
    
    @Setter @Getter
    private long cpf;
    
    @Setter @Getter
    private String nome;
    

}
