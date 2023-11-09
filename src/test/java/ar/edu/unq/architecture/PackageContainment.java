package ar.edu.unq.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class PackageContainment
{
    private JavaClasses baseClasses;

    @BeforeEach
    public void setup() {
        baseClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("ar.edu.unq.cryptop2p");
    }

    @Test
    public void Services_should_only_be_accessed_by_WebServices() {
        classes().that().haveSimpleNameEndingWith("Dto")
                .should().resideInAPackage("ar.edu.unq.cryptop2p.model.dto")
                .check(baseClasses);
    }
}
