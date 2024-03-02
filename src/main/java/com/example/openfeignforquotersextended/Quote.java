package com.example.openfeignforquotersextended;

public class Quote {
    private String content;

    public Quote() {
    }

    public Quote(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "content='" + content + '\'' +
                '}';
    }
}
