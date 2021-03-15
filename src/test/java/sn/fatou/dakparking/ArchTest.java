package sn.fatou.dakparking;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("sn.fatou.dakparking");

        noClasses()
            .that()
            .resideInAnyPackage("sn.fatou.dakparking.service..")
            .or()
            .resideInAnyPackage("sn.fatou.dakparking.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..sn.fatou.dakparking.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
