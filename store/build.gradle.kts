plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
    signing
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withJavadocJar()
    withSourcesJar()
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "io.github.xiaobaicz"
            artifactId = "store"
            version = "1.1.1"

            afterEvaluate {
                from(components["java"])
            }

            pom {
                name = "store"
                description = "java abstract store"
                url = "https://github.com/xiaobaicz/store"
                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }
                developers {
                    developer {
                        name = "bocheng.lao"
                        email = "xiaojinjincz@outlook.com"
                        organization = "bocheng.lao"
                        organizationUrl = "https://xiaobaicz.github.io"
                    }
                }
                scm {
                    connection = "scm:git:https://github.com/xiaobaicz/store.git"
                    developerConnection = "scm:git:https://github.com/xiaobaicz/store.git"
                    url = "https://github.com/xiaobaicz/store/tree/main"
                }
            }
        }
    }
    repositories {
        maven {
            url = uri("../build/maven")
        }
    }
}

signing {
    sign(publishing.publications["release"])
}