package kr.revelope.study.refactoring.model;

import kr.revelope.study.refactoring.common.FileUtils;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Crime {

    private Register register;

    public void registerCrime(String filePath) throws IOException {
        CsvForm csvForm = FileUtils.readCSV(filePath);

        if (csvForm.isValid()) {
            register = new CrimeRegister();
            register.updateHeader(csvForm);
            register.updateContents(csvForm);
        }
    }

    public void counting(String targetHeader) {

        Integer index = register.getHeader(targetHeader);

        if (index != null) {
            Map<String, Long> collect = register.getContent().stream()
                    .map(crime -> crime.get(index))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            collect.entrySet().forEach(System.out::println);
        }
    }
}
