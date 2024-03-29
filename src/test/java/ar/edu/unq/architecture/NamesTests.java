package ar.edu.unq.architecture;

import org.junit.jupiter.api.Test;


import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NamesTests {

    private JavaClasses baseClasses;
    @BeforeEach
    public void setup() {
        baseClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("ar.edu.unq.cryptop2p");
    }

    @Test
    public void dtoClassesShouldEndWithDto(){
        classes().that().resideInAPackage("..dto..")
                .should().haveSimpleNameEndingWith("Dto").check(baseClasses);
    }

    @Test
    public void exceptionsClassesShouldEndWithException(){
        classes().that().resideInAPackage("..exceptions..")
                .should().haveSimpleNameEndingWith("Exception").check(baseClasses);
    }

}
