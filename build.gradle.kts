plugins {
    `maven-publish`
    `version-catalog`
}

allprojects {
    group = "com.github.redmadrobot-tomsk.gradle-version-catalogs"
    version = "2022.09.08"
}

subprojects {
    apply {
        plugin("org.gradle.version-catalog")
        plugin("org.gradle.maven-publish")
    }

    catalog {
        versionCatalog {
            from(files("libs.versions.toml"))
        }
    }
}
