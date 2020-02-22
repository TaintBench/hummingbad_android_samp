package com.mopub.volley;

public class ParseError extends VolleyError {
    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable cause) {
        super(cause);
    }
}
