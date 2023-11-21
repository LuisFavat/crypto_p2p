/*
package ar.edu.unq.architecture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccesTests {

    private JavaClasses baseClasses;

    @BeforeEach
    public void setup() {
        baseClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("ar.edu.unq.cryptop2p");
    }

    @Test
    public void ServicesShouldOnlyBeAccessedByWebServices() {
         classes()
             .that().resideInAPackage("..service..")
             .should().onlyBeAccessed().byAnyPackage("..webservice..", "..service..")
             .check(baseClasses);
    }

}
*/