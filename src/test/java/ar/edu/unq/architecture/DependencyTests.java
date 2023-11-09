package ar.edu.unq.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class DependencyTests
{
    private JavaClasses baseClasses;

    @BeforeEach
    public void setup() {
        baseClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("ar.edu.unq.cryptop2p");
    }

    @Test
    public void ServiceNotDependOnWebServices()
    {
        val rule = ArchRuleDefinition.noClasses().that().resideInAPackage("..service..")
                .should().dependOnClassesThat().resideInAPackage("..webservice..");
        rule.check(baseClasses);
    }

    @Test
    public void webserviceOnlyDependOnService()
    {
        val rule = ArchRuleDefinition.classes().that().resideInAPackage("..webservice..")
                .should().onlyHaveDependentClassesThat().resideInAnyPackage("..service..");
        rule.check(baseClasses);
    }




}
