plugins {
    id("java")
}

group = "de.muv1n"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://repo.cloudnetservice.eu/repository/snapshots/")
}

dependencies {
    implementation("net.md-5:bungeecord-api:1.19-R0.1-SNAPSHOT")
    implementation("de.dytanic.cloudnet:cloudnet-driver:3.4.0-SNAPSHOT")
    implementation("de.dytanic.cloudnet:cloudnet-wrapper-jvm:3.4.0-SNAPSHOT")
    implementation("de.dytanic.cloudnet:cloudnet-bridge:3.4.0-SNAPSHOT")
    implementation("de.dytanic.cloudnet:cloudnet:3.4.0-SNAPSHOT")
    implementation("de.dytanic.cloudnet:cloudnet-syncproxy:3.4.0-SNAPSHOT")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}