package br.com.codecode.workix.tests.reflection;

import lombok.*;

@Builder @AllArgsConstructor @NoArgsConstructor
class NovaClasse {   

    @Setter @Getter
    private int idade;
    
    @Setter @Getter
    private long cpf;
    
    @Setter @Getter
    private String nome;
    

}
