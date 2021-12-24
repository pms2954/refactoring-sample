package kr.revelope.study.refactoring.model;

import java.util.List;
import java.util.Optional;

public interface Register {

    public void updateHeader(CsvForm csvForm);
    public void updateContents(CsvForm csvForm);

    public Integer getHeader(String targetText);
    public List<List<String>> getContent();

}
