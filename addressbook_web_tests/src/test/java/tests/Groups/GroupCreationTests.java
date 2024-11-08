package tests.Groups;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Common;
import model.GroupDate;
import org.hibernate.dialect.function.CommonFunctionFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GroupCreationTests extends TestBase {

    public static Stream<GroupDate> groupProvider() throws IOException {
        Supplier<GroupDate> randomGroup = () -> new GroupDate()
                    .withName(Common.randomString(5))
                    .withHeader(Common.randomString(5))
                    .withFooter(Common.randomString(5));
        return Stream.generate(randomGroup).limit(3);

//        for (var name : List.of("", "group name")) {
//            for (var header : List.of("", "group header")) {
//                for (var footer : List.of("", "group footer")) {
//                    result.add(new GroupDate().withName(name).withHeader(header).withFooter(footer));
//                }
//            }
//        }
//        var json = "";
//        try (var reader = new FileReader("groups.json");
//        var breader = new BufferedReader(reader)) {
//            var line = breader.readLine();
//            while(line != null) {
//                json = json + line;
//                line = breader.readLine();
//            }
//        }
  //      var json = Files.readString(Paths.get("groups.json"));
    //    ObjectMapper mapper = new ObjectMapper();
      //  var value = mapper.readValue(json, new TypeReference<List<GroupDate>>() {
       // });
    }

    @ParameterizedTest
    @MethodSource("groupProvider")
    public void canCreateMultipleGroups(GroupDate group) {
        var oldGroups = app.jdbc().getGroupList();
        app.groups().createGroup(group);
        var newGroups = app.jdbc().getGroupList();
//        Comparator<GroupDate> compareById = (o1, o2) -> {
//            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
//        };
//        newGroups.sort(compareById);
        var extraGroups = newGroups.stream().filter(g -> ! oldGroups.contains(g)).toList();
        var newId = extraGroups.get(0).id();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.add(group.withId(newId));
        //expectedList.sort(compareById);
        Assertions.assertEquals(newGroups, expectedList);

        var newUIGroups = app.groups().getList();//проверка соответствия списка групп на фронте с БД
        //newUIGroups.sort(compareById);
        newGroups = newGroups.stream()
                .map(c -> c.withFooter("").withHeader(""))
                .collect(Collectors.toList());
        Assertions.assertEquals(Set.copyOf(newGroups), Set.copyOf(newUIGroups));
    }

    public static Stream<GroupDate> negativeGroupProvider() {
        return Stream.of(
                new GroupDate("", "group name'", "", ""));
    }

    @ParameterizedTest
    @MethodSource("negativeGroupProvider")
    public void canNotCreateGroup(GroupDate group) {
        var oldGroups = app.groups().getList();
        app.groups().createGroup(group);
        var newGroups = app.groups().getList();
        Assertions.assertEquals(newGroups, oldGroups);
    }
}