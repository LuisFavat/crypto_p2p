package ar.edu.unq.cryptop2p.architectureTests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchitectureTests {

    private JavaClasses baseClasses;
    @BeforeEach
    public void setup() {
        baseClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("ar.edu.unq.cryptop2p");
    }

    @Test
    public void Services_should_only_be_accessed_by_WebServices() {
         classes()
             .that().resideInAPackage("..service..")
             .should().onlyBeAccessed().byAnyPackage("..webservice..", "..service..")
             .check(baseClasses);
    }


    @Test
    public void dtoClassesShouldEndWithDTO(){
        classes().that().resideInAPackage("..dto..")
                .should().haveSimpleNameEndingWith("Dto").check(baseClasses);
    }

    @Test
    public void exceptionsClassesShouldEndWithException(){
        classes().that().resideInAPackage("..exceptions..")
                .should().haveSimpleNameEndingWith("Exception").check(baseClasses);
    }



}
