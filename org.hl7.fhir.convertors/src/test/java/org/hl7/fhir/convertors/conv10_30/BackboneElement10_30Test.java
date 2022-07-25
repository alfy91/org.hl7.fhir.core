package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_30;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class BackboneElement10_30Test {
    private static Stream<Arguments> filesPaths() {
        return Stream.of(
            Arguments.of("/backbone_element_10.json", "/backbone_element_30.json")
         );
    }

    @ParameterizedTest
    @MethodSource("filesPaths")
    @DisplayName("Test 10_30 BackboneElement conversion")
    public void testConversion(String dstu2_path, String stu_path) throws IOException {
        InputStream dstu2_input = this.getClass().getResourceAsStream(dstu2_path);
        InputStream stu_exepected_input = this.getClass().getResourceAsStream(stu_path);

        org.hl7.fhir.dstu2.model.Bundle dstu2 = (org.hl7.fhir.dstu2.model.Bundle) new org.hl7.fhir.dstu2.formats.JsonParser().parse(dstu2_input);
        org.hl7.fhir.dstu3.model.Resource stu_actual = VersionConvertorFactory_10_30.convertResource(dstu2, new BaseAdvisor_10_30());

        org.hl7.fhir.dstu3.formats.JsonParser stu_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
        org.hl7.fhir.dstu3.model.Resource stu_expected = stu_parser.parse(stu_exepected_input);

        if (!stu_expected.equalsDeep(stu_actual)) {
          System.out.println("Expected");
          System.out.println(stu_parser.composeString(stu_expected));
          System.out.println();
          System.out.println("Actual");
          System.out.println(stu_parser.composeString(stu_actual));
        }
        
        Assertions.assertTrue(stu_expected.equalsDeep(stu_actual),
    "Failed comparing\n" + stu_parser.composeString(stu_actual) + "\nand\n" + stu_parser.composeString(stu_expected)
        );
    }
}
