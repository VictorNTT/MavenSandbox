package org.example.sandbox;

import java.lang.reflect.Field;
import java.util.*;

public class ProtoGeneratorUtil {

    public static void main(String[] args) {
        String proto = generateProto(Person.class);
        System.out.println("Proto generated: \n" + proto);
    }
    /**
     * Generates a .proto definition string for a given Java class.
     */
    public static String generateProto(Class<?> clazz) {
        StringBuilder sb = new StringBuilder();
        sb.append("syntax = \"proto3\";\n\n");
        sb.append("package ").append(clazz.getPackage().getName()).append(";\n\n");
        sb.append("option optimize_for = SPEED\n\n");
        sb.append("message ").append(clazz.getSimpleName()).append(" {\n");

        Field[] fields = clazz.getDeclaredFields();
        int tag = 1;
        for (Field field : fields) {
            String protoType = mapType(field.getType());
            if (protoType != null) {
                // optional
                // required
                //
                sb.append("  optional ").append(protoType).append(" ")
                        .append(field.getName().toLowerCase()).append(" = ")
                        .append(tag++).append(";\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    private static String mapType(Class<?> type) {
        if (type == int.class || type == Integer.class) return "int32";
        if (type == long.class || type == Long.class) return "int64";
        if (type == String.class) return "string";
        if (type == boolean.class || type == Boolean.class) return "bool";
        if (type == double.class || type == Double.class) return "double";
        if (type == float.class || type == Float.class) return "float";
        if (type == Date.class) return "google.protobuf.Timestamp";
        if (type.isArray() || Collection.class.isAssignableFrom(type)) return "repeated string"; // Simplification
        return "TODO - not yet supported: " + type; // Skip complex or unmapped types
    }

}


