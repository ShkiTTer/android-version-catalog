plugins {
    `maven-publish`
    `version-catalog`
}

allprojects {
    group = "io.github.shkitter.android-version-catalogs"
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

    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["versionCatalog"])

                afterEvaluate {
                    pom {
                        name.set(project.name)
                        description.set(project.description)
                        version = project.version.toString()
                    }
                }
            }
        }
    }
}
