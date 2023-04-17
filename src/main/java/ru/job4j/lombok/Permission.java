package ru.job4j.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {
    private int id;
    private String name;

    @Singular("accessBy")
    private List<String> rules;

        public static void main(String[] args) {
            var role = Permission.of()
                    .id(5)
                    .name("odmin")
                    .accessBy("create")
                    .accessBy("update")
                    .accessBy("read")
                    .accessBy("delete")
                    .build();
            System.out.println(role);
        }

}

