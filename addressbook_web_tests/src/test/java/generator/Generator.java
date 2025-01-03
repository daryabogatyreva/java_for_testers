package generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import common.Common;
import model.ContactDate;
import model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static tests.TestBase.randomFile;

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String output;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-c"})
    int count;

    public static void main(String[] args) throws IOException {

        var generator = new Generator();
        JCommander.newBuilder()
                  .addObject(generator)
                  .build()
                  .parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateData(Supplier<Object> dataSupplier) {
        return Stream.generate(dataSupplier).limit(count).collect(Collectors.toList());
    }

    private Object generateGroups() {
        return generateData(() -> new GroupDate()
                .withName(Common.randomString(6))
                .withFooter(Common.randomString(6))
                .withHeader(Common.randomString(6)));
//        var result = new ArrayList<GroupDate>();
//        for (int i = 0; i < count; i++) {
//            result.add(new GroupDate()
//                               .withName(Common.randomString(i))
//                               .withFooter(Common.randomString(i))
//                               .withHeader(Common.randomString(i)));
//        }
//        return result;
    }

    private Object generateContacts() {
        return generateData(() -> new ContactDate()
                .withFirstName(Common.randomString(5))
                .withLastName(Common.randomString(5))
                .withMiddleName(Common.randomString(5)));
//        var result = new ArrayList<ContactDate>();
//        for (int i = 0; i < count; i++) {
//            result.add(new ContactDate()
//                    .withFirstName(Common.randomString(i))
//                    .withLastName(Common.randomString(i))
//                    .withMiddleName(Common.randomString(i))
//                    .withPhoto(randomFile("src/test/resources/images")));
//        }
//        return result;
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            var mapper = new JsonMapper();
            mapper.writeValue(new File(output), data);
//            ObjectMapper mapper = new ObjectMapper();
//            mapper.enable(SerializationFeature.INDENT_OUTPUT);
//            var json = mapper.writeValueAsString(data);
//
//            try (var writer = new FileWriter(output)) {
//                writer.write(json);
//            }
        }
         else if ("yaml".equals(format)) {
            var mapper = new YAMLMapper();
            mapper.writeValue(new File(output), data);
        }
        else if ("xml".equals(format)) {
            var mapper = new XmlMapper();
            mapper.writeValue(new File(output), data);
        } else {
            throw new IllegalArgumentException("Неизвестный формат данных " + format);
        }
    }
}

