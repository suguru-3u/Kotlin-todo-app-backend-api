// 設定についてわかりやすく説明が記されている。https://qiita.com/_mi/items/4aea84f14e5b35ee6cda#import

/*
 * Gradleビルドスクリプトでプラグインを宣言し、
 * プロジェクトに適用するために使用されるブロック
 */
// Gradle 2.1以降で導入された新しい書き方
plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.0"
    id("io.spring.dependency-management") version "1.1.6"
}

/*
 * Gradleビルドスクリプト内で「ビルドスクリプト自体」の設定や
 * 依存関係を管理するために使用されるブロック。
 * 主に、ビルドスクリプト内で使用する外部プラグインや依存関係を指定するために使用。
 */
buildscript {
    dependencies {
    }
}

/*
 * Javaプラグインが提供する機能を設定するために使用される
 * このブロック内で、プロジェクトのJavaソースコードに関連する設定や依存関係を定義できる
 */
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

/*
 * Gradleビルドスクリプト内でソースセットの構成を定義するために使用される。
 * デフォルトではmainとtestという2つのソースセットが提供されるが、
 * それ以外のソースセットを追加したり既存のソースセットの構成を変更したりする場合は
 * sourceSetsブロックを使用する必要がある。
 * ただしデフォルトのディレクトリ構造に従っている場合、
 * 特にカスタムのソースセットを追加しない場合は、
 * sourceSetsブロックを明示的に定義する必要はない。
 */
// Integrationテスト用の Source Setを作成する。testで利用しているコードを利用するのでClasspathに追加する
sourceSets {
    create("integrationTest") {
        compileClasspath += test.get().output
        runtimeClasspath += test.get().output
    }
}


/*
 * プロジェクトの依存関係を管理するための設定を行うブロック
 * Gradleでは、ビルド時に使用する外部ライブラリやモジュールを依存関係として宣言する
 * -> この依存関係はconfigurationsと呼ばれる「グループ」に分類される
 *
 * configurationsは依存関係のグループ（またはスコープ）を作成し、
 * dependenciesはそのグループに対して実際の依存関係を指定するために使用されるという違いがある
 *
 * 例えば以下はJavaプロジェクトでよくある設定例
 */
configurations {
//    compileOnly // コンパイル時にのみ必要な依存関係
//    implementation // コンパイルから実行までの全体のプロセスで必要な依存関係
//    testImplementation // テスト実行時に必要な依存関係
//    runtimeOnly // コンパイル時には必要ないが、実行時にのみ必要な依存関係
}

// 新しく作成したintegrationテスト用階層をテストランタイムと認識してもらうための設定
// 公式サイト：https://docs.gradle.org/current/userguide/java_testing.html#sec:configuring_java_integration_tests
val integrationTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.testImplementation.get())
}
val integrationTestRuntimeOnly: Configuration by configurations.getting

configurations["integrationTestRuntimeOnly"].extendsFrom(configurations.testRuntimeOnly.get())


/*
 * Gradleビルドスクリプト内でプロジェクトの依存関係を解決するための
 * リポジトリなどの設定を行うために使用される
 */
repositories {
    mavenCentral()
}

/*
 * Gradleのビルドスクリプト内で依存関係の管理を行う
 * プロジェクトに必要な外部ライブラリやモジュールの依存関係を宣言できる
 */
dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.4")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    integrationTestImplementation("org.springframework.boot:spring-boot-starter-test")
    integrationTestImplementation("org.springframework.boot:spring-boot-testcontainers")
    integrationTestImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    integrationTestImplementation("org.testcontainers:testcontainers:1.20.4")
    integrationTestImplementation("org.testcontainers:junit-jupiter:1.20.4")
    integrationTestImplementation("org.testcontainers:mysql") //no version specified
}

group = "moja"
version = "0.0.1-SNAPSHOT"

/*
 * タスクは、Gradleビルドスクリプト内で定義される動作の単位のこと
 * ビルドプロセスの中で実行する特定の操作や処理を定義し、
 * ビルドのカスタマイズやビルドフローの制御を行うために使用される
 */
tasks.withType<Test> {
    useJUnitPlatform()
}


// 専用タスク `integrationTest` を作成。
task<Test>("integrationTest") {
    useJUnitPlatform()
    description = "Runs integration tests."
    group = "verification"
    testClassesDirs = sourceSets["integrationTest"].output.classesDirs
    classpath = sourceSets["integrationTest"].runtimeClasspath
}


// `intTestImplementation` と `intTestRuntimeOnly` を定義する。こちらも testをベースに設定した
//val integrationTestImplementation: Configuration by configurations.getting {
//    extendsFrom(configurations.testImplementation.get())
//}

//configurations["integrationTestRuntimeOnly"].extendsFrom(configurations.testRuntimeOnly.get())


