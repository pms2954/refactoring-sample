package kr.revelope.study.refactoring.common;

import kr.revelope.study.refactoring.DirtyCodeMain;
import kr.revelope.study.refactoring.model.CsvForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileUtils {

    public static CsvForm readCSV(String filePath) throws IOException {

        BufferedReader bufferedReader = load(filePath);

            CsvForm csvForm = new CsvForm();
            csvForm.addHeader(bufferedReader.readLine());

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                csvForm.addContents(line);
            }

        bufferedReader.close();

        return csvForm;
    }

    private static BufferedReader load(String filePath) {
        InputStream is = DirtyCodeMain.class.getClassLoader().getResourceAsStream(filePath);
        return new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
    }

}
