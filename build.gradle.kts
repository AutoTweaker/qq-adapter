/*
 * AutoTweaker QQ Adapter
 * Copyright (C) 2026  WhiteElephant-abc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
	alias(libs.plugins.kotlin.jvm)
	alias(libs.plugins.kotlin.kapt)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.autotweaker.plugin.sdk)
}

kotlin {
	jvmToolchain(25)
}

repositories {
	mavenCentral()
	maven {
		name = "GitHubPackages"
		url = uri("https://maven.pkg.github.com/AutoTweaker/core")
		credentials {
			username = providers.gradleProperty("gpr.user").getOrElse("")
			password = providers.gradleProperty("gpr.key").getOrElse("")
		}
	}
}

dependencies {
	implementation(libs.kotlinx.serialization.json)
	implementation(libs.kotlinx.coroutines.core)
	
	implementation(libs.auto.service.annotations)
	kapt(libs.auto.service)
}
