package kr.revelope.study.refactoring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CsvForm {

    private List<String> headers;
    private List<List<String>> contents;

    public CsvForm() {
        this.headers = new ArrayList<>();
        this.contents = new ArrayList<>();
    }


    public boolean isValid(){
        return !headers.isEmpty();
    }

    public List<String> getHeaders() {
        return headers;
    }

    public List<List<String>> getContents() {
        return contents;
    }

    public void addHeader(String headerLine ) {
        this.headers = Arrays.asList(headerLine.split(","));
    }

    public void addContents(String contentLine ) {
        this.contents.add(Arrays.asList(contentLine.split(",")));
    }
}
