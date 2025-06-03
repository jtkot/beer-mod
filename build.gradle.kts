plugins {
	java
	`maven-publish`
	alias(libs.plugins.fabricLoom)
}

group = property("mod_group") as String
version = property("mod_version") as String

base {
	archivesName = name
}

loom {
	splitEnvironmentSourceSets()
	mods {
		create(name) {
			sourceSets["main"]
			sourceSets["client"]
		}
	}
}

fabricApi {
	configureDataGeneration {
		client = true
	}
}

dependencies {
	mappings(loom.officialMojangMappings())
	minecraft(libs.minecraft)
	modImplementation(libs.fabricLoader)
	modImplementation(libs.fabricApi)
}

tasks.processResources {
	filesMatching("fabric.mod.json") {
		expand(mapOf("version" to version))
	}
}

tasks.withType<JavaCompile>().configureEach {
	options.release = 21
}

java {
	withSourcesJar()
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.jar {
	inputs.property("archivesName", base.archivesName)

	from("LICENSE") {
		rename({
			"${it}_${inputs.properties["archivesName"]}"
		})
	}
}

publishing {
	publications {
		create<MavenPublication>("mavenJava") {
			artifactId = name
			from(components["java"])
		}
	}
}
