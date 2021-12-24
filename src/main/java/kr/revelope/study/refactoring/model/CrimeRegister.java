package kr.revelope.study.refactoring.model;

import kr.revelope.study.refactoring.common.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CrimeRegister implements Register {

    private Map<String, Integer> headers = new HashMap<>();

    private List<List<String>> contents = new ArrayList<>();

    @Override
    public void updateHeader(CsvForm csvForm) {
        IntStream.rangeClosed(0, csvForm.getHeaders().size() - 1 )
                .forEach(index -> headers.put(csvForm.getHeaders().get(index), index));
    }

    @Override
    public void updateContents(CsvForm csvForm) {
        this.contents = csvForm.getContents().stream()
                .filter(t -> t.size() == headers.size())
                .collect(Collectors.toList());
    }

    @Override
    public Integer getHeader(String targetText) {
        return headers.get(targetText);
    }

    @Override
    public List<List<String>> getContent() {
        return contents;
    }
}
