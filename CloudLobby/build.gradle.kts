plugins {
    id("java")
}

group = "de.muv1n"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.24")
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")


}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(19))
}