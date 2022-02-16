package com.harby.market.domain.dto;

public class AuthenticationResponse {
    private String tk;

    public AuthenticationResponse(String tk) {
        this.tk = tk;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }
}
