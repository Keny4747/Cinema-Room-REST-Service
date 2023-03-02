package cinema.model.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class Token {
    private String token;

    public Token(){
        this.token = generateUUID();
    }
    public String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
